package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LacostaHomePage;
import page.LacostaLoginPage;
import page.LacostaProfilePage;
import page.LacostaSearchResultPage;
import service.UserCreator;

public class LacostaUserTest extends CommonConditions {


    private String failTerms  = "Хот-дог";
    private String failResult = "По запросу «Хот-дог» ничего не найдено";

    @Test(priority = 1)
    public  void loginAsLoggedInUser(){
        User testUser = UserCreator.withCredentialsFromProperty();
        LacostaProfilePage checkUser =  new LacostaLoginPage(driver,"https://lacoste.ru/account/auth/")
                .openPage()
                .login(testUser)
                .openProfilePage();

        Assert.assertTrue(checkUser.getСheckEmail().contains(testUser.getUsername()));
    }

    @Test(priority = 2)
    public void searchWithFailedTerms(){
        LacostaSearchResultPage checkResult  = new LacostaHomePage(driver, "https://lacoste.ru/")
                .openPage()
                .inputTerm(failTerms)
                .searchTerm();

        Assert.assertTrue(checkResult.getCheckResultSeacrh().contains(failResult));
    }
}
