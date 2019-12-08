import java.util.ArrayList;

public class Hire extends Employee {
	public static boolean isBetween(double age, int lower, int upper) {
		return lower <= age && age <= upper;
	}

	public Hire(String name, double age, int jobs, String healthy, String smoker, int languages, String photo,
			String[] lang1, String[] lang2, int[] jobs1, String[] jobs2) {
		super(name, age, jobs, healthy, smoker, languages, photo, lang1, lang2, jobs1, jobs2);
		// TODO Auto-generated constructor stub
	}

	public double gradeAge() {// βαθμολογεί την ηλικία του υπαλλήλου (ο βαθμός προσαρμόζεται αναλογα με τις
		// προτιμήσεις το καθενός)
		double age = getAge();
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

	public double gradeSmoker() {//αν ο υποψήφιος δεν είναι καπνιστής κερδίζει έξτρα πόντους
		double grade = 0;
		if (getSmoker() == "όχι") {
			grade = 100;
		}
		return grade * 0.03;
	}

	public double gradeHealth() {
		double grade = 0;
		if (getHealthy() == "ναι") {
			grade = 100;
		}
		return grade * 0.07;
	}

	public double gradeJobs(int[] Jobs1) { // βαθμολογεί εμπειρία δουλειάς εφόσον έχει
		// εργαστεί πάνω απο 6 μήνες σε κάθε δουλειά
		int jobs = getJobs();
		double grade = 0;
		for (int i = 0; i <= getJobs(); i++) {
			if (Jobs1[i] >= 6) {
				if (isBetween(jobs, 0, 0)) {
					grade = 0;
				} else if (isBetween(jobs, 1, 2)) {
					grade = 55;
				} else if (isBetween(jobs, 3, 4)) {
					grade = 75;
				} else if (isBetween(jobs, 4, 6)) {
					grade = 90;
				} else if (isBetween(jobs, 7, 99)) {
					grade = 100;
				}
			}
		}
		return grade;
	}

	public double gradeLanguages() { //βαθμολογεί τις ξένες γλώσσες εφόσον βρίσκονται σε άριστο επιπεδο

	}

	public double gradeExperiance() { // βαθμολογεί την γενική εμπειρία με συνιστώσες
		// την ηλικία και την εμπειρία δουλειάς (προυπηρεσία)
		double i = gradeJobs(getJobs1()), j = gradeAge();
		return (i * 0.75 + j * 0.25) * 0.7;
	}

	public double grading(double[] a) {// ο πίνακας α θα έχει τα στοιχεια της βαθμολόγησης πολλαπλασιαμένα με
		double teliko = 0;
		a[0] = gradeExperiance();
		a[1] = gradeHealth();
		a[2] = gradeSmoker();

		for (int i = 0; i < a.length; i++) {
			teliko += a[i];
		}
		teliko /= a.length;
		return teliko;
	}
}
