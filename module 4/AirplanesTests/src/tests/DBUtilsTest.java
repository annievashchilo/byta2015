package tests;

import exceptions.CompanyNotFoundException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DBUtilsTest extends BaseTest {

    @BeforeClass
    public void setUp() {

    }

    @Test(groups = "datautils", expectedExceptions = CompanyNotFoundException.class)
    public void testGetAviacompany() throws Exception {

    }

    @Test(groups = "datautils")
    public void testGetAirplanes() throws Exception {

    }
}