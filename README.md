BusLo (Android Application)

Introduction :-

It is a Bus Tracking System Which Tracks Driver Location Through the driver mobile gps.
Driver has to login the system then Driver location is get updated to the Database with Driver Email-ID , longitude and latitude.
Then Passenger can View Driver location In Google Map View After Login if Passenger is not Registered They must Register first.

Installation :-

After Installing the Buslo Application Give The Location and SMS permission manually.



After Downloading the Project.
put the BusTrackingSystem folder shown below :-
Put php files under the BusTrackingSystem on xampp folder -> htdocs -> Put The BusTrackingSystem folder Here.

In Android Studio :-

Use The XAMPP localhost Server to run the application locally.
In Android Studio For Some Activity We provide's the link so Replace the IP address to Your LocalIP .


create the database like below :-

Name the Database to bustrackingsystem

create tabbles like 
1.admin
2.driver_info
3.user_reviews
4.user_table
5.working_driver_info

now create rows for the table

1.admin
id	admin_Name admin_Password

2.driver_info
id	driver_Name	driver_email	password	driver_mob_num	driver_Address

3.user_reviews
id	feed_Backs	complaints

4.user_table
id	user_Name email-id	password	mobile	gender

5.working_driver_info
id	driver_email-id	latitude	longitude	rout





