package testng_extra;

import org.testng.annotations.Test;

public class InvocationCountOrgTest {
	
	@Test
	public void createInvocationCountOrgTest()
	{
		System.out.println("created Thread Pool size of Org Test");
	}
	
	@Test(invocationCount = 1)
	public void modifiedInvocationCountOrgTest()
	{
		System.out.println("modified Thread Pool size of Org Test");
	}
	
	@Test(invocationCount=0)
	public void deletedInvocationCountOrgTest()
	{
		System.out.println("deleted Thread Pool size of Org Test");
	}

}
