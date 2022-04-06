package Ticket;

public class Event {
  private String description;
  private int numberOfTickets;
  private double ticketPrice;

  Event(String description, int numberOfTickets, double ticketPrice) {
    this.description = description;
    this.numberOfTickets = numberOfTickets;
    this.ticketPrice = ticketPrice;
  }

  public String getDescription() {
    return description;
  }

  public double getTicketPrice() {
    return ticketPrice;
  }

  public int getNumberOfTickets() {
    return numberOfTickets;
  }

  public int removeBoughtTicket(int arbitraryNumberOfTickets) {
    numberOfTickets = numberOfTickets - arbitraryNumberOfTickets;
    return numberOfTickets;
  }

  @Override
  public String toString() {
    return "Event{" +
        "description='" + description + '\'' +
        ", numberOfTickets=" + numberOfTickets +
        ", ticketPrice=" + ticketPrice +
        '}';
  }
}
