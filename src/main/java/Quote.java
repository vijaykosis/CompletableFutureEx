/* Message from Shop to DiscountService */
public class Quote {

    private final String shopName;
    private final double price;
    private final DiscountService.DiscountCode discountCode;
    private final ExchangeService.Currency currency;

    public Quote(String shopName, double price, DiscountService.DiscountCode code,
                 ExchangeService.Currency currency) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = code;
        this.currency = currency;
    }

    public static Quote parse(String str) {
        String[] split = str.split(":");
        return new Quote(split[0], Double.parseDouble(split[1]),
                DiscountService.DiscountCode.valueOf(split[2]), ExchangeService.Currency.valueOf(split[3]));
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public DiscountService.DiscountCode getDiscountCode() {
        return discountCode;
    }

    public ExchangeService.Currency getCurrency() {
        return currency;
    }

}
