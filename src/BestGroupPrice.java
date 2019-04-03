import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BestGroupPrice {

	private String cabinCode;
	private String rateCode;
	private BigDecimal price;
	private String rateGroup;

	public BestGroupPrice(String cabinCode, String rateCode, BigDecimal price, String rateGroup) {
		this.cabinCode = cabinCode;
		this.rateCode = rateCode;
		this.price = price;
		this.rateGroup = rateGroup;
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
	public String getRateGroup() {
		return rateGroup;
	}

	public static List<BestGroupPrice> getBestGroupPrices(List<Rate> rates, List<CabinPrice> prices) {
		List<BestGroupPrice> result = new LinkedList<>();
		return result;
	}
}
