package org.example.test_ex;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 1000)
    public void waitLongTime() throws Exception {
        Thread.sleep(1001);
        System.out.println("Test status bad");
    }
}
