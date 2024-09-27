package cryptotradingplatform;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TradingPlatform {

    public List<Trader> traders;
    public List<Coin> coins;

    public JsonNode transactions;

    public TradingPlatform(){
        traders = new ArrayList<Trader>();
        coins = new ArrayList<Coin>();
        LoadTraders();
        LoadCoins();
    }

    public List<Trader> getTraders() {
        return traders;
    }

    public void setTraders(List<Trader> traders) {
        this.traders = traders;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public void setTransactions(JsonNode transactions) {
        this.transactions = transactions;
    }

//    public void LoadTransactions() {
//        String transactionPath = Main.class.getClassLoader().getResource("small_transaction.json").getPath();
//        JSONParser jsonParser = new JSONParser();
//        try {
//            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(transactionPath));
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            transactions = objectMapper.readTree(jsonArray.toString());
//
////            Iterator<JSONObject> iterator = jsonArray.iterator();
////            while(iterator.hasNext()) {
////                JSONObject obj = iterator.next();
////                String type = (String) obj.get("type");
////                JSONObject dataObject = (JSONObject) obj.get("data");
////                String coin = (String) dataObject.get("coin");
////                Long quantity = (Long) dataObject.get("quantity");
////                String walletAddress = (String) dataObject.get("wallet_address");
////
////                System.out.println("Type: " + type);
////                System.out.println("Coin: " + coin);
////                System.out.println("Quantity: " + quantity);
////                System.out.println("Wallet Address: " + walletAddress);
////            }
//
////            Iterator<Map.entry<String, JsonNode>> fields = transactions.fields();
////
////            while (fields.hasNext()) {
////                Map.Entry<String, JsonNode> field = fields.next();
////
////                System.out.println("Field name: " + field.getKey());
////                System.out.println("Field value: " + field.getValue());
////                System.out.println("###################");
////            }
//
////            System.out.println(transactions);
//        } catch (IOException | org.json.simple.parser.ParseException e) {
//            e.printStackTrace();
//        }
//    }
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
//                    System.out.println("Coins [Rank=" + coinProperties[1] + ", Name=" + coinProperties[2] + ", Symbol=" + coinProperties[3] + ", Price=" + coinProperties[4] + ", Supply=" + coinProperties[5] + "]");
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
//                System.out.println("Trader [First Name=" + traderProperties[1] + ", Last Name=" + traderProperties[2] + ", Number=" + traderProperties[3] + ", Address=" + traderProperties[4] + "]");
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
