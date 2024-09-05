package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import javax.print.DocFlavor.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void login(String os, String br) throws IOException{
		
	logger=LogManager.getLogger(this.getClass());
//	FileReader file= new FileReader(System.getProperty("user.dir")+"src//test//resources//config.properties");
	FileReader file= new FileReader("./src//test//resources//config.properties");
	p=new Properties();
	p.load(file);
	
//	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
//	{
//		DesiredCapabilities capabilities=new DesiredCapabilities();
//		
//		//os
//		if(os.equalsIgnoreCase("windows"))
//		{
//			capabilities.setPlatform(Platform.WIN11);
//		}
//		else if (os.equalsIgnoreCase("mac"))
//		{
//			capabilities.setPlatform(Platform.MAC);
//		}
//		else
//		{
//			System.out.println("No matching os");
//			return;
//		}
//		
//		//browser
//		switch(br.toLowerCase())
//		{
//		case "chrome": capabilities.setBrowserName("chrome"); break;
//		case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
//		default: System.out.println("No matching browser"); return;
//		}
//		
//		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
//	}
//
//			
//	if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	{
	switch(br)
	{
	case "chrome" : driver=new ChromeDriver(); break;
	case "edge" : driver=new EdgeDriver(); break;
	default : System.out.println("Invalid Browser"); break;
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(p.getProperty("appURL"));
	driver.manage().window().maximize();
	
	} 
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	// this is base class using to check how to push in git after changing in code


}

