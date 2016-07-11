@echo off
set pass=openHidden
set pass1=openGoT
set pass2=openTor
echo Enter password
set /p ui=
if %ui%==%pass% (goto open)
if %ui%==%pass1% (goto open1)
if %ui%==%pass2% (goto open2)
echo Incorrect password: Access Denied
pause
exit
:open
start hidden
exit
:open1
start GameOfThrones
exit
:open2
start torrents
exit
