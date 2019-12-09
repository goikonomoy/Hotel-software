import java.util.ArrayList;
import java.util.Scanner;
public class Questionnaire {
public Questionnaire(Reservation reservation, int[] answers) {
	
	}
public static int[] answers=new int[10];
public static char[] que = new char[10];
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
}
public static void run_que(char[]que) {
	Scanner sc = new Scanner(System.in);
	for(int x=0; x=9; x++) {
	System.out.println(que[x]);
	System.out.println("press a number from one to three and then enter:1=bad , 2=average , 3=good");
	answers[x]=sc.nextInt();
	}
}
}
