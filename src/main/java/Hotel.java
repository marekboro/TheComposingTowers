import rooms.BedRoom;
import rooms.ConferenceRoom;

import java.util.ArrayList;


public class Hotel {

    private final Randomiser randomiser;
    private double bankAccount;
    private ArrayList<BedRoom> bedRooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Integer> roomNumbers;


    public Hotel() {
        bankAccount = 3000.0;
        randomiser = new Randomiser();
        conferenceRooms = new ArrayList<ConferenceRoom>();
        roomNumbers = new ArrayList<Integer>();
        bedRooms = new ArrayList<BedRoom>();
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






}
