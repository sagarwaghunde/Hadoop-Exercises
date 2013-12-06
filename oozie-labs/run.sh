#!/bin/bash
set -e

# The expected input to the run.sh command is a path that has an Oozie workflow
# Example: run.sh lab1-java-mapreduce
LAB=${1?Usage: $0 job}

# Copy a jar file that contains classes that the Oozie job uses.
# The classes are referenced in the workflow.xml file.
# The path to this jar file is referenced in the job.properties file.
cp -f *.jar $LAB/job/lib

# Clean up HDFS in case you ran this job previously
hadoop fs -rm -r $LAB 2>/dev/null || true

# Put the path that contains the Oozie workflow in HDFS
hadoop fs -put $LAB .

# Schedule the Oozie job
oozie job -oozie http://localhost:11000/oozie -config $LAB/job/job.properties -auth simple -run