package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ww.base.BaseClass;


public class PageObjects extends BaseClass{

	public PageObjects(WebDriver driver) 
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"search-container\"]/div/div[2]/button")
	public WebElement Studio;
	
	@FindBy(xpath="//input[@id=\"location-search\"]")
	public WebElement LocationBox;
	
	@FindBy(xpath="//button[@id=\"location-search-cta\"]")
	public WebElement SearchButton;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[1]/a/div/div/a")
	public WebElement FirstSearchResultName;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[1]/a/div/span")
	public WebElement FirstSearchResultDistance;
	
	@FindBy(xpath="//*[contains(@class,'address-')]/div[1]")
	public WebElement DetailLocLine1;
	
	@FindBy(xpath="//*[contains(@class,'locationName')]")
	public WebElement DetailName;
	
	@FindBy(xpath="//*[contains(@class,'hours-')]/div[1]")
	public WebElement BusinessHours;
	
	
	
	
	
	
}
