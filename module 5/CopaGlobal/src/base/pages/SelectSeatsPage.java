package base.pages;

import base.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SelectSeatsPage extends Page
{
    @FindBy(css = "div.nameAreaWrap > table > tbody > tr > td.name > div")
    private static WebElement guestName;
    @FindBy(css = "#pgButtonSubmit > span > span")
    private static WebElement buttonNext;

    public SelectSeatsPage()
    {
        PageFactory.initElements(Utils.getHandler(), this);
    }

    public String getGuestName()
    {
        return guestName.getText();
    }

    public void nextPage()
    {
        if (buttonNext.isEnabled())
        {
            buttonNext.click();
        }
        Utils.getHandler().waitForPageToLoad();
    }

    public void verifyGuestName(String expectedName)
    {
        Assert.assertEquals(getGuestName(), expectedName, "Names are not equal. Expected: " + expectedName + ". Actual: " + getGuestName());
    }

}
