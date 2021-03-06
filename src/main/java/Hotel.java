import humans.Guest;
import rooms.BedRoom;
import rooms.ConferenceRoom;
import rooms.DiningRoom;
import rooms.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


public class Hotel {

    private final Randomiser randomiser;
    private double bankAccount;
    private ArrayList<BedRoom> bedRooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Integer> roomNumbers;
    private ArrayList<Booking> bookings;
    private Hashtable<Guest,Integer> allGuests;
    private HashMap<String, DiningRoom> diningRooms;



    public Hotel() {
        bankAccount = 3000.0;
        randomiser = new Randomiser();
        conferenceRooms = new ArrayList<ConferenceRoom>();
        roomNumbers = new ArrayList<Integer>();
        bedRooms = new ArrayList<BedRoom>();
        bookings = new ArrayList<Booking>();
        allGuests = new Hashtable<Guest, Integer>();
        diningRooms = new HashMap<String, DiningRoom>();
    }


    public boolean diningRoomDoesNotExist(String name){
        return !diningRooms.containsKey(name);
    }

    public ArrayList<BedRoom> getVacantBedrooms(){
        ArrayList<BedRoom> vacant = new ArrayList<BedRoom>();
        for (BedRoom bedRoom : bedRooms) {
            if(bedRoom.getGuests().size()==0){
                vacant.add(bedRoom);
            }
        }
        return vacant;
    }

    public void addDiningRoom(DiningRoom diningRoom){
        if (diningRoomDoesNotExist(diningRoom.getName())) {
        diningRooms.put(diningRoom.getName(),diningRoom);}
    }

    public void addDiningRoom(String name){
        DiningRoom diningRoom = new DiningRoom(name);
        if (diningRoomDoesNotExist(name)){
            diningRooms.put(name,diningRoom);}
    }

    public HashMap<String, DiningRoom> getDiningRooms() {
        return diningRooms;
    }

    public Hashtable<Guest, Integer> getAllGuests() {
        return allGuests;
    }

    public Booking bookRoom(BedRoom bedRoom, int nights){
        Booking booking = new Booking(bedRoom,nights);
        bankAccount += booking.getCost();  // THIS MAY NEED TO MOVE TO CHECKIN
        bookings.add(booking);
        return booking;

    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public double getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
        this.bankAccount = bankAccount;
    }

    public ArrayList<BedRoom> getBedRooms() {
        return bedRooms;
    }

    public void setBedRooms(ArrayList<BedRoom> bedRooms) {
        this.bedRooms = bedRooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public void setConferenceRooms(ArrayList<ConferenceRoom> conferenceRooms) {
        this.conferenceRooms = conferenceRooms;
    }

    public ArrayList<Integer> getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(ArrayList<Integer> roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public boolean canAddRoom(int roomNumber){
        return !roomNumbers.contains(roomNumber);
    }
    public void addSingleRoom(int roomNumber){
        if(canAddRoom(roomNumber)) {
            BedRoom singleBedroom = randomiser.singleRoom(roomNumber);
            bedRooms.add(singleBedroom);
            roomNumbers.add(roomNumber);
        }
    }
    public void addDoubleRoom(int roomNumber){
        if(canAddRoom(roomNumber)) {
            BedRoom doubleRoom = randomiser.doubleRoom(roomNumber);
            bedRooms.add(doubleRoom);
            roomNumbers.add(roomNumber);
        }
    }

    public void addTripleRoom(int roomNumber){
        if(canAddRoom(roomNumber)) {
            BedRoom tripleRoom = randomiser.tripleRoom(roomNumber);
            bedRooms.add(tripleRoom);
            roomNumbers.add(roomNumber);
        }
    }
    public void addFamilyRoom(int roomNumber){
        if(canAddRoom(roomNumber)) {
            BedRoom familyRoom = randomiser.familyRoom(roomNumber);
            bedRooms.add(familyRoom);
            roomNumbers.add(roomNumber);
        }
    }

    public void addConferenceRoom(String name){
        ConferenceRoom room = new ConferenceRoom(name);
        conferenceRooms.add(room);
    }


    public BedRoom getBedroomByNumber(int number){
        int index = 0;
        for (int i = 0;i< bedRooms.size(); i++){
            if (bedRooms.get(i).getRoomNumber()==number)
            {break;}
            index+=1;
        }
        return bedRooms.get(index);

    }

    public boolean canCheckInOne(BedRoom bedRoom){
        return bedRoom.getGuests().size()<bedRoom.getCapacity();
    }
    public boolean canCheckInGroup(BedRoom bedRoom, ArrayList<Guest> group){
        return (bedRoom.getCapacity() - bedRoom.getGuests().size())>= group.size();
    }



    public void checkIn(int roomNumber, Guest guest){
        BedRoom room = this.getBedroomByNumber(roomNumber);

        if(canCheckInOne(room)){
            allGuests.put(guest,roomNumber);
            room.addGuest(guest);
        }
    }

    public void checkIn(int roomNumber, ArrayList<Guest> group){
        BedRoom room = this.getBedroomByNumber(roomNumber);

        if(canCheckInGroup(room,group)){
            for(Guest guest: group){
            room.addGuest(guest);
            allGuests.put(guest,roomNumber);

            }

        }
//        System.out.println(allGuests.keySet());
    }

    public boolean isAHotelGuest(Guest guest) {
        return allGuests.containsKey(guest);

    }

    public boolean areAllHotelGuests(ArrayList<Guest> guests){
        Boolean notMissing = true;
        for(Guest guest: guests) {
            if(allGuests.containsKey(guest)){

            }
            else {
                notMissing = false;
            }
        }
        return notMissing;

    }
    public void checkOut(Guest guest){
        if( isAHotelGuest(guest)) {
            BedRoom room = getBedroomByNumber(allGuests.get(guest));
            room.removeAGuest(guest);
            allGuests.remove(guest);

        }
    }

    public void checkOut(ArrayList<Guest> guests){
        if( areAllHotelGuests(guests)) {
            for (Guest guest: guests) {
                BedRoom room = getBedroomByNumber(allGuests.get(guest));
                room.removeAGuest(guest);
                allGuests.remove(guest);
            }

        }
    }



}
