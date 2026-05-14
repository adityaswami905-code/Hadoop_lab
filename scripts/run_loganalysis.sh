#!/bin/bash

# Cleaning
rm -f loganalysis.jar
rm -rf logoutput
rm -rf log_classes

# Compile
mkdir log_classes
javac -classpath "$(hadoop classpath)" -d log_classes LogAnalysis.java

# Create JAR
jar -cvf loganalysis.jar -C log_classes/ .

# Run Hadoop Program
hadoop jar loganalysis.jar LogAnalysis logfile.txt logoutput

# Display Output
echo "\n===== OUTPUT ====="
cat logoutput/part-r-00000