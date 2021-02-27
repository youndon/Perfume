#Intro
A few years ago I came up with a funny project idea which involves some GUI programming combined with some computer vision algorithms.
Unfortunately, I didn't have enough time back then to get started with the project and forgot about it.

I wouldn't say I've got any more time right now, but I've started to play around with Kotlin and discovered TornadoFX, a JavaFX framework for Kotlin. Since it's possible to write OpenCV applications which integrate with JavaFX, and Kotlin seamlessly integrates with Java, I've been eager to try to write some image processing code with OpenCV Java and TornadoFX.

While I made my first steps,
I suddenly remembered my old project idea and decided to pick it up again.

Since I'm still learning both Kotlin and TornadoFX,
I'll be trying to figure out things more than once.
But if you're interested in Kotlin, TornadoFX and OpenCV, keep on reading.

#Setup
I'm working on an rather old MacBook Pro and the following softward:

-Kotlin 1.2.30
-TornadoFX 1.7.14
-OpenCV 3.4.1
-Maven 3.5.2

Altough I'll describe everything based on macOS,
you can work on Linux or Windows as well.
The only thing you'll have to keep in mind is that OpenCV requires its native library built for your platform.

The next section will deal with how to include OpenCV in a Maven project.

#OpenCV with Maven
Currently there's no official Maven artifact for OpenCV, but several third-party repos.
The problem with these repos is that they often provide quite old versions, like 2.4.9.

Due to this, and the fact that I wanted to see how I could set up my own custom repo, I created a GitHub repository to host my OpenCV dependencies.

#OpenCV Java Bindings
In order to use OpenCV with Java (or Kotlin), the library has to be built with the Java flag enabled.
The easiest way to do so on macOS is by using Homebrew and an edited formula.
See this answer if you have trouble installing OpenCV.

Homebrew allows to customize formulas using

`brew edit $formula`

The one thing we'll have to change is the following build flag:

`-DBUILD_opencv_java=ON`

Now we can build OpenCV with Java bindings enabled via

`brew install --build-from-source opencv`

Once the build is done the required files to use OpenCV with Java are in e.g.

`/usr/local/Cellar/opencv/3.4.1_1/share/OpenCV/java`

-libopencv_java341.dylib
-opencv-341.jar

The JAR file is needed at compile-time,
the native library is required at runtime.

#GitHub as Maven Repository
Hosting artifacts on GitHub is quite easy:

1-Install artifacts to a local repository
2-Push the local repository to GitHub
Installing a JAR to a local repository can be achieved like this (assuming you're inside the local repository folder):


```
mvn install:install-file -Dfile=/path/to/JAR -DgroupId=$groupId -DartifactId=$artifactId -Dversion=$version -Dpackaging=jar -DlocalRepositoryPath=/path/to/local/repo
```
e.g. for my local setup:
```
mvn install:install-file -Dfile=/usr/local/Cellar/opencv/3.4.1_1/share/OpenCV/java/opencv-341.jar -DgroupId=org.s1h -DartifactId=opencv -Dversion=3.4.1 -Dpackaging=jar -DlocalRepositoryPath=.
```
Before we can also provide the OpenCV native library via Maven,
we'll first have to package it as JAR:

```
jar cvf opencv-native-macos-3.4.1.jar libopencv_java341.dylib
```
Using the GitHub Repository With Maven
In order to obtain artifacts from our GitHub repository,
we'll have to define it in our

pom.xml
<repositories>
    <repository>
        <id>mvn-opencv</id>
        <url>https://raw.github.com/s1hofmann/MavenOpenCV/master/</url>
    </repository>
</repositories>

https://raw.github.com/s1hofmann/MavenOpenCV/ references the repository, master refers to the branch.

Now it's possible to declare OpenCV as dependency:
<dependency>
    <groupId>org.s1h</groupId>
    <artifactId>opencv</artifactId>
    <version>${opencv.version}</version>
</dependency>
#Packaging OpenCV Native Library
Since we've packaged our OpenCV native library as JAR,
we're also able to use it with Maven.

The native library is not a compile-time dependency,
we only have to provide it to our
`java.library.path`

at runtime,
so it's sufficient to include the JAR in our build in order to extract the native library from it.

I'm using the
`maven-dependency-plugin`
for this:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-dependency-plugin</artifactId>
    <executions>
        <execution>
            <id>unpack</id>
            <phase>prepare-package</phase>
            <goals>
                <goal>unpack</goal>
            </goals>
            <configuration>
                <artifactItems>
                    <artifactItem>
                        <groupId>org.s1h</groupId>
                        <artifactId>opencv-native-macos</artifactId>
                        <version>${opencv.version}</version>
                        <includes>**\/*.dylib</includes>
                        <outputDirectory>${project.build.directory}/lib</outputDirectory>
                    </artifactItem>
                </artifactItems>
            </configuration>
        </execution>
    </executions>
</plugin>
```

The native library will be extracted from the JAR and copied to the
`/target/lib`

folder so it's available at runtime.

Sample Program
In order to test if our OpenCV setup works we can use the following little sample,
which only creates a 5x5 identity matrix and prints it to stdout:

```
package org.s1h

import org.opencv.core.Core
import org.opencv.core.CvType
import org.opencv.core.Mat


fun main(args: Array<String>) {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME)

    val mat = Mat.eye(5, 5, CvType.CV_8UC1)
    println("mat = ${mat.dump()}")
}
```
#Including Kotlin Standard Library
In order to run Kotlin code we also require the Kotlin standard library.
One way to do so would be to manually add it to the classpath when executing a Kotlin program,
a more convenient way is to package our program and the Kotlin standard library as a single standalone JAR.
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-assembly-plugin</artifactId>
    <version>3.1.0</version>
    <executions>
        <execution>
            <id>make-assembly</id>
            <phase>package</phase>
            <goals>
                <goal>single</goal>
            </goals>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>${main.class}</mainClass>
                    </manifest>
                </archive>
                <descriptorRefs>
                    <descriptorRef>jar-with-dependencies</descriptorRef>
                </descriptorRefs>
            </configuration>
        </execution>
    </executions>
</plugin>
```

#Putting It All Together
With all parts in place we're able to build the project using
`mvn clean package`
This will download all dependencies,
extract the OpenCV native library to the
`target/lib`
folder and build a fat JAR including the Kotlin standard library.

To run the standalone JAR you'll have to specify the path of the native library:
```
java -Djava.library.path=target/lib -jar target/tornadoCV-1.0-SNAPSHOT-jar-with-dependencies.jar
```
#Conclusion
This as been my longest post ever! (Yay!)
Kotlin and OpenCV work together nicely!
The overall project structure / setup is pretty straightforward if you've ever worked with Java / Maven
I'm stoked to continue!
I hope you enjoyed this post,
in my next post I'll experiment with TornadoFX and camera input.

So long

Simon
