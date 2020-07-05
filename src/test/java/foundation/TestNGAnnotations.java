package foundation;

import org.testng.annotations.*;

/**
 *    BeforeTest
 *    |   BeforeClass
 *    |   |   BeforeMethod
 *    |   |   |   TestA
 *    |   |   AfterMethod
 *    |   |   BeforeMethod
 *    |   |   | TestB
 *    |   |   AfterMethod
 *    |   |   BeforeMethod
 *    |   |   |  TestC
 *    |   |   AfterMethod
 *    |   AfterClass
 *    AfterTest
 */

public class TestNGAnnotations {

    @BeforeClass
    public void beforeClassDemo() {
        System.out.println("Hi This is @BeforeClass");
    }

    @BeforeTest
    public void beforeTestDemo() {
        System.out.println("Hi This is @BeforeTest");
    }

    @BeforeMethod
    public void beforeMethodDemo() {
        System.out.println("Hi This is @BeforeMethod");
    }

    @Test
    public void testA() {
        System.out.println("Hi This is @Test A");
    }

    @Test
    public void testB() {
        System.out.println("Hi This is @Test B");
    }

    @Test
    public void testC() {
        System.out.println("Hi This is @Test C");
    }

    @AfterMethod
    public void afterMethodDemo() {
        System.out.println("Hi This is  @AfterMethod");
    }


    @AfterClass
    public void afterClassDemo() {
        System.out.println("Hi This is  @AfterClass");
    }

    @AfterTest
    public void afterTestDemo() {
        System.out.println("Hi This is  @AfterTest");
    }

}
