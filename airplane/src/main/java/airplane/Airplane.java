package airplane;
/* 
Busy Airport

Today is a busy day at Vancouver Airport. There are a lot of airplanes requesting to land but unfortunately, the number of available runways for landing is a few. As a result, a policy has been set to manage the landing aircrafts:
- Landing requests are processed in the order they are received.
- A landing request is accepted if there is a free runway available and the landing process starts immediately.
- The time needed for the landing process is different for each aircraft.
- A landing request is postponed if there is no free runaway available. The requesting aircraft is asked to request for landing again after 10 minutes.
- If two airplanes request to land at the same time, the request from the one with smaller flight number will be processed first.

Your task is:
Write a program that, given the number of runways, the list of the initial request time and the duration of landing for each aircraft, simulates the above process and generates a detailed report of all aircraft landing requests and their responses.

Sample Input
1    // # of runways
377 4 45  // flight #, mins it takes to land, time of initial landing request
367 3 45
357 4 48

Sample Output
367 45 ACCEPTED
377 45 POSTPONED
367 48 LANDED
357 48 ACCEPTED
357 52 LANDED
377 55 ACCEPTED
377 59 LANDED
 */

import java.util.ArrayList;
import java.util.List;

public class Airplane {
	
	public static void runwayDesign(int numRunway, List<String> flightNumber, 
			List<Integer> minutes, List<Integer> time) {
		
		int start_time = time.get(0);
		
		// Check the number of flights to the number of run ways available
		if(flightNumber.size() > numRunway) {
			
			// Loop for the number of flights
			for(int i = 0; i < flightNumber.size() - 1; i++) {
				
				// check if any two flights request landing at the same time.
				if(time.get(i) == time.get(i+1)) {
					
					// If the landing time is the same for both the flights
					// No flights are considered as having the same number
					if(minutes.get(i) == minutes.get(i+1)) {
												
						// Land the flight with the minimum flight number
						if(Integer.parseInt(flightNumber.get(i)) < Integer.parseInt(flightNumber.get(i+1))) {
							System.out.println(flightNumber.get(i) + " " + time.get(i) + " " + "ACCEPTED");
							System.out.println(flightNumber.get(i+1) + " " + time.get(i+1) + " " + "POSTPONED");
							
							int new_time = time.get(i+1) + 10;
							time.set(i+1, new_time);
							
							// Change the start time 
							start_time = time.get(i) + minutes.get(i);
							
							System.out.println(flightNumber.get(i) + " " + start_time + " " + "LANDED");
							
							// Remove the flight details after landing
							flightNumber.remove(i);
							time.remove(i);
							minutes.remove(i);
							
							// Always start from the first element in the ArrayList for execution
							i = -1;
							
						} else {
							System.out.println(flightNumber.get(i+1) + " " + time.get(i+1) + " " + "ACCEPTED");
							System.out.println(flightNumber.get(i) + " " + time.get(i) + " " + "POSTPONED");
							
							int new_time = time.get(i) + 10;
							time.set(i, new_time);
							
							// Change the start time 
							start_time = time.get(i+1) + minutes.get(i+1);
							
							System.out.println(flightNumber.get(i+1) + " " + start_time + " " + "LANDED");
							
							// Remove the flight details after landing
							flightNumber.remove(i+1);
							time.remove(i+1);
							minutes.remove(i+1);
							
							// Always start from the first element in the ArrayList for execution
							i = -1;
						}
						
						// Checking the less than condition for minutes
					} else if(minutes.get(i) < minutes.get(i+1)){ 
						System.out.println(flightNumber.get(i) + " " + time.get(i) + " " + "ACCEPTED");
						System.out.println(flightNumber.get(i+1) + " " + time.get(i+1) + " " + "POSTPONED");
						
						int new_time = time.get(i+1) + 10;
						time.set(i+1, new_time);
						
						start_time = start_time + minutes.get(i);
						
						System.out.println(flightNumber.get(i) + " " + start_time + " " + "LANDED");
						
						// Remove the flight details after landing
						flightNumber.remove(i);
						time.remove(i);
						minutes.remove(i);
						
						// Always start from the first element in the ArrayList for execution
						i = -1;
						
					} else {
						System.out.println(flightNumber.get(i+1) + " " + time.get(i+1) + " " + "ACCEPTED");
						System.out.println(flightNumber.get(i) + " " + time.get(i) + " " + "POSTPONED");
						
						int new_time = time.get(i) + 10;
						time.set(i, new_time);
						
						start_time = start_time + minutes.get(i+1);
						
						System.out.println(flightNumber.get(i+1) + " " + start_time + " " + "LANDED");
						
						// Remove the flight details after landing
						flightNumber.remove(i+1);
						time.remove(i+1);
						minutes.remove(i+1);
						
						// Always start from the first element in the ArrayList for execution
						i = -1;
					}
					// Different time for landing requested
				} else if(time.get(i) < time.get(i+1)) {
					System.out.println(flightNumber.get(i) + " " + time.get(i) + " " + "ACCEPTED");
					
					start_time = start_time + minutes.get(i);
					
					System.out.println(flightNumber.get(i) + " " + start_time + " " + "LANDED");
					
					// Remove the flight details after landing
					flightNumber.remove(i);
					time.remove(i);
					minutes.remove(i);
					
					// Always start from the first element in the ArrayList for execution
					i = -1;
					
				} else if(time.get(i) > time.get(i+1)) {
					System.out.println(flightNumber.get(i+1) + " " + time.get(i+1) + " " + "ACCEPTED");
					
					start_time = start_time + minutes.get(i+1);
					
					System.out.println(flightNumber.get(i+1) + " " + start_time + " " + "LANDED");
					
					// Remove the flight details after landing
					flightNumber.remove(i+1);
					time.remove(i+1);
					minutes.remove(i+1);
					
					// Always start from the first element in the ArrayList for execution
					i = -1;
				}
			}
			if(flightNumber.size() == 1) {
				start_time = time.get(0);
				
				System.out.println(flightNumber.get(0) + " " + time.get(0) + " " + "ACCEPTED");
				
				start_time = start_time + minutes.get(0);
				
				System.out.println(flightNumber.get(0) + " " + start_time + " " + "LANDED");
				
				// Remove the flight details after landing
				flightNumber.remove(0);
				time.remove(0);
				minutes.remove(0);
			}
		}
	}

	public static void main(String[] args) {
		
		// Values to use on the function above. 
		int numRunway = 1;
		
		List<String> flightNumber = new ArrayList<String>();
		flightNumber.add("377");
		flightNumber.add("367");
		flightNumber.add("357");
		
		List<Integer> minutes = new ArrayList<Integer>();
		minutes.add(4);
		minutes.add(3);
		minutes.add(4);
		
		List<Integer> time = new ArrayList<Integer>();
		time.add(45);
		time.add(45);
		time.add(48);
		
		// Calling the static function
		runwayDesign(numRunway, flightNumber, minutes, time);
	}
}