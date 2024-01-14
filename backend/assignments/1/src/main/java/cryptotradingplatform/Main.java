package cryptotradingplatform;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.util.Pair;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Main {

    private static TradingPlatform tradingPlatform;

    public static JsonNode parseJsonFile(String transactionPath) throws IOException {
//        String transactionPath = Main.class.getClassLoader().getResource("small_transaction.json").getPath();
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) jsonParser.parse(new FileReader(transactionPath));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(jsonArray.toString());
    }

    public static ArrayList<String[]> parseCSV(Path path) throws IOException {

        ArrayList<String[]> parsedCSV = new ArrayList<String[]>();
        String line = "";
        String splitBy = ",";
//            String tradersCSVPath = Main.class.getClassLoader().getResource("coins.csv").getPath();
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = Files.newBufferedReader(path);
            br.readLine();

            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] coinProperties = line.split(splitBy);    // use comma as separator
                    System.out.println("Coins [Rank=" + coinProperties[1] + ", Name=" + coinProperties[2] + ", Symbol=" + coinProperties[3] + ", Price=" + coinProperties[4] + "]");
//                Coin coin = new Coin(Integer.parseInt(coinProperties[1]), coinProperties[2], coinProperties[3], Double.parseDouble(coinProperties[4]), Long.parseLong(coinProperties[5]));
//                coins.add(coin);
                parsedCSV.add(coinProperties);
            }
        return parsedCSV;
    }
    public static void executeTransactions(JsonNode jsonTransactions, CountDownLatch latch) {
        tradingPlatform = new TradingPlatform();

        int numOfTransactions = jsonTransactions.size();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        jsonTransactions.forEach(jsonTransaction -> executorService.execute(new ExecuteTransaction(jsonTransaction, latch, tradingPlatform)));

        executorService.shutdown();

//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }
    public static void main(String[] args) throws IOException {


//        int numOfTransactions = tradingPlatform.transactions.size();
//        String transactionPath = Main.class.getClassLoader().getResource("small_transaction.json").getPath();

//        JsonNode trasnsactions = parseJsonFile(transactionPath);
//        int numOfTransactions = trasnsactions.size();
//        CountDownLatch doneSignal = new CountDownLatch(numOfTransactions);
//
//        System.out.println("Number of Transactions: " + numOfTransactions);
//
//        executeTransactions(trasnsactions, doneSignal);




        System.out.println("Its a Crypto Trading Platform");

        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean userChoice = true;
        while (userChoice){

            System.out.println("Enter 1,2,3,4 or 5 based on below options:");
            System.out.println("1. Get details of Coin");
            System.out.println("2. Display top N coins based on price");
            System.out.println("3. Get info about Trader");
            System.out.println("4. Retrieve profit/loss of any trader");
            System.out.println("5. Show top - bottom 5 traders");
            System.out.println("5. Quit the program");

            input = Integer.parseInt(sc.nextLine());
            AtomicBoolean flag = new AtomicBoolean(false);

            switch (input){
                case 1:
                    System.out.println("How do you wanted to know about coin?");
                    System.out.println("1. By Name");
                    System.out.println("2. By Rank");
                    System.out.println("3. By Symbol");

                    int firstInput = sc.nextInt();
                    switch (firstInput){
                        case 1:
                            System.out.print("Enter coin name: ");
                            String coinName = sc.nextLine();
                            tradingPlatform.coins.stream().forEach(coin -> {
                                if(coin.getCoinName().equals(coinName)){
                                    flag.set(true);
                                    System.out.println("Coins [Rank=" + coin.getRank() + ", Name=" + coin.getCoinName() + ", Symbol=" + coin.getCoinSymbol() + ", Price=" + coin.getPrice() + ", Supply=" + coin.getSupply() + "]");
                                }
                            });
                            if(flag.get()){
                                System.out.println("No such coin exist");
                            }
                            break;
                        case 2:
                            System.out.print("Enter coin Rank: ");
                            long coinRank = Long.parseLong(sc.nextLine());
                            tradingPlatform.coins.stream().forEach(coin -> {
                                if(coin.getRank() == coinRank){
                                    flag.set(true);
                                    System.out.println("Coins [Rank=" + coin.getRank() + ", Name=" + coin.getCoinName() + ", Symbol=" + coin.getCoinSymbol() + ", Price=" + coin.getPrice() + ", Supply=" + coin.getSupply() + "]");
                                }
                            });
                            if(flag.get()){
                                System.out.println("No such coin exist");
                            }
                            break;
                        case 3:
                            System.out.println("Enter coin symbol: ");
                            String coinSymbol = sc.nextLine();
                            tradingPlatform.coins.stream().forEach(coin -> {
                                if(coin.getCoinSymbol() == coinSymbol){
                                    flag.set(true);
                                    System.out.println("Coins [Rank=" + coin.getRank() + ", Name=" + coin.getCoinName() + ", Symbol=" + coin.getCoinSymbol() + ", Price=" + coin.getPrice() + ", Supply=" + coin.getSupply() + "]");
                                }
                            });
                            if(flag.get()){
                                System.out.println("No such coin exist");
                            }
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                    break;
                case 2:
                    System.out.println("Top N coins based on price are as below: ");
                    tradingPlatform.coins.stream().sorted(Comparator.comparing(Coin::getPrice).reversed()).collect(Collectors.toList()).forEach(coin -> System.out.println("Coins [Rank=" + coin.getRank() + ", Name=" + coin.getCoinName() + ", Symbol=" + coin.getCoinSymbol() + ", Price=" + coin.getPrice() + ", Supply=" + coin.getSupply() + "]"));
                    break;
                case 3:
                    System.out.println("Enter the wallet address: ");
                    String traderWallet = sc.nextLine();

                    tradingPlatform.traders.stream().forEach(trader -> {
                        if(trader.getWalletAddress().equals(traderWallet)){
                            System.out.println("Purchased coins looks like this:");
                            for (Map.Entry<String, Pair<Long, Double>> entry : trader.getPurchasedCoins().entrySet()) {
                                System.out.println(entry.getKey() + ": " + entry.getValue().getKey());
                            }
                            flag.set(true);
                        }
                    });
                    if (!flag.get())System.out.println("Invalid wallet address");


                case 4:
                    System.out.println("Enter the wallet address: ");
                    String traderWalletAddress = sc.nextLine();
                    tradingPlatform.traders.stream().forEach(trader -> {
                        if(trader.getWalletAddress().equals(traderWalletAddress)){
                            System.out.println("Profit for this trader is " + trader.getProfit());
                            flag.set(true);
                        }
                    });
                    if(!flag.get())System.out.println("Invalid Wallet address");

                case 5:
                    System.out.print("Enter N: ");
                    int num = Integer.parseInt(sc.nextLine());
                    System.out.println("Top " + num + " best performers are as below: ");
                    List<Trader> topPerformers = tradingPlatform.traders.stream().sorted(Comparator.comparing(Trader::getProfit)).collect(Collectors.toList());
                    for(int i=0; i<num; i++){
                        System.out.println("Trader [First Name=" + topPerformers.get(i).getFirstName() + ", Last Name=" + topPerformers.get(i).getLastName() + ", Number=" + topPerformers.get(i).getPhone() + ", Address=" + topPerformers.get(i).getWalletAddress() + ", Profit=" + topPerformers.get(i).getProfit() + "]");
                    }
                    Collections.reverse(topPerformers);
                    System.out.println("Top " + num + " worse performer are as below: ");
                    for(int i=0; i<num; i++){
                        System.out.println("Trader [First Name=" + topPerformers.get(i).getFirstName() + ", Last Name=" + topPerformers.get(i).getLastName() + ", Number=" + topPerformers.get(i).getPhone() + ", Address=" + topPerformers.get(i).getWalletAddress() + ", Profit=" + topPerformers.get(i).getProfit() + "]");
                    }
                    break;
                case 6:
                    userChoice = false;
                    break;

            }


        }








        System.out.println("Its at the end of main");
        System.out.println(tradingPlatform.traders.size());

        tradingPlatform.traders.forEach(trader -> {
            System.out.println(trader.getFirstName() + " : " + trader.getWalletAddress());
            for (Map.Entry<String, Pair<Long,Double>> entry : trader.getPurchasedCoins().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        });

//        tradingPlatform.coins.forEach(coin -> System.out.println("Coins [Rank=" + coin.getSupply() + ", Name=" + coin.getSymbol()));



//        System.out.println(doneSignal);
//        try {
//            doneSignal.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Its the end of whole main");
    }

}
