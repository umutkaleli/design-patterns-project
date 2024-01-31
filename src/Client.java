public class Client {
    public static Bank bank = Bank.getBankInstance();

    public static void main(String[] args) {

        User user1 = new User("Umut", "Kaleli", "123", "11-05-2000", "umutkaleli6500@gmail.com", "dsa", "5312469725");
        User user2 = new User("Arjin", "Kavalcı", "1350", "05-03-2001", "arjin.33@outlook.com", "adsadkflna", "5459404326");
        User user3 = new User("Alper", "Bilge", "4586", "25-08-1988", "alper.bilge@gmail.com", "Akdeniz University", "5467884354");
        User user4 = new User("John", "Doe", "789", "15-09-1995", "john.doe@example.com", "123 Main St", "5551234567");
        User user5 = new User("Alice", "Smith", "246", "03-07-1989", "alice.smith@example.com", "456 Oak St", "5559876543");
        User user6 = new User("Bob", "Johnson", "357", "21-11-1992", "bob.johnson@example.com", "789 Elm St", "5552345678");
        User user7 = new User("Jane", "Brown", "951", "08-04-1985", "jane.brown@example.com", "567 Pine St", "5558765432");
        User user8 = new User("Eva", "Taylor", "864", "12-06-1998", "eva.taylor@example.com", "890 Cedar St", "5553456789");
        User user9 = new User("Michael", "Williams", "258", "02-02-1980", "michael.williams@example.com", "321 Birch St", "5559876543");
        User user10 = new User("Emily", "Miller", "147", "19-12-1993", "emily.miller@example.com", "654 Maple St", "5552345678");
        User user11 = new User("Daniel", "Jones", "369", "27-03-1987", "daniel.jones@example.com", "876 Oak St", "5558765432");
        User user12 = new User("Sophia", "Davis", "852", "04-09-1990", "sophia.davis@example.com", "109 Pine St", "5553456789");
        User user13 = new User("William", "Garcia", "753", "14-01-1983", "william.garcia@example.com", "210 Cedar St", "5551234567");


        Account account = bank.createAccount(user8, "tl", 1000);
        Account account2 = bank.createAccount(user10, "eur", 1000);
        Account account3 = bank.createAccount(user2, "deposit", 9000);
        Account account4 = bank.createAccount(user1, "usd", 100);
        Account account5 = bank.createAccount(user2, "tl", 1500);
        Account account6 = bank.createAccount(user3, "eur", 2000);
        Account account7 = bank.createAccount(user4, "usd", 300);
        Account account8 = bank.createAccount(user5, "tl", 1200);
        Account account9 = bank.createAccount(user6, "eur", 1800);
        Account account10 = bank.createAccount(user7, "deposit", 2500);
        Account account11 = bank.createAccount(user10, "tl", 2000);
        Account account12 = bank.createAccount(user9, "eur", 1300);
        Account account13 = bank.createAccount(user10, "usd", 900);
        Account account14 = bank.createAccount(user11, "tl", 1700);
        Account account15 = bank.createAccount(user12, "eur", 2200);
        Account account16 = bank.createAccount(user13, "usd", 3000);
        Account account17 = bank.createAccount(user1, "deposit", 800);
        Account account18 = bank.createAccount(user2, "eur", 2500);
        Account account19 = bank.createAccount(user3, "usd", 1800);
        Account account20 = bank.createAccount(user4, "tl", 1200);
        Account account21 = bank.createAccount(user12, "deposit", 100000);

        //Observer Pattern tested
        //Create new subject
        ExchangeRateData exchangeRateData = new ExchangeRateData();

        ExchangeEurTl exchangeEurTl = new ExchangeEurTl(exchangeRateData);
        exchangeRateData.setExchangeRates(29, 32, (double) 29 / 32);
        System.out.println("-------------------------------------------------------");

        exchangeRateData.setExchangeRates(50, 60, (double) 50 / 60);
        System.out.println("-------------------------------------------------------");

        ExchangeUsdTl exchangeUsdTl = new ExchangeUsdTl(exchangeRateData);

        exchangeRateData.setExchangeRates(28.8, 31.6, (28.8 / 31.6));
        System.out.println("-------------------------------------------------------");

        ExchangeUsdEur exchangeUsdEur = new ExchangeUsdEur(exchangeRateData);

        exchangeRateData.setExchangeRates(32, 35, (double) 32 / 35);
        System.out.println("-------------------------------------------------------");

        exchangeRateData.removeObserver(exchangeUsdEur);

        exchangeRateData.setExchangeRates(32, 35, (double) 32 / 35);
        System.out.println("-------------------------------------------------------");

        exchangeRateData.removeObserver(exchangeUsdTl);
        exchangeRateData.removeObserver(exchangeEurTl);

        exchangeRateData.setExchangeRates(50, 100, (double)0.5);
        System.out.println("-------------------------------------------------------");


        //Singleton pattern tested
        Bank bank1 = Bank.getBankInstance();
        Bank bank2 = Bank.getBankInstance();

        if (!(bank1 == bank2)) {
            System.out.println("You created 2 bank objects.");
            System.out.println("-------------------------------------------------------");
        } else {
            System.out.println("There is only one bank object in the system you can use");
            System.out.println("-------------------------------------------------------");
        }


        // Strategy Pattern tested

        //Cannot exchange money in currencies to someone else
        account.setExchangeBehavior(exchangeEurTl);
        account2.setExchangeBehavior(exchangeEurTl);
        System.out.println("Sender account balance before exchanging: " + account.getBalance());
        System.out.println("Receiver account balance before exchanging: " + account2.getBalance());
        account.getExchangeBehavior().exchangeMoney(account2, account, 600);
        System.out.println("Sender account balance after trying exchanging: " + account.getBalance());
        System.out.println("Receiver account balance after trying exchanging: " + account2.getBalance());
        System.out.println("-------------------------------------------------------");

        // Deposit account cannot send money
        System.out.println("Balance befor sending money: " + account3.getBalance());
        account3.getTransactionBehavior().sendMoney(account3, account, 500);
        System.out.println("-------------------------------------------------------");

        System.out.println("Sender account balance before any transaction: " + account5.getBalance()+ account5.getType());
        System.out.println("Sender account sent 200TL to receiver account.");
        account5.getTransactionBehavior().sendMoney(account5,account8,200);
        System.out.println("-------------------------------------------------------");

        exchangeRateData.registerObserver(exchangeEurTl);
        exchangeRateData.registerObserver(exchangeUsdTl);


        System.out.println("Sender account balance for exchanging: " + account7.getBalance() + account7.getType());
        account7.getExchangeBehavior().exchangeMoney(account7,account14,400);
        account7.getExchangeBehavior().exchangeMoney(account7,account14,200);
        System.out.println("-------------------------------------------------------");

        // Belongs to same user exchange can happen
        account2.setExchangeBehavior(exchangeEurTl);
        account11.setExchangeBehavior(exchangeEurTl);
        System.out.println("Sender account balance: " + account2.getBalance() + account2.getType());
        System.out.println("Receiver account balance: " + account11.getBalance() + account11.getType());
        // EUR TO TL IS 35
        account2.getExchangeBehavior().exchangeMoney(account2,account11,200);
        System.out.println("-------------------------------------------------------");

        // Set new behaviors to accounts
        account13.setExchangeBehavior(exchangeUsdTl);
        account11.setExchangeBehavior(exchangeUsdTl);
        System.out.println("Sender account balance: " + account13.getBalance() + account13.getType());
        System.out.println("Receiver account balance: " + account11.getBalance() + account11.getType());
        // USD TO TL IS 32
        account13.getExchangeBehavior().exchangeMoney(account13,account11,200);
        System.out.println("-------------------------------------------------------");

        // look for deposit day
        account10.getDepositBehavior().getDepositTime();
        System.out.println("Account balance before any deposit: " + account10.getBalance());
        account10.getDepositBehavior().setBalanceAfterDepositDay(account10);
        System.out.println("-------------------------------------------------------");

        // Set new deposit behavior
        account10.setDepositBehavior(new MonthlyDeposit());
        System.out.println("Account balance before monthly deposit: " + account10.getBalance());
        account10.getDepositBehavior().getDepositTime();
        account10.getDepositBehavior().setBalanceAfterDepositDay(account10);
        System.out.println("-------------------------------------------------------");

        // Deposit after one month deposit : 100000TL
        account21.setDepositBehavior(new MonthlyDeposit());
        System.out.println("Account balance before any deposit: " + account21.getBalance());
        account21.getDepositBehavior().setBalanceAfterDepositDay(account21);
        account21.getDepositBehavior().setBalanceAfterDepositDay(account21);
        System.out.println("-------------------------------------------------------");

        /*
        exchangeRateData.registerObserver(exchangeUsdEur);
        exchangeRateData.setExchangeRates(10,15, (double) 10 /15);
        System.out.println("-------------------------------------------------------");*/
    }
}