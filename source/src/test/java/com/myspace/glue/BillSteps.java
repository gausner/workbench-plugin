package com.myspace.glue;

import com.myspace.kie_server_test.Bill;
import com.myspace.mother.BillMother;
import cucumber.api.java.en.Given;

public class BillSteps {

    @Given("^Received bill supposed to be reimbursed$")
    public void receivingBillToReimburse() {
        Bill bill = BillMother.reimbursementBill();
        String docId = bill.getDocId();
    }
}
