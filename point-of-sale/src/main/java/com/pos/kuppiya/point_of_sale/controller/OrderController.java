package com.pos.kuppiya.point_of_sale.controller;

import com.pos.kuppiya.point_of_sale.dto.paginated.PaginatedResponseItemDTO;
import com.pos.kuppiya.point_of_sale.dto.request.ItemSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.OrderSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.service.OrderService;
import com.pos.kuppiya.point_of_sale.util.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody OrderSaveRequestDTO orderSaveRequestDTO) {
        String id = orderService.addOrder(orderSaveRequestDTO);

        System.out.println(orderSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201," item saved success",2),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            params = {"paidStatus","page","size"},
            path = {"/get_paid_status"}
    )
    public ResponseEntity<StandardResponse> getPaidStatus(
            @RequestParam(value = "paidStatus") String paidStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
            ){
        PaginatedResponseItemDTO paginatedResponseItemDTO = null;
        if(paidStatus.equalsIgnoreCase("PAID")||paidStatus.equalsIgnoreCase("Not paid")){

        }




        return null;
    }

}
