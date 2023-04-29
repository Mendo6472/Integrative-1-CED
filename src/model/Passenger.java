package model;
public class Passenger {
    int arrivalNumber;
    String highClass;
    String seat;
    String fullName;
    String vulnerable;
    float miles;

    public Passenger(String seat, String fullName,String highClass,  String vulnerable, float miles, int arrivalNumber) {
        this.highClass = highClass;
        this.seat = seat;
        this.fullName = fullName;
        this.vulnerable = vulnerable;
        this.miles = miles;
    }

    public int getArrivalNumber() {
        return arrivalNumber;
    }

    public void setArrivalNumber(int arrivalNumber) {
        this.arrivalNumber = arrivalNumber;
    }

    public String getHighClass() {
        return highClass;
    }

    public void setHighClass(String highClass) {
        this.highClass = highClass;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getVulnerable() {
        return vulnerable;
    }

    public void setVulnerable(String vulnerable) {
        this.vulnerable = vulnerable;
    }

    public float getMiles() {
        return miles;
    }

    public void setMiles(float miles) {
        this.miles = miles;
    }
}
