package com.carservice;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceOrderRepository extends MongoRepository<ServiceOrder, String> {
}