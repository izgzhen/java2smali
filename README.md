java2smali
===

Compile:

    ./gradlew build

or, download: https://github.com/izgzhen/java2smali/releases

Run (in Unix system):

    ./java2smali example/Example.java example/Example.smali

### Related

https://github.com/ollide/intellij-java2smali is a IntelliJ plugin.

https://r8.googlesource.com/r8/+/1.0.21/tools/java2smali.sh is a bash script
that doesn't work off-the-shelf.

The following steps might work as well, as long as the `*.java` file
does not have a package namespace.

```
javac HelloWorld.java
dx --dex --output=classes.dex HelloWorld.class
baksmali classes.dex
```
