# Project-Specific Instructions for Gemini

This file provides project-specific context and instructions for the Gemini CLI.

## Project Overview

This is the source code for the "IntroGroovy" workshop, based on the book "Making Java Groovy" by Ken Kousen. It's a Gradle-based project with numerous Groovy and some Java examples.

## Build & Dependencies

- **Build Command:** The project is built using `./gradlew build`.
- **Dependency Management:** Dependencies are managed via a Gradle Version Catalog in `gradle/libs.versions.toml`.
- **Testing Libraries:** The project uses Spock and JUnit 5 for testing.

## Known Issues & Solutions

This section documents issues and resolutions we've found in the past to avoid repeating work.

### Test Framework Version Compatibility

- **Problem:** The build can fail due to version incompatibilities between Spock and JUnit, often with a `TestSuiteExecutionException` caused by `OutputDirectoryProvider not available`.
- **Solution:** A stable working combination is Spock `2.3-groovy-4.0` with JUnit `5.10.0`. Using the latest versions of both libraries has caused conflicts. We are using the JUnit BOM (`org.junit:junit-bom:5.10.0`) to manage JUnit versions. The explicit dependency on the `junit` bundle is still required in `build.gradle`.

### Gradle Deprecation Warnings

- **Problem:** A deprecation warning for `ApplicationPluginConvention` was present.
- **Solution:** The `mainClassName` property was moved inside an `application` block in `build.gradle`.

### Gradle Wrapper

- The Gradle wrapper has been updated to version 8.14.2 and uses the `-all` distribution for better IDE compatibility.