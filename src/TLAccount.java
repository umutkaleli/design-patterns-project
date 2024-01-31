public class TLAccount extends Account{

    public TLAccount(){
        this.setTransactionBehavior(new SendOrGetTransaction());
        this.setDepositBehavior(new NoDeposit());
        this.setExchangeBehavior(new ExchangeEurTl(new ExchangeRateData()));
        this.setType("TL");
    }
}
