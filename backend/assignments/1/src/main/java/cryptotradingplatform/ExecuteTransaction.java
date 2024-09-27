package cryptotradingplatform;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class ExecuteTransaction implements Runnable {

    private JsonNode transaction;

    private TradingPlatform tradingPlatform;
    private CountDownLatch latch;

    public ExecuteTransaction(JsonNode transaction, CountDownLatch latch, TradingPlatform tradingPlatform) {
        this.transaction = transaction;
        this.latch = latch;
        this.tradingPlatform = tradingPlatform;
    }

    public ExecuteTransaction() {

    }

    private String getBlockHash() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder transactionHash = new StringBuilder();
        Random rnd = new Random();
/**
 * Introducing delay mimicking complex
 * calculation being performed.
 */
        for (double i = 0; i < 1000; i++) {
            i = i;
        }
        while (transactionHash.length() < 128) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            transactionHash.append(SALTCHARS.charAt(index));
        }
        String hashCode = transactionHash.toString();
        return "0x" + hashCode.toLowerCase();
    }
    @Override
    public synchronized void run(){
        System.out.println("Total number: " + tradingPlatform.coins.size());
        String type = transaction.get("type").asText();
        JsonNode data = transaction.get("data");
        String coinSymbol = data.get("coin").asText();

//        System.out.println(transaction);
//        System.out.println(getBlockHash());

        switch (type){
            case "BUY":
                String walletAddress = data.get("wallet_address").asText();
                long quantity = data.get("quantity").asLong();


                tradingPlatform.setCoins(tradingPlatform.coins.stream().map(coin -> {
                    if (Objects.equals(coin.getCoinSymbol(), coinSymbol)){
                        long currQuantity = coin.getSupply();
                        if(currQuantity >= quantity){
                            coin.setSupply(currQuantity - quantity);



                            // GENERATE HASH



//                            System.out.println("traders size: " + tradingPlatform.traders.size());
                            tradingPlatform.setTraders(tradingPlatform.traders.stream().map(trader -> {

                                if (trader.getWalletAddress().equals(walletAddress)){
//                                    System.out.println("Trader [First Name=" + trader.getFirstName() + ", Last Name=" + trader.getWalletAddress() +  "]");

                                    trader.purchaseCoin(coinSymbol, quantity, coin.getPrice());
                                }
                                return trader;
                            }).collect(Collectors.toList()));

//                            System.out.println(latch.getCount());

                        }
                        else {
                            System.out.println("Not enough quantity available");
                        }


                    }
                    return coin;
                }).collect(Collectors.toList()));

                break;
            case "SELL":
                walletAddress = data.get("wallet_address").asText();
                quantity = data.get("quantity").asLong();

//                System.out.println(coinSymbol);
                tradingPlatform.setCoins(tradingPlatform.coins.stream().map(coin -> {
//                    System.out.println(coin.getSymbol() + " : " + coinSymbol);

                    if (Objects.equals(coin.getCoinSymbol(), coinSymbol)){

                        long currQuantity = coin.getSupply();
                            coin.setSupply(currQuantity + quantity);



                            // GENERATE HASH




                            tradingPlatform.traders.stream().map(trader -> {
//                                System.out.println(trader.getWalletAddress() + " : " + walletAddress);
                                if (trader.getWalletAddress().equals(walletAddress)){

                                    if(!trader.sellCoin(coinSymbol, quantity,coin.getPrice())){
                                        System.out.println("Not enough purchased this much coins");
                                    }

                                }
                                return trader;
                            });
                    }
                    return coin;
                }).collect(Collectors.toList()));

                break;
            case "UPDATE_PRICE":
                double price = data.get("price").asDouble();

                tradingPlatform.setCoins(tradingPlatform.coins.stream().map(coin -> {
                    if (Objects.equals(coin.getCoinSymbol(), coinSymbol)){
                        coin.setPrice(price);
                    }
                    return coin;
                }).collect(Collectors.toList()));
//                System.out.println(latch.getCount());

                break;
            case "ADD_VOLUME":
                long volume = data.get("volume").asLong();
                tradingPlatform.setCoins(tradingPlatform.coins.stream().map(coin -> {
//                    System.out.println("In AddVolume: " + coin.getSymbol());
                    if (Objects.equals(coin.getCoinSymbol(), coinSymbol)){
                        coin.setSupply(coin.getSupply() + volume);
                    }
                    return coin;
                }).collect(Collectors.toList()));
//                System.out.println(latch.getCount());

                break;
            default:
                System.out.println("Invalid transaction object with type as: " + type);
        }

        latch.countDown();



}


}
