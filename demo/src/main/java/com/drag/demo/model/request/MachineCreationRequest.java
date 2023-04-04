package com.drag.demo.model.request;

import lombok.Data;

@Data
public class MachineCreationRequest {
    private Long pc_id;
    private Long o_id;
    private String mname;
}
