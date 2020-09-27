import com.sun.tools.javac.util.List;
import humans.Guest;
import rooms.BedRoom;
import rooms.RoomType;

import java.util.ArrayList;
import java.util.Collections;

public class Randomiser {

    private ArrayList<String> names;
    private ArrayList<String> surnames;

    String name01;
    String name02;
    String name03;
    String name04;
    String name05;
    String name06;
    String name07;
    String name08;
    String name09;
    String name10;
    String name11;
    String name12;
    String name13;
    String name14;
    String surname01;
    String surname02;
    String surname03;
    String surname04;
    String surname05;
    String surname06;
    String surname07;
    String surname08;
    String surname09;
    String surname10;
    String surname11;
    String surname12;


    private double walletMax;

    public Randomiser() {
        name01 = "Ally";
        name02 = "Jennifer";
        name03 = "Katie";
        name04 = "Steven";
        name05 = "Jarrod";
        name06 = "Anna";
        name07 = "Ben";
        name08 = "Callum";
        name09 = "Duncan";
        name10 = "Jonny";
        name11 = "Lucy";
        name12 = "Marek";
        name13 = "Tim";
        name14 = "Vishal";

        names = new ArrayList<String>(List.of(name01, name02, name03, name04, name05, name06, name07, name08, name09, name10, name11, name12, name13, name14));

        surname01 = "Smith";
        surname02 = "Wazowski";
        surname03 = "Wick";
        surname04 = "Rambo";
        surname05 = "Matrix";
        surname06 = "Gruber";
        surname07 = "Wallace";
        surname08 = "Tribiani";
        surname09 = "Geller";
        surname10 = "Bing";
        surname11 = "Green";
        surname12 = "Buffey";


        surnames = new ArrayList<String>(List.of(surname01, surname02, surname03, surname04, surname05, surname06, surname07, surname08, surname09, surname10, surname11, surname12));

        walletMax = 1000.00;

    }

    public BedRoom singleRoom(int newRoomNumber){
        BedRoom bedroom = new BedRoom(0, RoomType.SINGLE);
        bedroom.setRoomNumber(newRoomNumber);
        return bedroom;
    }

    public BedRoom doubleRoom(int newRoomNumber){
        BedRoom bedroom = new BedRoom(0, RoomType.DOUBLE);
        bedroom.setRoomNumber(newRoomNumber);
        return bedroom;
    }
    public BedRoom tripleRoom(int newRoomNumber){
        BedRoom bedroom = new BedRoom(0, RoomType.TRIPLE);
        bedroom.setRoomNumber(newRoomNumber);
        return bedroom;
    }
    public BedRoom familyRoom(int newRoomNumber){
        BedRoom bedroom = new BedRoom(0, RoomType.FAMILY);
        bedroom.setRoomNumber(newRoomNumber);
        return bedroom;
    }


    public String getRandomName() {
        Collections.shuffle(names);
        Collections.shuffle(surnames);
        return names.get(0) + " " + surnames.get(0);
    }

    public Double getRandomWallet() {
        return Math.random() * walletMax;
    }

    public ArrayList<Guest> makeParty(int numberInParty) {
        ArrayList<Guest> team = new ArrayList<Guest>();
        for (int i = 0; i < numberInParty; i++) {
            Guest person = new Guest();
            person.setName(getRandomName());
            person.setWallet(getRandomWallet());
            team.add(person);
        }
        return team;
    }

    public Guest createGuest() {
        Guest newPerson = new Guest();
        newPerson.setName(getRandomName());
        newPerson.setWallet(getRandomWallet());
        return newPerson;
    }

    public Guest createGuest(String newName) {
        Guest newPerson = new Guest();
        newPerson.setName(newName);
        newPerson.setWallet(getRandomWallet());
        return newPerson;
    }

    public Guest createGuest(double newWallet) {
        Guest newPerson = new Guest();
        newPerson.setName(getRandomName());
        newPerson.setWallet(newWallet);
        return newPerson;
    }

    public Guest createGuest(String newName, double newWallet) {
        Guest newPerson = new Guest();
        newPerson.setName(newName);
        newPerson.setWallet(newWallet);
        return newPerson;
    }


    public Guest getDemoP1() {
        return createGuest(name01 + " " + surname01, 500);
    }

    public Guest getDemoP2() {
        return createGuest(name02 + " " + surname02, 600);
    }

    public Guest getDemoP3() {
        return createGuest(name03 + " " + surname03, 700);
    }

    public Guest getDemoP4() {
        return createGuest(name04 + " " + surname04, 800);

    }

    public Guest getDemoP5() {
        return createGuest(name05 + " " + surname05, 900);
    }

    public ArrayList<Guest> groupDemo01 = new ArrayList<Guest>(List.of(getDemoP1()));
    public ArrayList<Guest> groupDemo02 = new ArrayList<Guest>(List.of(getDemoP1(),getDemoP2()));
    public ArrayList<Guest> groupDemo03 = new ArrayList<Guest>(List.of(getDemoP1(),getDemoP2(),getDemoP3()));
    public ArrayList<Guest> groupDemo04 = new ArrayList<Guest>(List.of(getDemoP1(),getDemoP2(),getDemoP3(),getDemoP5()));
    public ArrayList<Guest> groupDemo05 = new ArrayList<Guest>(List.of(getDemoP1(),getDemoP2(),getDemoP3(),getDemoP4(),getDemoP5()));

    public Guest getDemoFun() {
        Guest newPerson = new Guest();
        newPerson.setName(name10 + " " + surname04);
        newPerson.setWallet(500.0);
        return newPerson;
    }



    public Hotel createHotelDemo(){
        Hotel hotel = new Hotel();
        hotel.addFamilyRoom(1);
        hotel.addTripleRoom(2);
        hotel.addTripleRoom(3);
        hotel.addDoubleRoom(4);
        hotel.addDoubleRoom(5);
        hotel.addDoubleRoom(6);
        hotel.addSingleRoom(7);
        hotel.addSingleRoom(8);
        hotel.addSingleRoom(9);
        hotel.addSingleRoom(10);
        hotel.addSingleRoom(11);
        hotel.addSingleRoom(12);
        hotel.addConferenceRoom("The Mountain");
        return hotel;
    }

}
