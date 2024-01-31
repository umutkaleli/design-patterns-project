import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private String id;
    private String birthDate;
    private String email;
    private String address;
    private String phoneNumber;
    ArrayList<Account> accounts;

    public User(String name, String surname, String id, String birthDate, String email, String address, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccountToUser(Account account){
        accounts.add(account);
    }

    public void deleteAccountFromUser(Account account){
        accounts.remove(account);
    }

}