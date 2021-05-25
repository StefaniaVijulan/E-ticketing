
# E-ticketing

## First part
Creates 8 types of objects and 10 methods that can be used within the system.  You must have:

* simple classes with private/ protected attributes;
* access methods;
* 2 different collections, one of which must be sorted;
* using inheritance to create abstract classes
* one service class to expose the system's operations
* a main class that uses service methods

## ***My project***


## Client: base class
- **Attributes:**
  - *String first_name* : sea, mountain, city
  - *String last_name*: location name
  - *String phone_number*
  - *String email*
  - *String password*
- **Methods:**
  - *Constructors*
  - *Get and set*
  - *isValidEmailAddress*
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class
  
### **1.Buyer** 
- **Attributes:**
  - *age*
- **Methods:**
  - *Constructors*
  - *Get and set*
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class
 
 ### **2.Organizer** 
- **Attributes:**
  - *Integer seniority_in_the_field*
  - *List<Event> events*

- **Methods:**
  - *Constructors*
  - *Get and set*
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class

## Login 
- **Attributes:**
  - *Set <Client> clientSet*
  - *static Login single_instance = null*
  - *Client curent* - we retain the current user
- **Methods:**
  - *Constructors*
  - *Get and set*
  - *signIn*: to check the possibility of connection, check in ClientSet if the email and the password entered exist
  - *signUp*: is used to register a new user

## Location: base class, abstract class
- **Attributes:**
  - *zone* : sea, mountain, city
  - *name*: location name
  - *country*
  - *town*
  - *street*
  - *number*
- **Methods:**
  - *Constructors*
  - *Get and set*
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class

### **1.Hotel** 
- **Attributes:**
  - *Integer number_of_starts:* : the number of stars the hotel has
  - *Boolean pets:*: true if the hotel accepts animals, false otherwise
  - *Boolean conference_room:*true if the hotel has conference room, false otherwise
  - *Float price_of_room;*
  - *Integer number_of_rooms;*
- **Methods:**
  - *Constructors*
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class
  - *price_location()*

### **2. Guest House** 
- **Attributes:**
  - *Integer number_of_starts:* : the number of stars the guest house has
  - *Boolean pets:*: true if the guest house accepts animals, false otherwise
  - *Boolean conference_room:* true if the guest house has conference room, false otherwise
  - *Float rooms_price;*
  - *Integer number_of_rooms*
  - *Boolean pool*: true if the guest house has pool, false otherwise
- **Methods:**
  - *Constructors*
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class
  - *price_location()*

### **3. Multipurpose Hall** 
- **Attributes:**
  - *Integer number_of_seats:* : the number of seats the multipurpose hall has
  - *Float price_per_seats*: the price of the seats;
  - *Boolean audio_equipment* true if the multipurpose hall has audio equiment, false otherwise
  - *Float price_of_the_audio_equipment*
  - *Boolean video_equipment* true if the multipurpose hall has video equiment, false otherwise
  - *Float price_of_the_audio_equipment*
- **Methods:**
  - *Constructors*
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class
  - *price_location()*
  
 ### **4. Restaurant** 
- **Attributes:**
  - *Integer number_of_seats:* : the number of seats therestaurant has
  - *Float price_per_seats*: the price of the seats;
  - *Integer table_seats*: the number of talbe seats the multipurpose hall has
  - *Boolean scene* true if the restaurant has scene, false otherwise
  - *Float scene_price*
  - *Boolean equipment* true if the multipurpose hall has equiment, false otherwise
  - *Float price_of_equipment*
- **Methods:**
  - *Constructors*
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class
  - *price_location()*

## Event : base class, abstract class
- **Attributes:**
  - *Location location:* information about the place where the event will take place  
  - *String name_event:* the name of the event after which buyers can search for it
  - *Integer number_of_tickets:* the number of tickets corresponding to this event
  - *LocalDate date_start:* the day, month and year when this event will begin
  - *LocalDate date_end:* the day, month and year when this event will end
  - *Hour hour_start:* the hour and minute when this event will begin
  - *Hour hour_end*: the hour and minute when this event will end
  - *Integer number_of_pause*: the number of breaks this event will have
- **Methods:**
  - *Constructors*
  - *Get and set*
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class
  - *ticket_value()*: the price of a ticket
  - *compareTo()*: is used to sort the list of events by their names

### **1. Concert** 
- **Attributes:**
  - *String name_of_singer:* the name of the singer who will perform the concert
  - *Float singer_price:* the price the singer asks to support the concert
- **Methods:**
  - *Constructors*
  - *convertToLocalDateViaInstant*: converts a Date date to LocalDate
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class
 - *ticket_value()*: the price of a ticket

 

### **2. School Camp** 
- **Attributes:**
  - *Integer number_of_breakfast:* the number of breakfasta they want during the accommodation period
  - *Integer number_of_dinner* the number of dinners they want during the accommodation period
  - *Integer number_of_lunch* the number of lunches they want during the accommodation period
- **Methods:**
  - *Constructors*
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class
 - *ticket_value()*: the price of a ticket


 ### **3. StreerFood** 
- **Attributes:**
  - *price_rented_space* 
- **Methods:**
  - *Constructors*
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class
 - *ticket_value()*: the price of a ticket

 ### **3. Theatrical Piece** 
- **Attributes:**
  - *theme*: the theme of the play to be played, eg comedy, dramaturgy
  - *name_of_team*: the name of the team that will play
  - *price_of_team*: the price of the team that will play
- **Methods:**
  - *Constructors*
  - *Read_Info()*: abstract method, it is used to read information specific to the attributes of this class
  - *ToString()*: abstract method, it is used to display information specific to the attributes of this class
  - *ticket_value()*: the price of a ticket

## Service
- **Attributes:**
  - *Service single_instance = null*
  - *List<Event> events* : we store the entered event
  - *List<Location> locations*: we store the entered location
  - *Login login*
  - *Client curent*
 
- **Methods:**
  - *Constructors*
  - *Get and set*
  - *AddBuyer()*: creating a new buyer
  - *AddOrganizer()*: creating a new organizer
  - *AddEvents()*: creating a new event and adding it to the specific list
  - *DeleteEvents()*: deleting an event
  - *PrintEvent()*: viewing events
  - *SeeEvent()*: viewing an event
  - *AddLocation()*: creating a new location and adding it to the specific list
  - *DeleteLocation()*: deleting a location
  - *isValidEmailAddress()*
  - *SeeTicketPrice()*: the ticket price of a certain event
  - *LogIn()* is used to log in or register a user or admin
  - *LogOff()* is used to log off a user or admin
 
 ## Main 
 It is used to call service class methods
