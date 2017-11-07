package cat.gencat.ctti.common.WebDriver;

import java.io.IOException;
import java.net.URL;


import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cat.gencat.ctti.common.WebDriver.IBrowserObject;

//import io.github.bonigarcia.wdm.Architecture;
//import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class InternetExplorerConfiguration implements IBrowserObject {
	RemoteWebDriver remoteWebDriver;
	DesiredCapabilities capabilities;

	public InternetExplorerConfiguration() {

		capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
	}


	@Override
	public RemoteWebDriver CreateWebDriverAndStartBrowser(String seleniumServer) throws IOException, Exception {
		remoteWebDriver = new RemoteWebDriver(new URL(seleniumServer), capabilities);
		return remoteWebDriver;
	}
}
