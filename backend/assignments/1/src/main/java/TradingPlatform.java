import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;


public class TradingPlatform {

    private ArrayList<Trader> traders;
    private ArrayList<Coin> coins;

    private ArrayList<Transaction> transactions;

    public TradingPlatform(){
        traders = new ArrayList<Trader>();
        coins = new ArrayList<Coin>();
//        LoadTraders();
//        LoadCoins();
        LoadTransactions();
    }

    public void LoadTransactions() {
        String transactionPath = Main.class.getClassLoader().getResource("small_transaction.json").getPath();
        JSONParser jsonParser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(transactionPath));
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while(iterator.hasNext()) {
                JSONObject obj = iterator.next();
                String type = (String) obj.get("type");
                JSONObject dataObject = (JSONObject) obj.get("data");
                String coin = (String) dataObject.get("coin");
                Long quantity = (Long) dataObject.get("quantity");
                String walletAddress = (String) dataObject.get("wallet_address");

                System.out.println("Type: " + type);
                System.out.println("Coin: " + coin);
                System.out.println("Quantity: " + quantity);
                System.out.println("Wallet Address: " + walletAddress);
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
    public void LoadCoins(){

            String line = "";
            String splitBy = ",";
            try
            {
                String tradersCSVPath = Main.class.getClassLoader().getResource("coins.csv").getPath();

                //parsing a CSV file into BufferedReader class constructor
                BufferedReader br = new BufferedReader(new FileReader(tradersCSVPath));
                br.readLine();

                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    String[] coinProperties = line.split(splitBy);    // use comma as separator
                    System.out.println("Coins [Rank=" + coinProperties[1] + ", Name=" + coinProperties[2] + ", Symbol=" + coinProperties[3] + ", Price=" + coinProperties[4] + ", Supply=" + coinProperties[5] + "]");
                    Coin coin = new Coin(Integer.parseInt(coinProperties[1]), coinProperties[2], coinProperties[3], Double.parseDouble(coinProperties[4]), Long.parseLong(coinProperties[5]));
                    coins.add(coin);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
    }


    public void LoadTraders(){
        String line = "";
        String splitBy = ",";
        try
        {
            String tradersCSVPath = Main.class.getClassLoader().getResource("traders.csv").getPath();

            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(tradersCSVPath));
            br.readLine();
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] traderProperties = line.split(splitBy);    // use comma as separator
                System.out.println("Trader [First Name=" + traderProperties[1] + ", Last Name=" + traderProperties[2] + ", Number=" + traderProperties[3] + ", Address=" + traderProperties[4] + "]");
                Trader trader = new Trader(traderProperties[1], traderProperties[2], traderProperties[3], traderProperties[4]);
                traders.add(trader);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
