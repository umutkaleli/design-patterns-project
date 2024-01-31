public interface TransactionBehavior {
    void balanceInfoAfterTransaction(Account account);

    void sendMoney(Account senderAccount, Account receiverAccount, double money);

    void getMoney(Account senderAccount, Account receiverAccount, double money);

    void sendExchangedMoney(Account senderAccount,Account receiverAccount,double money, double rate);

}
