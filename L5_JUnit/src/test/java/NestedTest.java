import org.junit.jupiter.api.*;

@DisplayName("JUnit 5 Nested Example")
public class NestedTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all methods");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all methods");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test method");
    }

    @Test
    void someParentTest() {
        System.out.println("Some parent test");
    }

    @Nested
    @DisplayName("This is a Child class tests")
    class ChildTest {
        @BeforeEach
        void beforeEach() {
            System.out.println("ChildTest: Before each");
        }

        @Test
        void someChildTest() {
            System.out.println("Child test execution");
        }

        @AfterEach
        void afterEach() {
            System.out.println("ChildTest: After each");
        }
    }
}
