public class NoDeposit implements DepositBehavior{
    @Override
    public void getDepositTime() {
        System.out.println("You cannot deposit from this account.");
    }

    @Override
    public void getInterestRate() {
        System.out.println("There is no interest rate of this account.");
    }

    @Override
    public void setBalanceAfterDepositDay(Account account) {
        System.out.println("Balance is still same since this is not a deposit account." );
    }
}
