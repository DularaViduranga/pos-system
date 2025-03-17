package com.pos.kuppiya.point_of_sale.dto.paginated;

import com.pos.kuppiya.point_of_sale.dto.response.ResponseOrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetails {
    private List<ResponseOrderDetails> list;
    private long dataCount;
}
