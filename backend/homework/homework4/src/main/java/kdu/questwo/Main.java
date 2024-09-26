package kdu.questwo;

import kdu.ConsoleLogger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TicketReservation ticketReservation = new TicketReservation();
        for(int i=1;i<16;i++){
            boolean isSuccessfull = ticketReservation.bookFlight("first name"+i,"lastName" + i, i+20, "male","economy", "C"+i);
            ConsoleLogger.infoMethod((isSuccessfull?"Successful":"Unsuccessful") + " registraion of ticket C"+i);
        }

        boolean c9Cancel = ticketReservation.cancel("C9");

        if(c9Cancel)ConsoleLogger.infoMethod("Successfully cancelled ticket of C9");
        else ConsoleLogger.infoMethod("Unsuccessfull cancellation of ticket of C9");

        boolean c12Cancel = ticketReservation.cancel("C12");

        if(c12Cancel)ConsoleLogger.infoMethod("Successfully cancelled ticket of C12");
        else ConsoleLogger.infoMethod("Unsuccessfull cancellation of ticket of C12");

        boolean c15Cancel = ticketReservation.cancel("C15");

        if(c15Cancel)ConsoleLogger.infoMethod("Successfully cancelled ticket C15");
        else ConsoleLogger.infoMethod("Unsuccessfull cancellation of ticket of C15");


    }
}