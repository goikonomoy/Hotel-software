import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

	private int confirmationNo;
	private static LocalDate check_in;
	private static LocalDate check_out;
	private Room Room;
	private AddOns addons;
	private String Cname;
	private int Cid;

	public Reservation(int confirmationNo, LocalDate check_in, LocalDate check_out, double value, Room room, AddOns addons, String Cname, int Cid) {
	 setCheck_in(check_in);
	 setConfirmationNo(confirmationNo);
	 
	}
	
	public static int nightsStayed(Reservation reservation) {
		long days = ChronoUnit.DAYS.between(check_in, check_out);
		return (int)days;
	}

	public LocalDate getCheck_in() {
		return check_in;
	}

	public void setCheck_in(LocalDate check_in) {
		this.check_in = check_in;
	}

	public int getConfirmationNo() {
		return confirmationNo;
	}

	public void setConfirmationNo(int confirmationNo) {
		this.confirmationNo = confirmationNo;
	}
}
