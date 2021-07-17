package testNg;

import org.testng.annotations.Test;

public class Testcase2 extends BaseClass{
	
	@Test(groups= {"Sanity"})
	public void InsuranceTest()
	{
		System.out.println("inside My Insurance Test");
	}
	@Test
	public void LoanTest2()
	{
		System.out.println("inside My Loan Test2");
	}
}
