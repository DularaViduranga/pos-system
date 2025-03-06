package com.pos.kuppiya.point_of_sale.service;

import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateQueryRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.response.ResponseActiveCustomerDTO;

import java.util.List;


public interface CustomerService {

    String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);


    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();

    boolean deleteCustomer(int id);

    List<CustomerDTO> getByName(String customerName);

    List<CustomerDTO> getCustomerByActiveState();

    List<ResponseActiveCustomerDTO> getCustomerByActiveStateAndName();

    String updateCustomerByQuery(CustomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO,int id);
}
