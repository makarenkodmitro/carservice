package com.carservice;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderWorkId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "work_name", length = 100)
    private String workName;

    public OrderWorkId() {
    }

    public OrderWorkId(Integer orderId, String workName) {
        this.orderId = orderId;
        this.workName = workName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderWorkId)) {
            return false;
        }
        OrderWorkId that = (OrderWorkId) other;
        return Objects.equals(orderId, that.orderId)
                && Objects.equals(workName, that.workName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, workName);
    }
}
