public class NoExchange implements ExchangeBehavior{
    @Override
    public void update(double usdToTl,double eurToTl,double usdToEur) {
        System.out.println("No exchange rate info is available.");
    }

    @Override
    public void exchangeMoney(Account exchangeAccount,Account transferredAccount,double money) {
        System.out.println("Exchange is not available");
    }
}