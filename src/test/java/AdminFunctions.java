import org.testng.annotations.Test;

public class AdminFunctions {

    com.aux.ra.AdminFunction adminFunction=new com.aux.ra.AdminFunction();

    @Test(priority=1)
    public void AdminLogin()
    {   System.out.println(" ************ Running Logging API Admin");
       String ValuesFromPOM = System.getProperty("instance");
        adminFunction.AdminLogin(ValuesFromPOM);
    }

    @Test(priority=3)
    public void AdminGetAget()
    {   System.out.println(" ************  Running Get All Agents in the system API Admin");
        adminFunction.adminGetAgents();
    }

    @Test(priority=4)
    public void ValidationContentTypeStatusCodeServer()
    {   System.out.println("************  Validating the get Agent API / Status /content type / server ... ");
        adminFunction.test_ResponseHeaderLength_ShouldBeCorrect();
    }

    @Test(priority=2)
    public void Transmit()
    {   System.out.println("************  Transmitting Access Token in to next API ");
        adminFunction.Parameterize();
    }

}
