@echo off

REM Server startup/shutdown script configuration
REM JAVA_HOME must point to the jdk installation folder
if "" == "%JAVA_HOME%" set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_21

REM The value of CATALINA_HOME must be the name of the
REM TomEE installation folder. You should install TomEE
REM in a folder without spaces in the path name
if "" == "%CATALINA_HOME%" set CATALINA_HOME=path to TomEE installation folder

REM If you do not have administrator rights, you can
REM still run TomEE if you create a private instance
REM (see the lecture notes for instructions)
REM Set CATALINA_HOME to point to the installation folder
REM and CATALINA_BASE to the path name of your instance
REM folder.
REM If you have administrator rights just leave this as is.
if "" == "%CATALINA_BASE%" set CATALINA_BASE=%CATALINA_HOME%

REM Derby is installed as part of jdk. Change this only if you
REM use a separate installation of derby
set DERBYRUN_JAR=%JAVA_HOME%\db\lib\derbyrun.jar

REM The database will be placed in this folder.
set DERBY_SYSTEM=%CATALINA_BASE%\derbydb
