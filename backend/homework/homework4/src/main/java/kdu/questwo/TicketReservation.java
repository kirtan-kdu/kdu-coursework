package kdu.questwo;

import java.util.*;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        Passenger passenger = new Passenger(firstName, lastName,age,gender,travelClass,confirmationNumber);

        if(confirmedList.size()<CONFIRMEDLIST_LIMIT){
            confirmedList.add(passenger);
            return true;
        }
        else if(waitingList.size() < WAITINGLIST_LIMIT){
            waitingList.add(passenger);
            return true;
        }
        return false;
    }

    public boolean cancel(String confirmationNumber) {
        Iterator<Passenger> confirmationIterator = confirmedList.iterator();

        boolean isInConfirmedList = removePassenger(confirmationIterator, confirmationNumber);

        if(isInConfirmedList){
            confirmedList.add(waitingList.poll());
            return true;
        }

        Iterator<Passenger> waitingIterator = waitingList.iterator();

        // Automatically resolve whether the passenger is removed or not
        return removePassenger(waitingIterator, confirmationNumber);
    }

    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while (iterator.hasNext()) {
            Passenger obj = iterator.next();
            if (Objects.equals(obj.getConfirmationNumber(), confirmationNumber)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}

