import com.google.gson.JsonObject
import com.google.gson.JsonParser
import dyorgio.runtime.run.`as`.root.RootExecutor
import org.hyperic.sigar.Sigar
import tornadofx.loadJsonArray
import tornadofx.observable
import java.text.SimpleDateFormat
import javax.json.Json
import java.text.DateFormat

import com.sun.javafx.perf.PerformanceTracker.logEvent
import kotlinx.datetime.TimeZone
import java.util.*


fun main() {
//        HashCodeBuilder.reflectionHashCode("")


    // system, bus, generic, network, display, bridge,multimedia, storage, disk, volume,power, input ,communication,processor ,memory

    System.setProperty("java.library.path", "/usr/lib64")
    System.setProperty("java.io.tmpdir", "/home/yon/")
//    RootExecutor("-Xmx64m").run {
        (Sigar().procList.forEach { it ->
//        println(Sigar().getProcState(it)) -> {Threads=1, Processor=1, State=S, Priority=20, Tty=0, Nice=0, Ppid=0, Name=systemd}
//            println(Sigar().getProcModules(it)) //[/usr/lib/systemd/systemd, /usr/lib/systemd/systemd, /usr/lib/systemd/systemd, /usr/lib/x86_64-linux-gnu/libm-2.32.so, /usr/lib/x86_64-linux-gnu/libm-2.32.so, /usr/lib/x86_64-linux-gnu/libm-2.32.so, /usr/lib/x86_64-linux-gnu/libudev.so.1.6.18, /usr/lib/x86_64-linux-gnu/libudev.so.1.6.18, /usr/lib/x86_64-linux-gnu/libudev.so.1.6.18, /usr/lib/x86_64-linux-gnu/libunistring.so.2.1.0, /usr/lib/x86_64-linux-gnu/libunistring.so.2.1.0, /usr/lib/x86_64-linux-gnu/libunistring.so.2.1.0, /usr/lib/x86_64-linux-gnu/libgpg-error.so.0.29.0, /usr/lib/x86_64-linux-gnu/libgpg-error.so.0.29.0, /usr/lib/x86_64-linux-gnu/libgpg-error.so.0.29.0, /usr/lib/x86_64-linux-gnu/libjson-c.so.5.1.0, /usr/lib/x86_64-linux-gnu/libjson-c.so.5.1.0, /usr/lib/x86_64-linux-gnu/libjson-c.so.5.1.0, /usr/lib/x86_64-linux-gnu/libargon2.so.1, /usr/lib/x86_64-linux-gnu/libargon2.so.1, /usr/lib/x86_64-linux-gnu/libargon2.so.1, /usr/lib/x86_64-linux-gnu/libdevmapper.so.1.02.1, /usr/lib/x86_64-linux-gnu/libdevmapper.so.1.02.1, /usr/lib/x86_64-linux-gnu/libdevmapper.so.1.02.1, /usr/lib/x86_64-linux-gnu/libuuid.so.1.3.0, /usr/lib/x86_64-linux-gnu/libuuid.so.1.3.0, /usr/lib/x86_64-linux-gnu/libuuid.so.1.3.0, /usr/lib/x86_64-linux-gnu/libcrypto.so.1.1, /usr/lib/x86_64-linux-gnu/libcrypto.so.1.1, /usr/lib/x86_64-linux-gnu/libcrypto.so.1.1, /usr/lib/x86_64-linux-gnu/libcap-ng.so.0.0.0, /usr/lib/x86_64-linux-gnu/libcap-ng.so.0.0.0, /usr/lib/x86_64-linux-gnu/libcap-ng.so.0.0.0, /usr/lib/x86_64-linux-gnu/libpcre2-8.so.0.9.0, /usr/lib/x86_64-linux-gnu/libpcre2-8.so.0.9.0, /usr/lib/x86_64-linux-gnu/libpcre2-8.so.0.9.0, /usr/lib/x86_64-linux-gnu/libpthread-2.32.so, /usr/lib/x86_64-linux-gnu/libpthread-2.32.so, /usr/lib/x86_64-linux-gnu/libpthread-2.32.so, /usr/lib/x86_64-linux-gnu/libdl-2.32.so, /usr/lib/x86_64-linux-gnu/libdl-2.32.so, /usr/lib/x86_64-linux-gnu/libdl-2.32.so, /usr/lib/x86_64-linux-gnu/liblzma.so.5.2.4, /usr/lib/x86_64-linux-gnu/liblzma.so.5.2.4, /usr/lib/x86_64-linux-gnu/liblzma.so.5.2.4, /usr/lib/x86_64-linux-gnu/libzstd.so.1.4.5, /usr/lib/x86_64-linux-gnu/libzstd.so.1.4.5, /usr/lib/x86_64-linux-gnu/libzstd.so.1.4.5, /usr/lib/x86_64-linux-gnu/liblz4.so.1.9.2, /usr/lib/x86_64-linux-gnu/liblz4.so.1.9.2, /usr/lib/x86_64-linux-gnu/liblz4.so.1.9.2, /usr/lib/x86_64-linux-gnu/libip4tc.so.2.0.0, /usr/lib/x86_64-linux-gnu/libip4tc.so.2.0.0, /usr/lib/x86_64-linux-gnu/libip4tc.so.2.0.0, /usr/lib/x86_64-linux-gnu/libidn2.so.0.3.7, /usr/lib/x86_64-linux-gnu/libidn2.so.0.3.7, /usr/lib/x86_64-linux-gnu/libidn2.so.0.3.7, /usr/lib/x86_64-linux-gnu/libgcrypt.so.20.2.5, /usr/lib/x86_64-linux-gnu/libgcrypt.so.20.2.5, /usr/lib/x86_64-linux-gnu/libgcrypt.so.20.2.5, /usr/lib/x86_64-linux-gnu/libcryptsetup.so.12.6.0, /usr/lib/x86_64-linux-gnu/libcryptsetup.so.12.6.0, /usr/lib/x86_64-linux-gnu/libcryptsetup.so.12.6.0, /usr/lib/x86_64-linux-gnu/libcrypt.so.1.1.0, /usr/lib/x86_64-linux-gnu/libcrypt.so.1.1.0, /usr/lib/x86_64-linux-gnu/libcrypt.so.1.1.0, /usr/lib/x86_64-linux-gnu/libcap.so.2.43, /usr/lib/x86_64-linux-gnu/libcap.so.2.43, /usr/lib/x86_64-linux-gnu/libcap.so.2.43, /usr/lib/x86_64-linux-gnu/libblkid.so.1.1.0, /usr/lib/x86_64-linux-gnu/libblkid.so.1.1.0, /usr/lib/x86_64-linux-gnu/libblkid.so.1.1.0, /usr/lib/x86_64-linux-gnu/libacl.so.1.1.2253, /usr/lib/x86_64-linux-gnu/libacl.so.1.1.2253, /usr/lib/x86_64-linux-gnu/libacl.so.1.1.2253, /usr/lib/x86_64-linux-gnu/libc-2.32.so, /usr/lib/x86_64-linux-gnu/libc-2.32.so, /usr/lib/x86_64-linux-gnu/libc-2.32.so, /usr/lib/x86_64-linux-gnu/libapparmor.so.1.7.0, /usr/lib/x86_64-linux-gnu/libapparmor.so.1.7.0, /usr/lib/x86_64-linux-gnu/libapparmor.so.1.7.0, /usr/lib/x86_64-linux-gnu/libkmod.so.2.3.5, /usr/lib/x86_64-linux-gnu/libkmod.so.2.3.5, /usr/lib/x86_64-linux-gnu/libkmod.so.2.3.5, /usr/lib/x86_64-linux-gnu/libaudit.so.1.0.0, /usr/lib/x86_64-linux-gnu/libaudit.so.1.0.0, /usr/lib/x86_64-linux-gnu/libaudit.so.1.0.0, /usr/lib/x86_64-linux-gnu/libpam.so.0.84.2, /usr/lib/x86_64-linux-gnu/libpam.so.0.84.2, /usr/lib/x86_64-linux-gnu/libpam.so.0.84.2, /usr/lib/x86_64-linux-gnu/libmount.so.1.1.0, /usr/lib/x86_64-linux-gnu/libmount.so.1.1.0, /usr/lib/x86_64-linux-gnu/libmount.so.1.1.0, /usr/lib/x86_64-linux-gnu/libselinux.so.1, /usr/lib/x86_64-linux-gnu/libselinux.so.1, /usr/lib/x86_64-linux-gnu/libselinux.so.1, /usr/lib/x86_64-linux-gnu/libseccomp.so.2.4.3, /usr/lib/x86_64-linux-gnu/libseccomp.so.2.4.3, /usr/lib/x86_64-linux-gnu/libseccomp.so.2.4.3, /usr/lib/x86_64-linux-gnu/librt-2.32.so, /usr/lib/x86_64-linux-gnu/librt-2.32.so, /usr/lib/x86_64-linux-gnu/librt-2.32.so, /usr/lib/systemd/libsystemd-shared-246.so, /usr/lib/systemd/libsystemd-shared-246.so, /usr/lib/systemd/libsystemd-shared-246.so, /usr/lib/x86_64-linux-gnu/ld-2.32.so, /usr/lib/x86_64-linux-gnu/ld-2.32.so, /usr/lib/x86_64-linux-gnu/ld-2.32.so]
//            println(Sigar().getProcCpu(it)) -> {User=6810, Percent=0.0, Total=11470, StartTime=1616324346000, Sys=4660, LastTime=1616592094867}
//            println(Sigar().getProcCred(it)) -> {Uid=0, Gid=0, Euid=0, Egid=0}
//            println(Sigar().getProcCredName(it)) -> {Group=root, User=root}
//            println(Sigar().getProcEnv(it)) -> {PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin, init=/sbin/init, rootmnt=/root, BOOT_IMAGE=/boot/vmlinuz-5.8.0-45-generic, NETWORK_SKIP_ENSLAVED=, TERM=linux, drop_caps=, PWD=/, HOME=/}
//            println(Sigar().getProcExe(1)) -> has Exception: {Cwd=/, Name=/usr/lib/systemd/systemd}
//            println(Sigar().getProcFd(it)) -> {Total=177}
//            println(Sigar().getProcMem(it)) -> {PageFaults=105833, Size=174690304, MajorFaults=3822, Resident=4325376, MinorFaults=102011, Share=2568192}
//            println(Sigar().getProcPort())
        })
//    }

    val date = Date()

}



