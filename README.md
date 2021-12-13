# cloud-storage-netty 
Maven проект сетевого хранилища. 
С его помощью можно загружать на сервер и на клиентскую сторону файлы любого размера, создавать, удалять и переименовывать файлы и папки на обеих сторонах.
Файлы загружаются частями. При загрузке/выгрузке файлов с одинаковым именем создаются их копии. Серверная часть написана с использованием фреймворка Netty.
Клиентский модуль написан с использованием фреймворка Netty, JavaFX, CSS. В клиентской части вся логика разбита по классам. App - управление окнами приложения.
Network - работа с сетью, включая методы отправки и чтения команд. Доступ к методам класса MainController из класса Network осуществляется через статику класса App.
В классах контроллеров собрана логика управления компонентами окон. Для передачи команд используются сериализованные объекты, классы которых вынесены в отдельный модуль.
В серврной части данные о пользователях хранятся в базе данных. Логика работы с базой данных вынесена в класс DatabaseService.
