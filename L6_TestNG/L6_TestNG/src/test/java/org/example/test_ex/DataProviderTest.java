package org.example.test_ex;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
    @BeforeMethod
    public void init() {
        System.out.println("Init method before each method");
    }

    @DataProvider(name = "studentsNames")
    public Object[][] provideStudentsNames() {
        return new Object[][] {
                {"Kate"}, {"Mike"}, {"Oleg"}, {"Alex"}
        };
    }

    @Test(dataProvider = "studentsNames")
    public void testStudentNames(String name) throws InterruptedException {
        System.out.println("Passed student name parameter is: " + name);
        Thread.sleep(1000);
    }
}
