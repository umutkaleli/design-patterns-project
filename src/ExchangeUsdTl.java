import java.util.Objects;

public class ExchangeUsdTl implements ExchangeBehavior{
    double usdToTl;
    ExchangeRateData exchangeRateData;

    public ExchangeUsdTl(ExchangeRateData exchangeRateData) {
        this.exchangeRateData = exchangeRateData;
        exchangeRateData.registerObserver(this);
    }

    @Override
    public void exchangeMoney(Account exchangeAccount, Account transferredAccount, double money) {
        if (exchangeAccount.getBalance() - money > 0) {
            if (Objects.equals(exchangeAccount.getOwner().getId(), transferredAccount.getOwner().getId())) {
                if (exchangeAccount.getType().equals("USD")) {
                    exchangeAccount.performTransactionExchangeMoney(exchangeAccount, transferredAccount, money, usdToTl);
                    exchangeMoneyInfo(exchangeAccount,transferredAccount,money);
                } else if (exchangeAccount.getType().equals("TL")) {
                    exchangeAccount.performTransactionExchangeMoney(exchangeAccount, transferredAccount, money, (1 / usdToTl));
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
        this.usdToTl = usdToTl;
        System.out.println("1 USD equals : " + usdToTl  +" Tl");
        System.out.println("1 Tl equals : " + 1/usdToTl + " USD");
    }
}
