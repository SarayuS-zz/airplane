package airplane;
/* 
Busy Airport

There are a lot of airplanes requesting to land but unfortunately, the number of available runways for landing is a few. As a result, a policy has been set to manage the landing aircrafts:
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

	public static void main(String[] args) {
		
		// Values to use on the function to design the airplane landing. 
		int numRunway = 1;
		runwayDesign run_design = new runwayDesign();
		
		// Sort the values so that the time is in ascending order
		// Hence comparison of the first two values of the array will always
		// provide the required result.
		mergeSort sorting = new mergeSort();
		
		// Input values 
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
		
		// Sorting the values before the order of landing is decided.
		sorting.sortingValues(flightNumber,minutes,time);
		
		// Calling the static function
		run_design.design(numRunway, flightNumber, minutes, time);
	}
}