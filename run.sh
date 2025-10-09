#!/usr/bin/env bash
MAIN_CLASS="${1:-stringsearch.MainSearch}"

mvn compile exec:java -Dexec.mainClass="$MAIN_CLASS"
