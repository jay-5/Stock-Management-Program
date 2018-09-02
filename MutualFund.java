/* Jay Jayewardene. A class that represent a mutual fund which is an equity that is the shares of a mutual fund */
public class MutualFund extends Equity {
  
  private String name;                    // stores the name of the mutual fund
  private char symbol;                   // stores the symbol of the mutual fund
  private double load;                    // stores the load of the mutual fund 
  private double inputAmount;  // stores the input amount of the mutual fund
  private double currentPrice;   // stores the current price of the mutual fund
  
  
  /* A constructor that sets the name and symbol of the mutual fund as well as the current price of it */
  public MutualFund(String name, char symbol, double currentPrice) {
    super(name, symbol, currentPrice);
   
  }
  
  /* Get the load of the mutual fund which is a percentage that is charged on all sales of the fund */
  public double getLoad(){
    return load;
  }
  
  /* Change the load of the mutual fund */
  public void setLoad(double load){
    this.load = load;
  }
  
  /* Buy shares of the mutual fund. Returns zero if the imput amount is negative and if not, 
   *it returns the input amount as well as increases the cost basis by the input amount.*/
  public double buy(double inputAmount){
    if (inputAmount < 0) {
      return 0; }
    else {
      this.setNumberShares(getNumberShares() + (inputAmount) * (100% - getLoad())/(getCurrentPrice()));
      this.setCostBasis(getCostBasis() + inputAmount);
      return inputAmount;
    }
  }
  
  /* Sell shares of the mutual fund. If the input amount  is negative, the method returns 0 
   * if not, the method returns the withdraw amount and increases the capital gains. */
  public double sell(double withdrawAmount){
    double sharesOwned = getNumberShares();
    if ((inputAmount < 0) || (inputAmount > getCurrentPrice())) {
      return 0; 
    }
    else  {
      this.setNumberShares(getNumberShares() - (withdrawAmount)/(getCurrentPrice()));
      this.setCostBasis(getCostBasis() * (1- (sharesOwned-getNumberShares())/(sharesOwned)));
      this.setCapitalGains(getCapitalGains() + (withdrawAmount - getCostBasis()));
      return withdrawAmount;
    }
  }
}