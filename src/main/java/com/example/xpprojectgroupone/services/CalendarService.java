package com.example.xpprojectgroupone.services;

import com.example.xpprojectgroupone.calendarPackage.CalendarReservation;
import com.example.xpprojectgroupone.models.Reservation;
import com.example.xpprojectgroupone.repositories.ReservationRepo;

import java.util.ArrayList;
import java.util.Date;

public class CalendarService {

    ReservationRepo reservationRepo;
    CalendarReservation calendarReservation;


    public CalendarService(){

        reservationRepo = new ReservationRepo();
        calendarReservation = new CalendarReservation();
        //inputReservation();
    }



   /* public void inputReservation(){
        ArrayList<Reservation> reserv = reservationRepo.fetchAll();
        for (Reservation res:
             reserv) {
           // calendarReservation.inputReservation(res);

        }
    }*/


    public ReservationRepo getReservationRepo() {
        return reservationRepo;
    }

    public CalendarReservation getCalendarReservation() {
        return calendarReservation;
    }



}