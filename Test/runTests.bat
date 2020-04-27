@echo off
set /a all=0
set /a failed=0
for %%f in (test???.txt) do (
	java -jar PolarSurvivor.jar %%f
	if ERRORLEVEL 1 set /a failed+=1
	set /a all+= 1
)
echo Test results:
echo %all% / %failed% tests were successful.
pause