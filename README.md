# JDBC_CRUD
Данный проект состоит из 6 модулей:
1) models
2) generator
3) serialization
4) deserialization
5) connectDB
6) consoleAPP

В 5 модуле происходит подключение к базе данных, используя информацию о бд, убранную в config.properties.
Далее создаются таблицы в базе данных (с помощью скриптов в папке sqlScripts), а затем наполняются.

В 6 модуле реализованы CRUD операции по взаимодействию с базой данных, где сами методы прописаны в соответствующих классах в папке CRUD.
В основном классе прописано взаимодействие пользователя с приложение через консоль.
Также в классе DatabaseCrudTest в папке test реализованы все тесты для всех операций.

Также использовался Docker для упаковки локальной базы данных в контейнер для возможности её развертывания на своей машине.
