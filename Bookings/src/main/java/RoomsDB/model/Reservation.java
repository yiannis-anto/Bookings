package RoomsDB.model;

public class Reservation {

    private int id;
    private String startdate;
    private String fullname;
    private int price;

    private int confirmed;

    private int roomid;

    private String telephone;

    public Reservation() {

    }

    public Reservation(int id, String startdate, String fullname, int price, int confirmed,
            int roomid, String tel) {

        this.id = id;
        this.startdate = startdate;
        this.fullname = fullname;
        this.price = price;

        this.confirmed = confirmed;

        this.roomid = roomid;

        telephone = tel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }


    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }



    public void setTelephone(String tel) {
        telephone = tel;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getFullname() {
        return fullname;
    }

    public int getPrice() {
        return price;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public int getRoomid() {
        return roomid;
    }

    public String getTelephone() {
        return telephone;
    }
}
