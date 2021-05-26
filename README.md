# usrPool
Разворачиваем приложение: 
Подключаем БД MySql:
Terminal
/usr/local/mysql/bin/mysql -u root -p
create database usrPoolDB;
use usrPoolDB;
create user 'springuser'@'%' identified by 'root';
grant all on usrPoolDB.* to 'springuser'@'%';

Для общения с Api используем Postman
Несколько примеров запроса:

1.Создаем Опрос (метод createPool)
  POST
  http://localhost:8080/pools
  Body
    {
    "description": "Титул опроса",
    "active": true - активность опроса
    "startDate": "2001-10-31" - дата открытия
    "endDate": "2001-11-01" - дата прохождения 
    }
 
2.Получаем опрос по id (метод getOnePool)
  GET
  http://localhost:8080/pools?id=
  Params: id 
  Body: none
  
3.Удаляем опрос (метод deletePool)
  DELETE
  http://localhost:8080/pools/3
  
4.Создаем пользователя (метод createUser)
  http://localhost:8080/pools
  Body
    {
    "firstName": "Василий",
    "LastName": "Валисльев" 
    }
