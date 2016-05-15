package ua.com.juja.lab38;

public class AccountManager {
    public static boolean transfer(Account[] accounts, int[] deltas) {
        int k = 0;
        while (k < accounts.length){
            try {
                accounts[k].change(deltas[k]);
            } catch (TryAgainException e) {
                continue;
            } catch (BlockAccountException e) {
                for (int i = 0; i < k ; i++) {
                    try {
                        accounts[i].change(-deltas[i]);
                    } catch (TryAgainException | BlockAccountException e1) {
                       //do nothing
                    }
                }
                return false;
            }
            k++;
        }
        return true;
    }
}

abstract class Account {
    protected int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public abstract void change(int delta) throws TryAgainException, BlockAccountException;

    public int getAmount() {
        return amount;
    }
}


class TryAgainException extends Exception {
}

class BlockAccountException extends Exception {
}