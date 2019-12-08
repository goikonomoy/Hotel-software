import java.util.ArrayList;

public class Customer {
	private String address;
	private String email;
	private String name;
	private int id;
	private String surname;
	ArrayList<Customer> customers = new ArrayList<Customer>() ;
	ArrayList<Reservation> reservations = new ArrayList<Reservation>() ;
	public Customer(int id, String name, String surname, String email, String address, ArrayList<Reservation> reservations) {
		this.setAddress(address);
		this.reservations = reservations;
	    this.setId(id);
		this.setName(name);
		this.setEmail(email);
		this.setSurname(surname);
		customers.add(this);
		
	}
	
	public String customerCat(ArrayList<Reservation> reservations, int id) {
		int i;
		int NoOfStays = 0;
		for (i = 0; i < reservations.size(); i++) {
			NoOfStays += Reservation.nightsStayed(reservations.get(i));
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
	private void setSurname(String surname) {
		this.surname = surname;
		
	}	
	
	public ArrayList<Questionnaire> revPerC(Customer customer){
		return reservation.reviews<Questionnaire>;
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
