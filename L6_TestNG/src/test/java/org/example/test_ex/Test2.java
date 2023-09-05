package org.example.test_ex;

import org.testng.Assert;
import org.testng.annotations.Test;
import test_ex.MessageUtil;

public class Test2 {
    String message = "Constanta";

    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintName2() throws InterruptedException {
        System.out.println("Log that method is running...");
        message = "Hi " + " Constanta!";
        Assert.assertEquals(message, MessageUtil.printMessage2());
        Thread.sleep(3000);
    }
}
