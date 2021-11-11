package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final String cinemaName;
    private List<Seat> seats = new ArrayList<>();

    public Cinema(String cinemaName, int numRows, int seatsPerRow) {
        this.cinemaName = cinemaName;

        int lastRow = 'A'+(numRows-1);
        for(char row='A';row<=lastRow;row++){
            for (int seatNum = 1; seatNum<=seatsPerRow;seatNum++){
                Seat seat = new Seat(row+String.format("%2d",seatNum));
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber) {
        int low = 0;

        int high = seats.size() - 1;
            while (low <= high) {
                System.out.println(",");
                int mid = (low + high) / 2;
                Seat midVal = seats.get(mid);
                int cmp = midVal.getSeatNumber().compareTo(seatNumber);

                if (cmp < 0) {
                    low = mid + 1;
                } else if (cmp > 0) {
                    high = mid -1;
                } else {
                    return seats.get(mid).reserve();
                }
            }
            System.out.println("There is not seat " + seatNumber);
            return false;
    }

    public void getSeats () {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }
    private class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reversed = false;

        public Seat(String seatNumber){
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve(){
            if(this.reversed = true){
                System.out.println("Seat "+seatNumber+" reserved");
                return true;
            }else {
                return false;
            }
        }

        public boolean cancel(){
            if(this.reversed){
                this.reversed = false;
                System.out.println("Reservation of seat "+seatNumber+" cancelled");
                return true;
            }else {
                return false;
            }
        }
        public String getSeatNumber(){
            return seatNumber;
        }
    }



}
















