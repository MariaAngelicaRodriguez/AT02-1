package org.fundacion.pages.workspaces;

import org.fundacion.model.workspaces.WorkspaceListModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 12/19/2016.
 */
public class WorkspaceListPage {
  WebDriver driver;
  WebDriverWait wait;
  String elementDeleted;

  public WorkspaceListPage(WebDriver driver) {

    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(xpath = WorkspaceListModel.workspaces)
  List<WebElement> workspaces;

  public void deleteWorkspace(String name) {
    elementDeleted = driver.findElement(By.xpath("//a[text() = '" + name + "']")).getAttribute("href");
    driver.findElement(By.xpath("//a[text() = '" + name + "']")).click();
  }

  public Boolean verifyProjectWasDeleted() {
    Boolean flag = false;
    ArrayList<String> hrefs = new ArrayList<String>();

    for (WebElement element : workspaces) {
      hrefs.add(element.getAttribute("href"));
    }

    for (String index : hrefs) {
      if (index.equals(elementDeleted))
        flag = true;
    }

    return flag;
  }
}