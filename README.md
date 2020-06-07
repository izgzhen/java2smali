java2smali
===

Compile:

    ./gradlew build

or, download: https://github.com/izgzhen/java2smali/releases

Run (in Unix system):

    ./java2smali example/Example.java

Then you should be able to find `*.smali` files in the `example/` directory.

Another example run with imports:

    APP_CLASSPATH=. ./java2smali example2/Example2.java

Note that `Example2.java` import `example.Example`, so you must specify its class path directory.

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
