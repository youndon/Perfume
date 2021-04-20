
#2. Setting Up

To use **TornadoFX**, there are several options to set up the dependency for your project.
Mainstream build automation tools like Gradle and Maven are supported and should have no issues in getting set up.

Please note that **TornadoFX** is a **Kotlin** library, and therefore your project needs to be configured to use Kotlin. 
For Gradle and Maven configurations, please refer to the Kotlin Gradle Setup and Kotlin Maven Setup guides. 
Make sure your development environment or IDE is equipped to work with Kotlin and has the proper plugins and compilers.

This guide will use Intellij IDEA to walk through certain examples. IDEA is the IDE of choice to work with Kotlin, although Eclipse has a plugin as well.

###If you are using Oracle JDK

###Gradle

For Gradle, you can set up the dependency directly from Maven Central. 
Provide the desired version number for the `x.y.z` placeholder.
```groovy

repositories {
    mavenCentral()
}

// Minimum jvmTarget of 1.8 needed since Kotlin 1.1
compileKotlin {
    kotlinOptions.jvmTarget= 1.8
}

dependencies {  
    implementation 'no.tornado:tornadofx:x.y.z'
}
```
###Maven
To import TornadoFX with Maven, add the following dependency to your `POM` file.
Provide the desired version number for the `x.y.z` placeholder.

Goes into kotlin-maven-plugin block:
```xml
<configuration>
    <jvmTarget>1.8</jvmTarget>
</configuration>
```
Then this goes into dependencies block:
```xml
<dependency>
    <groupId>no.tornado</groupId>
    <artifactId>tornadofx</artifactId>
    <version>x.y.z</version>
</dependency>
```
###If you are using OpenJDK

On Ubuntu 19.10, there is no longer any clean way to run OpenJDK 8 with JFX. 
OpenJDK in general does not include the JFX module libraries -- JFX support for OpenJDK is commonly provided by OpenJFX, which has a maven distribution as well as packages in various Linux distributions.
However, the OpenJFX versions are tied to JDK versions (e.g. OpenJFX 8 is compatible with OpenJDK 8), and unfortunately the OpenJFX 8 version is not available in Ubuntu 19.10's packages, nor does it compile from source using the packaged OpenJDK 8.

The upshot of this is that if you wish to continue using OpenJDK (on Ubuntu), your options are:

1) Stay on OpenJDK 8 but install OpenJFX 8 system wide by adding older dependencies to your system (e.g. https://bugs.launchpad.net/ubuntu/+source/openjfx/+bug/1799946/comments/7)

2) Alternately, you can bite the bullet and upgrade to OpenJDK 11, and install OpenJFX via Maven/Gradle. 
   This solution is as follows:

###Gradle
a) Upgrade to OpenJDK 11 via your system's packaging tools.

b) Add the OpenJFX gradle plugin:
```groovy

plugins {
    id 'application'
    id 'org.openjfx.javafxplugin' version '0.0.8'
}
```
c) Add gradle dependencies:
```groovy

javafx {
       version = "11.0.2"
       modules = ['javafx.controls', 'javafx.graphics']
}

dependencies {
    implementation 'no.tornado:tornadofx:x.y.z'
}
```
d) Change kotlin jvmTarget to 11:
```groovy

   compileKotlin {
       kotlinOptions.jvmTarget = "11"
   }
   
   compileTestKotlin {
       kotlinOptions.jvmTarget = "11"
   }
```
e) The gradle doesn't support JPMS correctly, so we don't need to add module-info.java for project.

In Intellij Idea, you should change the Project SDK to 11 in File -> Project Structure -> Project Settings -> Project.

##Maven
a) Upgrade to OpenJDK 11 via your system's packaging tools.

b) Add maven dependencies:
```xml
        <dependency>
            <groupId>no.tornado</groupId>
            <artifactId>tornadofx</artifactId>
            <version>x.y.z</version>
        </dependency>

        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx</artifactId>
            <version>11.0.2</version>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-base</artifactId>
            <version>11.0.2</version>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>11.0.2</version>
        </dependency>
```
c) Add the OpenJFX builder to your build/plugins section:
```xml
<build>
   <plugins>
       ...
    <plugin>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-maven-plugin</artifactId>
            <version>0.0.3</version>
            <configuration>
                <mainClass>MyMainApp</mainClass>
            </configuration>
        </plugin>
   </plugins>
</build>
```
d) Set the language level in your maven build to 11:
```xml
<build>
   <plugins>
    ...
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.0</version>
            <configuration>
                <release>11</release>
            </configuration>
        </plugin>
    </plugins>
</plugin>
```
e) Finally, add src/main/kotlin/module-info.java, to set up permissioning in Java 11's module system.
```java
module yourmodulename {
    requires javafx.controls;
    requires javafx.graphics;
    requires tornadofx;
    requires kotlin.stdlib;
    opens your.package.to.ui.classes;
}
```

If you are using IntelliJ, it will provide helpful prompts to add any additional modules that you may need for the build to succeed with your app.
**StackOverflow** has a plethora of questions from Java programmers switching to the module system for the first time, so if you run into a module permissions related issue, google the error message for a solution.

(Variations on this section for other platforms are welcomed.)

###Other Build Automation Solutions
For instructions on how to use TornadoFX with other build automation solutions, please refer to the TornadoFX page at the Central Repository​

###Manual Import
To manually download and import the JAR file, go to the TornadoFX release page or the Central Repository. Download the JAR file and configure it into your project.
