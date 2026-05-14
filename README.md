# Hadoop Lab Programs

This repository contains Hadoop MapReduce programs implemented in Java using Hadoop 3.3.6 in local standalone mode.

## Technologies Used

- Java 17
- Hadoop 3.3.6
- MapReduce
- GitHub Codespaces

---

# Programs Included

1. Word Count
2. Log File Analysis
3. Weather Data Analysis

---

# Project Structure

```text
Hadoop_lab/
│
├── WordCount.java
├── input.txt
│
├── LogAnalysis.java
├── logfile.txt
│
├── WeatherAnalysis.java
├── sample_weather.txt
│
├── scripts/
│   ├── run_wordcount.sh
│   ├── run_loganalysis.sh
│   └── run_weather.sh
│
├── .gitignore
└── README.md
```

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

# Automation Scripts

Shell scripts are included inside the `scripts/` folder to automate:
- cleaning old files
- compiling Java programs
- creating JAR files
- running Hadoop MapReduce jobs
- displaying output

## Give Execute Permission

```bash
chmod +x scripts/run_wordcount.sh
chmod +x scripts/run_loganalysis.sh
chmod +x scripts/run_weather.sh
```

## Run WordCount

```bash
./scripts/run_wordcount.sh
```

## Run LogAnalysis

```bash
./scripts/run_loganalysis.sh
```

## Run WeatherAnalysis

```bash
./scripts/run_weather.sh
```

---

# Git Commands

## Add Files

```bash
git add .
```

## Check Status

```bash
git status
```

## Commit Changes

```bash
git commit -m "Added Hadoop MapReduce programs"
```

## Push to GitHub

```bash
git push origin main
```

---

# Notes

- Hadoop output folders must be deleted before rerunning a job.
- JAR files and build folders are ignored using `.gitignore`.
- Programs are executed in local standalone Hadoop mode.
- Shell scripts simplify execution during practical examinations.
