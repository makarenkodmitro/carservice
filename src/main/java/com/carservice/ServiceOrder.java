package com.carservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carservice")
public class ServiceOrder {
    @Id
    private String id;
    private Integer orderNumber;
    private String openingDate;
    private String licensePlate;
    private String brand;
    private String model;
    private String performedWorks;

    public ServiceOrder() {
    }

    public ServiceOrder(Integer orderNumber, String openingDate, String licensePlate,
            String brand, String model, String performedWorks) {
        this.orderNumber = orderNumber;
        this.openingDate = openingDate;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.performedWorks = performedWorks;
    }

    public String toString() {
        String formattedPerformedWorks = performedWorks == null
                ? null
                : performedWorks.replaceAll("\\s*;\\s*", System.lineSeparator());
        return "ServiceOrder {" +
                " id=\"" + id + "\"\n" +
                " orderNumber=\"" + orderNumber + "\"\n" +
                " openingDate=\"" + openingDate + "\"\n" +
                " licensePlate=\"" + licensePlate + "\"\n" +
                " brand=\"" + brand + "\"\n" +
                " model=\"" + model + "\"\n" +
                " performedWorks=\"" + formattedPerformedWorks + "\"\n" +
                "}";
    }
}