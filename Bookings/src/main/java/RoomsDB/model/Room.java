package RoomsDB.model;

public class Room {

    private int id;
    private String name;
    private int maxCapacity;
    private String address;
    private String comforts;
    private int price;
    private String takenDate;


    public Room(int id, String name, int maxCapacity, String address, String comforts, int price,
            String takenDate) {
        this.id = id;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.address = address;
        this.comforts = comforts;
        this.price = price;
        this.takenDate = takenDate;

    }

    public Room() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComforts() {
        return comforts;
    }

    public void setComforts(String comforts) {
        this.comforts = comforts;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(String takenDate) {
        this.takenDate = takenDate;
    }


}
