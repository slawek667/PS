package manage;

import org.testng.annotations.Test;

import requirements.Generic;

import java.net.MalformedURLException;


public class ScriptsTestNG extends Generic {
    @Test
    public void checkLoginFlow() throws MalformedURLException, InterruptedException {
        driver.getPageSource();
    }

}