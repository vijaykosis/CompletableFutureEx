
public class ShopPrice {

    private String mShop;
    private double mPrice;
    private ExchangeService.Currency mCurrency;

    public ShopPrice(String shop, double price, ExchangeService.Currency currency) {
        mShop = shop;
        mPrice = price;
        mCurrency = currency;
    }

    public String getShop() {
        return mShop;
    }

    public double getPrice() {
        return mPrice;
    }

    public ExchangeService.Currency getCurrency() {
        return mCurrency;
    }

    public void convertCurrency(double rate, ExchangeService.Currency toCurrency) {
        mPrice = mPrice * rate;
        mCurrency = toCurrency;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f %s", mShop, mPrice, mCurrency.name());
    }

}
