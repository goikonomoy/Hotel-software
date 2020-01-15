import java.util.Scanner;

import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

	public static void setValues() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Παρακαλω πληκτρολογήστε όνομα");
		String name = sc.nextLine();
		System.out.println("Παρακαλω πληκτρολογήστε ηλικία");
		double age = sc.nextDouble();
		sc.nextLine();
		System.out.println(
				"Παρακαλω δηλώστε αν ο υποψήφιος έχει προσκομίσει ιατρική βεβαίωση.\nΑπαντήστε με: 'ναι' ή 'όχι'");
	    String healthy = sc.nextLine();
		healthy.toLowerCase();
		System.out.println("Παρακαλω πληκτρολογήστε αριθμό προηγούμενων εργασιακών εμπειριών");
		int jobs = sc.nextInt();
		System.out.println("Παρακαλω πληκτρολογήστε αν ο υποψήφιος είναι καπνιστής.\nΑπαντήστε με: 'ναι' ή 'όχι'");
		String smoker = sc.nextLine();
		smoker.toLowerCase();
		sc.nextLine();
		System.out.println("Παρακαλω πληκτρολογήστε αν ο υποψήφιος έχει επισυνάψει φωτογραφία." +
       "\nΑπαντήστε με: 'ναι' ή όχι'");
		String photo = sc.nextLine();
		photo.toLowerCase();
		System.out.println("Παρακαλώ πείτε πόσες ξένες γλώσσες γνωρίζει ο υποψήφιος");
		int languages=sc.nextInt();
		int[] Jobs1 = new int[jobs];
		String[]Lang1 = new String[languages];
		String[]Jobs2 = new String[jobs];
		String[]Lang2 = new String[languages];
			for (int j = 0; j < jobs; j++) {
					System.out.println("Παρακαλώ πληκτρολογήστε το είδος της εργασίας νούμερο "+(j+1)+"Απλές εργασίες," 
							 +"Reception, Λογιστήριο, Καθαριότητα, Διοικητικό στέλεχος");
					Jobs2[j] = sc.nextLine();
			}
			sc.nextLine();
					for (int i = 0; i < jobs; i++) {
				System.out.println(
						"Παρακαλώ γράψτε για πόσο καιρό έμεινε (σε μήνες) ο υποψήφιος στην εργασία νούμερο:  " +(i+1));
				Jobs1[i] = sc.nextInt();
			}
		for (int i = 0; i < languages; i++) {
			System.out.println("Παρακαλώ γράψτε το όνομα της ξένης γλώσσας νούμερο" +(i+1));
			Lang1[i] = sc.nextLine();
		}
		sc.nextLine();
		for (int k = 0; k < languages; k++) {
				System.out.println("Παρακαλώ γράψτε το επίπεδο ('άριστα' ή 'όχι άριστα')"
						+ " του υποψήφιου στη γλώσσα νούμερο" +(k+1));
				Lang2[k] = sc.nextLine();//υποθέτουμε πως το ξενοδοχείο αναζητεί 
				//υποψήφιους μόνο με άριστη γνώση ξένων γλωσσών
			}
		Hire.grading(name,age, jobs, healthy, smoker, languages, photo,
				Lang1, Lang2, Jobs1, Jobs2);
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

			main3();

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
			System.out.printf("Το ξενοδοχείο ζημιώθηκε κατά %.2f %s\n", -profit, "ευρώ πέρσι");
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
			System.out.printf("Το ξενοδοχείο ζημιώθηκε κατά %.2f %s\n", -profit, "ευρώ σε σχέση με πέρσι");
		} else if (profit == 0) {
			System.out.println("Το ξενοδοχείο δεν σημείωσε κέρδος σε σχέση με πέρσι");
		} else {
			System.out.printf("Το ξενοδοχείο είχε κέρδος %.2f %s\n", profit, "ευρώ σε σχέση με πέρσι");
		}
	}



	private static final String String = null;

	public static void main3() {
		loadObjects2();
		boolean obj = loadObjects2();
		Scanner sc = new Scanner(System.in);
		if (obj == false) {
		int p = 0 ;
		boolean loop ;
		do {
			 loop = true;
			do {
				try {
					System.out.println("Γειά σας έχετε κάνει κάποια κράτηση;/n press 1 for yes or 2 for no");
					p=sc.nextInt();
					if (p<1||p>2) {
						System.out.println("Παρακαλώ πατήστε 1 ή 2");
					}
					loop = false;
				} catch (InputMismatchException ex) {
					System.err.println("exception" + ex);
					sc.hasNextLine();
					System.out.println("Παρακαλω δωστε εναν ακεραιο 1 ή 2");
				}
			}while(loop);
		}while(p < 1 || p >2);
			if  (p==2) {
			int kind_room = 0;
			do {
				 loop = true;
				do {
					try {
						System.out.println("Τι είδους δωματίου ψάχνετε;\n Υπάρχουν μονόκλινα,δύκλινα,τρίκλινα,τετράκλινα,suite \n πληκτρολογήστε 1,2,3,4,5 για το είδους δωματίου που προτιμάτε αντίστοιχα\n");
						kind_room=sc.nextInt();
						if (kind_room<1||kind_room>5) {
							System.out.println("Παρακαλώ πατήστε 1 ή 2 ή 3 ή 4 ή 5");
						}
						loop = false;
					} catch (InputMismatchException ex) {
						System.err.println("exception" + ex);
						sc.hasNextLine();
						System.out.println("Παρακαλω δωστε εναν ακεραιο 1 ή 2 ή 3 ή 4 ή 5");
					}
				}while(loop);
			}while(kind_room < 1 || kind_room >5);
			
			String input;
			System.out.println("Δώστε μηνα,ημέρα,χρόνο άφιξης πχ 10/25/2019");
		    input = sc.next();
		    LocalDate chekin = dateInput(input);
		    System.out.println("Δώστε μήνα,ημέρα,χρόνο αναχώρισης πχ 1/31/2019");
			input = sc.next();
			LocalDate chekout = dateInput(input);
			Room r = Room.roomAvailability(kind_room, chekin,  chekout);
			int q = 0;
			do {
				 loop = true;
				do {
					try {
						System.out.println("Είναι η πρώτη φορά που έρχεστε στο ξενοδοχείο;/n 1 για Nαι και 2 για Oχι");
						q=sc.nextInt();
						if (q<1||q>2) {
							System.out.println("Παρακαλώ πατήστε 1 ή 2");
						}
						loop = false;
					} catch (InputMismatchException ex) {
						System.err.println("exception" + ex);
						sc.hasNextLine();
						System.out.println("Παρακαλω δωστε εναν ακεραιο 1 ή 2");
					}
				}while(loop);
			}while(q < 1 || q >2);
			
			if (q==1) {
				System.out.println("Όνομα");
			    String name;
				name=sc.next();
				System.out.println("Επίθετο");
				String surname;
				surname = sc.next();
				System.out.println("Email");
				String email;
				email=sc.next();
				System.out.println("Διεύθυνση");
				String address;
				address = sc.next();
				int age = 0;
				do {
					 loop = true;
					do {
						try {
							System.out.println("Ηλικία");
							age=sc.nextInt();
							if (age<18) {
								System.out.println("Παρακαλώ δωστε σωστή ηλικία");
							}
							loop = false;
						} catch (InputMismatchException ex) {
							System.err.println("exception" + ex);
							sc.hasNextLine();
							System.out.println("δωστε την ηλικία σας");
						}
					}while(loop);
				}while(age<18);
				
				String sex="";
					do { 
					System.out.println("please and your sex.M for male and F for female");
					sex=sc.next();
					}while (sex == "M" || sex=="F");
				System.out.println("please enter your id");
				int id;
				id=sc.nextInt();
			    new Customer(name, surname, email, address, age, sex);
			}
			
				
			}else 
				System.out.println("Δωστε μας το ονομα σας και το επιθετό σας για να μπορέσουμε να βρουμε τα στοιχεία σας");
			String nam = sc.next();
			String surnam = sc.next();
			Customer cu = Customer.findCustomer(nam,surnam);
			if(cu == null) {
				System.out.println("Δεν υπάρχει αυτός ο πελάτης");
				
				
			} else {
			System.out.println("Δωστε μασ τον κωδικό κρατησης");
			Scanner sc1 = new Scanner(System.in);
			int connumber = sc1.nextInt();
			Reservation.rFinder(connumber);
			
		}
		}else {
			System.out.println("FAILED TO LOAD OBJECTS PROPERLY");
		}
	sc.close();
	}
	
	
	public static LocalDate dateInput(String userInput) {

	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
	    LocalDate date = LocalDate.parse(userInput, dateFormat);
	    return date ;
	}
	public static boolean loadObjects2() {
		boolean obj = false;
		new Room(1, 101);
		new Room(1, 102);
		new Room(1, 103);
		new Room(1, 104);
		new Room(1, 105);
		new Room(2, 201);
		new Room(2, 202);
		new Room(2, 203);
		new Room(2, 204);
		new Room(2, 205);
		new Room(3, 301);
		new Room(3, 302);
		new Room(3, 303);
		new Room(3, 304);
		new Room(3, 305);
		new Room(3, 401);
		new Room(4, 402);
		new Room(4, 403);
		new Room(4, 404);
		new Room(4, 405);
		new Room(5, 1001);
		new Room(5, 1002);
		new Room(5, 1003);
		new Customer("panagiotis","spiliotis","panspil1111@gmail.com","stravonos 14", 18,"M");
		new Customer("giannhs","vagionakis","gvagion@gmail.com","ieronos 14", 23,"M");
		new Customer("manolis","papakostantinoy","manolis13@gmail.com","derbenakioy 18", 38,"M");
		new Customer("artemis","patedaki","artemis@hotmail.com","agiou nikolaoy 5", 32,"F");
		new Customer("elina","saranti","elinam@gmail.com","diovoyniotoy 12", 28,"F");
		new Customer("giorgos","oikonomoy","goikonom@gmail.com","panepistimioy 56", 22,"M");
		new Customer("mhxalhs","papantonioy","makispap@gmail.com","kolokotronh 14", 26,"M");
		//new Reservation(dateInput("9/2/2019"),dateInput("9/16/2019"),1002,"giannhs",2);
		//new Reservation(dateInput("9/15/2019"),dateInput("9/30/2019"),1001,"panagiotis",3);
		//new Reservation(dateInput("9/13/2019"),dateInput("9/17/2019"),201,"artemis",5);
		obj = ((Customer.customers.isEmpty()) && (Room.rooms.isEmpty()));
		return obj;
	}
	
}



}
