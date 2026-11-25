package com.carservice;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CarServiceApplication implements CommandLineRunner {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Додати наряди з CSV-файлу");
            System.out.println("2. Переглянути наряди");
            System.out.println("3. Видалити всі наряди");
            System.out.println("4. Вихід");
            System.out.print("Введіть номер команди (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    importOrdersFromCsv();
                    break;
                case 2:
                    viewAllOrders();
                    break;
                case 3:
                    deleteAllOrders();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Номер команди некоректний. Спробуй ще.");
            }
        }
    }

    private void importOrdersFromCsv() throws IOException, CsvException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("service-orders.csv")) {
            if (input == null) {
                throw new IOException("Ресурс service-orders.csv не знайдено.");
            }

            try (CSVReader reader = new CSVReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
                List<String[]> records = reader.readAll();
                String[] expectedHeader = {
                    "order_number", "opening_date", "license_plate", "brand", "model", "performed_works"
                };
                if (records.isEmpty() || !Arrays.equals(records.get(0), expectedHeader)) {
                    throw new IOException("CSV-файл має містити очікувані шість стовпців сервісного наряду.");
                }

                List<ServiceOrder> orders = new ArrayList<>();
                for (int i = 1; i < records.size(); i++) {
                    String[] record = records.get(i);
                    if (record.length != expectedHeader.length) {
                        throw new IOException("Некоректна кількість стовпців у рядку CSV " + (i + 1) + ".");
                    }

                    orders.add(new ServiceOrder(
                            Integer.valueOf(record[0]),
                            record[1],
                            record[2],
                            record[3],
                            record[4],
                            record[5]));
                }

                serviceOrderRepository.saveAll(orders);
                System.out.println(orders.size() + " сервісних нарядів імпортовано з CSV.");
            }
        }
    }

    private void viewAllOrders() {
        List<ServiceOrder> orders = serviceOrderRepository.findAll();
        if (orders.isEmpty()) {
            System.out.println("Сервісні наряди не знайдено.");
        } else {
            System.out.println("Знайдено сервісних нарядів: " + orders.size());
            orders.forEach(System.out::println);
        }
    }

    private void deleteAllOrders() {
        serviceOrderRepository.deleteAll();
        System.out.println("Усі сервісні наряди видалено.");
    }
}