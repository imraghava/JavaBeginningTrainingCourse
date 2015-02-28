package com.tyshchenko.java.training.oop.lesson7.synchronize;

/**
 * @author Alexander Tyshchenko.
 */
public class SynchronizedExample2 {

    public static void main(String[] args) {
        Account account = new Account(1000_000);

        for (int i = 0; i < 1000; i++) {
            Action action = new Action(account, 1000);
            action.start();
        }

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getAmount());
    }


    private static final class Action extends Thread {

        private final Account account;
        private final int withdraw;

        public Action(Account account, int withdraw) {
            this.account = account;
            this.withdraw = withdraw;
        }

        public void run() {
            synchronized (account) {
                int amount = account.getAmount();
                if (amount >= withdraw) {
                    account.setAmount(account.getAmount() - withdraw);
                }
            }
        }
    }

    private static final class Account {

        private int amount;

        public Account(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

}
