package com.carservice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class MainApp {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(ServiceOrder.class)
                .addAnnotatedClass(Work.class)
                .addAnnotatedClass(OrderWork.class)
                .buildSessionFactory()) {

            seedSampleData(factory);

            try (Session session = factory.openSession()) {
                List<CarServiceScheduleDTO> results = session.createQuery(
                        "select new com.carservice.CarServiceScheduleDTO("
                                + "o.orderId, o.orderDate, c.licensePlate, c.brand, c.model, "
                                + "w.workName, w.workCategory, ow.duration, ow.cost) "
                                + "from OrderWork ow "
                                + "join ow.order o "
                                + "join o.car c "
                                + "join ow.work w "
                                + "order by o.orderDate, o.orderId, w.workName",
                        CarServiceScheduleDTO.class).getResultList();

                for (CarServiceScheduleDTO info : results) {
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

    private static void seedSampleData(SessionFactory factory) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Car skoda = createCar(session, "CA 1001 AA", "Skoda", "Octavia");
                Car renault = createCar(session, "CA 2002 BB", "Renault", "Megane");
                Car toyota = createCar(session, "CA 3003 CC", "Toyota", "Corolla");

                Work pads = createWork(session, "Заміна колодок", "Гальмівна система");
                Work oil = createWork(session, "Заміна мастила", "Технічне обслуговування");
                Work filter = createWork(session, "Заміна фільтра", "Технічне обслуговування");
                Work lights = createWork(session, "Перевірка освітлення", "Електрообладнання");
                Map<Integer, ServiceOrder> orders = new HashMap<>();

                addWork(session, orders, 1201, "2026-09-02", skoda, pads, "1.5", "900");
                addWork(session, orders, 1201, "2026-09-02", skoda, oil, "0.8", "500");
                addWork(session, orders, 1201, "2026-09-02", skoda, filter, "1.2", "850");
                addWork(session, orders, 1202, "2026-09-03", renault, pads, "1.2", "850");
                addWork(session, orders, 1202, "2026-09-03", renault, lights, "0.5", "300");
                addWork(session, orders, 1203, "2026-09-05", skoda, pads, "0.5", "300");
                addWork(session, orders, 1203, "2026-09-05", skoda, oil, "0.7", "520");
                addWork(session, orders, 1203, "2026-09-05", skoda, filter, "0.3", "200");
                addWork(session, orders, 1204, "2026-09-07", toyota, filter, "0.4", "230");
                addWork(session, orders, 1204, "2026-09-07", toyota, lights, "0.6", "350");
                addWork(session, orders, 1205, "2026-09-09", renault, oil, "1.6", "1000");
                addWork(session, orders, 1205, "2026-09-09", renault, lights, "0.5", "350");
                addWork(session, orders, 1206, "2026-09-19", skoda, pads, "1.5", "900");
                addWork(session, orders, 1206, "2026-09-19", skoda, oil, "0.8", "500");
                addWork(session, orders, 1206, "2026-09-19", skoda, filter, "1.2", "850");
                addWork(session, orders, 1207, "2026-09-29", renault, pads, "1.2", "850");
                addWork(session, orders, 1207, "2026-09-29", renault, lights, "0.5", "300");
                addWork(session, orders, 1208, "2026-10-09", skoda, pads, "0.5", "300");
                addWork(session, orders, 1208, "2026-10-09", skoda, oil, "0.7", "520");
                addWork(session, orders, 1208, "2026-10-09", skoda, filter, "0.3", "200");
                addWork(session, orders, 1209, "2026-10-19", toyota, filter, "0.4", "230");
                addWork(session, orders, 1209, "2026-10-19", toyota, lights, "0.6", "350");
                addWork(session, orders, 1210, "2026-10-29", renault, oil, "1.6", "1000");
                addWork(session, orders, 1210, "2026-10-29", renault, lights, "0.5", "350");
                addWork(session, orders, 1211, "2026-11-08", skoda, pads, "1.5", "900");
                addWork(session, orders, 1211, "2026-11-08", skoda, oil, "0.8", "500");
                addWork(session, orders, 1211, "2026-11-08", skoda, filter, "1.2", "850");
                addWork(session, orders, 1212, "2026-11-18", renault, pads, "1.2", "850");
                addWork(session, orders, 1212, "2026-11-18", renault, lights, "0.5", "300");

                transaction.commit();
            } catch (RuntimeException e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw e;
            }
        }
    }

    private static Car createCar(Session session, String licensePlate, String brand, String model) {
        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setBrand(brand);
        car.setModel(model);
        session.persist(car);
        return car;
    }

    private static Work createWork(Session session, String workName, String category) {
        Work work = new Work();
        work.setWorkName(workName);
        work.setWorkCategory(category);
        session.persist(work);
        return work;
    }

    private static void addWork(
            Session session,
            Map<Integer, ServiceOrder> orders,
            int orderId,
            String date,
            Car car,
            Work work,
            String duration,
            String cost) {
        ServiceOrder order = orders.get(orderId);
        if (order == null) {
            order = new ServiceOrder();
            order.setOrderId(orderId);
            order.setOrderDate(LocalDate.parse(date));
            order.setCar(car);
            session.persist(order);
            orders.put(orderId, order);
        }

        OrderWorkId id = new OrderWorkId(orderId, work.getWorkName());
        OrderWork orderWork = new OrderWork();
        orderWork.setId(id);
        orderWork.setOrder(order);
        orderWork.setWork(work);
        orderWork.setDuration(new BigDecimal(duration));
        orderWork.setCost(new BigDecimal(cost));
        session.persist(orderWork);
    }
}