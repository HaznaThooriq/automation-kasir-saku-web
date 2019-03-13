package com.bukakasir.tes.hazna.jenkins.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import java.util.List;
import net.serenitybdd.core.pages.PageObject;
import org.springframework.stereotype.Component;
@Component
@DefaultUrl("https://accounts.google.com/ServiceLogin/identifier?hl=in&lp=1&flowName=GlifWebSignIn&flowEntry=AddSession")
public class DictionaryPage extends PageObject {
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/content/span")
    private WebElementFacade tmblBerikutnyaLogin;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/content/span")
    private WebElementFacade tmblBerikutnyaPassword;


    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    private WebElementFacade fieldUsernameGoogle;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElementFacade fieldPasswordGoogle;

    @FindBy(name="search")
    private WebElementFacade searchTerm;

    @FindBy(name="go")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        //WebElementFacade key = searchTerm.typeAndEnter(keyword);
    }

    public void typeUsername(){
        typeInto(fieldUsernameGoogle,"cahaya.petshop2");
        tmblBerikutnyaLogin.click();
    }

    public void typePassword(){
        typeInto(fieldPasswordGoogle,"CahayaPetshop99");
        tmblBerikutnyaPassword.click();
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        return definitionList.findElements(By.tagName("li")).stream()
                             .map( element -> element.getText() )
                             .collect(Collectors.toList());
    }
}