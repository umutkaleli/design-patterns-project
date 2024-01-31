public interface ExchangeBehavior extends Observer {
    void exchangeMoney(Account exchangeAccount,Account transferredAccount,double money);
}
