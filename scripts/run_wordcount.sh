#!/bin/bash

# Cleaning
rm -f wordcount.jar
rm -rf output
rm -rf classes

# Compile
mkdir classes
javac -classpath "$(hadoop classpath)" -d classes WordCount.java

# Create JAR
jar -cvf wordcount.jar -C classes/ .

# Run Hadoop Program
hadoop jar wordcount.jar WordCount input.txt output

# Display Output
echo "\n===== OUTPUT ====="
cat output/part-r-00000