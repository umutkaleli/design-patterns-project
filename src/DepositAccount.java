public class DepositAccount extends Account{
    public DepositAccount(){
        this.setTransactionBehavior(new NoTransaction());
        this.setDepositBehavior(new DailyDeposit());
        this.setExchangeBehavior(new NoExchange());
        this.setType("DEPOSIT");
    }
}
