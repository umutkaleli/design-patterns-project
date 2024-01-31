import java.util.Objects;

public class ExchangeEurTl implements ExchangeBehavior {
    private double eurToTl;
    private ExchangeRateData exchangeRateData;

    public ExchangeEurTl(ExchangeRateData exchangeRateData) {
        this.exchangeRateData = exchangeRateData;
        exchangeRateData.registerObserver(this);
    }

    @Override
    public void exchangeMoney(Account exchangeAccount, Account transferredAccount, double money) {
        if (exchangeAccount.getBalance() - money > 0) {
            if (Objects.equals(exchangeAccount.getOwner().getId(), transferredAccount.getOwner().getId())) {
                if (exchangeAccount.getType().equals("EUR")) {
                    exchangeAccount.performTransactionExchangeMoney(exchangeAccount, transferredAccount, money, eurToTl);
                    exchangeMoneyInfo(exchangeAccount,transferredAccount,money);
                } else if (exchangeAccount.getType().equals("TL")) {
                    exchangeAccount.performTransactionExchangeMoney(exchangeAccount, transferredAccount, money, (1 / eurToTl));
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
        this.eurToTl = eurToTl;
        System.out.println("1 EUR equals : " + eurToTl + " Tl");
        System.out.println("1 Tl equals : " + 1 / eurToTl + " EUR");
    }
}
