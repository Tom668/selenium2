package cn.itcast;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridDemo {
    @Test
    public void test() throws MalformedURLException,InterruptedException{
        //实例化一个DesiredCapabilities对象dc
        DesiredCapabilities dc=DesiredCapabilities.chrome();
        //实例化一个driver
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.21.1:4444/wd/hub"),dc);
        //打开百度首页
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }
    @DataProvider(name="hehe")
    public Object[][] browser(){
        return new Object[][]{
                {"firefox","http://192.168.21.1:5555"},
                {"chrome","http://192.168.21.1:6666"},
                {"ie","http://192.168.21.1:5555"}
        };
    }
    @Test(dataProvider = "hehe")
    public void test1(String browser,String url) throws MalformedURLException,InterruptedException{
        //实例化一个DesiredCapabilities对象dc
        DesiredCapabilities dc=null;
        if(browser.equals("firefox")){
            dc=DesiredCapabilities.firefox();
        }
        else if(browser.equals("chrome")){
            dc=DesiredCapabilities.chrome();
        }
        else if(browser.equals("ie")){
            dc=DesiredCapabilities.internetExplorer();
        }
        else{
            System.out.println("error");
        }
        //实例化一个driver
        WebDriver driver = new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
        //打开百度首页
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }
}
