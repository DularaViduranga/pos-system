package com.pos.kuppiya.point_of_sale.service.impl;

import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.ItemDTO;
import com.pos.kuppiya.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.entity.Customer;
import com.pos.kuppiya.point_of_sale.entity.Item;
import com.pos.kuppiya.point_of_sale.exception.EntryDuplicateException;
import com.pos.kuppiya.point_of_sale.repo.ItemRepo;
import com.pos.kuppiya.point_of_sale.service.ItemService;
import com.pos.kuppiya.point_of_sale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

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

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> getItems = StreamSupport
                .stream(itemRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
        List<ItemDTO> itemDTOS = modelMapper.map(getItems, new TypeToken<List<ItemDTO>>() {}.getType());
        return itemDTOS;
    }
}
