@echo off
for %%f in (test?.txt) do (
	java -jar PolarSurvivor.jar %%f
)
for %%f in (test1?.txt) do (
	java -jar PolarSurvivor.jar %%f
)
for %%f in (test2?.txt) do (
	java -jar PolarSurvivor.jar %%f
)
for %%f in (test3?.txt) do (
	java -jar PolarSurvivor.jar %%f
)
pause