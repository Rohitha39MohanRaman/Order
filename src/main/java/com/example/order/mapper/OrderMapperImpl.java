package com.example.order.mapper;

import com.example.order.model.OrderDto;
import com.example.order.model.OrderVo;
import java.util.ArrayList;
import java.util.List;
//import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

//@Generated(
//    value = "org.mapstruct.ap.MappingProcessor",
//    date = "2022-11-09T22:01:07+0530",
//    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 18.0.1 (Eclipse Adoptium)"
//)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public List<OrderVo> toOrderVos(List<OrderDto> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderVo> list1 = new ArrayList<OrderVo>( list.size() );
        for ( OrderDto orderDto : list ) {
            list1.add( toOrderVo( orderDto ) );
        }

        return list1;
    }

    @Override
    public List<OrderDto> toOrderDtos(List<OrderVo> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDto> list1 = new ArrayList<OrderDto>( list.size() );
        for ( OrderVo orderVo : list ) {
            list1.add( toOrderDto( orderVo ) );
        }

        return list1;
    }

    @Override
    public OrderDto toOrderDto(OrderVo order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setOrderId( order.getOrderId() );
        orderDto.setOrderName( order.getOrderName() );

        return orderDto;
    }

    @Override
    public OrderVo toOrderVo(OrderDto order1) {
        if ( order1 == null ) {
            return null;
        }

        OrderVo orderVo = new OrderVo();

        orderVo.setOrderId( order1.getOrderId() );
        orderVo.setOrderName( order1.getOrderName() );

        return orderVo;
    }
}
