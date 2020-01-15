import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Room {
	private int Cat;
	private int RoomNo;
	public double Price;
	static ArrayList<Room> rooms = new ArrayList<Room>();
	public Room(int Cat, int RoomNo) {
		this.setCat(Cat);
		this.setRoomNo(RoomNo);
		Price = CatPrice(Cat);
		rooms.add(this);
	}
	private double CatPrice(int cat) {
		double price = 0;
		switch (cat) {
			case  1 :
				price = 30;
				break;
			case 2 :
				price = 50;
				break;
			case 3 :
				price = 65;
				break;
			case 4 :
				price = 87.5;
				break;
			case 5 :
				price = 100;
				break;
		}
		return price;
	}
	public int getCat() {
		return Cat;
	}
	//εξετάζει τη διαθεσιμότητα για δοσμένες ημερομηνίες και τύπο δωματίου και επιστρέφει (τυχαία για παραπάνω από 1 διαθέσιμα) ένα αντικείμενο δωματίου που πληροί τα κριτήρια
	public static Room roomAvailability(int Cat, LocalDate check_in, LocalDate check_out){
		int i;
		ArrayList<Room> roomsAvailable = rooms;
		if (false == (Reservation.reservations.isEmpty())) {
        for (i = 0; i < Reservation.reservations.size(); i++) {
        	Reservation r = Reservation.reservations.get(i);
        	if (((r.getCheck_in().compareTo(check_in) >= 0) && (r.getCheck_out().compareTo(check_out) <= 0)) || 
        		 ((r.getCheck_in().compareTo(check_in) <= 0 && (r.getCheck_out().compareTo(check_out)) >= 0)) 
        		 || (((r.getCheck_in().compareTo(check_out) < 0) && (r.getCheck_out().compareTo(check_out) >=0 )))
        		 || ((r.getCheck_in().compareTo(check_in) <= 0) && (r.getCheck_out().compareTo(check_in) > 0))){
        			 roomsAvailable.remove(r.getRoom());
        	}
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
	public void setCat(int cat) {
		Cat = cat;
	}
	public int getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(int roomNo) {
		RoomNo = roomNo;
	}
}
