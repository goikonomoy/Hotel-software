import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class Reservation {

	private int confirmationNo;
	private static LocalDate check_in;
	private static LocalDate check_out;
	private Room room;
	private String Cname;
	private int Cid;
	public static ArrayList<Reservation> reservations;
	private int comfNo;
	static int count = 1;
	private double value;

	public Reservation(LocalDate check_in, LocalDate check_out,Room room, String Cname, int Cid) {
	 setCheck_in(check_in);
	 setCheck_out(check_out);
	 setComfNo(count);
	 setRoom(room);
	 value = room.Price * ChronoUnit.DAYS.between(check_in, check_out);
	 reservations.add(this);
	 count++;
	}
	
	private void setRoom(Room room) {
		this.room = room;
	}

	private void setComfNo(int count) {
		comfNo = count;
	}
	

	private void setCheck_out(LocalDate check_out) {
		this.check_out= check_out;
	}
	
	public LocalDate getCheck_in() {
		return check_in;
	}

	public void setCheck_in(LocalDate check_in) {
		this.check_in = check_in;
	}

	public LocalDate getCheck_out() {
		return check_out;
	}

	public Room getRoom() {
		return room;
	}
	public int getComfNo() {
		return comfNo;
	}
	//πραγματοποιεί το check out, δημιουργώντας μια ολοκληρωμένη κράτηση, και διαγράφοντας αυτή που κλείνει απ τη λίστα των τρεχουσών//
	public static void check_out() {
		System.out.println("Please give your RoomNo");
		Scanner sc = new Scanner(System.in);
		int No = sc.nextInt();
		sc.close();
		int i;
		for (i = 0; i < reservations.size(); i++){
				Reservation r = reservations.get(i);
				Room ro = r.room;
				if ( ro.getRoomNo() == No){
                   new CompletedReservation(r.getCheck_in(), r.getCheck_out(), r.room, r.Cname, r.Cid, r.value);
				   reservations.remove(i);
				}
		}
		
	}
	//υπολογίζει τις μέρες διαμονής//
	public static int nightsStayed(Reservation reservation) {
		long days = ChronoUnit.DAYS.between(check_in, check_out);
		return (int)days;
	}
	//βρίσκει την κράτηση με βάση το id του πελάτη
	public int rFinder(int id) {
		int i;
		int No = 0;
		for (i = 0; i < reservations.size(); i++){
			Reservation r = reservations.get(i);
			Room ro = r.room;
		    if (comfNo == r.getCid()) {
		    	No = ro.getRoomNo();
		    }
		}
		return No;
	}

	private int getCid() {
		return Cid;
	}

}
		

