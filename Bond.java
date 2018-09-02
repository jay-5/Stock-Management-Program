/* Jay Jayewardene. A class that represents a bond which is an asset that is a loan from a government or 
 * corporation. */
public class Bond extends Asset {
  
  private String name;                       //stores the name of the bond
  private int principal;                       //stores the principal cost of the bond
  private int numberOwned;           //stores the number of owned bonds   
  private int bondNumber;              //stores the bond number
  private double interestRate;        //stores the interest rate of the bond
  private double costBasis;              //stores what was payed to acquire the bond
  
  /* A constructor that sets the bond name, principal, and interest rate */
  public Bond(String name, int principal, double interestRate) {
    super(name,0);
    this.principal = principal;
    this.interestRate = interestRate;
    this.currentPrice = principal;
  }
  
  /* Get the name of the bond */
  public String getName(){
    return this.name; }
  
  /* Get the principal value of the bond */
  public int getPrincipal()  {
    return principal; 
  }
  
  /* Get the interest rate of the bond */
  public double getInterestRate() {
    return interestRate; 
  }
  
  /* Change the interest rate of the bond */
  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate; 
  }
  
  /* Pay the interest of the bond. This returns the interest rate multiplied by the principal */
  public double payInterest() {
    return getInterestRate() * getPrincipal(); 
  }
  
  /* Purchase a bond. This increases the cost basis by the current price, 
   * adds one to the number of owned bonds, and returns the current price of the bond   */
  public double buy(){
    bondNumber = bondNumber + 1;
    setCostBasis(getCurrentPrice() + getCostBasis());
    return currentPrice;
  }
  
  /* Sell a bond. If no bonds are owned, zero is returned. If not, the current price is returned */
  public double sell(){
    if (numberOwned == 0)
      return 0;
    else {
      double entry = getCostBasis();
      setCostBasis(getCostBasis()/bondNumber);
      setCapitalGains(getCapitalGains() + getCurrentPrice() - (entry - getCostBasis()));
      bondNumber = bondNumber - 1;
      return currentPrice;
    }
  }
  
  /* Get the number of bonds that are owned */
  public int getNumberOwned(){
    return numberOwned;
  }
  
}
