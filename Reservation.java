import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class Reservation {

	private int confirmationNo;
	private LocalDate check_in;
	private  LocalDate check_out;
	private Room room;
	private String Cname;
	private int Cid;
	public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	private int comfNo;
	static int count;
	private double value;

	public Reservation(LocalDate check_in, LocalDate check_out,int roomNo, String Cname, int Cid) {
	 setCheck_in(check_in);
	 setCheck_out(check_out);
	 setComfNo(count);
	 setRoom(roomNo);
	 setValue(this.getRoom().Price * Period.between(check_in, check_out).getDays());
	 setId(Cid);
	 setCname(Cname);
	 reservations.add(this);
	 count++;
	}
	
	private void setCname(String cname2) {
		this.Cname = cname2;
		
	}

	private void setId(int cid2) {
			this.Cid = cid2; 
		
	}

	private void setValue(double d) {
		this.value = d; 
		
	}

	public void setRoom(int roomNo) {
		int i;
		Room room = null;
		for (i=0 ; i<Room.rooms.size();i++)
	    room = Room.rooms.get(i);
		if (roomNo == room.getRoomNo())
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
				Room ro = r.getRoom();
				if ( ro.getRoomNo() == No){
                   new CompletedReservation(r.getCheck_in(), r.getCheck_out(), r.getRoom().getRoomNo(), r.Cname, r.Cid, r.value);
				   reservations.remove(i);
				}
		}
		
	}
	//υπολογίζει τις μέρες διαμονής//
	public int nightsStayed(Reservation reservation) {
		int days = Period.between(check_in, check_out).getDays();
		return (int)days;
	}
	//βρίσκει την κράτηση με βάση το comfNo
	public static void rFinder(int connumb) {
		Reservation rr = null;
		int i;
		int No = 0;
		for (i = 0; i < reservations.size(); i++){
			Reservation r = reservations.get(i);
			Room ro = r.room;
		    if (r.comfNo == connumb) {
		    	rr= r;
		    	No = ro.getRoomNo();
		    }
		}
		if (No != 0) {
			System.out.println("Your room is Room no %d" + No);
		}
		
	}

	private int getCid() {
		return Cid;
	}

}
		

