package foundation;

import org.junit.*;

public class JUnitAnnotations {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("This is @BeforeClass");
    }

    @Before
    public void before(){
        System.out.println("This is @Before");
    }

    @Test
    public void testA() {
        System.out.println("This is testA");
    }

    @Test
    public void testB() {
        System.out.println("This is testB");
    }

    @Test
    public void testC() {
        System.out.println("This is testC");
    }

    @After
    public void tearDown()  {
        System.out.println("This is @After");
    }

    @AfterClass
    public static void afterClass()  {
        System.out.println("This is @AfterClass");
    }
}
