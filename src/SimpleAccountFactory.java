public class SimpleAccountFactory {
    public Account createAccount(String type){
        Account account = null;

        if(type.equals("tl")){
            account = new TLAccount();
        }
        else if(type.equals("eur")){
            account = new EURAccount();
        }
        else if(type.equals("usd")){
            account = new USDAccount();
        }
        else if(type.equals("deposit")){
            account = new DepositAccount();
        }
        else{
            System.out.println("There is no such option.");
        }
        return account;
    }
}
