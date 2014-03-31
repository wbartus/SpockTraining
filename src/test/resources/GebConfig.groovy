/**
 * Created by bawe on 2014-03-31.
 */
import geb.driver.SauceLabsDriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.safari.SafariDriver

baseUrl = 'http://google.com'

// default driver...
driver = { new ChromeDriver() }

environments {
    // specify environment via -Dgeb.env=ie
    'ie' {
        def ieDriver = new File('src/test/resources/IEDriverServer.exe')
        System.setProperty('webdriver.ie.driver', ieDriver.absolutePath)
        driver = { new InternetExplorerDriver() }
    }

    'chrome' {
        def chromeDriver = new File('src/test/resources/chromedriver') // add .exe for Windows...
        System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)
        driver = { new ChromeDriver() }
    }

    'ff' {
        driver = { new FirefoxDriver() }
        //driver.Manage().Window.Maximize()
    }

    'safari' {
        driver = { new SafariDriver() }
    }

    'sauce' {
        driver = {
            // sauce.config: <browser>:<os>:<ver> eg. iphone:OSX10.9:7
            def sauceBrowser = System.properties.getProperty('sauce.config')
            def username = System.properties.getProperty('sauce.user')
            def accessKey = System.properties.getProperty('sauce.key')
            new SauceLabsDriverFactory().create(sauceBrowser, username, accessKey)
        }
    }
}

waiting {
    timeout = 6
    retryInterval = 0.5
    slow { timeout = 12 }
    reallySlow { timeout = 24 }
    quick = 3
}

reportsDir = "target/geb-reports"
//cacheDriver = false
//autoClearCookies = false
