import java.util.ArrayList;
import java.util.UUID;

public class Bank {
    private final static Bank uniqueBankInstance = new Bank(new SimpleAccountFactory()); //Eager initialization
    private final SimpleAccountFactory simpleAccountFactory;
    private final String bankName;
    private final String bankId;

    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    private Bank(SimpleAccountFactory simpleAccountFactory){
        bankName = "Design Patterns Bank";
        bankId = "DPBANK";
        users = new ArrayList<>();
        accounts = new ArrayList<>();
        this.simpleAccountFactory = simpleAccountFactory;

    }

    public static Bank getBankInstance(){
        return uniqueBankInstance;
    }

    public void addUser(User user){
        if(!users.contains(user)){
        users.add(user);
        }else{
            System.out.println("This user already exists in the database.");
        }
    }
    public void removeUser(User user){
        if(users.contains(user)){
            users.remove(user);
        }
        else{
            System.out.println("There is no such user in the bank.");
        }
    }
    public Account createAccount(User user, String type, double initialBalance){
        Account account;
        account = simpleAccountFactory.createAccount(type);
        account.setOwner(user);
        if(initialBalance >= 0){
        account.setBalance(initialBalance);
        }else{
            System.out.println("You cannot give negative value.");
        }
        account.setCreatedTime(new java.util.Date());
        account.setIban(UUID.randomUUID().toString().replaceAll("-", "").substring(0,24));
        user.setAccountToUser(account);
        return account;
    }

    public void deleteAccount(Account account){
        account.getOwner().deleteAccountFromUser(account);
        accounts.remove(account);
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankId() {
        return bankId;
    }
}
