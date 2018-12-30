#!/bin/bash

./gradlew build
rm -rf dist
mkdir -p dist/build/libs
cp build/libs/java2smali-1.0-SNAPSHOT.jar dist/build/libs
cp java2smali dist
zip -r dist.zip dist
