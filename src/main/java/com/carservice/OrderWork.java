package com.carservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "order_works")
public class OrderWork {
    @EmbeddedId
    private OrderWorkId id;

    @MapsId("orderId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id")
    private ServiceOrder order;

    @MapsId("workName")
    @ManyToOne(optional = false)
    @JoinColumn(name = "work_name", columnDefinition = "varchar(100)")
    private Work work;

    @Column(columnDefinition = "numeric")
    private BigDecimal duration;

    @Column(columnDefinition = "numeric")
    private BigDecimal cost;

    public OrderWorkId getId() {
        return id;
    }

    public void setId(OrderWorkId id) {
        this.id = id;
    }

    public ServiceOrder getOrder() {
        return order;
    }

    public void setOrder(ServiceOrder order) {
        this.order = order;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}