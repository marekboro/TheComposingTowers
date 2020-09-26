#The Composing Towers
A hotel booking App:
- written in Java.
- Interface: Scanner.
#### Purpose - Practice using:
- TDD
- enums
- abstract classes and inheritance
- encapsulation
- HashMaps
- logic and problem solving
- method overloading
- packages

#### Requirements:
- Java compiler & Java

## Classes tested:
- [x] Guest.java via GuestTest.java, test count: 4
- [x] BedRoom.java via BedRoomTest.java, test count: 7
- [x] ConferenceRoom.java via ConferenceRoomTest.java, test count: 7
- [ ] four
- [ ] Randomised.java +

### MVP
- [x] Create a Guest class to represent a visitor to the hotel, they'll at least need a name, you can add more properties later if and when they become necessary
- [x] Create a RoomType enum of bedroom types (e.g. Single/Double) and capacity
- [x] Create a Room abstract class with a capacity and collection of Guests
- [x] Create 2 different types of rooms that inherit from Room:
- [x] Bedrooms will additionally have a room number and RoomType
- [x] ConferenceRooms will additionally have a name and any other properties you wish.
- [ ] Create a Hotel class, which has a collection of Bedrooms and a collection of ConferenceRooms.
- [ ] The Hotel will be able check guests in/out of rooms.

### Extensions
- [ ] Create a Booking class which contains a Bedroom with a number of nights booked.
- [ ] Create a bookRoom method in your Hotel. This should book a given Bedroom for a number of nights. This should return a new Booking object.
- [x] Add a nightly rate to your Bedrooms and write a method to return the total bill for the Booking.
- [ ] Add a DiningRoom class with a name, capacity, and collection of guests
- [ ] Hotel will have a HashMap based collection of DiningRooms.

### Advanced Extensions
- [ ] Add functionality to the Hotel, so it can return a collection of only the vacant Bedrooms.
- [ ] Update the check-in process so that Hotel will only be able to check guests into empty Bedrooms.

### Personal Extensions  (hopefully have time for these)
- [ ] Humorous feedback/commentary
- [ ] Edit bookings
- [ ] Hotel has a bank guests have wallets
- [ ] Basil make mistakes
- [ ] Hotel employee profiles. 

## Planning practice:
- [x] Class diagram
- [ ] Acceptance Criteria
- [ ] 

## Images:
##### Class diagram: 
![image](hotelPlanning.png) 
##### Acceptance Criteria: 


