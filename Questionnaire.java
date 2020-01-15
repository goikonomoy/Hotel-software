import java.util.ArrayList;
import java.util.Scanner;
public class Questionnaire {
public int[] answers=new int[11];
private Reservation reservation;
int CustomerId;
public ArrayList<Questionnaire> Questionnaires = new ArrayList<Questionnaire>();
public Questionnaire(int CustomerId) {
	this.CustomerId = CustomerId;
	answers = run_que();
	Questionnaires.add(this);
	}
public static String[] que = new String[10];{
que[0]="How did you find the hotel?";
que[1]="How clean the hotel was?";
que[2]="How good was the service in the restaurant?";
que[3]="How good was the food in the restaurant?";
que[4]="How good was service in the beach bar?";
que[5]="How good the quality of the drinks at the beach bar was?";
que[6]="How helpful was the reception at the hotel?";
que[7]="Are you happy adout the price of the hotel";
que[8]="Would you visit the hotel again?";
que[9]="Would recommend the hotel to a friend or acquaintance";
}
//τρέχει το ερωτηματολόγιο και αποθηκέυει τις απαντήσεις (σε κλίμακα 1-3) στις πρώτες 10 θέσεις του πίνακα ansers, ενώ στην 
//τελευταία εκχωρείται η συνολική βαθμολογία (αστέρια, κλίμακα 0-5)
public int[] run_que(){
	int sum = 0;
	int x;
	for( x=0; x<10; x++) {
	System.out.println(que[x]);
	System.out.println("press a number from one to three and then enter:1=bad , 2=average , 3=good");
	Scanner sc = new Scanner(System.in);
	answers[x] = sc.nextInt();
	sum += (answers[x]-1);
	sc.close();
	
	}
	answers[10] = (sum/4);
	return answers;
}

}


