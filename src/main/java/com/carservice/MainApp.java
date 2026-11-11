package com.carservice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(ServiceOrder.class)
                .addAnnotatedClass(Work.class)
                .addAnnotatedClass(OrderWork.class)
                .buildSessionFactory();
             Session session = factory.openSession()) {

            List<ScheduleInfoDTO> results = session.createQuery(
                    "select new com.carservice.ScheduleInfoDTO("
                            + "o.orderId, o.orderDate, c.licensePlate, c.brand, c.model, "
                            + "w.workName, w.workCategory, ow.duration, ow.cost) "
                            + "from OrderWork ow "
                            + "join ow.order o "
                            + "join o.car c "
                            + "join ow.work w "
                            + "order by o.orderDate, o.orderId, w.workName",
                    ScheduleInfoDTO.class).getResultList();

            for (ScheduleInfoDTO info : results) {
                System.out.printf(
                        "Замовлення: %d%n"
                                + "Дата замовлення: %s%n"
                                + "Автомобіль: %s %s%n"
                                + "Номерний знак: %s%n"
                                + "Робота: %s%n"
                                + "Категорія: %s%n"
                                + "Тривалість: %s%n"
                                + "Вартість: %s%n"
                                + "--------------------------------------------------%n",
                        info.getOrderId(),
                        info.getOrderDate(),
                        info.getBrand(),
                        info.getModel(),
                        info.getLicensePlate(),
                        info.getWorkName(),
                        info.getWorkCategory(),
                        info.getDuration(),
                        info.getCost());
            }
        }
    }
}
