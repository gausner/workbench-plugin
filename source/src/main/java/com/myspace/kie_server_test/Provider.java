package com.myspace.kie_server_test;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Provider {
    private String id;

    private String tin;

    private String treatmentZipCode;

    private String treatmentState;
}
