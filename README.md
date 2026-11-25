# Java-програма для обліку сервісних нарядів у MongoDB

## Кроки для виконання

1. Встановіть Java Development Kit 17 або новішу версію. Застосунок перевірено на JDK 17.
2. Завантажте [Apache Maven 3.9.9](https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.zip) і розпакуйте архів.
3. У змінних середовища Windows створіть `MAVEN_HOME`, вказавши шлях до розпакованої папки Maven, і додайте `%MAVEN_HOME%\bin` до системної змінної `Path`.
4. Встановіть MongoDB Community Server для Windows. Під час встановлення виберіть `Complete` і `Run service as Network Service user`. Переконайтеся, що сервер працює на `localhost:27017`.
5. Встановіть MongoDB Compass, щоб переглядати дані через графічний інтерфейс.
6. Не потрібно створювати базу або колекцію вручну. Застосунок використовує базу `carservice` і колекцію `carservice`; MongoDB створить їх під час першого імпорту даних.
7. Відкрийте PowerShell у кореневій папці проєкту та зберіть програму:

   ```powershell
   mvn clean install
   ```

8. Запустіть програму:

   ```powershell
   mvn exec:java -D"exec.mainClass=com.carservice.CarServiceApplication"
   ```

9. У меню виберіть потрібну дію: імпорт нарядів із `service-orders.csv`, перегляд або видалення всіх нарядів.

## Результати виконання програми
```
PS C:\Users\Lenovo\carservice> mvn clean install                                                    
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< com.carservice:carservice >----------------------
[INFO] Building carservice 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ carservice ---
[INFO] Deleting C:\Users\Lenovo\carservice\target
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ carservice ---
[INFO] Copying 2 resources from src\main\resources to target\classes
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ carservice ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 3 source files with javac [debug target 1.8] to target\classes
[WARNING] bootstrap class path not set in conjunction with -source 8
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ carservice ---
[INFO] skip non existing resourceDirectory C:\Users\Lenovo\carservice\src\test\resources
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ carservice ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 1 source file with javac [debug target 1.8] to target\test-classes
[WARNING] bootstrap class path not set in conjunction with -source 8
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ carservice ---
[INFO] Using auto detected provider org.apache.maven.surefire.junit.JUnit3Provider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.carservice.AppTest
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.014 s -- in com.carservice.AppTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- jar:3.4.1:jar (default-jar) @ carservice ---
[INFO] Building jar: C:\Users\Lenovo\carservice\target\carservice-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- install:3.1.2:install (default-install) @ carservice ---
[INFO] Installing C:\Users\Lenovo\carservice\pom.xml to C:\Users\Lenovo\.m2\repository\com\carservice\carservice\1.0-SNAPSHOT\carservice-1.0-SNAPSHOT.pom
[INFO] Installing C:\Users\Lenovo\carservice\target\carservice-1.0-SNAPSHOT.jar to C:\Users\Lenovo\.m2\repository\com\carservice\carservice\1.0-SNAPSHOT\carservice-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.627 s
[INFO] Finished at: 2026-11-25T23:52:47+02:00
[INFO] ------------------------------------------------------------------------
PS C:\Users\Lenovo\carservice> mvn exec:java -D"exec.mainClass=com.carservice.CarServiceApplication"
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< com.carservice:carservice >----------------------
[INFO] Building carservice 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.7.0:java (default-cli) @ carservice ---

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.4)

2026-11-25 23:52:54.942  INFO 11388 --- [lication.main()] com.carservice.CarServiceApplication     : Starting CarServiceApplication using Java 17.0.21.0.2 on DESKTOP-NF861LS with PID 11388 (C:\Users\Lenovo\carservice\target\classes started by Lenovo in C:\Users\Lenovo\carservice)
2026-11-25 23:52:54.944  INFO 11388 --- [lication.main()] com.carservice.CarServiceApplication     : No active profile set, falling back to default profiles: default
2026-11-25 23:52:55.201  INFO 11388 --- [lication.main()] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data MongoDB repositories in DEFAULT mode.
2026-11-25 23:52:55.236  INFO 11388 --- [lication.main()] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 31 ms. Found 1 MongoDB repository interfaces.
2026-11-25 23:52:55.453  INFO 11388 --- [lication.main()] org.mongodb.driver.cluster               : Cluster created with settings {hosts=[localhost:27017], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms'}
2026-11-25 23:52:55.500  INFO 11388 --- [localhost:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:2, serverValue:70}] to localhost:27017
2026-11-25 23:52:55.500  INFO 11388 --- [localhost:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:1, serverValue:71}] to localhost:27017
2026-11-25 23:52:55.500  INFO 11388 --- [localhost:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=25, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=15238800}
2026-11-25 23:52:55.717  INFO 11388 --- [lication.main()] com.carservice.CarServiceApplication     : Started CarServiceApplication in 1.015 seconds (JVM running for 2.605)
1. Додати наряди з CSV-файлу
2. Переглянути наряди
3. Видалити всі наряди
4. Вихід
Введіть номер команди (1-4): 1
2026-11-25 23:53:01.646  INFO 11388 --- [lication.main()] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:3, serverValue:72}] to localhost:27017
12 сервісних нарядів імпортовано з CSV.
1. Додати наряди з CSV-файлу
2. Переглянути наряди
3. Видалити всі наряди
4. Вихід
Введіть номер команди (1-4): 2
Знайдено сервісних нарядів: 24
ServiceOrder { id="6b0757129f198211c20ea570"
 orderNumber="1201"
 openingDate="2026-09-02"
 licensePlate="CA 1001 AA"
 brand="Skoda"
 model="Octavia"
 performedWorks="Заміна мастила / Технічне обслуговування / 0.8 / 500 
Заміна колодок / Гальмівна система / 1.5 / 900 
Заміна фільтра / Технічне обслуговування / 1.2 / 850"
}
ServiceOrder { id="6b0757129f198211c20ea571"
 orderNumber="1202"
 openingDate="2026-09-03"
 licensePlate="CA 2002 BB"
 brand="Renault"
 model="Megane"
 performedWorks="Заміна колодок / Гальмівна система / 1.2 / 850 
Перевірка освітлення / Електрообладнання / 0.5 / 300"
}
ServiceOrder { id="6b0757129f198211c20ea572"
 orderNumber="1203"
 openingDate="2026-09-05"
 licensePlate="CA 1001 AA"
 brand="Skoda"
 model="Octavia"
 performedWorks="Заміна мастила / Технічне обслуговування / 0.7 / 520 
Заміна фільтра / Технічне обслуговування / 0.3 / 200 
Заміна колодок / Гальмівна система / 1.0 / 850"
}
ServiceOrder { id="6b0757129f198211c20ea573"
 orderNumber="1204"
 openingDate="2026-09-07"
 licensePlate="CA 3003 CC"
 brand="Toyota"
 model="Corolla"
 performedWorks="Перевірка освітлення / Електрообладнання / 0.6 / 350 
Заміна фільтра / Технічне обслуговування / 0.4 / 230"
}
ServiceOrder { id="6b0757129f198211c20ea574"
 orderNumber="1205"
 openingDate="2026-09-09"
 licensePlate="CA 2002 BB"
 brand="Renault"
 model="Megane"
 performedWorks="Заміна мастила / Технічне обслуговування / 1.6 / 1000 
Перевірка освітлення / Електрообладнання / 0.5 / 350"
}
ServiceOrder { id="6b0757129f198211c20ea575"
 orderNumber="1206"
 openingDate="2026-09-19"
 licensePlate="CA 1001 AA"
 brand="Skoda"
 model="Octavia"
 performedWorks="Заміна мастила / Технічне обслуговування / 0.8 / 500 
Заміна колодок / Гальмівна система / 1.5 / 900 
Заміна фільтра / Технічне обслуговування / 1.2 / 850"
}
ServiceOrder { id="6b0757129f198211c20ea576"
 orderNumber="1207"
 openingDate="2026-09-29"
 licensePlate="CA 2002 BB"
 brand="Renault"
 model="Megane"
 performedWorks="Заміна колодок / Гальмівна система / 1.2 / 850 
Перевірка освітлення / Електрообладнання / 0.5 / 300"
}
ServiceOrder { id="6b0757129f198211c20ea577"
 orderNumber="1208"
 openingDate="2026-10-09"
 licensePlate="CA 1001 AA"
 brand="Skoda"
 model="Octavia"
 performedWorks="Заміна мастила / Технічне обслуговування / 0.7 / 520 
Заміна фільтра / Технічне обслуговування / 0.3 / 200 
Заміна колодок / Гальмівна система / 1.0 / 850"
}
ServiceOrder { id="6b0757129f198211c20ea578"
 orderNumber="1209"
 openingDate="2026-10-19"
 licensePlate="CA 3003 CC"
 brand="Toyota"
 model="Corolla"
 performedWorks="Перевірка освітлення / Електрообладнання / 0.6 / 350 
Заміна фільтра / Технічне обслуговування / 0.4 / 230"
}
ServiceOrder { id="6b0757129f198211c20ea579"
 orderNumber="1210"
 openingDate="2026-10-29"
 licensePlate="CA 2002 BB"
 brand="Renault"
 model="Megane"
 performedWorks="Заміна мастила / Технічне обслуговування / 1.6 / 1000 
Перевірка освітлення / Електрообладнання / 0.5 / 350"
}
ServiceOrder { id="6b0757129f198211c20ea57a"
 orderNumber="1211"
 openingDate="2026-11-08"
 licensePlate="CA 1001 AA"
 brand="Skoda"
 model="Octavia"
 performedWorks="Заміна мастила / Технічне обслуговування / 0.8 / 500 
Заміна колодок / Гальмівна система / 1.5 / 900 
Заміна фільтра / Технічне обслуговування / 1.2 / 850"
}
ServiceOrder { id="6b0757129f198211c20ea57b"
 orderNumber="1212"
 openingDate="2026-11-18"
 licensePlate="CA 2002 BB"
 brand="Renault"
 model="Megane"
 performedWorks="Заміна колодок / Гальмівна система / 1.2 / 850 
Перевірка освітлення / Електрообладнання / 0.5 / 300"
}
ServiceOrder { id="6b0758bd37cfc624e22f276a"
 orderNumber="1201"
 openingDate="2026-09-02"
 licensePlate="CA 1001 AA"
 brand="Skoda"
 model="Octavia"
 performedWorks="Заміна мастила / Технічне обслуговування / 0.8 / 500 
Заміна колодок / Гальмівна система / 1.5 / 900 
Заміна фільтра / Технічне обслуговування / 1.2 / 850"
}
ServiceOrder { id="6b0758bd37cfc624e22f276b"
 orderNumber="1202"
 openingDate="2026-09-03"
 licensePlate="CA 2002 BB"
 brand="Renault"
 model="Megane"
 performedWorks="Заміна колодок / Гальмівна система / 1.2 / 850 
Перевірка освітлення / Електрообладнання / 0.5 / 300"
}
ServiceOrder { id="6b0758bd37cfc624e22f276c"
 orderNumber="1203"
 openingDate="2026-09-05"
 licensePlate="CA 1001 AA"
 brand="Skoda"
 model="Octavia"
 performedWorks="Заміна мастила / Технічне обслуговування / 0.7 / 520 
Заміна фільтра / Технічне обслуговування / 0.3 / 200 
Заміна колодок / Гальмівна система / 1.0 / 850"
}
ServiceOrder { id="6b0758bd37cfc624e22f276d"
 orderNumber="1204"
 openingDate="2026-09-07"
 licensePlate="CA 3003 CC"
 brand="Toyota"
 model="Corolla"
 performedWorks="Перевірка освітлення / Електрообладнання / 0.6 / 350 
Заміна фільтра / Технічне обслуговування / 0.4 / 230"
}
ServiceOrder { id="6b0758bd37cfc624e22f276e"
 orderNumber="1205"
 openingDate="2026-09-09"
 licensePlate="CA 2002 BB"
 brand="Renault"
 model="Megane"
 performedWorks="Заміна мастила / Технічне обслуговування / 1.6 / 1000 
Перевірка освітлення / Електрообладнання / 0.5 / 350"
}
ServiceOrder { id="6b0758bd37cfc624e22f276f"
 orderNumber="1206"
 openingDate="2026-09-19"
 licensePlate="CA 1001 AA"
 brand="Skoda"
 model="Octavia"
 performedWorks="Заміна мастила / Технічне обслуговування / 0.8 / 500 
Заміна колодок / Гальмівна система / 1.5 / 900 
Заміна фільтра / Технічне обслуговування / 1.2 / 850"
}
ServiceOrder { id="6b0758bd37cfc624e22f2770"
 orderNumber="1207"
 openingDate="2026-09-29"
 licensePlate="CA 2002 BB"
 brand="Renault"
 model="Megane"
 performedWorks="Заміна колодок / Гальмівна система / 1.2 / 850 
Перевірка освітлення / Електрообладнання / 0.5 / 300"
}
ServiceOrder { id="6b0758bd37cfc624e22f2771"
 orderNumber="1208"
 openingDate="2026-10-09"
 licensePlate="CA 1001 AA"
 brand="Skoda"
 model="Octavia"
 performedWorks="Заміна мастила / Технічне обслуговування / 0.7 / 520 
Заміна фільтра / Технічне обслуговування / 0.3 / 200 
Заміна колодок / Гальмівна система / 1.0 / 850"
}
ServiceOrder { id="6b0758bd37cfc624e22f2772"
 orderNumber="1209"
 openingDate="2026-10-19"
 licensePlate="CA 3003 CC"
 brand="Toyota"
 model="Corolla"
 performedWorks="Перевірка освітлення / Електрообладнання / 0.6 / 350 
Заміна фільтра / Технічне обслуговування / 0.4 / 230"
}
ServiceOrder { id="6b0758bd37cfc624e22f2773"
 orderNumber="1210"
 openingDate="2026-10-29"
 licensePlate="CA 2002 BB"
 brand="Renault"
 model="Megane"
 performedWorks="Заміна мастила / Технічне обслуговування / 1.6 / 1000 
Перевірка освітлення / Електрообладнання / 0.5 / 350"
}
ServiceOrder { id="6b0758bd37cfc624e22f2774"
 orderNumber="1211"
 openingDate="2026-11-08"
 licensePlate="CA 1001 AA"
 brand="Skoda"
 model="Octavia"
 performedWorks="Заміна мастила / Технічне обслуговування / 0.8 / 500 
Заміна колодок / Гальмівна система / 1.5 / 900 
Заміна фільтра / Технічне обслуговування / 1.2 / 850"
}
ServiceOrder { id="6b0758bd37cfc624e22f2775"
 orderNumber="1212"
 openingDate="2026-11-18"
 licensePlate="CA 2002 BB"
 brand="Renault"
 model="Megane"
 performedWorks="Заміна колодок / Гальмівна система / 1.2 / 850 
Перевірка освітлення / Електрообладнання / 0.5 / 300"
}
1. Додати наряди з CSV-файлу
2. Переглянути наряди
3. Видалити всі наряди
4. Вихід
Введіть номер команди (1-4): 3
Усі сервісні наряди видалено.
1. Додати наряди з CSV-файлу
2. Переглянути наряди
3. Видалити всі наряди
4. Вихід
Введіть номер команди (1-4): 1
12 сервісних нарядів імпортовано з CSV.
1. Додати наряди з CSV-файлу
2. Переглянути наряди
3. Видалити всі наряди
4. Вихід
Введіть номер команди (1-4): 4
2026-11-25 23:53:50.152  INFO 11388 --- [ionShutdownHook] org.mongodb.driver.connection            : Closed connection [connectionId{localValue:3, serverValue:72}] to localhost:27017 because the pool has been closed.