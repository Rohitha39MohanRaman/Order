package com.example.order.mapper;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.order.model.OrderDto;
import com.example.order.model.OrderVo;
@Mapper(componentModel = "Spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper{
	
		List<OrderVo> toOrderVos(List<OrderDto> list);
		List<OrderDto> toOrderDtos(List<OrderVo> list);
		OrderDto toOrderDto(OrderVo order);
		OrderVo toOrderVo(OrderDto order1);
}
