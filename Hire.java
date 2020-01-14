import java.util.ArrayList;
import java.util.Scanner;

public class Hire extends Employee {
	static Scanner sc = new Scanner(System.in);
	public static double c = 0;
	public static boolean isBetween(double age, int lower, int upper) {
		return lower <= age && age <= upper;
	}

	public Hire(String name, double age, int jobs, String healthy, String smoker, int languages, String photo,
			String[] lang1, String[] lang2, int[] jobs1, String[] jobs2) {
		super(name, age, jobs, healthy, smoker, languages, photo, lang1, lang2, jobs1, jobs2);
		// TODO Auto-generated constructor stub
	}

	public static double gradeAge(double age) {// βαθμολογεί την ηλικία του υπαλλήλου (ο βαθμός προσαρμόζεται αναλογα με τις
		// προτιμήσεις το καθενός)
		double grade = 0;
		if (isBetween(age, 18, 25)) {
			grade = 70;
		} else if (isBetween(age, 26, 32)) {
			grade = 100;
		} else if (isBetween(age, 33, 40)) {
			grade = 90;
		} else if (isBetween(age, 41, 50)) {
			grade = 60;
		} else if (isBetween(age, 51, 99)) {
			grade = 0;
		}
		return grade;
	}
	public static double gradePhoto(String photo) {
		String str2 = "ναι";
		double grade = 0;
		if (photo.equals(str2)) {
			grade = 100;
		}
		return grade * 0.04;
	}
    public static double gradeSmoker(String smoker) {//αν ο υποψήφιος δεν είναι καπνιστής κερδίζει έξτρα πόντους
		String str1 = "όχι";
    	double grade = 0;//διότι είναι πρακτικά πιο βολικός σε σχεση με τον καπνιστή.
		if (smoker.equals(str1)) {
			grade = 100;
		}
		return grade * 0.03;
	}

	public static double gradeHealth(String healthy) {
		double grade = 0;
		String str1="ναι";
		if (healthy.equals(str1)) {
			grade = 100;
		}
		return grade * 0.07;
	}

	public static double gradeJobs(int[] Jobs1, String[]Jobs2, int jobs) { // βαθμολογεί εμπειρία δουλειάς εφόσον έχει
		// εργαστεί πάνω απο 6 μήνες σε κάθε δουλειά
		System.out.println("Παρακαλώ πείτε μας τι είδος εργασίας θέλετε να κάνει ο υποψήφιος (Απλές εργασίες, "
				+ " Reception, Λογιστήριο, Καθαριότητα, Διοικητικό στέλεχος");
		String s = sc.nextLine();
		double grade = 0;
		for (int i = 0; i < jobs; i++) {
			if (Jobs1[i] >= 6) {
				if (isBetween(jobs, 0, 1)) {
					grade = 30;
				} else if (isBetween(jobs, 2, 3)) {
					grade = 40;
				} else if (isBetween(jobs, 4, 5)) {
					grade = 60;
				} else if (isBetween(jobs, 6, 7)) {
					grade = 70;
				} else if (isBetween(jobs, 8, 99)) {
					grade = 80;
				}	
			}
		}
		double grade2 = 0;
		for (int i = 0; i < jobs; i++) {
			if(Jobs2[i].equals(s)) {
				grade2 = 20; //έξτρα βαθμός αν έστω μια δουλειά είναι συμβατή με αυτό που θέλουμε
			}
		}
		grade+=grade2;
		return grade;
	}

	public static double gradeLanguages(int languages, String[]Lang1, String[]Lang2) { //βαθμολογεί τις ξένες γλώσσες εφόσον βρίσκονται σε άριστο επιπεδο(δηλαδη δινει έξτρα βαθμό)
		System.out.println("Παρακαλώ πείτε μας ποιά ξένη γλώσσα θα θέλατε να ξέρει ο υποψήφιος");
		String s2 = sc.nextLine();
		double grade = 0;
		for (int i = 0; i < languages; i++) {
			String str3="άριστα";
	if (Lang2[i].equals(str3)) {
		if(s2.equals(Lang1[i])) {
			grade=100;
		}else {
			grade=85;
		}
	}
}
		if (languages==1) {
			grade*=0.8;
		}else if(languages==2) {
			grade*=0.9;
		}
		grade*=0.16;
return grade;
	}

	public static double gradeExperiance(int[]Jobs1, String[] Jobs2, int jobs, double age) { // βαθμολογεί την γενική εμπειρία με συνιστώσες
		// την ηλικία και την εμπειρία δουλειάς (προυπηρεσία)
		double i = gradeJobs(Jobs1, Jobs2, jobs), j = gradeAge(age);
		return (i * 0.75 + j * 0.25) * 0.7;
	}

	public static double grading(String name, double age, int jobs, String healthy, String smoker, int languages, String photo,
			String[]Lang1, String[]Lang2, int[]Jobs1, String[]Jobs2) {
		double teliko = 0;
		double[] a = new double[5];
		a[0] = gradeExperiance(Jobs1, Jobs2, jobs, age);
		a[1] = gradeHealth(healthy);
		a[2] = gradeSmoker(smoker);
		a[3] = gradePhoto(photo);
		a[4] = gradeLanguages(languages, Lang1, Lang2);
		
		for (int i = 0; i <=4; i++) {
			teliko += a[i];
		}
		System.out.println("Ο υποψήφιος βαθμολογείται με "+teliko+" σύμφωνα με τα κριτήριά σας.");
		return teliko;
		
	}
}
