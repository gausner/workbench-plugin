package com.myspace.glue;

import com.myspace.kie_server_test.Applicant;
import com.myspace.mother.ApplicantMother;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.Collection;

public class ApplicantSteps {
    ArrayList<Object> facts = new ArrayList<>();
    Applicant applicant;

    @Given("^Harry$")
    public void harry() {
        ApplicantMother mother = new ApplicantMother();
        applicant = mother.harry().build();
        facts.add(applicant);
    }

    @Given("^applicant is (\\d+) years old and has (\\d+) dollars investment$")
    public void applicant_is_years_old_and_has_dollars_investment(int arg1, double arg2) throws Throwable {
        ApplicantMother mother = new ApplicantMother();
        applicant = mother.applicantOfAge(arg1).withInvestmentOf(arg2).build();
        facts.add(applicant);
    }

    @When("^I run the rules$")
    public void i_run_the_rules() throws Throwable {
        runCukesRules(facts);
    }

    @Then("^approved$")
    public void approved() throws Throwable {
        for(Object fact : facts) {
            if(fact instanceof Applicant) {
                if(((Applicant) fact).isApproved()) {
                    System.out.println("GOOD");
                } else {
                    System.out.println("BAD");
                }
            }
        }
    }


    public void runCukesRules(Collection<Object> facts) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            // iterate over facts and insert them individually
            for(Object fact : facts) {
                System.out.println(fact);
                kSession.insert(fact);
            }
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
