package SessionOne;

import org.testng.annotations.*;

@Test
public class Annotations {

    @BeforeSuite
    public void BeforeSuite(){

        System.out.println("BeforeSuite");
    }

    @BeforeTest
    public void BeforeTest(){

        System.out.println("BeforeTest");
    }

    @BeforeClass
    public void BeforeClass(){

    System.out.println("BeforeClass");
    }

    @BeforeMethod
    public void BeforeMethod(){

        System.out.println("BeforeMethod");
    }



    public void testcase1(){

        System.out.println("Test case 1");
    }


    public void testcase2()
    {
        System.out.println("Test case 2");
    }

    @AfterSuite
    public void AfterSuite(){

        System.out.println("AfterSuite");
    }

    @AfterTest
    public void AfterTest(){

        System.out.println("AfterTest");
    }

    @AfterClass
    public void AfterClass(){

        System.out.println("AfterClass");
    }

    @AfterMethod
    public void AfterMethod(){

        System.out.println("AfterMethod");
    }





}
