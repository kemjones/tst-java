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
	public static List<Rate> load(String filename) {
		List<Rate> result = new LinkedList<>();
		System.out.printf("loading Rates from %s\n", filename);
		return result;
	}
}
