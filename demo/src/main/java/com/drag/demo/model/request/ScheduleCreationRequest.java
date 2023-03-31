package com.drag.demo.model.request;
import lombok.Data;

@Data
public class ScheduleCreationRequest {
    private Long pcm_id;
    private java.sql.Date schedule;
}
