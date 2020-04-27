@echo off
set /a all=0
set /a failed=0
for %%f in (test???.txt) do (
	java -jar PolarSurvivor.jar %%f
	if ERRORLEVEL 1 set /a failed+=1
	set /a all+= 1
)
set /a succesful=%all%-%failed%
echo Test results:
echo %all% / %succesful% tests were successful.
pause