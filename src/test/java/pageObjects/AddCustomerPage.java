package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
    public WebDriver pageDriver;

    public AddCustomerPage(WebDriver ldriver) {
		
		pageDriver = ldriver;
		PageFactory.initElements(ldriver,this);
	}

    By lnkCustomers_menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
    By lnkCustomers_menuitem=By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");

    By btnAddnew=By.xpath("//a[@class='btn bg-blue']"); //Add new

    By txtEmail=By.xpath("//input[@id='Email']");
    By txtPassword=By.xpath("//input[@id='Password']");

    By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

    By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
    By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
    By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
    By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");


    By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
    By rdMaleGender=By.id("Gender_Male");
    By rdFeMaleGender=By.id("Gender_Female");

    By txtFirstName=By.xpath("//input[@id='FirstName']");
    By txtLastName=By.xpath("//input[@id='LastName']");

    By txtDob=By.xpath("//input[@id='DateOfBirth']");

    By txtCompanyName=By.xpath("//input[@id='Company']");

    By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");

    By btnSave=By.xpath("//button[@name='save']");

    //Actions Methods


    public String getPageTitle()
    {
        return pageDriver.getTitle();
    }

    public void clickOnCustomersMenu() {
    	pageDriver.findElement(lnkCustomers_menu).click();
    }

    public void clickOnCustomersMenuItem() {
    	pageDriver.findElement(lnkCustomers_menuitem).click();
    }

    public void clickOnAddnew() {
    	pageDriver.findElement(btnAddnew).click();
    }

    public void setEmail(String email)
    {
    	pageDriver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password)
    {
    	pageDriver.findElement(txtPassword).sendKeys(password);
    }


    public void setCustomerRoles(String role) throws InterruptedException
    {
        if(!role.equals("Vendors")) //If role is vendors should not delete Register as per requirement
        {
        	pageDriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
        }

        pageDriver.findElement(txtcustomerRoles).click();

        WebElement listitem;

        Thread.sleep(3000);

        if(role.equals("Administrators"))
        {
            listitem=pageDriver.findElement(lstitemAdministrators);
        }
        else if(role.equals("Guests"))
        {
            listitem=pageDriver.findElement(lstitemGuests);
        }
        else if(role.equals("Registered"))
        {
            listitem=pageDriver.findElement(lstitemRegistered);
        }
        else if(role.equals("Vendors"))
        {
            listitem=pageDriver.findElement(lstitemVendors);
        }
        else
        {
            listitem=pageDriver.findElement(lstitemGuests);
        }

        //listitem.click();
        //Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor)pageDriver;
        js.executeScript("arguments[0].click();", listitem);

    }

    public void setManagerOfVendor(String value)
    {
        Select drp=new Select(pageDriver.findElement(drpmgrOfVendor));
        drp.selectByVisibleText(value);
    }

    public void setGender(String gender)
    {
        if(gender.equals("Male"))
        {
        	pageDriver.findElement(rdMaleGender).click();
        }
        else if(gender.equals("Female"))
        {
        	pageDriver.findElement(rdFeMaleGender).click();
        }
        else
        {
        	pageDriver.findElement(rdMaleGender).click();//Default
        }

    }

    public void setFirstName(String fname)
    {
    	pageDriver.findElement(txtFirstName).sendKeys(fname);
    }

    public void setLastName(String lname)
    {
    	pageDriver.findElement(txtLastName).sendKeys(lname);
    }

    public void setDob(String dob)
    {
    	pageDriver.findElement(txtDob).sendKeys(dob);
    }

    public void setCompanyName(String comname)
    {
    	pageDriver.findElement(txtCompanyName).sendKeys(comname);
    }

    public void setAdminContent(String content)
    {
    	pageDriver.findElement(txtAdminContent).sendKeys(content);
    }

    public void clickOnSave()
    {
    	pageDriver.findElement(btnSave).click();
    }
}