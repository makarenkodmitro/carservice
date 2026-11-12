# Кроки для виконання
1. Встановіть локально PostgreSQL, Maven та Java.
2. Створіть базу даних carservice.
3. Вкажіть правильне значення властивості `hibernate.connection.password` у файлі "src\main\resources\hibernate.cfg.xml".
4. Зберіть програму за допомогою команди: `mvn clean install`.
5. Запустіть програму за допомогою команди: `mvn exec:java -D"exec.mainClass=com.carservice.MainApp"`.

> Увага: під час кожного запуску Hibernate видаляє та створює таблиці проєкту заново. Наявні дані в таблицях `cars`, `"order"`, `works` та `order_works` буде втрачено; програма заповнить їх демонстраційними записами.

# Результати виконання програми
```
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< com.carservice:carservice-schedule >-----------------
[INFO] Building carservice-schedule 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.1.0:java (default-cli) @ carservice-schedule ---
Nov. 12, 2026 12:39:42 ПП org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 5.6.14.Final
Nov. 12, 2026 12:39:43 ПП org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
Nov. 12, 2026 12:39:43 ПП org.hibernate.engine.jdbc.connections.internal.ConnectionProviderInitiator instantiateC3p0Provider
WARN: HHH000022: c3p0 properties were encountered, but the c3p0 provider class was not found on the classpath; these properties are going to be ignored.
Nov. 12, 2026 12:39:43 ПП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
Nov. 12, 2026 12:39:43 ПП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [org.postgresql.Driver] at URL [jdbc:postgresql://localhost:5432/carservice]
Nov. 12, 2026 12:39:43 ПП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {password=****, user=postgres}
Nov. 12, 2026 12:39:43 ПП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Nov. 12, 2026 12:39:43 ПП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
Nov. 12, 2026 12:39:43 ПП org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.PostgreSQLDialect
Hibernate: 
    
    alter table "order" 
       drop constraint FKytqf0cpgkqvhoqresj3e03qm
Nov. 12, 2026 12:39:43 ПП org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@3857c5a1] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    
    alter table order_works 
       drop constraint FKdbveq2767je4q4eu4rq5dpr76
Hibernate: 
    
    alter table order_works 
       drop constraint FKlwb3rs5dwbq5oegyatohpd4jj
Hibernate: 
    
    drop table if exists cars cascade
Hibernate: 
    
    drop table if exists "order" cascade
Hibernate: 
    
    drop table if exists order_works cascade
Hibernate: 
    
    drop table if exists works cascade
Hibernate: 
    
    create table cars (
       license_plate varchar(20) not null,
        brand varchar(50),
        model varchar(50),
        primary key (license_plate)
    )
Nov. 12, 2026 12:39:43 ПП org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@4682e671] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: 
    
    create table "order" (
       order_id int4 not null,
        order_date date,
        license_plate varchar(20) not null,
        primary key (order_id)
    )
Hibernate: 
    
    create table order_works (
       order_id int4 not null,
        work_name varchar(100) not null,
        cost numeric,
        duration numeric,
        primary key (order_id, work_name)
    )
Hibernate: 
    
    create table works (
       work_name varchar(100) not null,
        work_category varchar(100),
        primary key (work_name)
    )
Hibernate: 
    
    alter table "order" 
       add constraint FKytqf0cpgkqvhoqresj3e03qm 
       foreign key (license_plate) 
       references cars
Hibernate: 
    
    alter table order_works 
       add constraint FKdbveq2767je4q4eu4rq5dpr76 
       foreign key (order_id) 
       references "order"
Hibernate: 
    
    alter table order_works 
       add constraint FKlwb3rs5dwbq5oegyatohpd4jj 
       foreign key (work_name) 
       references works
Hibernate: 
    insert 
    into
        cars
        (brand, model, license_plate) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        cars
        (brand, model, license_plate) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        cars
        (brand, model, license_plate) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        works
        (work_category, work_name) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        works
        (work_category, work_name) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        works
        (work_category, work_name) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        works
        (work_category, work_name) 
    values
        (?, ?)
Hibernate: 
    insert 
    into
        "order"
        (license_plate, order_date, order_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        "order"
        (license_plate, order_date, order_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        "order"
        (license_plate, order_date, order_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        "order"
        (license_plate, order_date, order_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        "order"
        (license_plate, order_date, order_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        "order"
        (license_plate, order_date, order_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        "order"
        (license_plate, order_date, order_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        "order"
        (license_plate, order_date, order_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        "order"
        (license_plate, order_date, order_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        "order"
        (license_plate, order_date, order_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        "order"
        (license_plate, order_date, order_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        "order"
        (license_plate, order_date, order_id) 
    values
        (?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    insert 
    into
        order_works
        (cost, duration, order_id, work_name) 
    values
        (?, ?, ?, ?)
Hibernate: 
    select
        serviceord1_.order_id as col_0_0_,
        serviceord1_.order_date as col_1_0_,
        car2_.license_plate as col_2_0_,
        car2_.brand as col_3_0_,
        car2_.model as col_4_0_,
        work3_.work_name as col_5_0_,
        work3_.work_category as col_6_0_,
        orderwork0_.duration as col_7_0_,
        orderwork0_.cost as col_8_0_ 
    from
        order_works orderwork0_ 
    inner join
        "order" serviceord1_ 
            on orderwork0_.order_id=serviceord1_.order_id 
    inner join
        cars car2_ 
            on serviceord1_.license_plate=car2_.license_plate 
    inner join
        works work3_ 
            on orderwork0_.work_name=work3_.work_name 
    order by
        serviceord1_.order_date,
        serviceord1_.order_id,
        work3_.work_name
Замовлення: 1201
Дата замовлення: 2026-09-02
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна колодок
Категорія: Гальмівна система
Тривалість: 1.5
Вартість: 900
--------------------------------------------------
Замовлення: 1201
Дата замовлення: 2026-09-02
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна мастила
Категорія: Технічне обслуговування
Тривалість: 0.8
Вартість: 500
--------------------------------------------------
Замовлення: 1201
Дата замовлення: 2026-09-02
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна фільтра
Категорія: Технічне обслуговування
Тривалість: 1.2
Вартість: 850
--------------------------------------------------
Замовлення: 1202
Дата замовлення: 2026-09-03
Автомобіль: Renault Megane
Номерний знак: CA 2002 BB
Робота: Заміна колодок
Категорія: Гальмівна система
Тривалість: 1.2
Вартість: 850
--------------------------------------------------
Замовлення: 1202
Дата замовлення: 2026-09-03
Автомобіль: Renault Megane
Номерний знак: CA 2002 BB
Робота: Перевірка освітлення
Категорія: Електрообладнання
Тривалість: 0.5
Вартість: 300
--------------------------------------------------
Замовлення: 1203
Дата замовлення: 2026-09-05
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна колодок
Категорія: Гальмівна система
Тривалість: 0.5
Вартість: 300
--------------------------------------------------
Замовлення: 1203
Дата замовлення: 2026-09-05
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна мастила
Категорія: Технічне обслуговування
Тривалість: 0.7
Вартість: 520
--------------------------------------------------
Замовлення: 1203
Дата замовлення: 2026-09-05
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна фільтра
Категорія: Технічне обслуговування
Тривалість: 0.3
Вартість: 200
--------------------------------------------------
Замовлення: 1204
Дата замовлення: 2026-09-07
Автомобіль: Toyota Corolla
Номерний знак: CA 3003 CC
Робота: Заміна фільтра
Категорія: Технічне обслуговування
Тривалість: 0.4
Вартість: 230
--------------------------------------------------
Замовлення: 1204
Дата замовлення: 2026-09-07
Автомобіль: Toyota Corolla
Номерний знак: CA 3003 CC
Робота: Перевірка освітлення
Категорія: Електрообладнання
Тривалість: 0.6
Вартість: 350
--------------------------------------------------
Замовлення: 1205
Дата замовлення: 2026-09-09
Автомобіль: Renault Megane
Номерний знак: CA 2002 BB
Робота: Заміна мастила
Категорія: Технічне обслуговування
Тривалість: 1.6
Вартість: 1000
--------------------------------------------------
Замовлення: 1205
Дата замовлення: 2026-09-09
Автомобіль: Renault Megane
Номерний знак: CA 2002 BB
Робота: Перевірка освітлення
Категорія: Електрообладнання
Тривалість: 0.5
Вартість: 350
--------------------------------------------------
Замовлення: 1206
Дата замовлення: 2026-09-19
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна колодок
Категорія: Гальмівна система
Тривалість: 1.5
Вартість: 900
--------------------------------------------------
Замовлення: 1206
Дата замовлення: 2026-09-19
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна мастила
Категорія: Технічне обслуговування
Тривалість: 0.8
Вартість: 500
--------------------------------------------------
Замовлення: 1206
Дата замовлення: 2026-09-19
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна фільтра
Категорія: Технічне обслуговування
Тривалість: 1.2
Вартість: 850
--------------------------------------------------
Замовлення: 1207
Дата замовлення: 2026-09-29
Автомобіль: Renault Megane
Номерний знак: CA 2002 BB
Робота: Заміна колодок
Категорія: Гальмівна система
Тривалість: 1.2
Вартість: 850
--------------------------------------------------
Замовлення: 1207
Дата замовлення: 2026-09-29
Автомобіль: Renault Megane
Номерний знак: CA 2002 BB
Робота: Перевірка освітлення
Категорія: Електрообладнання
Тривалість: 0.5
Вартість: 300
--------------------------------------------------
Замовлення: 1208
Дата замовлення: 2026-10-09
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна колодок
Категорія: Гальмівна система
Тривалість: 0.5
Вартість: 300
--------------------------------------------------
Замовлення: 1208
Дата замовлення: 2026-10-09
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна мастила
Категорія: Технічне обслуговування
Тривалість: 0.7
Вартість: 520
--------------------------------------------------
Замовлення: 1208
Дата замовлення: 2026-10-09
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна фільтра
Категорія: Технічне обслуговування
Тривалість: 0.3
Вартість: 200
--------------------------------------------------
Замовлення: 1209
Дата замовлення: 2026-10-19
Автомобіль: Toyota Corolla
Номерний знак: CA 3003 CC
Робота: Заміна фільтра
Категорія: Технічне обслуговування
Тривалість: 0.4
Вартість: 230
--------------------------------------------------
Замовлення: 1209
Дата замовлення: 2026-10-19
Автомобіль: Toyota Corolla
Номерний знак: CA 3003 CC
Робота: Перевірка освітлення
Категорія: Електрообладнання
Тривалість: 0.6
Вартість: 350
--------------------------------------------------
Замовлення: 1210
Дата замовлення: 2026-10-29
Автомобіль: Renault Megane
Номерний знак: CA 2002 BB
Робота: Заміна мастила
Категорія: Технічне обслуговування
Тривалість: 1.6
Вартість: 1000
--------------------------------------------------
Замовлення: 1210
Дата замовлення: 2026-10-29
Автомобіль: Renault Megane
Номерний знак: CA 2002 BB
Робота: Перевірка освітлення
Категорія: Електрообладнання
Тривалість: 0.5
Вартість: 350
--------------------------------------------------
Замовлення: 1211
Дата замовлення: 2026-11-08
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна колодок
Категорія: Гальмівна система
Тривалість: 1.5
Вартість: 900
--------------------------------------------------
Замовлення: 1211
Дата замовлення: 2026-11-08
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна мастила
Категорія: Технічне обслуговування
Тривалість: 0.8
Вартість: 500
--------------------------------------------------
Замовлення: 1211
Дата замовлення: 2026-11-08
Автомобіль: Skoda Octavia
Номерний знак: CA 1001 AA
Робота: Заміна фільтра
Категорія: Технічне обслуговування
Тривалість: 1.2
Вартість: 850
--------------------------------------------------
Замовлення: 1212
Дата замовлення: 2026-11-18
Автомобіль: Renault Megane
Номерний знак: CA 2002 BB
Робота: Заміна колодок
Категорія: Гальмівна система
Тривалість: 1.2
Вартість: 850
--------------------------------------------------
Замовлення: 1212
Дата замовлення: 2026-11-18
Автомобіль: Renault Megane
Номерний знак: CA 2002 BB
Робота: Перевірка освітлення
Категорія: Електрообладнання
Тривалість: 0.5
Вартість: 300
--------------------------------------------------
лист. 12, 2026 12:39:44 ПП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:postgresql://localhost:5432/carservice]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.730 s
[INFO] Finished at: 2026-11-12T12:39:44+02:00
[INFO] ------------------------------------------------------------------------
```