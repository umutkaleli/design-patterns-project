import java.util.ArrayList;
import java.util.Date;

public class Account {
    private TransactionBehavior transactionBehavior;

    private ExchangeBehavior exchangeBehavior;

    private DepositBehavior depositBehavior;

    private User owner;
    private double balance;
    private String iban;
    private Date createdTime;

    private String type;

    public void setTransactionBehavior(TransactionBehavior transactionBehavior) {
        this.transactionBehavior = transactionBehavior;
    }

    public void setExchangeBehavior(ExchangeBehavior exchangeBehavior) {
        this.exchangeBehavior = exchangeBehavior;
    }

    public void setDepositBehavior(DepositBehavior depositBehavior) {
        this.depositBehavior = depositBehavior;
    }

    public TransactionBehavior getTransactionBehavior() {
        return transactionBehavior;
    }

    public ExchangeBehavior getExchangeBehavior() {
        return exchangeBehavior;
    }

    public DepositBehavior getDepositBehavior() {
        return depositBehavior;
    }

    public void performTransactionSendMoney(Account senderAccount, Account receiverAccount, double money){
        transactionBehavior.sendMoney(senderAccount,receiverAccount,money);
    }

    public void performTransactionGetMoney(Account senderAccount, Account receiverAccount, double money){
        transactionBehavior.getMoney(senderAccount,receiverAccount,money);
    }

    public void performTransactionExchangeMoney(Account senderAccount,Account receiverAccount,double money, double rate){
        transactionBehavior.sendExchangedMoney(senderAccount,receiverAccount,money,rate);
    }

    public String getType() {
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public void setOwner(User user ) {
        this.owner = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public User getOwner() {
        return owner;
    }
}
