package cat.gencat.ctti.common.WebDriver;


import org.openqa.selenium.remote.RemoteWebDriver;
import cat.gencat.ctti.common.WebDriver.ChromeConfiguration;
import cat.gencat.ctti.common.WebDriver.IBrowserObject;

public class WebDriverCreation {

	public  RemoteWebDriver CreateWebDriver(String browser, String seleniumServer) throws Exception {
		IBrowserObject browserObject = null;
		
		switch (browser) {
		
			case "Chrome":
				browserObject = new ChromeConfiguration();
				break;
			case "Firefox":
				browserObject = new FirefoxConfiguration();
				break;
			case "IExplorer":
				browserObject = new InternetExplorerConfiguration();
				break;
			case "Edge":
				browserObject = new EdgeConfiguration();
				break;
			/*case "Safari":
				browserObject = new SafariConfiguration();
				break;
			case "Opera":
				browserObject = new OperaConfiguration();
				break;
			case "PhantomJS":
				browserObject = new PhantomConfiguration();
				break;*/
		}


		return browserObject.CreateWebDriverAndStartBrowser(seleniumServer);
	}
}
