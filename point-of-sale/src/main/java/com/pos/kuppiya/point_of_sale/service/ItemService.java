package com.pos.kuppiya.point_of_sale.service;

import com.pos.kuppiya.point_of_sale.dto.request.ItemSaveRequestDTO;

public interface ItemService {
    String addItem(ItemSaveRequestDTO itemSaveRequestDTO);
}
