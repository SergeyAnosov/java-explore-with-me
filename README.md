# Java-explore-with-me

&emsp; Приложение — афиша. В этой афише можно предложить какое-либо событие
от выставки до похода в кино и собрать компанию для участия в нём.

![picture](Explore-with-me_image.png)

**Стек:**
- Java 11
- Spring Boot
- Hibernate ORM
- PostgreSQL
- Maven
- Postman
- Docker


    Приложение построено на микросервисной архитектуре.

&emsp; **Состоит из двух сервисов**
- основной сервис ["спецификация API основного сервиса"](https://github.com/SergeyAnosov/java-explore-with-me/blob/main/ewm-main-service-spec.json)
- сервис статистики. Он собирает информацию о количестве обращений пользователей к спискам событий и
о количестве запросов к подробной информации о событии.
На основе этой информации формируется статистика о работе приложения. Состоит из HTTP-сервиса и HTTP-клиента.
["спецификация"](https://github.com/SergeyAnosov/java-explore-with-me/blob/main/ewm-stats-service-spec.json)

 





### для Запуска приложения необходимо:
- Выполнить в терминале ***docker compose up***
- Запустить Postman-коллекцию основного сервиса [**postman/main_service_test.json**]() из корневой папки *postman* 
- Запустить Postman-коллекцию **postman/feature.json** из корневой папки *postman*
