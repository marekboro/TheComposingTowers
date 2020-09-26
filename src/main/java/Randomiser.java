import humans.Guest;

import java.util.ArrayList;
import java.util.Collections;

public class Randomiser {

    private ArrayList<String> names;
    private ArrayList<String> surnames;


    private double walletMax;

    public Randomiser(){

        names = new ArrayList<String>();
        names.add("Ally");
        names.add("Jennifer");
        names.add("Katie");
        names.add("Steven");
        names.add("Jarrod");
        names.add("Anna");
        names.add("Ben");
        names.add("Callum");
        names.add("Duncan");
        names.add("Jonny");
        names.add("Lucy");
        names.add("Marek");
        names.add("Tim");
        names.add("Vishal");

        surnames = new ArrayList<String>();
        surnames.add("Smith");
        surnames.add("Wazowski");
        surnames.add("Wick");
        surnames.add("Rambo");
        surnames.add("Matrix");
        surnames.add("Gruber");
        surnames.add("Wallace");
        surnames.add("Tribiani");
        surnames.add("Geller");
        surnames.add("Bing");
        surnames.add("Green");
        surnames.add("Buffey");

        walletMax = 1000.00;

}
    public String getRandomName(){
        Collections.shuffle(names);
        Collections.shuffle(surnames);
        return names.get(0) + " " + surnames.get(0);
    }

    public Double getRandomWallet(){
        return Math.random()*walletMax;
    }

    public ArrayList<Guest> makeParty(int numberInParty){
        ArrayList<Guest> team = new ArrayList<Guest>();
        for (int i = 0; i <numberInParty; i++){
            Guest person = new Guest();
            person.setName(getRandomName());
            person.setWallet(getRandomWallet());
            team.add(person);
        }
        return team;
    }

    public Guest getDemoPerson1(){
        Guest newPerson = new Guest();
        newPerson.setName(getRandomName());
        newPerson.setWallet(getRandomWallet());
        return newPerson;
    }
    public Guest getDemoPerson2(){
        Guest newPerson = new Guest();
        newPerson.setName("AAA");
        newPerson.setWallet(500.0);
        return newPerson;
    }
    public Guest getDemoPerson3(){
        Guest newPerson = new Guest();
        newPerson.setName("BBB");
        newPerson.setWallet(600.0);
        return newPerson;
    }



}
