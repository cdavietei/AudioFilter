# Audio Filter

## Features In Progress

1. Pause Identification
1. Asynchronous Pipeline - Non block stages
1. Input Interface
1. Output Interface
1. Audio Converter Interface

## Features Completed

1. Google Speech API Hookup
1. Profanity Identification

## TODO:

1. Async callback interfaces

---

## How to run

Easiest way to run this is by just by executing the following command if you have Gradle installed.

```gradle run```

This will run the demo example with the file ```data/zach-short.flac```

Compile to a jar file with ```gradle shadowJar``` and you can run it with the following command from the project's root directory

```java -jar build/libs/AudioFilter-all.jar <PATH/TO/FLAC/FILE>```

### Important note:

The current swears.txt has 4 extra non swear words chosen specifically for the demo files to demonstrate the selection process. Remove these when testing on proper files.
