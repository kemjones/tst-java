import java.util.List;

public class Problem1 {

	public static void main(String[] args) {
		List<Rate> rates = Rate.load(args[0]);
		List<CabinPrice> prices = CabinPrice.load(args[1]);
		List<BestGroupPrice> groupPrices = BestGroupPrice.getBestGroupPrices(rates, prices);
		groupPrices.stream().forEach(System.out::println); 
	}

}
