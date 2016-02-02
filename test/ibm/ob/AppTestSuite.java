package ibm.ob;

import ibm.ob.repositories.RepositoriesTestSuite;
import ibm.ob.web.restful.services.WebServicesTestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RepositoriesTestSuite.class, WebServicesTestSuite.class})
public class AppTestSuite {

}
