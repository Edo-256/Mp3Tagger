# Mp3Tagger
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Mp3Tagger is a simple program that allows you to automatically add title, album, artist to your mp3 files by using their location.

## ⚠️WARNING⚠️

- This program automatically renames all your mp3 files in a format compatible with all types of devices (even older mp3s)
- Make sure that you input the right directory to prevent file losses or file corruption
- Make sure that ALL your files in the input_directory are all mp3s
- I suggest to make a backup of your input_directory before use the program, I will not assume any responsibility about data losses

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
| Mp3agic | [https://github.com/mpatric/mp3agic] |

## Development

🪟In this state the program only runs in windows🪟
