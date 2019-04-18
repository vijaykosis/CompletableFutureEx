import org.junit.Test;
import org.junit.Ignore;

import java.util.List;
import java.util.stream.Stream;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;

public class BestPriceFinderTestAllShops {

    private BestPriceFinder mFinder = new BestPriceFinder();
    private String mProduct = "BestProduct";  // "NA"

    @Test
    public void runFindAllPricesAsync() {
        long startTime = System.currentTimeMillis();
        Stream<CompletableFuture<ShopPrice>> fut = mFinder.findAllPricesAsync(mProduct);
        System.out.println("< findAllPricesAsync returns after > " + (System.currentTimeMillis() - startTime) + " milliseconds");

        CompletableFuture[] futArr = fut.map(f -> f.thenAccept(price ->
                System.out.println(String.format("%s (%d milliseconds)", price, (System.currentTimeMillis() - startTime)))
        ))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futArr).join();
        System.out.println("All shops returned results after " + (System.currentTimeMillis() - startTime) + " milliseconds");
    }

}
