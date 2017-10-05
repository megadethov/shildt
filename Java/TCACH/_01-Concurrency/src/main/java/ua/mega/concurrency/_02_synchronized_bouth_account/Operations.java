package ua.mega.concurrency._02_synchronized_bouth_account;

import javax.naming.InsufficientResourcesException;

public class Operations {
    public static void main(String[] args) throws InsufficientResourcesException {
        final Account a = new Account(1000);
        final Account b = new Account(2000);

        new Thread(new Runnable() {
            public void run() {
                try {
                    transfer(a,b,500);
                } catch (InsufficientResourcesException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        transfer(b, a, 300);
    }

    static void transfer(Account acc1, Account acc2, int amount) throws InsufficientResourcesException {
        if (acc1.getBalance() < amount) {
            throw new InsufficientResourcesException();
        }
        // теперь только один поток может работать с обеими аккаунтами
        // но возможен - DeadLock
        synchronized (acc1){
            synchronized (acc2){
                acc1.withdraw(amount);
                acc2.deposit(amount);
            }
        }

    }
}
