package cat.gencat.ctti.common.WebDriver;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeConfiguration implements IBrowserObject {
	RemoteWebDriver remoteWebDriver;
	DesiredCapabilities capabilities;

	public EdgeConfiguration() {

		capabilities = DesiredCapabilities.edge();
		//capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
		capabilities.setBrowserName("MicrosoftEdge");
       // capability.setBrowserName(BrowserType.EDGE);
		capabilities.setPlatform(Platform.WIN10);
	}


	@Override
	public RemoteWebDriver CreateWebDriverAndStartBrowser(String seleniumServer) throws IOException, Exception {
		remoteWebDriver = new RemoteWebDriver(new URL(seleniumServer), capabilities);
		return remoteWebDriver;
	}

}
