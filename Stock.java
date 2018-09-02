/* Jay Jayewardene. A class that represents a stock which is an equity that is the shares of stock */
public class Stock extends Equity {
  
  private String name;                   //stores the name of the stock
  private char symbol;                  //stores the symbol of the stock
  private double currentPrice;   //stores the current price of the stock
  
  /* A constructor that sets the stock name, symbol, and current price */
  public Stock(String name, char symbol, double currentPrice) {
    super(name, symbol, currentPrice);
    this.name = name;
    this.symbol = symbol; 
    this.currentPrice = currentPrice; 
  }
  
  /* buys the stock,  adds one to the number of shares, and changes the cost basis */
  public double buy(int numberOfShares, double commission) {
    double n = numberOfShares;
    double p = getCurrentPrice();
    double c = commission;
    double z = (n * p + c);
    setNumberShares(getNumberShares() + n);
    setCostBasis(getCostBasis() + z);
    return z;
  }
  
  /* sells the stock, decreases the number of shares by one, changes the cost basis, 
   * and changes the capital gains */
  public double sell(int numberOfSharesSold, double commission) {
    if (numberOfSharesSold > getNumberShares()) {
      return 0; 
    }
    else { 
      setNumberShares(getNumberShares() - numberOfSharesSold);
      setCostBasis((getCostBasis()) - getCostBasis()/(numberOfSharesSold/getNumberShares()));
      setCapitalGains(getCapitalGains() + (numberOfSharesSold * getCurrentPrice() - commission));
      return ((numberOfSharesSold * getCurrentPrice()) - commission);
    }
    
  }
  
  /* sets the number of stocks to split which means to increase the amount of shares 
   * in a company so long as neither the ratio numerator nor the ratio denominator equal zero */ 
  public double split(int ratioNumerator, int ratioDenominator) {
    if ((ratioNumerator == 0) || (ratioDenominator == 0)) {
      return 0; 
    }
    if (getNumberShares() != (int)getNumberShares()) {
      setNumberShares(getNumberShares() * (ratioNumerator/ratioDenominator));
      return ((getNumberShares() % (int)getNumberShares()) * getCurrentPrice());
    }
    else {
      return 0;
      
    }
  }
  
}
  