package com.ramirez.hexagonal.infrastructure.persistence.dynamo.repository;

import java.util.Optional;

import com.ramirez.hexagonal.domain.model.Order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.ramirez.hexagonal.domain.repository.OrderRepository;
import com.ramirez.hexagonal.infrastructure.persistence.dynamo.entities.OrderEntity;
import com.ramirez.hexagonal.infrastructure.persistence.dynamo.mapper.OrderMapper;

@Repository
public class OrderRepositoryImpl extends BaseRepository<OrderEntity>  implements OrderRepository {
    
    @Value("${amazon.dynamo.orders.table}")
    private String table;
    @Value("#{new Boolean('${amazon.dynamo.orders.consistentRead}')}")
    private boolean consistentRead;


    @Override
    public String getTableName(){
        return table;
    }


    @Override
    public void save(Order order) {
        OrderEntity entity = OrderMapper.toEntity(order);
        super.save(entity);
    }

    @Override
    public Order findById(String orderId, Optional<String> sk) {
        OrderEntity entity = super.getItem(orderId, sk);
        return OrderMapper.toModel(entity);
    }

    @Override
    public void update(Order order) {
        OrderEntity entity = OrderMapper.toEntity(order);
        super.update(entity);
    }    
    
}
