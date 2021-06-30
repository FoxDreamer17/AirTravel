package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Вылет до текущего момента

public class DepartureToTime implements Filter {
    @Override //переопределение метода базового класса
    public List<Flight> filter(List<Flight> flightList) {
        LocalDateTime timeNow = LocalDateTime.now();
        System.out.println("Вылет до текущего момента. Исключить из тестового набора перелёты. ");
        List<Flight> list = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (timeNow.isBefore(segment.getDepartureDate())) {
                    list.add(flight);
                    break;
                }
            }
        }
        return list;
    }
}
