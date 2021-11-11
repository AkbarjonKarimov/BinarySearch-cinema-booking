package com.company;

public class Main {

    public static void main(String[] args) {


        Cinema cinema = new Cinema("Panarama",10,20);
        cinema.getSeats();
        if(cinema.reserveSeat("A13")){
            System.out.println("Please pay");
        }else {
            System.out.println("Sorry, seat is taken");
        }

    }

}
