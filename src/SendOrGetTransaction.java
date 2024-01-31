public class SendOrGetTransaction implements TransactionBehavior {
    @Override
    public void balanceInfoAfterTransaction(Account account) {
        System.out.println("Your new balance is: " + account.getBalance() + account.getType());
    }

    @Override
    public void sendMoney(Account senderAccount, Account receiverAccount, double money) {
        if (senderAccount.getType().equals(receiverAccount.getType())) {
            receiverAccount.setBalance(receiverAccount.getBalance() + money);
            senderAccount.setBalance(senderAccount.getBalance() - money);
            balanceInfoAfterTransaction(senderAccount);
        } else {
            System.out.println("You cannot send money between different account types.");
        }
    }

    @Override
    public void getMoney(Account senderAccount, Account receiverAccount, double money) {
        if (senderAccount.getType().equals(receiverAccount.getType())) {
            senderAccount.setBalance(senderAccount.getBalance() - money);
            receiverAccount.setBalance(money);
            balanceInfoAfterTransaction(senderAccount);
        } else {
            System.out.println("You cannot send money between different account types.");
        }
    }

    public void sendExchangedMoney(Account senderAccount, Account receiverAccount, double money, double rate) {
        receiverAccount.setBalance(receiverAccount.getBalance() + (money * rate));
        senderAccount.setBalance(senderAccount.getBalance() - money);
    }
}
