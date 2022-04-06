package Ticket;

import java.util.ArrayList;

public class EventOrganiser {
  private ArrayList<Event> eventList = new ArrayList<>();
  public void eventReceiver(Event events) {
    eventList.add(events);
  }
  public ArrayList<Event> printEvents() {
    return eventList;
  }
  public Event checkListForEvent(String ticketDescription) {
    for (int i = 0; i < eventList.size(); i++) {
      Event check = eventList.get(i);
      if (ticketDescription.equalsIgnoreCase(eventList.get(i).getDescription())) {
        return check;
      }
    }
    return null;
  }
}