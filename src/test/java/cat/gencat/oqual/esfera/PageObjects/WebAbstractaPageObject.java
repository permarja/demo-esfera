package cat.gencat.oqual.esfera.PageObjects; 

//IMPORTS
//import java.net.URL;

//import java.util.Set;
//import java.util.List;
import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.Cookie;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.WebDriver.Window;
//import org.openqa.selenium.WebDriver.Timeouts;
//import org.openqa.selenium.WebDriver.ImeHandler;
//import org.openqa.selenium.WebDriver.Navigation;
//import org.openqa.selenium.WebDriver.Options;
//import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;

//CLASS CONSTRUCTOR
/*public abstract class PaginaWebAbstracta implements org.openqa.selenium.WebDriver.Window,
													org.openqa.selenium.WebDriver.Options,
													org.openqa.selenium.WebDriver.Timeouts,
													org.openqa.selenium.WebDriver.Navigation, 													
													org.openqa.selenium.WebDriver.ImeHandler,
													org.openqa.selenium.WebDriver.TargetLocator, WebDriver
													{
*/

public abstract class WebAbstractaPageObject {

	// OBJECTS DECLARATIONS
	public RemoteWebDriver driver;

	// CLASS METHODS

	public WebAbstractaPageObject(RemoteWebDriver driver) {
		this.driver = driver;

	}

	public String AbrirPagina(String URL) {
		try {
			driver.get(URL);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public void Espera(int s) {
		try {
			Thread.sleep(1000 * s);
		} catch (InterruptedException ie) {
			// nada
		}
	}

	public String PulsarTecla(String Elemento, CharSequence... keys) {
		try {
			for (CharSequence key : keys) {
				driver.findElement(By.xpath(Elemento)).sendKeys(key);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "OK";
	}

	public String HacerClick(String Elemento) {
		try {
			driver.findElement(By.xpath(Elemento)).click();
		} catch (Exception e) {
			return e.getMessage();
		}
		return "OK";
	}

	public void CerrarSeguro() {
		/*
		 * ########################### 
		 * .Quit() - Calls Dispose() 
		 * .Close() - Close the browser window that the driver has focus of
		 * .Dispose() - Closes all browser windows and safely ends the session
		 * ###########################
		 */
		driver.quit();
	}

	public String AbrirNuevaPestana(String URL) {
		try {
			Robot rob = new Robot();
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_T);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_T);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));
			driver.get(URL);
		} catch (AWTException e) {
			return "No s'ha pogut obrir una nova pestanya";
		}
		return "OK";
	}

	public String AbrirNuevaPestana() {
		try {
			Robot rob = new Robot();
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_T);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyRelease(KeyEvent.VK_T);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));
		} catch (AWTException e) {
			return e.getMessage();
		}
		return "OK";
	}

	public String ElementoCargado(int Iteraciones, int Milisegundos, String... Elementos) {
		String missatge = "OK";
		for (String Elemento : Elementos) {
			Integer i = 1;
			//Boolean Cargado;			
			try {
				while (i < Iteraciones) {
					if (driver.findElement(By.xpath(Elemento)).isDisplayed()) {
						i = Iteraciones;
					} else {
						i++;
						Thread.sleep(Milisegundos / 1000);
						//Cargado = driver.findElement(By.xpath(Elemento)).isDisplayed();
						// if (i.equals(Iteraciones) && Cargado.equals(false)) {					 
						// }
					}
				}

			} catch (NoSuchElementException e) {
				if (missatge.equals("OK")) {
					missatge = "";
				}
				missatge = missatge + "\n\r" + e.getMessage();
				System.out.println(e.getMessage());
			} catch (InterruptedException e) {
				//
			}
		}
		return missatge;
	}

	public String ElementoCargado(int Iteraciones, int Milisegundos, String Elemento) {
		String missatge = "OK";		
		Integer i = 1;
			try {
				while (i < Iteraciones) {
					if (driver.findElement(By.xpath(Elemento)).isDisplayed()) {
						i = Iteraciones;
					} else {
						i++;
						Thread.sleep(Milisegundos / 1000);
						//Cargado = driver.findElement(By.xpath(Elemento)).isDisplayed();
						// if (i.equals(Iteraciones) && Cargado.equals(false)) {					 
						// }
					}
				}

			} catch (NoSuchElementException e) {
				if (missatge.equals("OK")) {
					missatge = "";
				}
				missatge = missatge + "\n\r" + e.getMessage();
				System.out.println(e.getMessage());
			} catch (InterruptedException e) {
				//
			}
		return missatge;
	}
	/*
	 * public boolean ElementoCargado(int Iteraciones, int Milisegundos, String
	 * Elemento) { Integer i = 1; Boolean Cargado; try { while (i<Iteraciones){ if
	 * (driver.findElement(By.xpath(Elemento)).isDisplayed()) { i=Iteraciones; }
	 * else { i++; Thread.sleep(Milisegundos/1000); Cargado =
	 * driver.findElement(By.xpath(Elemento)).isDisplayed(); if
	 * (i.equals(Iteraciones) && Cargado.equals(false)) { // REPORT KO return false;
	 * } } }
	 * 
	 * } catch (NoSuchElementException e) { System.out.println(e.getMessage()); }
	 * catch (InterruptedException e) { System.out.println(e.getMessage()); } return
	 * true; }
	 */

	// NAVIGATION
	/*
	 * @Override public void back() { driver.navigate().back();
	 * 
	 * }
	 * 
	 * @Override public void forward() { driver.navigate().forward();
	 * 
	 * }
	 * 
	 * @Override public void refresh() { driver.navigate().refresh(); }
	 * 
	 * @Override public void to(String arg0) { driver.navigate().to(arg0);
	 * 
	 * }
	 * 
	 * @Override public void to(URL arg0) { driver.navigate().to(arg0);
	 * 
	 * }
	 * 
	 * 
	 * //MANAGE
	 * 
	 * @Override public void addCookie(Cookie arg0) {
	 * driver.manage().addCookie(arg0);
	 * 
	 * }
	 * 
	 * @Override public void deleteAllCookies() {
	 * driver.manage().deleteAllCookies();
	 * 
	 * }
	 * 
	 * @Override public void deleteCookie(Cookie arg0) {
	 * driver.manage().deleteCookie(arg0);
	 * 
	 * }
	 * 
	 * @Override public void deleteCookieNamed(String arg0) {
	 * driver.manage().deleteCookieNamed(arg0);
	 * 
	 * }
	 * 
	 * @Override public Cookie getCookieNamed(String arg0) { return
	 * driver.manage().getCookieNamed(arg0); }
	 * 
	 * @Override public Set<Cookie> getCookies() { return
	 * driver.manage().getCookies(); }
	 * 
	 * @Override public ImeHandler ime() { return driver.manage().ime(); }
	 * 
	 * @Override public Logs logs() { return driver.manage().logs(); }
	 * 
	 * @Override public Timeouts timeouts() { return driver.manage().timeouts(); }
	 * 
	 * @Override public Window window() { return driver.manage().window(); }
	 * 
	 * 
	 * //TARGET LOCATOR
	 * 
	 * @Override public WebElement activeElement() { return
	 * driver.switchTo().activeElement(); }
	 * 
	 * @Override public Alert alert() { return driver.switchTo().alert(); }
	 * 
	 * @Override public RemoteWebDriver defaultContent() { return (RemoteWebDriver)
	 * driver.switchTo().defaultContent(); }
	 * 
	 * @Override public RemoteWebDriver frame(int arg0) { return (RemoteWebDriver)
	 * driver.switchTo().frame(arg0); }
	 * 
	 * @Override public WebDriver frame(String arg0) { driver. return
	 * PaginaWebAbstracta.this; //return (RemoteWebDriver)
	 * driver.switchTo().frame(arg0); }
	 * 
	 * @Override public RemoteWebDriver frame(WebElement arg0) { return
	 * (RemoteWebDriver) driver.switchTo().frame(arg0); }
	 * 
	 * @Override public RemoteWebDriver parentFrame() { return (RemoteWebDriver)
	 * driver.switchTo().parentFrame(); }
	 * 
	 * @Override public RemoteWebDriver window(String arg0) { return
	 * (RemoteWebDriver) driver.switchTo().window(arg0); }
	 * 
	 * 
	 * //IME HANDLER
	 * 
	 * @Override public void activateEngine(String arg0) {
	 * driver.manage().ime().activateEngine(arg0);
	 * 
	 * }
	 * 
	 * @Override public void deactivate() { driver.manage().ime().deactivate();
	 * 
	 * }
	 * 
	 * @Override public String getActiveEngine() { return
	 * driver.manage().ime().getActiveEngine(); }
	 * 
	 * @Override public List<String> getAvailableEngines() { return
	 * driver.manage().ime().getAvailableEngines(); }
	 * 
	 * @Override public boolean isActivated() { return
	 * driver.manage().ime().isActivated(); }
	 * 
	 * 
	 * //TIMEOUTS
	 * 
	 * @Override public Timeouts implicitlyWait(long arg0, TimeUnit arg1) { return
	 * driver.manage().timeouts().implicitlyWait(arg0, arg1); }
	 * 
	 * @Override public Timeouts pageLoadTimeout(long arg0, TimeUnit arg1) { return
	 * driver.manage().timeouts().pageLoadTimeout(arg0, arg1); }
	 * 
	 * @Override public Timeouts setScriptTimeout(long arg0, TimeUnit arg1) { return
	 * driver.manage().timeouts().setScriptTimeout(arg0, arg1); }
	 * 
	 * //WINDOWS
	 * 
	 * 
	 * @Override public void fullscreen() { driver.manage().window().fullscreen(); }
	 * 
	 * @Override public org.openqa.selenium.Point getPosition() { return
	 * driver.manage().window().getPosition(); }
	 * 
	 * @Override public org.openqa.selenium.Dimension getSize() { return
	 * driver.manage().window().getSize(); }
	 * 
	 * @Override public void maximize() { driver.manage().window().maximize(); }
	 * 
	 * @Override public void setPosition(org.openqa.selenium.Point arg0) {
	 * driver.manage().window().setPosition(arg0);
	 * 
	 * }
	 * 
	 * @Override public void setSize(org.openqa.selenium.Dimension arg0) {
	 * driver.manage().window().setSize(arg0); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //@Override public WebElement findElement(By arg0) { // TODO Auto-generated
	 * method stub return arg0.findElement(this); }
	 * 
	 * @Override public List<WebElement> findElements(By arg0) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public void get(String arg0) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public String getCurrentUrl() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public String getPageSource() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public String getTitle() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public String getWindowHandle() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public Set<String> getWindowHandles() { // TODO Auto-generated
	 * method stub return null; }
	 * 
	 * @Override public Options manage() { // TODO Auto-generated method stub return
	 * null; }
	 * 
	 * @Override public Navigation navigate() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public void quit() { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public TargetLocator switchTo() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * 
	 */

}
