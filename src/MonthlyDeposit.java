public class MonthlyDeposit implements DepositBehavior{
    private final int depositDay = 30;

    private int interestRate = 32;

    @Override
    public void getDepositTime() {
        System.out.println("Deposit time is " + depositDay +" day.");
    }

    @Override
    public void getInterestRate() {
        System.out.println("Interest rate is: %" + interestRate);
    }

    @Override
    public void setBalanceAfterDepositDay(Account account) {
        account.setBalance(account.getBalance() + (account.getBalance()*((double) interestRate /100)/365*32));
        System.out.println("New balance after 1 month deposit: " + account.getBalance() + "TL");
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public int getDepositDay() {
        return depositDay;
    }
}
