package testng_extra;

import org.testng.annotations.Test;

public class DependsOnOrgTest {
	
	@Test
	public void createOrgTest()
	{
		System.out.println("Created Org Test");
	}
	
	@Test(dependsOnMethods = "createOrgTest")
	public void deletedTest()
	{
		System.out.println("deleted Org Test");
	}
	
	@Test(dependsOnMethods = "deletedTest")
	public void modifiedTest()
	{
		System.out.println("modified Org Test");
	}

}
