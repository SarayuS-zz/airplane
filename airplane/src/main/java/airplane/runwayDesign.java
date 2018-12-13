package airplane;

import java.util.List;

public class runwayDesign {

	public runwayDesign() {
		System.out.println("Default constructor");
	}
	public void design(int numRunway, List<String> flightNumber, 
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
}
