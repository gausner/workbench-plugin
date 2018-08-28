package com.myspace.mother;

import com.myspace.kie_server_test.Bill;
import com.myspace.kie_server_test.Gender;
import com.myspace.kie_server_test.Line;
import com.myspace.kie_server_test.Provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BillMother {
    public static Bill reimbursementBill() {
        String docId = "123";
        String state = "CA";
        String id = "id";
        String tin = "tin";
        String zipCode = "zipCode";
        String patientId = "patientId";
        String claimId = "claimId";
        Date dateOfLoss = new Date();
        Date dateOfBirth = new Date();
        Gender gender = Gender.UNDEFINED;
        String icd1 = "123";
        String icd2 = "456";

        Line line1 = Line.builder()
                .treatmentState(state)
                .build();

        Provider provider1 = Provider.builder()
                .id(id)
                .tin(tin)
                .treatmentZipCode(zipCode)
                .treatmentState(state)
                .build();

        List<Line> lines = new ArrayList<>();
        lines.add(line1);

        return Bill.builder()
                .docId(docId)
                .patientId(patientId)
                .dateOfLoss(dateOfLoss)
                .dateOfBirth(dateOfBirth)
                .gender(gender)
                .claimId(claimId)
                .icdCodes(Arrays.asList(icd1, icd2))
                .provider(provider1)
                .lines(lines)
                .build();
    }
}
