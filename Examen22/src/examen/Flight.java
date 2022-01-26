
package examen;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mayte
 */
public class Flight {
    private Airport departure,arrival;
    private LocalTime time;
    
    public Flight(Airport departure, Airport arrival, LocalTime time) {
        this.arrival = arrival;
        this.time = time;
        this.departure = departure;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
   
    
    
}
