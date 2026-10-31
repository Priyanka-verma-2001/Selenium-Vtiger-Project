package testng_extra;

import org.testng.annotations.Test;

public class PriorityOrgTest {
	
	@Test(priority = -1)
	public void createOrgTeest()
	{
		System.out.println("Create Organ. Test");
	}
	
	@Test
	public void modifyTest()
	{
		System.out.println("modified Org Test");
	}
	
	@Test(priority = 0)
	public void deleteOrgTest()
	{
		System.out.println("deleted Org Test");
	}

}
