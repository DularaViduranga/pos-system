package com.pos.kuppiya.point_of_sale.controller;

import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;

import com.pos.kuppiya.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateQueryRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.response.ResponseActiveCustomerDTO;
import com.pos.kuppiya.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class TestController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO) {
        String id = customerService.addCustomer(customerSaveRequestDTO);
        return id;
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        String updated = customerService.updateCustomer(customerUpdateRequestDTO);
        return updated;
    }

    @GetMapping(
            path = {"/get-by-id"},
            params = {"id"}
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return customerDTO;
    }

    @GetMapping(path = "/get-all-cus")
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(path = "/delete-cus/{id}")
    public String deleteCustomer(@PathVariable(value = "id")int id) {
        boolean deletedCustomer = customerService.deleteCustomer(id);
        return "delete cus";
    }

    @GetMapping(
            path = {"/get-by-name"},
            params = {"name"}
    )
    public List<CustomerDTO> getCustomerByName(@RequestParam(value = "name")String customerName) {
        List<CustomerDTO> getCustomer = customerService.getByName(customerName);
        return getCustomer;
    }

    @GetMapping(
            path = {"/get-by-active-state"}
    )
    public List<CustomerDTO> getCustomerByActiveState(){
        List<CustomerDTO> getCustomer = customerService.getCustomerByActiveState();
        return getCustomer;
    }

    @GetMapping(
            path = {"/get-name-by-active-state"}
    )
    public List<ResponseActiveCustomerDTO> getCustomerByActiveStateAndName(){
        List<ResponseActiveCustomerDTO> getCustomer = customerService.getCustomerByActiveStateAndName();
        return getCustomer;
    }

    @PutMapping(path = "/update-query/{id}")
    public String updateCustomerByQuery(@RequestBody CustomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO, @PathVariable(value = "id")int id) {
        String updated = customerService.updateCustomerByQuery(customerUpdateQueryRequestDTO,id);
        return updated;
    }

}
