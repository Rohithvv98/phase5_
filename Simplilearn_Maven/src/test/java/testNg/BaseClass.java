package testNg;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	@BeforeGroups("Sanity")
	public void beforeGroup() {
		System.out.println("Inside before group");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside before test");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside before method");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside after method");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("Inside after test");
	}
	@AfterGroups("Sanity")
	public void afterGroup() {
		System.out.println("Inside after group");
	}
}
