/* Jay Jayewardene. This is a class that represents an asset which is any tangible property 
 * that has a value. */
public class Asset extends Object  {
  
  private String name;                             // stores the name of the asset
  private String description;                 // stores the description of the asset
  private double costBasis;                   // stores the cost basis for the asset
  public double currentPrice;            // stores the current price of the asset
  private double capitalGains = 0;      /* stores the capital gains for the asset and sets the initial value of 
                                                                    the capital gains as zero */
  
  
  /* A constructor that sets an asset name and cost basis */
  public Asset(String name, double costBasis) { 
    this.name = name; 
    this.costBasis = 0;
  }
  
  /* Get the name of the asset */
  public String getName()  {
    return name; 
  }
  
  /* Change the name of the asset */
  public void setName(String name)  {
    this.name = name; 
  }
  
  /* Get the description of the asset */
  public String getDescription() {
    return description; 
  }
  
  /* Change the description of the asset */
  public void setDescription(String description) {
    this. description = description; 
  }
  
  /* Get the cost basis of the asset which is how much money was spent to get the asset */
  public double getCostBasis() {
    return costBasis; 
  }
  
  /* Change the cost basis of the asset */
  protected void setCostBasis (double costBasis) {
    this.costBasis = costBasis; 
  }
  
  /* Get the current price of the asset */
  public double getCurrentPrice() {
    return currentPrice;
  }
  
  /* Change the current price of the asset */
  public void setCurrentPrice(double currentPrice) {
    this.currentPrice = currentPrice;
  }
  
  /* Get the capital gains for the asset which is the value of the profit made when/if the asset is sold */
  public double getCapitalGains() {
    return capitalGains;
  }
  
  /* Change the capital gains for the asset */
  protected void setCapitalGains(double capitalGains){
    this.capitalGains = (capitalGains);
  }
  
}