package tests;

import exceptions.CompanyNotFoundException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import planes.Plane;
import utils.DOMXmlParser;

import java.util.List;


public class DOMXmlParserTest extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        xml = new DOMXmlParser("planes.xml");
    }

    @Test(groups = "datautils")
    public void testGetAirplanes() {
        System.out.println("TestCase1: Verify get all airplanes from xml file");
        List<Plane> planes = xml.getAirplanes();
        for (Plane p : planes) {
            Assert.assertNotNull(p, "Didn't get airplanes -> FAIL!");
            System.out.println(p.toString());
            System.out.println("Got all airplanes -> OK!");
        }
    }

    @Parameters("companyName")
    @Test(groups = "datautils", dependsOnMethods = "testGetAirplanes",
            expectedExceptions = {CompanyNotFoundException.class, AssertionError.class})
    public void testIsCompanyPresent(String companyName) throws CompanyNotFoundException {
        System.out.println("TestCase2: Verify get aviacompany from xml file");

        Assert.assertTrue(xml.isCompanyPresent(companyName));

        System.out.println("Company was found in xml file -> OK!");

    }
}