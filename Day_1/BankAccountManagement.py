from typing import Dict

class BankAccountManagement:
    def __init__(self):
        print("Bank Account Management Server is Started")

    class BankAccount:
        def __init__(self,name,balance):
            self.createAccount(name,balance)
            
        def createAccount(self,name,balance):
            self.name=name
            self.balance = balance
        
        def deposit(self,amount):
            if amount < 0:
                raise ValueError("Deposit amount must be greater than 0")
            self.balance += amount
            print("Amount: " + str(amount) + "/- is Successfully Deposited to "+self.name)
            print("New Balance: " + str(self.balance) + "/-")
        
        def withdraw(self,amount) -> int:
            if amount < 0:
                raise ValueError("Withdrawal amount must be greater than 0")
            if amount > self.balance:
                raise ValueError("Insufficient Balance")
            self.balance-=amount
            print("Amount: " + str(amount) + "/- is Successfully Withdrawn from "+ self.name)
            print("New Balance: " + str(self.balance) + "/-")
            return amount
        
        def getBalance(self) -> int:
            return self.balance
        
        def updateName(self,name):
            self.name = name
        
        def getName(self) -> str:
            return self.name
        
        def getDetails(self)->Dict[str,str]:
            datas = dict()
            datas.update({"Name":self.name});
            datas.update({"Balance":str(self.balance)})
            return datas

if __name__=="__main__":
    karaikalBranch = BankAccountManagement()

    ac1 = karaikalBranch.BankAccount("Kedhara Murugavel V", 100000)
    ac2 = karaikalBranch.BankAccount("Kalaiselvi K",100000)
    ac3 = karaikalBranch.BankAccount("Niranjani K",100000)
    ac4 = karaikalBranch.BankAccount("Naleaswara Kumaran K",100000)

    ac4withdrawal = ac4.withdraw(75000)

    split3 = ac4withdrawal/3

    ac1.deposit(split3)
    ac2.deposit(split3)
    ac3.deposit(split3)

    acs = [ac1,ac2,ac3,ac4]

    for ac in acs:
        data = ac.getDetails()
        print(data)
    


