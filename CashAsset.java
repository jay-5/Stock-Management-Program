  /* Jay Jayewardene. A class that represents money reserves */
public class CashAsset extends Object {
  
  private double balance;                     // stores the balance of the cash asset
  private double savingsRate;            // stores the savings rate of the cash asset
  private double loanRate;                  // stores the loan rate of the cash asset
  private double loanLimit;                 // stores the loan limit of the cash asset
  private double overdraftPenalty;   //stores the overdraft penalty of the cash asset
  private double deposit;                     //stores the deposit of the cash asset
  private double accruedInterest;     //stores the accreud interest of the cash asset
  private boolean withdrawal;          //stores the withdrawal of the cash asset
  
  
  /* A constructor that sets the cash asset savings rate, interest rate for loans, the loan limit, and overdraft 
   * penalty */
  public CashAsset(double savingsRate, double loanRate, double loanLimit, double overdraftPenalty) {
    this.savingsRate = savingsRate;
    this.loanRate = loanRate;
    this.loanLimit = loanLimit;
    this.overdraftPenalty = overdraftPenalty;
  }
  
  /* get the balance of the cash account */
  public double getBalance() {
    return balance;
  }
  
  /* get the savings rate of the cash account */
  public double getSavingsRate() {
    return savingsRate;
  }
  
  /* change the savings rate of the cash account */
  public void setSavingsRate(double savingsRate) {
    this.savingsRate = savingsRate;
  }
  
  /* get the loan rate of the cash account */
  public double getLoanRate() {
    return loanRate;
  }
  
  /* sets the loan rate of the cash account */
  public void setLoanRate(double loanRate) {
    this.loanRate = loanRate;
  }
  
  /*get the loan limit of the cash account */
  public double getLoanLimit() {
    return loanLimit;
  }
  
  /* change the loan limit for the cash account */
  public void setLoanLimit(double loanLimit) {
    this.loanLimit = loanLimit;
  }
  
  /* get the overdraft penalty for the cash account */
  public double getOverdraftPenalty() {
    return overdraftPenalty;
  }
  
  /* change the overdraft penalty for the cash account */ 
  public void setOverdraftPenalty(double overdraftPenalty) {
    this.overdraftPenalty = overdraftPenalty;
  }
  
  /* makes a deposit */
  public void deposit (double amount) {
    balance = getBalance() + amount;
  }
  
  /* makes a withdrawal */
  public boolean withdraw(double input, boolean overdraft) {
    if ((overdraft == false) && (input > getBalance())) {
      return false; }
    else {
      balance = getBalance() - input; 
      return true;
    }
  }
  
  /* represents a process day that changes the accrued interest  */
  public void processDay()  {
    if (balance > 0) {
      setAccruedInterest ((getBalance() * (getSavingsRate()/365)) + getAccruedInterest()); 
    }
    else { 
      setAccruedInterest(-1 * (getBalance() * (getLoanRate()/365))+ getAccruedInterest());
    }
  }
  
  /* represents the process month  */
  public void processMonth() {
    if ((getBalance() + getAccruedInterest() < 0) && (getBalance() + getAccruedInterest() > getLoanLimit())) {
      balance = getBalance() - getOverdraftPenalty();
    }
  }
  
  /* get the accrued interest of the cash asset */
  public double getAccruedInterest() {
    return accruedInterest; 
  }
  
  /* change the accrued interest of the cash asset */
  protected void setAccruedInterest(double input) {
    this.accruedInterest = accruedInterest;
  }
  
}