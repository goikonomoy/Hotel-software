/**
 * Created by Konstantinos Spinos and Vasilis Papatheodorides on 7/12/2019.
 * 8180122, 8180096
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Hotel_Software {
	public static void main(String[] args) {
		login(); //φορτώνεται η φόρμα σύνδεσης του οικονομικά ενδιαφερόμενου ατόμου
		loadObjects();
	}
	private static void login() {
		Scanner input = new Scanner(System.in);
		String set_username = "admin";
	    String set_password = "admin";
	    String username = null;
	    String password = null;
	    while (!set_username.equals(username)) {
	    	System.out.println("Εισάγετε username:");
	    	username = input.next();
	    	if (!set_username.equals(username)) {
	    		System.out.println("Λάθος username.");
	    	   	username = input.nextLine();
	    	}
	    }
	    while (!set_password.equals(password)) {
			System.out.println("Εισάγετε password:");
			password = input.next();
			if (!set_password.equals(password)) {
			    System.out.println("Λάθος password.");
			    password = input.nextLine();
			}
	    }
	    System.out.println("Επιτυχής σύνδεση.");
	}
	private static void loadObjects() {
		//Έσοδα ξενοδοχείου για το έτος 2018
		Income i1_2018 = new Income("Έσοδα από δωμάτια", 985392.30);
		Income i2_2018 = new Income("Έσοδα από bar", 252426.60);
		Income i3_2018 = new Income("Λοιπά έσοδα", 100765.40);

		//Έξοδα ξενοδοχείου για το έτος 2018
		Outcome o1_2018 = new Outcome("Έξοδα μισθοδοσίας", 176268.25);
		Outcome o2_2018 = new Outcome("Έξοδα συντήρησης ξενοδοχείου", 103245.80);
		Outcome o3_2018 = new Outcome("Λοιπά έξοδα", 732953.60);

		//Λίστα οικονομικών στοιχείων για το έτος 2018
		ArrayList<Double> year_2018 = new ArrayList<Double>();
		year_2018.add(i1_2018.getValue());
		year_2018.add(i2_2018.getValue());
		year_2018.add(i3_2018.getValue());
		year_2018.add(o1_2018.getValue());
		year_2018.add(o2_2018.getValue());
		year_2018.add(o3_2018.getValue());
		calculateProfit(year_2018);
	}
	private static void calculateProfit(ArrayList<Double> list1) {
		double income = list1.get(0) + list1.get(1) + list1.get(2);
		double outcome = list1.get(3) + list1.get(4) + list1.get(5);
		double profit = income - outcome;
		if (profit < 0) {
			System.out.printf("Το ξενοδοχείο ζημιώθηκε κατά %.2f %s\n", profit, "ευρώ");
		} else if (profit == 0) {
			System.out.println("Το ξενοδοχείο δεν σημείωσε κέρδος");
		} else {
			System.out.printf("Το ξενοδοχείο είχε κέρδος %.2f %s\n", profit, "ευρώ");
		}
	}
}

