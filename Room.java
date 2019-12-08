
public class Room {
	private String Cat;
	private int RoomNo;
	public Room(String Cat, int RoomNo) {
		this.setCat(Cat);
		this.setRoomNo(RoomNo);
		
	}
	public String getCat() {
		return Cat;
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
