import java.util.ArrayList;

public class Customer {
	private String address;
	private String email;
	private String name;
	private int id;
	private String surname;
	private String sex;
	ArrayList<Customer> customers = new ArrayList<Customer>() ;
	ArrayList<CompletedReservation> creservations = new ArrayList<CompletedReservation>() ;

	public Customer( String name, String surname, String email, String address,int age, String sex) {
		this.setAddress(address);
		this.setName(name);
		this.setEmail(email);
		this.setSurname(surname);
		customers.add(this);
	}

	//καθορίζει την κατηγορία του πελάτη ανάλογα με τις μέρες διαμονής//
	public String customerCat(int id) {
		int i;
		int NoOfStays = 0;
		for (i = 0; i < creservations.size(); i++) {
			NoOfStays += Reservation.nightsStayed(creservations.get(i));
		}
		String customerCat;
		if (NoOfStays <= 8) {
			customerCat = "C";
		}else if (NoOfStays <= 25) {
			customerCat = "B";
		}else {
			customerCat = "A";
		}
		return customerCat;
	}

	//επιστρέφει τη μέση εμπειρία (βαθμολογία) που αποκόμισε ο πελάτης με βάση τα reviews του, με το δοσμένο id//
	public int stars(int id){
		int i;
		int stars = 0;
		for (i = 0; i < creservations.size() ; i++ ) {
			CompletedReservation cr = creservations.get(i);
			stars += cr.Q.answers[10] ;
		}
		stars /= i;
		return stars;
	}
	//επιστρέφει τις ολοκληρωμένες κρατήσεις του πελάτη//
	public ArrayList<CompletedReservation> crPerC(int id) {
		int i;
		for (i = 0; i < CompletedReservation.creservations.size() ; i++ ) {
			CompletedReservation cr = CompletedReservation.creservations.get(i);
			if (cr.getCid() == id) {
				creservations.add(cr);
			}
		}
		return creservations;
	}
	private void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}
