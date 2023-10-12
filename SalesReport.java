/**
 * WARNING:  THE CODE IN THIS PROGRAM "CANNOT" BE ALTERED.
 * NO POSTING OF THIS CODE IS ALLOWED ANY WHERE AS IT
 * IS THE INTELLECTUAL PROPERTY OF THE AUTHOR.
 * 
 * STUDENTS ARE TO INSERT CODE AND COMMENTS WHERE INDICATED IN CAPS
 * STARTING WITH "STUDENT INSERTS ... " OR CODE ... ".  USE DRJAVA'S
 * Find TO LOCATE THE INSERT AND CODE INSTRUCTIONS. * 
 * 
 * @(#)SalesReport.java
 * @author Linda Shepherd
 * @version 1.00 2022/10/28 11:55 PM
 *
 * PROGRAM PURPOSE:  STUDENT INSERTS.
 */
import java.util.Scanner;   //STUDENT INSERTS LINE COMMENTS FOR EACH IMPORT STMT.
import java.util.Calendar;

public class SalesReport
{    
  //STUDENT INSERTS LINE COMMENTS DESCRIPTIVE OF THE PURPOSE OF EACH VARIABLE.
  private Scanner input = new Scanner(System.in);        
  private Calendar dateTime = Calendar.getInstance();        
  private String monthNo = "";                         
  private String salesRep = "";                        
  private String quarter = "";                         
  
  private double quarterlySales = 0.0;            
  private double salesRevenue = 0.0;              
  /* These static fields are data for 
   * the company and not just the salesRep which 
   * is why they're being treated as static, so all 
   * SalesReport objects can use them.*/
  private static double annualSales = 0.0;        
  private static double projectedSales = 0.0;     
  private static double percOfTargetCo = 0.0;     
  private double percOfTargetRep = 0.0;           
        
  private int noOfQtrs = 0;                       
  private int qtrChoice = 0;                      
  private int noOfMonths = 3;                     
  private static int noSalesReps = 0;             

  private boolean repeat;                         
  
  /* NOTE:  EXCEPT CONSTRUCTORS THAT DON'T HAVE A return TYPE.
   * ALL OTHER METHODS IN THIS CLASS ARE INSTANCE METHODS WHICH
   * REQUIRES AN OBJECT TO CALL THEM IN THE CLIENT CLASS.*/
  
  

  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public SalesReport()
  {
  }//END Default Constructor
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  //CODE THE CONSTRUCTOR'S HEADER BASED ON THE CLOSE BRACE LINE COMMENT.
  public SalesReport(int noOfQtrs, String salesRep, double quarterlySales)
  {
    setNoQtrs(noOfQtrs);
    setSalesRep(salesRep);
    setQuarterlySales(quarterlySales);
  }//END Constructor(noOfQtrs:  int, salesRep:  String, quarterlySales:  double)
  
  
 
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public SalesReport copy()
  {
    /* CODE BELOW THE reportObj ACCEPTING noOfQtrs, salesRep, quarterlySales
     * IN THAT ORDER.*/
    
    SalesReport reportObj = new SalesReport(noOfQtrs, salesRep, quarterlySales);
    return reportObj;
  }//END copy():  SalesReport
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  //CODE THE equals HEADER BASED ON THE CLOSE BRACE LINE COMMENT.
  public boolean equals(SalesReport report)
  {
    /* Variable isEqual determines content equality of 2 SaleReport objects.  
     * Starting premise is NO (false).*/
    boolean isEqual = false;
    
    /* CODE BELOW THE if HEADER THAT TESTS, IN THE ORDER LISTED,
     * WHETHER noOfQtrs, salesRep, AND quarterlySales
     * ARE EQUAL TO THE SAME VARIABLES IN THE INCOMING report
     * OBJECT.*/
    if ( noOfQtrs == report.noOfQtrs && salesRep.equalsIgnoreCase(report.salesRep) && quarterlySales == report.quarterlySales)
    {
      isEqual = true;
    }//END if objects have same salesRep, 
    
    return isEqual;    
  }//END equals(report:  SalesReport):  boolean  
  
  
  
  
  
  
  
 
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public void setProjectedSales()
  {
    do
    {
      System.out.printf("%nWhat is the projected annual sales for Tandem?  ");      
      repeat = !input.hasNextDouble();  //Assigns a boolean on whether the input value is a double.
      
      validateNumber();  //A single validation method for numbers regardless of type.
    }while(repeat);
    
    projectedSales = input.nextDouble();  //Can safely convert input data to a double. 
    
    /* Clears the input buffer of what's left by next methods for numbers, so a subsequent 
     * nextLine() call works properly.*/
    input.nextLine();    
  }//END setProjectedSales():  void
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public int setNoSalesReps()
  {
    int noSalesReps = 0;  //Local variable for returning captured value.
    
    do
    {
      System.out.printf("%nHow many sales reps work for Tandem?  ");
    
      repeat = !input.hasNextInt();
      
      validateNumber();
    }while(repeat);
    
    noSalesReps = input.nextInt();
    input.nextLine();
    
    this.noSalesReps = noSalesReps;  //Assigns to field.       
    
    return noSalesReps;
  }//END setNoSalesReps():  int
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  //CODE THE HEADER BASED ON THE CLOSE BRACE LINE COMMENT.
  public final void setSalesRep(String salesRep)
  {
    this.salesRep = salesRep;
  }//END setSalesRep(salesRep:  String):  final void
  
  
  
  
  
  
  
  

  
  /**
   * setSalesRep() receives the sales rep count, prompts for the
   * name of the rep and ensures the proper capitalization of the
   * name.
   */
  public void setSalesRep(int salesRepCtr)
  {
    int index = 0;               //Stores the position of a letter in a String object.
    String salesRepCopy = null,  //Copy of the salesRep's name. 
           first = null,         //First name in salesRep.
           last = null;          //Last name in salesRep.
    char correct = ' ';          //Determines the value in the field repeat, a boolean.
    
    do
    {
      /* Determines how the prompt is presented.  Uses integer
       * value in a ternary operation to determine what goes in 
       * the %s for how the prompt will read.*/
      System.out.printf("%nEnter the name of %s sales rep:  ", 
                        salesRepCtr == 1 ? "a" : "the next");
      salesRep = input.nextLine();
      
      /*Takes out all spaces in salesRep and stores in the copy variable.*/
      salesRepCopy = new String(salesRep).replace(" ", "");

      /*Resolves a sales rep name that is not an alpha using isAlpha().*/
      while(!isAlpha(salesRepCopy))  
      {
        System.out.printf("%nInvalid name!  Please re-enter:  ");
        salesRep = input.nextLine();
        
        salesRepCopy = new String(salesRep).replace(" ", "");
      }//while salesRep's name is NOT alphabetic
      
      /*Asks user to validate name.*/
      System.out.printf("%nSales Rep Name:  %s"                            
                      + "%n%nIs this name correct?  \'Y\' or \'N\':  ",
                        salesRep);        
      correct = input.nextLine().toLowerCase().charAt(0);
      
      /* A ternary is used to determine the value of repeat based on the
       * value in correct which assesses the correctness of a sales rep's name.*/
      repeat = correct == 'y' ? false : true;  
    }while(repeat);  //do-while sales rep name is not correct
    
    index = salesRep.indexOf(" ");  //Locate where the first space is in salesRep.      
    
    if(index > 0)  //Is there a space?  If so, there is another word in the name.
    {
      /* Extract the first name from salesRep, uppercase the first letter
       * and add the rest of the letters lowercased.*/
      first = Character.toUpperCase(salesRep.charAt(0)) 
        + salesRep.substring(1, index).toLowerCase();      
      
      /* CODE BELOW THE EXTRACTION FOR THE last NAME FROM salesRep
       * AND UPPERCASE/LOWERCASE WHERE NEEDED.  
       *  - THE ARGUMENT FOR charAt() IS index + 1.
       *  - THE ARGUMENTS FOR THE substring() IS
       *    o index + 2
       *    o salesRep.Length()*/
      
       last = Character.toUpperCase(salesRep.charAt(index +1)) 
        + salesRep.substring(index + 2, salesRep.length()).toLowerCase();

      /*CODE BELOW THE STATEMENT TO LOCATE THE FIRST SPACE IN THE LAST NAME.*/
       index = last.indexOf(" ");  

      
      if(index > 0)  //If there is a space in the last name, there's another word.
      {
        /* Add to the first name a space, then the word from the last name
         * starting at the first letter in the last name until the index for
         * the space.*/
        first += " " + last.substring(0, index);  
        
        /* Now capitalize the first letter in the next word of the last name
         * and add the rest of the letters lowercased.*/
        last = Character.toUpperCase(last.charAt(index + 1))
          + last.substring(index + 2, last.length()).toLowerCase(); 
      }//END if index > 0
      
      /*Reconstitute the salesRep's name which is now properly capitalized.*/
      salesRep = first + " " + last;
    }//if there is more than one name, capitalize the first letter in each
    else
    {
      salesRep = Character.toUpperCase(salesRep.charAt(0)) 
        + salesRep.substring(1, salesRep.length()).toLowerCase();
    }//else capitalize first letter of a single name        
  }//END setSalesRep(salesRepCtr:  int):  void 
  
  
  
  
  
  
  
  
  
  
  
  /**
   * setNoQtrs() assigns an incoming value for noOfQtrs
   * to the field.  It is final because it is called from
   * a constructor.
   */
  public final void setNoQtrs(int noOfQtrs)
  {
    this.noOfQtrs = noOfQtrs;
  }//END setNoQtrs(noOfQtrs:  int):  final void
  
  
  
  
  
  
  
  
  /**
   * setNoQtrs() prompts for the number of quarters a sales
   * rep has worked.  The entry is validated for proper
   * conversion to an integer.
   */
  public void setNoQtrs()
  {
    do
    {
      System.out.printf("%nEnter the number of quarters worked (no less "
                          + "than 1 or greater than 4):  ");          
      
      repeat = !input.hasNextInt();
     
      if(repeat)
      {  
        validateNumber();
      }//END if takes care of invalid integer
      else
      { 
        noOfQtrs = input.nextInt();
      }//END else converts input to an integer and assigns to field        
            
      /* If the number entered for noOfQtrs is not in the
       * proper range of 1-4, then while-loop corrects it.*/
      while(noOfQtrs < 1 || noOfQtrs > 4)
      {
        System.out.printf("%nOUT OF RANGE!  Re-enter the number of quarters worked (no less "
                            + "than 1 or greater than 4):  ");                     
        /*Every time an integer is entered it has to be validated.*/
        repeat = !input.hasNextInt();  
        
        if(repeat)
        {  
          validateNumber();
        }//END if takes care of invalid integer
        else
        { 
          noOfQtrs = input.nextInt();
        }//END else converts input to an integer and assigns to field        
      }//END while noOfQtrs is out of range
    }while(repeat);    //END do-while repeats when number of quarters is invalid
    
    input.nextLine();     
  }//END setNoQtrs():  void
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * chooseQtr() prompts for the quarter in which the sales
   * were earned.  The entry is validated for proper
   * conversion to an integer before it is returned to the
   * calling statement.
   */
  public void chooseQtr(int qtrCounter)
  {
    do
    {
      System.out.printf("%n1.  First Quarter"
                          + "%n2.  Second Quarter"
                          + "%n3.  Third Quarter"
                          + "%n4.  Fourth Quarter"
                          + "%n%nChoose the %squarter in which sales were earned:  ",
                        qtrCounter > 1 ? "next " : "");                       
      
      repeat = !input.hasNextInt();
      
      if(repeat)
      {  
        validateNumber();
      }//END if takes care of invalid integer
      else
      { 
        qtrChoice = input.nextInt();
      }//END else converts input to an integer and assigns to field  
            
      /*CODE BELOW FOR while HEADER OUT OF RANGE TEST FOR qtrChoice.*/
      while ( qtrChoice < 1 || qtrChoice > 4)
      {
        System.out.printf("%nOUT OF RANGE!%n"
                            + "%n1.  First Quarter"
                            + "%n2.  Second Quarter"
                            + "%n3.  Third Quarter"
                            + "%n4.  Fourth Quarter"
                            + "%n%nChoose the %squarter in which sales were earned:  ",
                          qtrCounter > 1 ? "next " : "");     
        
        //CODE THE ASSIGNMENT TO repeat.
        repeat = !input.hasNextInt();
        //CODE THE if TEST OF repeat
        
        if (repeat)
        {  
          //CODE THE CALL TO THE VALIDATE METHOD.
        }//END if takes care of invalid integer
        else
        { 
          qtrChoice = input.nextInt();
        }//END else converts input to an integer and assigns to field        
      }//END while qtrChoice is out of range
    }while(repeat);  //END do-while repeats when qtrChoice is invalid
    
    //CODE THE CLEAR BUFFER STATEMENT.
     input.nextLine(); 
    quarter = (qtrChoice == 1) ? "First Quarter" 
              : (qtrChoice == 2) ? "Second Quarter" 
              : (qtrChoice == 3) ? "Third Quarter" 
              : "Fourth Quarter";    
  }//END chooseQtr(int):  void
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * determineMonthNo() receives the monthCounter to
   * figure out which month it is in the quarter:
   * 1st, 2nd, 3rd.
   */
  public void determineMonthNo(int monthCounter)
  {
    switch(monthCounter)
    {
      case 1: monthNo = "1st";
      break;
      case 2:  monthNo = "2nd";
      break;
      case 3:  monthNo = "3rd";
    }//END switch on monthCounter for 1st thru 3rd      
  }//END determineMonthNo(monthCounter:  int):  void
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * setSalesRevenue() asks for the sales revenue earned
   * for a given month within a given quarter.  The entry is 
   * validated for proper conversion to a double before it
   * is returned to the calling statement.
   */
  public void setSalesRevenue()
  { 
    do
    {
      System.out.printf("%nEnter the sales revenue for the %s "
                    + "month of the %s:  ", monthNo, quarter);
    
      repeat = !input.hasNextDouble();
      
      validateNumber();
      
    }while(repeat);  //END do-while repeats when richter is invalid
      
    salesRevenue = input.nextDouble();  
    
    input.nextLine();    
  }//END setSalesRevenue():  void
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  //CODE THE METHOD HEADER BASED ON THE CLOSE BRACE LINE COMMENT.
  public final void setQuarterlySales (double quarterlySales)
  {
    this.quarterlySales = quarterlySales;
  }//END setQuarterlySales(quarterlySales:  double):  final void
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public void calculateQtrlySales()
  {
    quarterlySales += salesRevenue;
    
  }//END calculateSales():  void
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public void calculateAnnualSales()
  {
     annualSales += quarterlySales;
     
  }//END calculateSales():  void
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * getSalesRepRevReport() prints the total year-to-date
   * sales revenue earned by a sales rep for the number of 
   * quarters worked in the current year.
   */
  public String getSalesRepRevReport()
  {       
    return String.format("%nSALES REVENUE FOR %d QUARTER(S) OF %tY" 
                       + "%nSALES REP:  %s"
                       + "%n%nTotal Year-To-Date:      $%,19.2f%n", 
                         noOfQtrs, dateTime, salesRep, quarterlySales);
  }//END getSalesRepRevReport():  String
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public String getRepTargetMsg()
  {
    //Calculating the sales earned by the sales rep to see if rep is on target.    
    percOfTargetRep = quarterlySales/(projectedSales/noSalesReps) * 100;
   
    String message = "";  //STORES A MESSAGE ABOUT YEAR-END BONUSES.
    
    /* Based on whether there is a space in the sales rep's name, extract
     * the first name, else, keep name as is.*/
    String rep = salesRep.indexOf(" ") > 0 ? 
      salesRep.substring(0, salesRep.indexOf(" ")) : salesRep;
                                                                
    if(noOfQtrs < 4)  //If the number of quarters is less than 4
    {
      /* Is the sales rep's sales on target?  If so, an encouraging message
       * is printed; otherwise, a warning of lagging sales.  The substring() 
       * is used to extract the first name and ensure the first letter is 
       * capitalized.
       */
      message = String.format(percOfTargetRep >= 50 ? String.format("%nKeep up the GOOD work, %s.  "
                         + "There is a possible year-end bonus!%n", rep)                                                                     
                         : "%nSo far sales are lagging behind projections.%n");
      }//END if noOfQtrs < 4 OR  >= 4  
    
    return message;
  }//END getRepTargetMsg():  String
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public void getCompanyTargetMsg()
  {
    //Calculating the annual sales to date to see if the company is on target.
    percOfTargetCo = (annualSales/projectedSales) * 100;    
    
    System.out.printf("%nCORPORATE SALES PERFORMANCE%n");
    
    /* Is the company on target to meet or exceed its projected sales?
     * If so, a year-end bonus message is printed; otherwise, a warning
     * precluding a year-end bonus.
     */
    System.out.printf(percOfTargetCo >= 100 ? "%nIt\'s been a GOOD year so far.  "
                    + "There could be a year-end bonus of "
                    + "%nabout 2-5%% if we can keep on top of our sales goals.  Thank you all "
                    + "%nand please continue your excellent effort!%n" 
                      : "%nSales are lagging projections.  A year-end bonus may "
                    + "not be possible.%n");
  }//END getCompanyTargetMsg():  void
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public void validateNumber()
  {
    if(repeat) //As long as the input is "not" an integer or double.
    { 
      input.next(); //Consumes the non-numeric value that caused the error.
      System.out.printf("%nWarning:  You entered an invalid integer or "
                          + "floating-point value.%n");  //RE-PROMPT     
    }//END if repeat when a number is an invalid type
  }//END validateNumber():  void
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * isAlpha() 
   *   - accepts a String to analyze.
   *   - is final because it is not to be overridden/replaced.
   *   - returns a boolean as to whether the word is alphabetic or not.
   * 
   * chars() returns the integer values of the characters in word.  
   * 
   * allMatch determines whether the integer values for each character 
   * matches the predicate (criterion) that each character is a letter.  
   * 
   * The :: is a method reference operator for calling isLetter from
   * the Character class.
   * 
   * @param word is the incoming String value to test.
   * @return is true when the word is not empty and is alphabetic 
   *  or false when it isn't.
   */
  /*CODE THE METHOD HEADER BASED ON THE CLOSE BRACE LINE COMMENT.*/
   
  public final boolean isAlpha (String word)
  {    
    /* Test to see if the word is not empty AND if each letter
     * in a word is an alphabetic character.  
     */
    return word != null && word.chars().allMatch(Character :: isLetter);
  }//END isAlpha(word:  String):  final boolean  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public String getDate()
  {
    return String.format("%tD", dateTime);  //Returns a formatted date as 99/99/9999.
  }//END getDate():  String
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  /*CODE THE METHOD HEADER BASED ON THE CLOSE BRACE LINE COMMENT.*/
  public double getprojectedSales()
  {
    return projectedSales;
  }//END getProjectedSales:  double
  
  
  
  
  
  

  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  /*CODE THE METHOD HEADER BASED ON THE CLOSE BRACE LINE COMMENT.*/
  public int getNoSalesReps()
  {
    
    //CODE THE return STATEMENT.
    return noSalesReps;
  }//END getNoSalesReps():  int
  
  
  
  
 
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  /*CODE THE METHOD HEADER BASED ON THE CLOSE BRACE LINE COMMENT.*/
  public String getSalesRep()
  {
    //CODE THE return STATEMENT.
    return salesRep;
  }//END getSalesRep():  String
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  /*CODE THE METHOD HEADER BASED ON THE CLOSE BRACE LINE COMMENT.*/
  public int getNoQtrs()
  {
    //CODE THE return STATEMENT.
    return noOfQtrs;
  }//END getNoQtrs():  int
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  /*CODE THE METHOD HEADER BASED ON THE CLOSE BRACE LINE COMMENT.*/
  public int getQtrChoice()
  {
    //CODE THE return STATEMENT.
    return qtrChoice;
  }//END getQtrChoice():  int
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public String getQuarter()
  {
    return quarter;
  }//END getQuarter():  String
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public int getNoMonths()
  {
    return noOfMonths;
  }//END getNoMonths:  int
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public double getSalesRevenue()
  {
    return salesRevenue;
  }//END getSalesRevenue():  double
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public double getQuarterlySales()
  {
    return quarterlySales;
  }//END getQuarterlySales():  double
  
  
  
  
  
  
  
  
  
  
  
  
  
  /**
   * STUDENT INSERTS DESCRIPTION OF WHAT'S GOING ON WITH THE CODE 
   * INSIDE THE METHOD.
   */
  public double getAnnualSales()
  {
    return annualSales;
  }//END getAnnualSales():  double  
}//END CLASS SalesReport
