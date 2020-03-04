import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Driver {

	public static void reader(String fileName)throws Exception {
		try(FileReader fr = new FileReader(fileName)) {
			int charRead = 0;
			BufferedReader bf = new BufferedReader(fr);
			while((charRead = bf.readLine().length()) != -1) {
				
			}
		}
		FileWriter f = new FileWriter("");
		File fs = new File("");
		FileReader fr = new FileReader(fs);
		
	}
	public static void main(String[] args) {
		String[] array = {"one", "two", "three"};
		List<String> asList = Arrays.asList(array);
		
		Object[] t = asList.toArray();
		
		Integer [] i = new Integer[3];
		int [] a = {1,2,3};
		List<Integer> as = new ArrayList<Integer>();
		as.add(1);
		as.add(2);
		i = as.toArray(i);
		
		Object[] ob = {1,"t"};
		
		List test = new ArrayList<>();
		test.add("tse");
		test.add(new Integer(1));
		
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTimeInMillis());
		Date d = new Date();
		System.out.println(d.getTime());
		
		
	}

}
