public class NoTransaction implements  TransactionBehavior{
    @Override
    public void balanceInfoAfterTransaction(Account account) {
        System.out.println("Balance is same: " + account.getBalance());
    }

    @Override
    public void sendMoney(Account senderAccount, Account receiverAccount, double money) {
        System.out.println("You cannot send money from " + senderAccount.getType() +" account.");
        balanceInfoAfterTransaction(senderAccount);
    }

    @Override
    public void getMoney(Account senderAccount, Account receiverAccount, double money) {
        System.out.println("You cannot request any money from " + senderAccount.getType() +" account.");
        balanceInfoAfterTransaction(senderAccount);
    }

    public void sendExchangedMoney(Account senderAccount,Account receiverAccount,double money, double rate){
        System.out.println("You cannot send money from " + senderAccount.getType() + "  account.");
        balanceInfoAfterTransaction(senderAccount);
    }
}
