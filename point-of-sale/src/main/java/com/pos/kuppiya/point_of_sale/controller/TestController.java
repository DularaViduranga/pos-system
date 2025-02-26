package com.pos.kuppiya.point_of_sale.controller;

import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class TestController {

    @PostMapping(path = "/save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println("come " + customerDTO.getCustomerName());
        return null;
    }



}
