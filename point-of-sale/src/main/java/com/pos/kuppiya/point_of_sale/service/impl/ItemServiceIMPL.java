package com.pos.kuppiya.point_of_sale.service.impl;

import com.pos.kuppiya.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.entity.Item;
import com.pos.kuppiya.point_of_sale.exception.EntryDuplicateException;
import com.pos.kuppiya.point_of_sale.repo.ItemRepo;
import com.pos.kuppiya.point_of_sale.service.ItemService;
import com.pos.kuppiya.point_of_sale.util.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String addItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item = itemMapper.RequestDTOtoEntity(itemSaveRequestDTO);
        item.setActiveState(true);
        if(!itemRepo.existsById(item.getItemId())){
            return itemRepo.save(item).getItemName();
        }else {
            throw new EntryDuplicateException("Entry already exists");
        }
    }
}
