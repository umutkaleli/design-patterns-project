import java.util.Objects;

public class ExchangeUsdEur implements ExchangeBehavior{
    double usdToEur;
    ExchangeRateData exchangeRateData;

    public ExchangeUsdEur(ExchangeRateData exchangeRateData) {
        this.exchangeRateData = exchangeRateData;
        exchangeRateData.registerObserver(this);
    }

    @Override
    public void exchangeMoney(Account exchangeAccount, Account transferredAccount, double money) {
        if (exchangeAccount.getBalance() - money > 0) {
            if (Objects.equals(exchangeAccount.getOwner().getId(), transferredAccount.getOwner().getId())) {
                if (exchangeAccount.getType().equals("USD")) {
                    exchangeAccount.performTransactionExchangeMoney(exchangeAccount, transferredAccount, money, usdToEur);
                    exchangeMoneyInfo(exchangeAccount,transferredAccount,money);
                } else if (exchangeAccount.getType().equals("EUR")) {
                    exchangeAccount.performTransactionExchangeMoney(exchangeAccount, transferredAccount, money, (1 / usdToEur));
                    exchangeMoneyInfo(exchangeAccount,transferredAccount,money);
                }
            }
            else{
                System.out.println("You cannot exchange money to someone else.");
            }
        }
        else{
            System.out.println("Balance is not enough for doing this exchange.");
        }
    }

    public void exchangeMoneyInfo(Account exchangeAccount, Account transferredAccount, double money){
        System.out.println("Exchange Account new balance is: " + exchangeAccount.getBalance() + exchangeAccount.getType());
        System.out.println("Transferred Account new balance is: " + transferredAccount.getBalance() + transferredAccount.getType());
    }

    @Override
    public void update(double usdToTl, double eurToTl, double usdToEur) {
        this.usdToEur = usdToEur;
        System.out.println("1 USD equals : " + usdToEur  +" EUR");
        System.out.println("1 EUR equals : " + (1/usdToEur) + " USD");
    }
}
