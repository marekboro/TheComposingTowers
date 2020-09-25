package rooms;

import humans.Guest;

import java.util.ArrayList;

public abstract class Room {
    private int capacity;
    private ArrayList<Guest> guests;

    public Room() {
        this.capacity = 0;
        this.guests = new ArrayList<Guest>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        removeAllGuests();

    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void removeAllGuests() {
        guests = new ArrayList<Guest>();
    }

    public Guest removeAGuest(Guest guest) {
        Guest removed = new Guest();
        if(guests.contains(guest)){
            removed = guest;
            guests.remove(guest);
        }

        return removed;
    }

    private Boolean canAddOne(){
        return guests.size()<capacity;
    }

    private Boolean canAddSet(ArrayList<Guest> moreGuests){
        return moreGuests.size()<=capacity-guests.size();
    }

    public void addGuest(Guest guest){
        if (canAddOne()){
            guests.add(guest);
        }
    }

    public void addGroup(ArrayList<Guest> moreGuests){
        if(canAddSet(moreGuests)){

            for (int i =0; i <moreGuests.size(); i++){
                guests.add(moreGuests.get(i));
            }
        }
    }

    public void setGuests(ArrayList<Guest> guests) {
        if(canAddSet(guests)){
        this.guests = guests;}
    }
}
