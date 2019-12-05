package com.aux.stepdef;

import cucumber.api.java.en.Then;

public class MyStepdefs {


    @Then("login")
    public void login() {
        System.out.println(" Login Runs ");
    }

    @Then("^dw$")
    public void dw() {

        System.out.println(" Logindio  Runs ");
    }
}

