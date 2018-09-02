/* Jay Jayewardene. A class that represents equity which is an asset where one can own shares of 
 * the asset */
public class Equity extends Asset {
  
  private String name;                        //stores the name of the equity asset
  private char symbol;                       //stores the character symbol of the equity asset
  private double numberShares;   //stores the number of asset shares of the equity asset
  
  /* A constructor that sets the name, symbol, and current price of an equity */
  public Equity(String name, char symbol, double currentPrice){
    super(name, 0);
    this.symbol = symbol;
    this.currentPrice = currentPrice;
  }
  
  /*  Get the symbol of the equity  */
  public char getSymbol(){
    return symbol;
  }
  
  /*  Get the number of shares of the equity  */
  public double getNumberShares(){
    return numberShares;
  }
  
  /*  Change the number of shares of equity  */
  protected void setNumberShares(double numberShares){
    this.numberShares = numberShares;
  }
  
  
  
}