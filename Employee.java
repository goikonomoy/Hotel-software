import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
	private static String name;
	private static double age;
	private static int jobs;
	private static String healthy;
	private static String smoker;
	private static int languages;
	private static String photo;
	private static String[] Lang1 = new String[languages];// περιέχει τα ονόματα των ξένων γλωσσών
	private static int[] Jobs1 = new int[jobs];//περιέχει χρονικό διάστημα δουλειάς σε μήνες
	private static String[] Lang2 = new String[languages];// περιέχει επίπεδο ξένης γλώσσας
	private static String[] Jobs2 = new String[jobs];//περιέχει είδος δουλειάς

	public static void setName(String name) {
		Employee.name = name;
	}

	public static double getAge() {
		return age;
	}

	public static void setAge(double age) {
		Employee.age = age;
	}

	public static int getJobs() {
		return jobs;
	}

	public static void setJobs(int jobs) {
		Employee.jobs = jobs;
	}

	public static String getHealthy() {
		return healthy;
	}

	public static void setHealthy(String healthy) {
		Employee.healthy = healthy;
	}

	public static String getSmoker() {
		return smoker;
	}

	public static void setSmoker(String smoker) {
		Employee.smoker = smoker;
	}

	public static int getLanguages() {
		return languages;
	}

	public static void setLanguages(int languages) {
		Employee.languages = languages;
	}

	public static String getPhoto() {
		return photo;
	}

	public static void setPhoto(String photo) {
		Employee.photo = photo;
	}

	public String[] getLang1() {
		return Lang1;
	}

	public void setLang1(String[] lang1) {
		Lang1 = lang1;
	}

	public String[] getLang2() {
		return Lang2;
	}

	public void setLang2(String[] lang2) {
		Lang2 = lang2;
	}

	public String[] getJobs2() {
		return Jobs2;
	}

	public void setJobs2(String[] jobs2) {
		Jobs2 = jobs2;
	}

	public void setJobs1(int[] jobs1) {
		Jobs1 = jobs1;
	}

	public int[] getJobs1() {
		return Jobs1;
	}

public Employee(String name, double age, int jobs, String healthy, String smoker, int languages, String photo,
			String[]lang1, String[]lang2, int[]jobs1, String[]jobs2) {
		this.name = name;
		this.age = age;
		this.jobs = jobs;
		this.healthy = healthy;
		this.smoker = smoker;
		this.languages = languages;
		this.photo = photo;
		this.Lang1 = lang1;
		this.Jobs1 = jobs1;
		this.Lang2 = lang2;
		this.Jobs2 = jobs2;

	}
}

