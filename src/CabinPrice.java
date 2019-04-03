import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

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
	public static List<CabinPrice> load(String filename) {
		List<CabinPrice> result = new LinkedList<>();
		System.out.printf("loading CabinPrices from %s\n", filename);
		return result;
	}
}
