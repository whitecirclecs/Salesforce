package com.salesforce.test.SalesforceDreamHouse;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	static WebDriver driver;
	private static ITestContext context;
	Login login;
	PropertiesPage properties;
	JavascriptExecutor js;

	public static ITestContext setContext(ITestContext iTestContext, WebDriver driver) {
		iTestContext.setAttribute("driver", driver);
		return iTestContext;
	}

	@BeforeClass()
	public void openBrowser(ITestContext iTestContext) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		context = setContext(iTestContext, driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
	}

	@AfterClass()
	public void closeBrowser() {
		driver.close();
	}

	@AfterSuite()
	public void tearDown() {
		sendPDFReportByGMail("batmanqa007@gmail.com", "Thursday1350", "deebhatti@gmail.com", "Test Report", "");
		sendPDFReportByGMail("batmanqa007@gmail.com", "Thursday1350", "mmanhar@salesforce.com", "Test Report", "");
		sendPDFReportByGMail("batmanqa007@gmail.com", "Thursday1350", "vpinnu@salesforce.com", "Test Report", "");
		
	}

	/**
	 * Send email using java
	 * 
	 * @param from
	 * @param pass
	 * @param to
	 * @param subject
	 * @param body
	 */
	private static void sendPDFReportByGMail(String from, String pass, String to, String subject, String body) {
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			// Set from address
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set subject
			message.setSubject(subject);
			message.setText(body);

			BodyPart objMessageBodyPart = new MimeBodyPart();

			objMessageBodyPart.setText("Please Find The Attached Report File!");

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(objMessageBodyPart);

			objMessageBodyPart = new MimeBodyPart();

			// Set path to the pdf report file
			String filename = System.getProperty("user.dir") + "\\TestReport\\Test-Automation-Report.html";
			// Create data source to attach the file in mail
			DataSource source = new FileDataSource(filename);

			objMessageBodyPart.setDataHandler(new DataHandler(source));

			objMessageBodyPart.setFileName(filename);

			multipart.addBodyPart(objMessageBodyPart);

			message.setContent(multipart);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
