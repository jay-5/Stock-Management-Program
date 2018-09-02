/* Jay Jayewardene. A class that represents a customer */
public class Customer extends Object {
  
  private Bond bond;                                  //stores the bond instance for the customer
  private Stock stock;                                  //stores the stock value for the customer
  private MutualFund mutualFund;      //stores the mutual fund value for the customer
  private CashAsset cashAsset;              //stores the cash asset value for the customer
  private CashAsset cashAccount;         //stores the cash account value for the customer
  private double commission;                 //stores the commission for the customer
  private double commissionAmount;  //stores the commission amount for the customer
 
  /* A constructor that sets the customer's cash amount and the commission */
  public Customer(CashAsset cashAsset, double commission) {
    this.cashAsset = cashAsset;
    this.commission = commission;
  }
  
  
  /* A constructor that sets the customer's cash asset, bond, stock, and commission */
  public Customer(CashAsset cashAsset, Bond bond, MutualFund mutualFund, Stock stock, double commissionAmount) {
    this.cashAsset = cashAsset;
    this.bond = bond;
    this.mutualFund = mutualFund;
    this.stock = stock;
    this.commissionAmount = commissionAmount; 
  }
  
  /* get the bond instance that corresponds with the account */
  public Bond getBond() {
    return bond;
  }
  
  /* change the bond instance that corresponds with the account */ 
  public void setBond(Bond bond) {
    this.bond = bond;
  }
  
  /* get the mutual fund instance that corresponds with the account */
  public MutualFund getMutualFund() {
    return mutualFund;
  }
  
  /* change the mutual fund instance that corresponds with the account */ 
  public void setMutualFund(MutualFund mutualFund) {
    this.mutualFund = mutualFund;
  }
  
  /* get the stock instance that corresponds with the account */
  public Stock getStock() {
    return stock;
  }
  
  /* change the stock instance that corresponds with the account */
  public void setStock(Stock stock) {
    this.stock = stock;
  }
  
  /* get the cash account instance that corresponds with the account */
  public CashAsset getCashAccount() {
    return cashAccount;
  }
  
  /* change the cash account instance that corresponds with the account */
  public void setCashAccount(CashAsset cashAccount) {
    this.cashAccount = cashAccount;
  }
  
  /* get the commission amount instance that corresponds with the account */
  public double getCommissionAmount() {
    return commissionAmount;
  }
  
  /* change the commission amount instance that corresponds with the account */
  public void setCommissionAmount(double commissionAmount) {
    this.commissionAmount = commissionAmount;
  }
  
  /* take the sum of the bond value, mutual fund value, and stock value of the account if they exist */
  public double currentValue() {
    double value = cashAccount.getBalance();
    double bondValue = 0;
    double stockValue = 0;
    double mutualFundValue = 0;
    if (bond != null) {
      bondValue = bond.getNumberOwned() * bond.getCurrentPrice();
    }
    if (mutualFund != null) {
      mutualFundValue = mutualFund.getNumberShares() * mutualFund.getCurrentPrice();
    }
    if (stock != null){
      stockValue = stock.getNumberShares() * stock.getCurrentPrice();
    }
    return bondValue + mutualFundValue + stockValue;
  }
  
  /* get the sum of the capital gains of the stock, mutual fund, and bond if they exist */
  public double getCapitalGains() {
    double capitalGainsStock = 0;
    double capitalGainsMutualFund = 0;
    double capitalGainsBond = 0;
    if (stock != null) { 
      capitalGainsStock = stock.getCapitalGains(); 
    }
    if (mutualFund != null) { 
      capitalGainsMutualFund = mutualFund.getCapitalGains() ;
    }
    if(bond != null) {
      capitalGainsBond = bond.getCapitalGains();
    }
    return capitalGainsStock + capitalGainsMutualFund + capitalGainsBond;
  }
  
  /* make a deposit by adding an amount of input to the balance of the cash account */
  public void deposit (double amount) {
    this.deposit(amount + cashAsset.getBalance()); 
  }
  
  /* call the withdraw method from the cash account with a boolean set as false */ 
  public boolean withdraw(double input) {
    return cashAccount.withdraw(input, false);
  }
  
  /* sell the bond */ 
  public void sellBond() {
    cashAccount.deposit(bond.sell());
  }
  
  /* buy the bond */ 
  public boolean buyBond() {
    if (bond.getCurrentPrice() > currentValue()) {
      return false;
    }
    else {
      return cashAsset.withdraw(bond.buy(), true);
    }
  }
  
  /* pay the bond interest */ 
  public void payBondInterest(){
    cashAccount.deposit(bond.payInterest());
  }
  
  /* withdraw from mutual fund */ 
  public void withdrawMutualFund(double withdrawAmount) {
    cashAsset.deposit(mutualFund.sell(withdrawAmount));
  }
  
  /* buy mutual fund */
  public boolean buyMutualFund(double buyAmount){
    if (buyAmount > currentValue())
      return false;
    else  {
      return cashAsset.withdraw(mutualFund.buy(buyAmount), true);
    }
  }
  
  /* sell stock shares */
  public void sellStockShares(int numberOfShares) {
    cashAsset.deposit(stock.sell(numberOfShares, getCommissionAmount()));
  }
  
  /* buy stock shares */
  public boolean buyStockShares(int numberOfShares) {
    if (stock.buy(numberOfShares, commission) > currentValue()) 
      return false;
    else {
      return cashAsset.withdraw(stock.buy(numberOfShares, getCommissionAmount()), true);
    }
  }
  
}