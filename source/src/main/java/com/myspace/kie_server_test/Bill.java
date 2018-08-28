package com.myspace.kie_server_test;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class Bill {
    private String docId;

    private String patientId;

    private Date dateOfLoss;

    private Date dateOfBirth;

    private Gender gender;

    private String claimId;

    private Provider provider;

    List<String> icdCodes;

    private List<Line> lines;
}
