package org.example.lesson6.problem4;

public class BankTransfer {

    public class Account {
        private final int id;
        private double balance;
        private final Object lock = new Object();

        public Account(int id, double balance) {
            this.id = id;
            this.balance = balance;
        }

        public boolean withdraw(double amount) {
            synchronized (lock) {
                if(amount > balance) return false;

                balance -= amount;
                return true;
            }
        }

        public void deposit(double amount) {
            synchronized (lock) {
                balance += amount;
            }
        }

        public double getBalance() {
            synchronized (lock) {
                return balance;
            }
        }
    }

    public boolean transfer(Account from, Account to, double amount) {
        synchronized (from.lock) {
            synchronized (to.lock) {
                boolean deducted = from.withdraw(amount);
                if(deducted) {
                    to.deposit(amount);
                    return true;
                }

                return false;
            }
        }

    }
}
