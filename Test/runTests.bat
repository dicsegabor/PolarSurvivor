@echo off
for %%f in (test???.txt) do (
	java -jar PolarSurvivor.jar %%f
)
pause