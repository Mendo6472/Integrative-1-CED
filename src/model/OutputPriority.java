package model;

public class OutputPriority implements Comparable<OutputPriority> {
    int seatsPerRow;
    int arrivalNumber;
    String seat;

    public OutputPriority(int arrivalNumber, String seat, int seatsPerRow) {
        this.arrivalNumber = arrivalNumber;
        this.seat = seat;
        this.seatsPerRow = seatsPerRow;
    }

    public int getArrivalNumber() {
        return arrivalNumber;
    }

    public void setArrivalNumber(int arrivalNumber) {
        this.arrivalNumber = arrivalNumber;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public int compareTo(OutputPriority o) {
         int row1 = this.seat.charAt(0) - 'A' + 1;
         int row2 = o.seat.charAt(0) - 'A' + 1;
         int seatNum1 = Integer.parseInt(this.seat.substring(1));
         int seatNum2 = Integer.parseInt(o.seat.substring(1));
 
         int result = row2 - row1;
         if (result == 0) {
             if(seatNum1 < seatsPerRow/2) seatNum1--;
             if(seatNum2 < seatsPerRow/2) seatNum2--;
             int middleRow = seatsPerRow/2;
             int thisCercanyToMid = Math.abs(seatNum1-middleRow);
             int otherCercanyToMid = Math.abs(seatNum2-middleRow);
             result = otherCercanyToMid - thisCercanyToMid;
             if(result == 0){
                result = this.arrivalNumber - o.arrivalNumber;
             }
        }
 
         return result;
    }
}
