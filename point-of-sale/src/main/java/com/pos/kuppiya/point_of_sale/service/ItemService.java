package com.pos.kuppiya.point_of_sale.service;

import com.pos.kuppiya.point_of_sale.dto.ItemDTO;
import com.pos.kuppiya.point_of_sale.dto.request.ItemSaveRequestDTO;

import java.util.List;

public interface ItemService {
    String addItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemDTO> getAllItems();
}
