package com.pos.kuppiya.point_of_sale.controller;

import com.pos.kuppiya.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.OrderSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {
    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody OrderSaveRequestDTO orderSaveRequestDTO) {
        System.out.println(orderSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201," item saved success",2),
                HttpStatus.CREATED
        );
    }
}
