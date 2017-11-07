package cat.gencat.ctti.common.WebDriver;

import java.io.IOException;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface IBrowserObject {

	public RemoteWebDriver CreateWebDriverAndStartBrowser(String seleniumServer) throws IOException, Exception;
}
