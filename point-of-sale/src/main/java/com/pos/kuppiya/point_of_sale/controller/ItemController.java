package com.pos.kuppiya.point_of_sale.controller;

import com.pos.kuppiya.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.service.ItemService;
import com.pos.kuppiya.point_of_sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String id = itemService.addItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id+" item saved success",id),
                HttpStatus.CREATED
        );
    }
}
