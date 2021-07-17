package testNg;


import org.testng.annotations.Test;

public class Testcase1 extends BaseClass{

	
	
	@Test(priority=2 ,description="this test will test the personal loan feature", groups= {"Sanity"})
	public void LoanTest()
	{
		System.out.println("Inside loan Test");
	}
	
	@Test(priority=1)
	public void LoanTest1()
	{
		System.out.println("Inside loan Test1");
	}
	
	@Test(priority=0)
	public void CreditCardTest()
	{
		System.out.println("Inside CC Test");	
	}
	
	
}
