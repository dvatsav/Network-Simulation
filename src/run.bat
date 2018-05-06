@echo off

echo Welcome, this will run Lab1.jar
:: Set the amount of times to run from user input
set /P numToRun= Please enter how many times to run the program: 

setlocal enabledelayedexpansion enableextensions


:: Start looping here while increasing the jar pars
:: Loop from 0 to numToRun
for /L %%i in (1 1 %numToRun%) do (
    java simulator < testcase1.txt !numParam! !strParam!
)

@echo on
