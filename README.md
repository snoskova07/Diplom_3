# Diplom_3 Selenium

## **Технологии:**
- Java 11
- Maven 3.8.1
- RestAssured 4.4.0
- Selenium 4
- Allure 2.24.1

## **Запуск тестов:**
- В Yandex-браузере:
`mvn clean test -DbrowserName=yandex`

- В chrome:
`mvn clean test -DbrowserName=chrome`

## **Отчет:**
`mvn allure:serve`