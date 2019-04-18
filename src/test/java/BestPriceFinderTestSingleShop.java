import org.junit.Test;
import org.junit.Ignore;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BestPriceFinderTestSingleShop {

    private BestPriceFinder mFinder = new BestPriceFinder();
    private String mProduct = "BestProduct";  // "NA"
    private String mShop = "BestShop";

    @Test
    public void runFindPrice() {
        System.out.println("> Calling findPrice");
        long startTime = System.currentTimeMillis();
        ShopPrice price = mFinder.findPrice(mShop, mProduct);
        System.out.println("< findPrice returns after " + (System.currentTimeMillis() - startTime) + " milliseconds");
        System.out.println("I have been blocked until now :(");
        System.out.println(price.toString());
    }

    @Test
    public void runFindPriceAsync() {
        System.out.println("> Calling findPriceAsync");
        long startTime = System.currentTimeMillis();
        Future<ShopPrice> futurePrice = mFinder.findPriceAsync(mShop, mProduct);
        System.out.println("< findPriceAsync returns a Future after " + (System.currentTimeMillis() - startTime) + " milliseconds");

        System.out.println("I can now dow anything I want :)");

        ShopPrice price;
        try {
            price = futurePrice.get(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("The Future is ready after " + (System.currentTimeMillis() - startTime) + " milliseconds");
        System.out.println(price.toString());
    }

}
