package Day_1;

import java.util.*;

public class BankAccountManagement {
    public BankAccountManagement() {
        System.out.println("Bank Account Management Server is Started");
    }

    final class BankAccount {
        private String name;
        private long balance;

        public BankAccount(String name, long balance) {
            this.createAccount(name, balance);
        }

        private void createAccount(String name, long balance) {
            this.name = name;
            this.balance = balance;
            System.out.println("Account Created Succesfully.. for "+this.name);
        }

        public void deposit(long amount) throws Exception {
            if(amount<0){
                throw new Exception("Amount should be greater than 0");
            }
            this.balance += amount;
            System.out.println("Amount: " + amount + "/- is Successfully Deposited");
            System.out.println("New Balance: " + this.balance + "/-");
        }

        public long withdraw(long amount) throws Exception {
            if(amount<0){
                throw new Exception("Amount should be greater than 0");
            }
            if (amount > balance) {
                throw new Exception("Insufficient Balance");
            }
            balance -= amount;
            System.out.println("Amount: " + amount + "/- is Successfully Withdrawn");
            System.out.println("New Balance: " + this.balance + "/-");

            return amount;
        }

        public long getBalance() {
            return this.balance;
        }

        public void updateName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public Map<String, String> getDetails() {
            Map<String, String> details = new HashMap();

            details.put("Name", name);
            details.put("Balance", balance + "");

            return details;
        }
    }

    public static void main(String[] args) throws Exception {

        BankAccountManagement karaikalBranch = new BankAccountManagement();
        BankAccountManagement.BankAccount ac1 =  karaikalBranch.new BankAccount("Kedhara Murugavel", 100000);
        BankAccountManagement.BankAccount ac2 =  karaikalBranch.new BankAccount("Kalaiselvi",100000);
        BankAccountManagement.BankAccount ac3 =  karaikalBranch.new BankAccount("Niranjani",100000);
        BankAccountManagement.BankAccount ac4 =  karaikalBranch.new BankAccount("Naleaswara Kumaran",100000);
        
        long naleashWithdraw = ac4.withdraw(75000);

        long splitToOthers = naleashWithdraw/3;

        ac1.deposit(splitToOthers);
        ac2.deposit(splitToOthers);
        ac3.deposit(splitToOthers);
        
        List<BankAccount> acs = new ArrayList<>();
        acs.add(ac1);
        acs.add(ac2);
        acs.add(ac3);
        acs.add(ac4);

        for(BankAccount a:acs){
            Map<String,String> data = a.getDetails();
            System.out.println(data);
        }
    }
}
