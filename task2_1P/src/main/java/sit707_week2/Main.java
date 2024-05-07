package sit707_week2;

import sit707_week2.SeleniumOperations;

/**
 * Hello world!
 * @author Ahsan Habib
 */
public class Main 
{
    public static void main( String[] args )
    {
    	int choice = 2;

		switch (choice) {
		case 1:
			SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
			break;
		case 2:
			SeleniumOperations.bunnings_registration_page("https://www.bunnings.com.au/register");
			break;
		default:
			System.out.println("Invalid choice.");
			break;
		}
        
    }
}
