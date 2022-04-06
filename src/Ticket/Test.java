package Ticket;

public class Test {
  EventOrganiser eventWebsite = new EventOrganiser();

  public void goTest() {
    Event rockConcert = new Event("RockConcert", 500, 450.5);
    Event doomsDay = new Event("Lecture in the end of the world", 250, 150);

    System.out.println(rockConcert.getDescription());
    System.out.println(rockConcert.getTicketPrice());
    System.out.println(rockConcert.getNumberOfTickets());
    eventWebsite.eventReceiver(rockConcert);
    eventWebsite.eventReceiver(doomsDay);
    System.out.println(eventWebsite.printEvents());

    buyTicket();

  }

  public Event checkExistenceOfEvent(String eventInput) {
    Event tmp;
    tmp = eventWebsite.checkListForEvent(eventInput);
    if (tmp == null) {
      System.out.println("This event does not exist.");
      return null;
    } else {
      return tmp;
    }
  }

  public int checkEnoughTickets(int numOfTickets, Event eventInput) {

    if (eventInput.getNumberOfTickets() < 1) {
         return 0;
       } else {
         if(numOfTickets > eventInput.getNumberOfTickets()) {
         return 1;
          } else {
           return 2;
         }
  }
  }

  public void buyTicket() {
    Event doesEventExist;
    int checkEnoughTicketsOutcome;
    System.out.println("What event do you want to buy?");
    // Enter some input

    doesEventExist = checkExistenceOfEvent(arbitraryNameOfEvent());
    if(doesEventExist != null) {
      System.out.println("How many tickets do you want to buy to " + arbitraryNameOfEvent());
      // Enter some input
      checkEnoughTicketsOutcome = checkEnoughTickets(arbitraryNumberOfTickets(), doesEventExist);
      switch(checkEnoughTicketsOutcome) {
        case 0 -> {
          System.out.println("This event is sold out.");
        }
        case 1 -> {
          System.out.println("The event is not sold out however," +
              "there is not enough tickets left to confirm your order.");
        }
        case 2 -> {
          System.out.println("There is enough tickets left.");
          System.out.println("The total price is: " + arbitraryNumberOfTickets() * doesEventExist.getTicketPrice());
          System.out.println("Do you still want to confirm your order?");
          //Enter some input
          if(arbitraryConfirmationOfOrder().equalsIgnoreCase("Yes")) {
            doesEventExist.removeBoughtTicket(arbitraryNumberOfTickets());
            System.out.println("Thank you for you purchase");
            System.out.println(doesEventExist.getNumberOfTickets());
          } else {
            System.out.println("Your order has been cancelled have a nice day.");
          }
        }
      }
    }
  }

  public String arbitraryConfirmationOfOrder() {
    return "Yes";
  }

  public String arbitraryNameOfEvent() {
    String Name = "Lecture in the end of the world";
    return Name;
  }

  public int arbitraryNumberOfTickets() {
    return 100;
  }

  public static void main(String[] args) {
    new Test().goTest();
  }
}