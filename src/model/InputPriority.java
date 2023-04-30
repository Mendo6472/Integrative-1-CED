package model;

public class InputPriority implements Comparable<InputPriority> {

    String highClass;
    String vulnerable;
    float miles;
    String seat;
    int arrivalNumber;

    //
    public int compareTo(InputPriority p2){

        boolean p1HighClass = this.getHighClass().equals("yes");
        boolean p2HighClass = p2.getHighClass().equals("yes");

        if (p1HighClass && !p2HighClass) return 1;
        if (!p1HighClass && p2HighClass) return -1;

        if(p1HighClass && p2HighClass){
            int vulnerableCmp = this.getVulnerable().compareTo(p2.getVulnerable());
            if (vulnerableCmp != 0) {
                return vulnerableCmp;
            }
            int milesCmp = Float.compare(miles, p2.getMiles());
            if (milesCmp != 0) {
                return milesCmp;
            }
            int rowCmp = this.getSeat().substring(0, 1).compareTo(p2.seat.substring(0, 1));
            if (rowCmp != 0) {
                return rowCmp;
            }
            return Integer.compare(p2.getArrivalNumber(), this.getArrivalNumber());
        }
        else {
            int rowCmp = this.getSeat().substring(0, 1).compareTo(p2.getSeat().substring(0, 1));
            if (rowCmp != 0) {
                return rowCmp;
            }
            return Integer.compare(p2.getArrivalNumber(), this.getArrivalNumber());
        }
    }

    public InputPriority(String highClass, String vulnerable, Float miles, String seat, int arrivalNumber) {
        this.highClass = highClass;
        this.vulnerable = vulnerable;
        this.miles = miles;
        this.seat = seat;
        this.arrivalNumber = arrivalNumber;
    }

    public String getHighClass() {
        return highClass;
    }

    public void setHighClass(String highClass) {
        this.highClass = highClass;
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

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getArrivalNumber() {
        return arrivalNumber;
    }

    public void setArrivalNumber(int arrivalNumber) {
        this.arrivalNumber = arrivalNumber;
    }
}
