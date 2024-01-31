public class USDAccount extends Account{
    public USDAccount(){
        this.setTransactionBehavior(new SendOrGetTransaction());
        this.setDepositBehavior(new NoDeposit());
        this.setExchangeBehavior(new ExchangeUsdTl(new ExchangeRateData()));
        this.setType("USD");
    }
}
