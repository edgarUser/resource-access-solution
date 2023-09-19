package com.mycom.resourceservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Resource {
    private String id;
    private String status;
}
