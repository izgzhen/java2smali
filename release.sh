#!/bin/bash

./gradlew build
rm -rf dist dist.zip
mkdir -p dist/build/libs
cp build/libs/java2smali-1.1.jar dist/build/libs
cp java2smali dist
mkdir -p dist/example
mkdir -p dist/example2
cp example/*.java dist/example
cp example2/*.java dist/example2
zip -r dist.zip dist
