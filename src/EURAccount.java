public class EURAccount extends Account{
    public EURAccount(){
        this.setTransactionBehavior(new SendOrGetTransaction());
        this.setDepositBehavior(new NoDeposit());
        this.setExchangeBehavior(new ExchangeEurTl(new ExchangeRateData()));
        this.setType("EUR");
    }
}
