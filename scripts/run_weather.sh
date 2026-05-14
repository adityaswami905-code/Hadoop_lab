#!/bin/bash

# Cleaning
rm -f weather.jar
rm -rf weatheroutput
rm -rf weather_classes

# Compile
mkdir weather_classes
javac -classpath "$(hadoop classpath)" -d weather_classes WeatherAnalysis.java

# Create JAR
jar -cvf weather.jar -C weather_classes/ .

# Run Hadoop Program
hadoop jar weather.jar WeatherAnalysis sample_weather.txt weatheroutput

# Display Output
echo "\n===== OUTPUT ====="
cat weatheroutput/part-r-00000