import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CabinPrice {

	private String cabinCode;
	private String rateCode;
	private BigDecimal price;
	public CabinPrice(String cabinCode, String rateCode, BigDecimal price) {
		this.cabinCode = cabinCode;
		this.rateCode = rateCode;
		this.price = price;
	}
	public String getCabinCode() {
		return cabinCode;
	}
	public String getRateCode() {
		return rateCode;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public String toString() {
		return String.format("CabinPrice(%s, %s, %s)", cabinCode, rateCode, price);
	}
	public static List<CabinPrice> load(String filename) {
		List<CabinPrice> result = new LinkedList<>();
		//System.out.printf("loading CabinPrices from %s\n", filename);
		try (Stream<String> lines = Files.lines(Paths.get(filename))) {
			result = lines.map(s -> s.split("[(),]"))
				.filter(a -> 4 == a.length)
				.filter(a -> "CabinPrice".equals(a[0].trim()))
				.map(a -> new CabinPrice(a[1].trim(), a[2].trim(), new BigDecimal(a[3].trim())))
				.collect(Collectors.toList())
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.printf("%d loaded.\n", result.size());
		return result;
	}
}
