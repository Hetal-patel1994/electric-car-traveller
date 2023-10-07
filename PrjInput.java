package csuf.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrjInput {

	private int capacity;
	private int nocities;
	private int distance;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNocities() {
		return nocities;
	}

	public void setNocities(int nocities) {
		this.nocities = nocities;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "PrjInput [capacity=" + capacity + ", nocities=" + nocities + ", distance=" + distance + "]";
	}

	public List<Character> shortestPath(Map<Character, Integer> maparr, int capacityc) {

		List<Character> path = new ArrayList<Character>();
		List<Character> valueArr2 = new ArrayList<Character>();
		int sum = 0;
		int count = 1;
		int previousdistance = 0;

		for (Map.Entry<Character, Integer> dist : maparr.entrySet()) {
			valueArr2.add(dist.getKey());

			// take first charging station as output//
			if (count == 1) {
				path.add(dist.getKey());
			}

			// take total distance between cities where car traveled//
			sum = sum + dist.getValue();

			// take total distance between cities where car traveled plus previous city
			// distance,if in case currant station is broken//
			previousdistance = sum + dist.getValue();

			// if distance increase at given capacity car has to stop at the previous
			// charging station//
			if (previousdistance >= capacityc) {
				sum = 0;
				sum = sum + dist.getValue();
				previousdistance = sum + dist.getValue();

				path.add(valueArr2.get(valueArr2.size() - 2));
			}

			// take last charging station as output//
			if (count == maparr.size()) {
				path.add(dist.getKey());
			}
			count++;
		}

		return path;
	}
}
