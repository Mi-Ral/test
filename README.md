# Скриншотные тесты

Этот проект содержит автоматизированные тесты скриншотов с использованием Selenide и JUnit 5.

## Требования

* Java 8 или выше
* Maven 
* Браузер Google Chrome

## Установка

1. Склонируйте репозиторий проекта
2. Откройте проект в IDE(Желательно в IntelliJ IDEA).
3. Установите необходимые зависимости с помощью Maven:

```mvn clean install```

4. При необходимости обновите свойство `browser` в классе `ScreenshotTest` с помощью названия вашего браузера (например, `chrome`, `firefox`, `edge` и т.д.).
5. Обновите свойство `browserBinary` в классе `ScreenshotTest` путем к исполняемому файлу вашего браузера.

## Запуск тестов

1. Запустите класс `ScreenshotTest` в вашей IDE ИЛИ с помощью команды  
```mvn clean test```
2. Тесты откроют указанный URL в Google Chrome и сделают скриншоты указанных элементов
3. Скриншоты будут сохранены в папке `output` в корневом каталоге проекта
