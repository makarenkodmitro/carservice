# Carservice

Java консольний застосунок для імпорту та перегляду сервісних нарядів у MongoDB.

## Налаштування

- Java Development Kit 23
- Apache Maven
- MongoDB Community Server, запущений локально на `localhost:27017`

Застосунок використовує базу даних `carservice` та колекцію `carservice`. CSV-файл `service-orders.csv` містить наряди з такими стовпцями: номер, дата відкриття, державний номер, марка, модель і виконані роботи.

## Запуск

У терміналі з кореня проєкту виконайте:

```powershell
mvn clean install
mvn exec:java -D"exec.mainClass=com.carservice.CarServiceApplication"
```

Після запуску виберіть у меню імпорт нарядів із CSV, перегляд або видалення всіх нарядів.
