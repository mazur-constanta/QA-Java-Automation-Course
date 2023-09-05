//package org.example.test_ex;
//
//import org.testng.annotations.Test;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
//
//public class DependencyTest {
//    private String api;
//
//    @Test(dependsOnMethods = {"getAPIValue"})
//    public void apiResponseValidation() {
//        assertThat("Some API").as("API response is incorrect").isEqualTo(api);
//    }
//
//    @Test
//    public void getAPIValue() {
//        api = "Some API";
//        System.out.println("This will execute first (getAPIValue)");
//        assertThat(1).isEqualTo(2);
//    }
//}
