package com.myspace;

import com.myspace.exception.Failure;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

public class MyMojoTest {

    @Ignore("Skipped because there is no failure as expected") @Test(expected = Failure.class)
    public void will_execute_mojo_and_fail() throws Exception {
        MyMojo myMojo = new MyMojo();
        myMojo.execute();
    }

    @Test
    public void will_execute_mojo_and_pass() throws Exception {
        MyMojo myMojo = new MyMojo();
        myMojo.execute();
    }

}