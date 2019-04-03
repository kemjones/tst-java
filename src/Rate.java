import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Rate {

	private String rateCode;
	private String rateGroup;
	public Rate(String rateCode, String rateGroup) {
		this.rateCode = rateCode;
		this.rateGroup = rateGroup;
	}
	public String getCode() {
		return rateCode;
	}
	public String getGroup() {
		return rateGroup;
	}
	public String toString() {
		return String.format("Rate(%s, %s)", rateCode, rateGroup);
	}
	public static List<Rate> load(String filename) {
		List<Rate> result = new LinkedList<>();
		//System.out.printf("loading Rates from %s\n", filename);
		try (FileReader input = new FileReader(filename)) {
			try (BufferedReader buf = new BufferedReader(input)) {
				String line;
				while (null != (line = buf.readLine())) {
					String[] tokens = line.split("[(),]");
					//Arrays.stream(tokens).forEach(System.out::println);
					if (3 != tokens.length) {
						break;
					}
					if ("Rate".equals(tokens[0].trim())) {
						result.add(new Rate(tokens[1].trim(), tokens[2].trim()));
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.printf("%d loaded.\n", result.size());
		return result;
	}
}
