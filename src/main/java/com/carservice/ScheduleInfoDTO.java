package com.carservice;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ScheduleInfoDTO {
    private final Integer orderId;
    private final LocalDate orderDate;
    private final String licensePlate;
    private final String brand;
    private final String model;
    private final String workName;
    private final String workCategory;
    private final BigDecimal duration;
    private final BigDecimal cost;

    public ScheduleInfoDTO(Integer orderId, LocalDate orderDate, String licensePlate, String brand,
            String model, String workName, String workCategory, BigDecimal duration, BigDecimal cost) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.workName = workName;
        this.workCategory = workCategory;
        this.duration = duration;
        this.cost = cost;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getWorkName() {
        return workName;
    }

    public String getWorkCategory() {
        return workCategory;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
