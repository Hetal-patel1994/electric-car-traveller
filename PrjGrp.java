package csuf.graph;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrjGrp {

	public static void main(String arg[]) {

		PrjInput userinput = new PrjInput();

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter maximum number of miles:");
		userinput.setCapacity(Integer.parseInt(scan.nextLine()));

		System.out.println("Enter Number of cities:");
		userinput.setNocities(Integer.parseInt(scan.nextLine()));

		Map<Character, Integer> lhmap = new LinkedHashMap<Character, Integer>();

		for (int i = 65; i < (userinput.getNocities() + 65) - 1; i++) {
			if (i == 65) {
				lhmap.put((char) (i), 0);
			}
			System.out.println("Enter distance from city " + (char) i + " to " + (char) (i + 1) + ":");
			userinput.setDistance(Integer.parseInt(scan.nextLine()));
			lhmap.put((char) (i + 1), userinput.getDistance());

		}
		
		List<Character> result = userinput.shortestPath(lhmap, userinput.getCapacity());
		System.out.println("Output List: " + result);

	}

}
