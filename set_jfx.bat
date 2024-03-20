@echo off

set "source_folder=Z:\Install316\javafx-sdk-17.0.10"
set "destination_folder=D:\Installed\javafx-sdk-17.0.10"

rem Копирование папки с файлами
xcopy "%source_folder%" "%destination_folder%" /E /I

rem Установка переменной среды для указания на скопированную папку
setx PATH_TO_FX "%destination_folder%"
