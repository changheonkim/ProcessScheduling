package com.drag.demo.model.request;

import lombok.Data;

@Data
public class OrderProcessCreationRequest {
    private Long pc_id;
    private Long p_id;
    private Long idx;
}
