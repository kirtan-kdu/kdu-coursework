package cryptotradingplatform;

//import org.graalvm.collections.Pair;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Trader {
    private String firstName;
    private String lastName;
    private String phone;

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    private long profit;



    private Map<String, Pair<Long,Double>> purchasedCoins;

    public void purchaseCoin(String symbol, long quantity, double price){
        if (purchasedCoins.containsKey(symbol)){
            purchasedCoins.put(symbol, new Pair(purchasedCoins.get(symbol).getKey() + quantity, price));
        }
        else purchasedCoins.put(symbol,new Pair(quantity, price));
    }

    public boolean sellCoin(String symbol, long quantity, double price){
        if(purchasedCoins.containsKey(symbol) && purchasedCoins.get(symbol).getKey()>=quantity){
            profit += (price - purchasedCoins.get(symbol).getValue()) * quantity;
            purchasedCoins.put(symbol, new Pair(purchasedCoins.get(symbol).getKey() - quantity, purchasedCoins.get(symbol).getValue()));
            return true;
        }
        return false;
    }





    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public Map<String, Pair<Long, Double>> getPurchasedCoins() {
        return purchasedCoins;
    }

    public void setPurchasedCoins(Map<String, Pair<Long, Double>> purchasedCoins) {
        this.purchasedCoins = purchasedCoins;
    }

    private String walletAddress;

    public Trader(String firstName, String lastName, String phone, String walletAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.walletAddress = walletAddress;
        purchasedCoins = new HashMap<>();
    }

}
