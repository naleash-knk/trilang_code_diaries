void main() {
  Bankaccountmanagement karaikalBranch = Bankaccountmanagement();
  BankAccount ac1 = karaikalBranch.createAccount("Kedhara Murugavel", 100000);
  BankAccount ac2 = karaikalBranch.createAccount("Kalaiselvi", 100000);
  BankAccount ac3 = karaikalBranch.createAccount("Niranjani", 100000);
  BankAccount ac4 = karaikalBranch.createAccount("Naleaswara Kumaran K", 100000);

  int ac4Withdrawal = ac4.withdraw(75000);
  int splitinto3 =  ac4Withdrawal~/3;
  ac1.deposit(splitinto3);
  ac2.deposit(splitinto3);
  ac3.deposit(splitinto3);

  List<BankAccount> acs = [ac1,ac2,ac3,ac4];

  acs.forEach((ac){
    print(ac.getDetails());
  });
}

class Bankaccountmanagement {
  BankAccountManagement(){
    print("Bank Account Management Server is Started");
  }
  BankAccount createAccount(String name, int balance){
    return BankAccount(name,balance);
  }
}

class BankAccount {
  late String name;
  late int balance;
  
  BankAccount(String name, int balance) {
    this.createAccount(name, balance);
  }

  void createAccount(String name, balance) {
    this.name = name;
    this.balance = balance;
  }

  void deposit(int amount) {
    if (amount < 0) {
      throw Exception("Amount should be greater than 0");
    }
    print("Amount: " + amount.toString() + "/- is Successfully Deposited to "+this.name);
    print("New Balance: " + this.balance.toString() + "/-");
    this.balance += amount;
  }

  int withdraw(int amount) {
    if (amount < 0) {
      throw Exception("Amount should be greater than 0");
    }
    if (amount > balance) {
      throw Exception("Insufficient Balance");
    }

    this.balance -= amount;
    print("Amount: " + amount.toString() + "/- is Successfully Withdrawn from "+this.name);
    print("New Balance: " + this.balance.toString() + "/-");
    return amount;
  }

  int getBalance() {
    return this.balance;
  }

  void updateName(String name) {
    this.name = name;
  }

  String getName() {
    return this.name;
  }

  Map<String, String> getDetails(){
    Map<String,String> datas = {};
    datas["Names"]=this.getName();
    datas["Balance"]=this.getBalance().toString();
    return datas;
  }
}
