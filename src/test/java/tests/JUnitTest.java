package tests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class JUnitTest {
    int result;

    @BeforeAll
    static void beforeAll(){
        System.out.println("\n### beforeAll()\n");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("### beforeEach()");
        result = getResult();
    }

    @AfterEach
    void AfterEach(){
        System.out.println("### AfterEach()");
        result = 0;
    }

    @AfterAll
    static void AfterAll(){
        System.out.println("\n### AfterAll()\n");
    }


       @Test
    void firstTest() {
           System.out.println("###   firstTest()");
        Assertions.assertTrue(result>2);
    }
    @Test
    void secondTest() {
        System.out.println("###   secondTest()");
        Assertions.assertTrue(result>2);
    }
    @Test
    void thirdTest() {
        System.out.println("###    thirdTest()");
        Assertions.assertTrue(result>2);
    }

    private int getResult() {
           return 3;
    }
}
