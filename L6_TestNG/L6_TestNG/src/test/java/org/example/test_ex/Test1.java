package org.example.test_ex;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import test_ex.MessageUtil;

@Listeners(MyListener.class)
public class Test1 {
    String message = "Constanta";

    MessageUtil messageUtil = new MessageUtil();

    @Test
    public void testPrintName() throws InterruptedException {
        System.out.println("Log that method is running...");
        Assert.assertEquals(message, MessageUtil.printMessage());
        Thread.sleep(3000);
    }
}
