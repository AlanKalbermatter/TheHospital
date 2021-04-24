package dao.domain;

public class Bed {
    private long id;
    private int roomNumber;

    public Bed(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public long getId() {
        return id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
