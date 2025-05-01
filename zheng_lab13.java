import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;


public class zheng_lab13 {
	private static ArrayList<Integer> arrValues;
	
	public static void main(String[] args) {
		
	}
	
	public static void readData(String filename) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		try {
			BufferedReader file = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = file.readLine()) != null) {
				values.add(Integer.parseInt(line));
			}
			
		} catch (Exception e) {
			
		}
		
		arrValues = values;
	}
	
	public long getTotalCount() {
		long count = arrValues.stream().count();
		return count;
	}	
	public long getOddCount() {
		long count = arrValues.stream().filter(v -> v%2==1).count();
		return count;
	}	
	public long getEvenCount() {
		long count = arrValues.stream().filter(v -> v%2==0).count();
		return count;
	}	
	public long getDistinctGreaterThanFiveCount() {
		long count = arrValues.stream().filter(x->x>5).distinct().count();
		return count;
	}	
	
	public Integer[] getResult1() {
		Integer[] values = arrValues.stream().filter(v -> v > 5 && v < 50 && v%2==0).sorted().toArray(Integer[]::new);
		return values;
	}

	public Integer[] getResult2() {
		System.out.println(arrValues.get(0));
		Integer[] values = arrValues.stream().map(v -> (v*v)*3).limit(50).toArray(Integer[]::new);
		return values;
	}
	
	public Integer[] getResult3() {
		Integer[] values = arrValues.stream().filter(v -> v%2==1).map(v -> v*2).sorted().skip(20).distinct().toArray(Integer[]::new);
		return values;
	}
	
}