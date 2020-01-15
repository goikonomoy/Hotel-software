
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class CompletedReservation extends Reservation {
 Questionnaire Q;
 private int Cid;
 private double Value;
 public static ArrayList<CompletedReservation> creservations;
 
	public CompletedReservation(LocalDate check_in, LocalDate check_out, int roomNo, String Cname, int Cid, double value) {
		super(check_in, check_out, roomNo, Cname, Cid);
		Questionnaire Q = new Questionnaire(Cid);
		Value = value;
		creservations.add(this);
	}
	
	public int getCid() {
		return Cid;
	}
	public int setCid(int cid) {
		Cid = cid;
		return cid;
	}
}
