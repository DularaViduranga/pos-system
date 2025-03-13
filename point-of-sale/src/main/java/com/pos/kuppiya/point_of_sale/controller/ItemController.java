package com.pos.kuppiya.point_of_sale.controller;

import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.ItemDTO;
import com.pos.kuppiya.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.service.ItemService;
import com.pos.kuppiya.point_of_sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/get-all-items")
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<ItemDTO> allItems = itemService.getAllItems();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",allItems),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"/get-all-items-state"},params = {"state"})
    public ResponseEntity<StandardResponse> getAllCustomersBystate(@RequestParam (value = "state")String state) {
        if(state.equalsIgnoreCase("ACTIVE")||state.equalsIgnoreCase("INACTIVE")) {
//            boolean status = false;
//            if(state.equalsIgnoreCase("ACTIVE")) {
//                status = true;
//            }
            boolean status = state.equalsIgnoreCase("ACTIVE")?true:false;
            List<ItemDTO> allItems = itemService.getAllItemsByStateType(status);
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200,"success",allItems),
                    HttpStatus.OK
            );
        }else if (state.equalsIgnoreCase("all"))
        {
            List<ItemDTO> allItems = itemService.getAllItems();
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200,"success",allItems),
                    HttpStatus.OK
            );
        }
        else {
            return null;
        }
    }
}
