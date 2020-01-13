import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
	public static void main(String args[]) {
		start();//καλείται η στατική μέθοδος start() για να ξεκινήσει το πρόγραμμα και 
		//να εμφανιστεί το αρχικό μενού επιλογών
	}

	public static void setValues() throws FileNotFoundException, UnsupportedEncodingException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Παρακαλω πληκτρολογήστε όνομα");
		String name = sc.nextLine();
		System.out.println("Παρακαλω πληκτρολογήστε ηλικία");
		double age = sc.nextDouble();
		System.out.println(
				"Παρακαλω δηλώστε αν ο υποψήφιος έχει προσκομίσει ιατρική βεβαίωση.\nΑπαντήστε με: 'ναι' ή 'όχι'");
		String healthy = sc.nextLine();
		healthy.toLowerCase();
		System.out.println("Παρακαλω πληκτρολογήστε αριθμό προηγούμενων εργασιακών εμπειριών");
		int jobs = sc.nextInt();
		System.out.println("Παρακαλω πληκτρολογήστε αν ο υποψήφιος είναι καπνιστής.\nΑπαντήστε με: 'ναι' ή 'όχι'");
		String smoker = sc.nextLine();
		smoker.toLowerCase();
		System.out.println("Παρακαλω πληκτρολογήστε αριθμό ξένων γλωσσών");
		int languages = sc.nextInt();
		System.out.println("Παρακαλω πληκτρολογήστε αν ο υποψήφιος έχει επισυνάψει φωτογραφία." +
       "\nΑπαντήστε με: 'ναι' ή 'όχι'");
		String photo = sc.nextLine();
		photo.toLowerCase();
		int[] Jobs1 = new int[jobs];
		String[]Lang1 = new String[languages];
		String[]Jobs2 = new String[jobs];
		String[]Lang2 = new String[languages];
			for (int j = 0; j < 2; j++) {
					System.out.println("Παρακαλώ πληκτρολογήστε το είδος της εργασίας νούμερο"+j);
					Jobs2[j] = sc.nextLine();
			}
					for (int i = 0; i < jobs; i++) {
				System.out.println(
						"Παρακαλώ γράψτε για πόσο καιρό έμεινε (σε μήνες) ο υποψήφιος στην εργασία νούμερο:  " + i);
				Jobs1[i] = sc.nextInt();
			}
		for (int i = 0; i < languages; i++) {
			System.out.println("Παρακαλώ γράψτε το όνομα της ξένης γλώσσας νούμερο" + i);
			Lang1[i] = sc.nextLine();
		}
			for (int k = 0; k < 2; k++) {
				System.out.println("Παρακαλώ γράψτε το επίπεδο ('άριστα' ή 'όχι άριστα')"
						+ " του υποψήφιου στη γλώσσα νούμερο" + k);
				Lang2[k] = sc.nextLine();//υποθέτουμε πως το ξενοδοχείο αναζητεί 
				//υποψήφιους μόνο με άριστη γνώση ξένων γλωσσών
			}
		Employee A = new Employee(name, age, jobs, healthy, smoker, languages, photo, Lang1, Lang2, Jobs1, Jobs2);
		ArrayList<String> character = new ArrayList<String>();
		String e = null;
		for (int u = 0; u < 15; u++) {
			character.add(e);
		}
	}

	public static void start() {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		System.out.println("Καλως Ορίσατε! Παρακαλώ επιλέξτε μια απο τις παρακάτω επιλογές:"
				+ "Πληκτρολογήστε : 1 για Αξιολόγηση Υπαλλήλων, 2 για τα Οικονομικά Στατιστικά,"
				+ "3 για Επικοινωνία Πελατών");
		try {
			a = sc.nextInt();
		} catch (InputMismatchException exception) {
			System.out.println("Κάτι πήγε στραβά...");
		}
		if (a != 1 && a != 2 && a != 3) {// ελέγχει αν είναι μέσα στα όρια η επιλογή
			System.out.println("Δεν υπάρχει τέτοια επιλογή!!!\nΞαναδωσε!!!\n");
			a = sc.nextInt();
			sc.nextLine();// χρειάζεται για να δουλέψει
		}
		switch (a) {
		case 1:
			setValues();//Καλεί την μέθοδο καταχώρησης τιμών για την αξιολόγηση υπαλλήλου
			System.out.println();
		case 2:
			login(); //φορτώνεται η φόρμα σύνδεσης του οικονομικά ενδιαφερόμενου ατόμου
			loadObjects();
		case 3:
			System.out.println();
		}
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
		//Έσοδα ξενοδοχείου για το περσινό έτος
		Income i1 = new Income("Έσοδα από δωμάτια", 985392.30);
		Income i2 = new Income("Έσοδα από bar", 252426.60);
		Income i3 = new Income("Λοιπά έσοδα", 100765.40);

		//Έξοδα ξενοδοχείου για το περσινό έτος
		Outcome o1 = new Outcome("Έξοδα μισθοδοσίας", 176268.25);
		Outcome o2 = new Outcome("Έξοδα συντήρησης ξενοδοχείου", 103245.80);
		Outcome o3 = new Outcome("Λοιπά έξοδα", 732953.60);

		//Λίστα οικονομικών στοιχείων για το περσινό έτος και ο οικονομικά ενδιαφερόμενος εισάγει στοιχεία φετινού έτους
		ArrayList<Double> lastyear = new ArrayList<Double>();
		lastyear.add(i1.getValue());
		lastyear.add(i2.getValue());
		lastyear.add(i3.getValue());
		lastyear.add(o1.getValue());
		lastyear.add(o2.getValue());
		lastyear.add(o3.getValue());
		calculateProfit(lastyear);
		Scanner input = new Scanner(System.in);
		System.out.println("Παρακαλώ εισάγετε τα έσοδα απο δωμάτια για το φετινός έτος.");
		Income i11 = new Income("Έσοδα από δωμάτια", input.nextDouble());
		System.out.println("Παρακαλώ εισάγετε τα έσοδα απο bar για το φετινός έτος.");
		Income i21 = new Income("Έσοδα από bar", input.nextDouble());
		System.out.println("Παρακαλώ εισάγετε λοιπά έσοδα για το φετινός έτος.");
		Income i31 = new Income("Λοιπά έσοδα", input.nextDouble());
		System.out.println("Παρακαλώ εισάγετε τα έξοδα μισθοδοσίας για το φετινός έτος.");
		Outcome o11 = new Outcome("Έξοδα μισθοδοσίας", input.nextDouble());
		System.out.println("Παρακαλώ εισάγετε τα έξοδα συντήρησης ξενοδοχείου για το φετινός έτος.");
		Outcome o21 = new Outcome("Έξοδα συντήρησης ξενοδοχείου", input.nextDouble());
		System.out.println("Παρακαλώ εισάγετε λοιπά έξοδα για το φετινός έτος.");
		Outcome o31 = new Outcome("Λοιπά έξοδα", input.nextDouble());
		ArrayList<Double> thisyear = new ArrayList<Double>();
		thisyear.add(i11.getValue());
		thisyear.add(i21.getValue());
		thisyear.add(i31.getValue());
		thisyear.add(o11.getValue());
		thisyear.add(o21.getValue());
		thisyear.add(o31.getValue());
		calculateProfit(lastyear, thisyear);
	}
	private static void calculateProfit(ArrayList<Double> list1) {
		double income = list1.get(0) + list1.get(1) + list1.get(2);
		double outcome = list1.get(3) + list1.get(4) + list1.get(5);
		double profit = income - outcome;
		if (profit < 0) {
			System.out.printf("Το ξενοδοχείο ζημιώθηκε κατά %.2f %s\n", profit, "ευρώ πέρσι");
		} else if (profit == 0) {
			System.out.println("Το ξενοδοχείο δεν σημείωσε κέρδος πέρσι");
		} else {
			System.out.printf("Το ξενοδοχείο είχε κέρδος %.2f %s\n", profit, "ευρώ πέρσι");
		}
	}
	private static void calculateProfit(ArrayList<Double> list1, ArrayList<Double> list2) {
		double incomelastyear = list1.get(0) + list1.get(1) + list1.get(2);
		double outcomelastyear = list1.get(3) + list1.get(4) + list1.get(5);
		double profitlastyear = incomelastyear - outcomelastyear;
		double incomethisyear = list2.get(0) + list2.get(1) + list2.get(2);
		double outcomethisyear = list2.get(3) + list2.get(4) + list2.get(5);
		double profitthisyear = incomethisyear - outcomethisyear;
		double profit = profitthisyear - profitlastyear;
		if (profit < 0) {
			System.out.printf("Το ξενοδοχείο ζημιώθηκε κατά %.2f %s\n", profit, "ευρώ σε σχέση με πέρσι");
		} else if (profit == 0) {
			System.out.println("Το ξενοδοχείο δεν σημείωσε κέρδος σε σχέση με πέρσι");
		} else {
			System.out.printf("Το ξενοδοχείο είχε κέρδος %.2f %s\n", profit, "ευρώ σε σχέση με πέρσι");
		}
	}
}

