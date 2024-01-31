public class DailyDeposit implements DepositBehavior{

    private final int depositDay = 1;

    private int interestRate = 25;

    @Override
    public void getDepositTime() {
        System.out.println("Deposit time is " + depositDay +" day.");
    }
    @Override
    public void setBalanceAfterDepositDay(Account account) {
        account.setBalance(account.getBalance() + (account.getBalance()*((double) interestRate /100)/365));
        System.out.println("New balance after 1 day deposit: " + account.getBalance() + "TL");
    }
    @Override
    public void getInterestRate() {
        System.out.println("Interest rate is: %" + interestRate);
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public int getDepositDay() {
        return depositDay;
    }

}
