## **CRC Card**

Class: Aircraft

Responsibilities:

* Aircraft flight number  
* Pilot of plane  
* Destination information  
* Stores passenger count  
* Flight metadata (position, speed, altitude, heading)  
* Update flight information when new data is received

Collaborators (if any):

* AircraftDatabase  
* Transponder

Assumptions (if any):  
Each aircraft has a unique flight identifier transmitted by its transponder.

## **CRC Card**

Class: Transponder

Responsibilities:

* Transmits aircraft type  
* Transmits flight data

Collaborators (if any):

* Aircraft  
* ATC Ground Station

Assumptions (if any):  
Aircraft automatically transmit packets periodically while in the air.

## **CRC Card**

Class: Transponder

Responsibilities:

* Transmits aircraft type  
* Transmits flight data

Collaborators (if any):

* Aircraft  
* ATC Ground Station

Assumptions (if any):  
Aircraft automatically transmit packets periodically while in the air.

## **CRC Card**

Class: ATC Ground Station

Responsibilities:

* Receive high-density packets from aircraft transponders  
* Unpack aircraft data from packets  
* Send unpacked aircraft data to the aircraft database

Collaborators (if any):

* Transponder  
* Aircraft Database

Assumptions (if any):  
The ground station can receive packets from multiple aircraft at once.

## **CRC Card**

Class: Computer Graphic Display

Responsibilities:

* Display aircraft positions for the controller  
* Update aircraft display every 10 seconds  
* Show alerts for dangerous aircraft situations

Collaborators (if any):

* Aircraft Database  
* Analysis System

Assumptions (if any):  
The display refresh interval is fixed at 10 seconds.

## **CRC Card**

Class: Air Traffic Controller

Responsibilities:

* Query aircraft information from the system  
* Communicate instructions to aircraft pilots  
* View aircraft data on the display  
* Send unpacked aircraft data to the aircraft database

Collaborators (if any):

* Computer Graphic Display  
* Aircraft Database

Assumptions (if any):  
The controller interacts with aircraft information through the display interface.

## **CRC Card**

Class: Aircraft Database

Responsibilities:

* Store unpacked aircraft data  
* Update aircraft records when new data arrives  
* Provide aircraft information for display updates  
* Provide aircraft information for controller queries

Collaborators (if any):

* ATC Ground Station  
* Computer Graphic Display  
* Air Traffic Controller  
* Analysis System

Assumptions (if any):  
The database stores aircraft currently within the monitored airspace.

## **CRC Card**

Class: Aircraft Database

Responsibilities:

* Store unpacked aircraft data  
* Update aircraft records when new data arrives  
* Provide aircraft information for display updates  
* Provide aircraft information for controller queries

Collaborators (if any):

* ATC Ground Station  
* Computer Graphic Display  
* Air Traffic Controller  
* Analysis System

Assumptions (if any):  
The database stores aircraft currently within the monitored airspace.

## **CRC Card**

Class: Analysis System

Responsibilities:

* Analyze aircraft data stored in the database  
* Detect potentially dangerous aircraft situations  
* Send alerts to the computer graphic display

Collaborators (if any):

* Aircraft Database  
* Computer Graphic Display

Assumptions (if any):  
