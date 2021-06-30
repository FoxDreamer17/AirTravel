package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Если дата прилета раньше даты вылета

public class FlightDepartsBeforeArrives implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Полеты без сегмента, дата прилета раньше даты вылета: ");
        List<Flight> list = new ArrayList<>();
        flightList.forEach(flight -> flight.getSegments()
                .stream()
                .filter(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())).limit(1)
                .forEach(segment -> list.add(flight)));
        return list;
    }
  }
