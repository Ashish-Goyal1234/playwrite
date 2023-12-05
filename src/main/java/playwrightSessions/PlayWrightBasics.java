package playwrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWrightBasics {
	
	public static void main(String[] args) {
		
		/*
		   1. Playwright is an interface
		   2. create = will start the playwright server.
		   3. playwright.chromium().launch()
		      playwright.firefox().launch()
		      playwright.webKit().launch()
		 */
		
		
		Playwright playwright = Playwright.create();  // Creating playwright server
		
		// Below Example to run the test in binary browsers such as chromium, firefox and webkit
		//Browser browser = playwright.chromium().launch();  // It will return browser
		//Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)); 
		
		
		// Below example to run the test on browsers chrome, firefox
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("msedge");
		lp.setHeadless(false);
		Browser browser = playwright.chromium().launch(lp); // launch is overloaded method
		Page page = browser.newPage();  // It will return the page
		page.navigate("https://www.amazon.com");
		
		
		String title = page.title();
		System.out.println("Page title is : " + title);
		
		String url = page.url();
		System.out.println("URL is : "+ url);
		
		browser.close(); // Close the browser
		playwright.close(); // Close the server
		
	}

}
