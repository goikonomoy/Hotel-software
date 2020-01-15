import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Room {
	private String Cat;
	private int RoomNo;
	public double Price;
	ArrayList<Room> rooms = new ArrayList<Room>();
	public Room(String Cat, int RoomNo) {
		this.setCat(Cat);
		this.setRoomNo(RoomNo);
		Price = CatPrice(Cat);
		rooms.add(this);
	}
	private double CatPrice(String cat2) {
		double price = 0;
		switch (cat2) {
			case  "1-bed" :
				price = 30;
				break;
			case "2-bed" :
				price = 50;
				break;
			case "3-bed" :
				price = 65;
				break;
			case "4-bed" :
				price = 87.5;
				break;
			case "suite" :
				price = 100;
				break;
		}
		return price;
	}
	public String getCat() {
		return Cat;
	}
	//εξετάζει τη διαθεσιμότητα για δοσμένες ημερομηνίες και τύπο δωματίου και επιστρέφει (τυχαία για παραπάνω από 1 διαθέσιμα) ένα αντικείμενο δωματίου που πληροί τα κριτήρια
	public Room roomAvailability(String Cat, LocalDate check_in, LocalDate check_out){
		int i;
		ArrayList<Room> roomsAvailable = rooms;
        for (i = 0; i < Reservation.reservations.size(); i++) {
        	Reservation r = Reservation.reservations.get(i);
        	if (((r.getCheck_in().compareTo(check_in) >= 0) && (r.getCheck_out().compareTo(check_out) <= 0)) || 
        		 ((r.getCheck_in().compareTo(check_in) <= 0 && (r.getCheck_out().compareTo(check_out)) >= 0)) 
        		 || (((r.getCheck_in().compareTo(check_out) < 0) && (r.getCheck_out().compareTo(check_out) >=0 )))
        		 || ((r.getCheck_in().compareTo(check_in) <= 0) && (r.getCheck_out().compareTo(check_in) > 0))){
        			 roomsAvailable.remove(r.getRoom());
        	}
        }
        for (i = 0; i < roomsAvailable.size(); i++) {
        	Room ro = roomsAvailable.get(i);
        	if (ro.Cat != Cat) {
        		roomsAvailable.remove(ro);
        	}
        }
        Random rand = new Random();
        int No = rand.nextInt(roomsAvailable.size());
        return roomsAvailable.get(No);
	}
	//Επιστρέφει την συνολική πληρότητα του ξενοδοχείου επι τοις εκατό
	public double hotelFullness() {
		int i;
		double HotelFullness;
		ArrayList<Room> roomsAvailable = rooms;
        for (i = 0; i < Reservation.reservations.size(); i++) {
        	Reservation r = Reservation.reservations.get(i);
        	if ( ((r.getCheck_in().compareTo(LocalDate.now()) <= 0) && (r.getCheck_out().compareTo(LocalDate.now()) > 0))) {
        		roomsAvailable.remove(r.getRoom());
        	}
        }
        HotelFullness = (double)( 100-(roomsAvailable.size())*100/rooms.size());
	return HotelFullness;
		
	}
	public void setCat(String cat) {
		Cat = cat;
	}
	public int getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}
}
