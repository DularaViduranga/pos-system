package com.pos.kuppiya.point_of_sale.dto.request;

import com.pos.kuppiya.point_of_sale.entity.Item;
import com.pos.kuppiya.point_of_sale.entity.Orders;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailRequestDTO {
    private int orders;
    private String itemName;
    private double sellingPrice;
    private double qty;
    private double amount;
    private int items;
}
