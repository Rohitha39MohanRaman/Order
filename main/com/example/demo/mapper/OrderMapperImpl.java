package com.example.order.mapper;

import com.example.order.model.Order;
import com.example.order.model.OrderVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-20T10:40:43+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public List<OrderVo> toOrderVos(List<Order> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderVo> list1 = new ArrayList<OrderVo>( list.size() );
        for ( Order order : list ) {
            list1.add( toOrderVo( order ) );
        }

        return list1;
    }

    @Override
    public List<Order> toOrders(List<Vo> list) {
        if ( list == null ) {
            return null;
        }

        List<Order> list1 = new ArrayList<Order>( list.size() );
        for ( OrderVo orderVo : list ) {
            list1.add( toOrder( orderVo ) );
        }

        return list1;
    }

    @Override
    public Order toOrder(OrderVo order) {
        if ( order == null ) {
            return null;
        }

        Order order1 = new Order();

        order1.setOrderId( order.getOrderId() );
        order1.setOrderName( order.getOrderName() );

        return order1;
    }

    @Override
    public OrderVo toOrderVo(Order order1) {
        if ( product1 == null ) {
            return null;
        }

        OrderVo orderVo = new OrderVo();

        orderVo.setOrderId( order1.getOrderId() );
        orderVo.setOrderName( order1.getOrderName() );

        return orderVo;
    }
}
