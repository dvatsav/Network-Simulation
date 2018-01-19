all:
	javac *.java
	for number in {1..10}
	do
	java simulator < testcase1.txt
	done
	