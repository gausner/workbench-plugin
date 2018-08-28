package com.myspace.mother;

import com.myspace.kie_server_test.Applicant;

public class ApplicantMother {

    Applicant internal;

    public ApplicantMother harry() {
        return youngApplicant().withLoadsOfCash();
    }

    public ApplicantMother youngApplicant(){
        applicantOfAge(18);
        return this;
    }


    public ApplicantMother applicantOfAge(Integer age){
        internal = new Applicant();
        internal.setAge(age);
        return this;
    }

    public ApplicantMother withLoadsOfCash(){
        withInvestmentOf(1_000_000_000D);
        return this;
    }

    public ApplicantMother withInvestmentOf(Double investment){ // TODO Money Object
        internal.setMoneyInvestment(investment);
        return this;
    }


    public Applicant build() {
        return internal;
    }
}
