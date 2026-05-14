# Hadoop Lab Programs

This repository contains Hadoop MapReduce programs implemented in Java using Hadoop 3.3.6 in local standalone mode.

## Programs Included

1. Word Count
2. Log File Analysis
3. Weather Data Analysis

---

# 1. Word Count

Counts the occurrence of each word in the input text file.

## Input File
`input.txt`

## Cleaning Previous Build

```bash
rm wordcount.jar
rm -r output
rm -r classes
```

## Compile Program

```bash
mkdir classes

javac -classpath "$(hadoop classpath)" -d classes WordCount.java
```

## Create JAR File

```bash
jar -cvf wordcount.jar -C classes/ .
```

## Run Program

```bash
hadoop jar wordcount.jar WordCount input.txt output
```

## Display Output

```bash
cat output/part-r-00000
```

---

# 2. Log File Analysis

Processes a log file and counts occurrences of:
- INFO
- ERROR
- WARNING

## Input File
`logfile.txt`

## Cleaning Previous Build

```bash
rm loganalysis.jar
rm -r logoutput
rm -r log_classes
```

## Compile Program

```bash
mkdir log_classes

javac -classpath "$(hadoop classpath)" -d log_classes LogAnalysis.java
```

## Create JAR File

```bash
jar -cvf loganalysis.jar -C log_classes/ .
```

## Run Program

```bash
hadoop jar loganalysis.jar LogAnalysis logfile.txt logoutput
```

## Display Output

```bash
cat logoutput/part-r-00000
```

---

# 3. Weather Data Analysis

Calculates average:
- Temperature
- Dew Point
- Wind Speed

## Input File
`sample_weather.txt`

## Cleaning Previous Build

```bash
rm weather.jar
rm -r weatheroutput
rm -r weather_classes
```

## Compile Program

```bash
mkdir weather_classes

javac -classpath "$(hadoop classpath)" -d weather_classes WeatherAnalysis.java
```

## Create JAR File

```bash
jar -cvf weather.jar -C weather_classes/ .
```

## Run Program

```bash
hadoop jar weather.jar WeatherAnalysis sample_weather.txt weatheroutput
```

## Display Output

```bash
cat weatheroutput/part-r-00000
```

---

# Technologies Used

- Java 17
- Hadoop 3.3.6
- MapReduce
- GitHub Codespaces
