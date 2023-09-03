package org.example.test_ex;

import org.testng.annotations.Test;

public class GroupingTest {
    @Test
    public void testWebLoginPersonalLoan() {
        System.out.println("Web Login Personal Loan");
    }

    @Test(groups = {"SmokeTest"})
    public void testMobileLoginPersonalLoan() {
        System.out.println("Mobile Login Personal Loan");
    }

    @Test
    public void testAPILoginPersonalLoan() {
        System.out.println("API Login Personal Loan");
    }
}
