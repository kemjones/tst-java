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
	public String toString() {
		return String.format("BestGroupPrice(%s, %s, %s, %s)", cabinCode, rateCode, price, rateGroup);
	}

	public static List<BestGroupPrice> getBestGroupPrices(List<Rate> rates, List<CabinPrice> prices) {
		List<BestGroupPrice> result = new LinkedList<>();

		//System.out.printf("\nRates:\n");
		//rates.stream().forEach(System.out::println);
		//System.out.printf("\nCabinPrices:\n");
		//prices.stream().forEach(System.out::println);

		// Combine rates and prices
		prices.stream().forEach(p -> {
			//System.out.printf("p=%s\n", p);
			rates.stream().filter(r -> r.getCode().equals(p.getRateCode()))
				.forEach(r -> {
					//System.out.printf("r=%s\n", r);
					result.add(new BestGroupPrice(p.getCabinCode(), p.getRateCode(), p.getPrice(), r.getGroup()));
				});
		});
		//System.out.printf("%d values\n", result.size());

		// sort them by cabinCode, rateGroup, and price
		// return distinct cabin code and rate group items
		Comparator<BestGroupPrice> cmp = Comparator
				.comparing(BestGroupPrice::getCabinCode)
				.thenComparing(BestGroupPrice::getRateGroup)
				.thenComparing(BestGroupPrice::getPrice)
				;
		return result.stream()
				.sorted(cmp)
				.filter(distinctByKeys(BestGroupPrice::getCabinCode, BestGroupPrice::getRateGroup))
				.collect(Collectors.toList())
				;
	}
	@SafeVarargs
	private static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors)
	{
		final Map<List<?>, Boolean> seen = new HashMap<>();
		return t ->
		{
			final List<?> keys = Arrays.stream(keyExtractors)
					.map(ke -> ke.apply(t))
					.collect(Collectors.toList())
					;
			return seen.putIfAbsent(keys, Boolean.TRUE) == null;
		};
	}
}
