!/bin/bash
clear

sudo chmod 754 start.sh

echo "Compiling the program..."
cd src/main/java
javac Simulator.java

echo "Running the program..."
java Simulator


