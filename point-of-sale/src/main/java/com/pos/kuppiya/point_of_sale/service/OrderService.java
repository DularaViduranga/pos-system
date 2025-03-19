package com.pos.kuppiya.point_of_sale.service;

import com.pos.kuppiya.point_of_sale.dto.paginated.PaginatedResponseOrderDetails;
import com.pos.kuppiya.point_of_sale.dto.request.OrderSaveRequestDTO;
import jakarta.validation.constraints.Max;

public interface OrderService {
    String addOrder(OrderSaveRequestDTO orderSaveRequestDTO);

    PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, @Max(50) int size);
}
