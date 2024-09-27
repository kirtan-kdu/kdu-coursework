package cryptotradingplatform;

public class Coin {
    private int rank;
    private String coinName;
    private String coinSymbol;
    private double price;
    private long supply;

    public Coin(int rank, String name, String symbol, double price, long supply) {
        this.rank = rank;
        this.coinName = name;
        this.coinSymbol = symbol;
        this.price = price;
        this.supply = supply;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinSymbol() {
        return coinSymbol;
    }

    public void setCoinSymbol(String coinSymbol) {
        this.coinSymbol = coinSymbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getSupply() {
        return supply;
    }

    public void setSupply(long supply) {
        this.supply = supply;
    }
}
