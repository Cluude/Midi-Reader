@echo off

if "%1"=="" goto Error
if "%2"=="" goto Error

echo Compiling...
cd %1\src\main
javac %2.java
cd ..\..\..

echo Launching...
java %1.src.main.%2

exit

:Error
echo Please enter your package name as the first parameter, and your entry class as a second parameter.
pause
exit