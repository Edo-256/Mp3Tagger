# Mp3Tagger
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Mp3Tagger is a simple program that allow you to automatically add title, album, artist \
to yours mp3 files only based on their location.

## ⚠️WARNING⚠️

- This program automatically rename all yours mp3 files in a format compatible with all type of devices (even older mp3s)
- Make sure that you input the right directory to prevent file losses or file corruption
- Make sure that ALL your files in the input_directory are all mp3s
- I suggest to make a backup of your input directory before use the program, i will not assume any responsibility about data losses

## Program Logic
![alt text](https://github.com/Edo-256/Mp3Tagger/blob/main/diagram/graph.png)

## Usage (Not jar)
Compile
```sh
javac Mp3AutoEncoder.java
```
With program input
```sh
java Mp3AutoEncoder
```
With cmd launch input
```sh
java Mp3AutoEncoder <selected-directory>
```

## Usage (jar)
With program input
```sh
java –jar <ExecutableJarFileName>.jar
```
With cmd launch input
```sh
java –jar <ExecutableJarFileName>.jar <selected-directory>
```

## Used libraries

| Library | Link |
| ------ | ------ |
| Mp3agic | [https://github.com/mpatric/mp3agic][PlDb] |

## Development

🪟At this state the program only run in windows 🪟


## Building for source
```sh
--Compile the program as simple .java file, you need to compile only the .java in the main folder
```
