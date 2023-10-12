import java.util.Scanner;
import java.util.Calendar;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
 
public class SalesSystem
{
  
 private static SalesReport[] reports;
 private static Scanner input = new Scanner(System.in);
 private static Calendar dateTime = Calendar.getInstance();
 private static ArrayList<String> salesReports = new ArrayList<>(); 
 private static String fileName = " ";
 private static char cont;
  
 public SalesSystem()
 {
   
 }
 
 public void start()
 {
   System.out.printf("%nTANDEM ENTERPRISES%n");
   System.out.printf("%nBegin the processing of a sales report? Enter 'Y' or 'N'");
   cont = input.next().charAt(0);
   
   if ( cont == 'y' || cont == 'Y' )
   {
     processSalesReport();
     writeSalesRepData();
     checkInputFile();
   }
   else
   {
     exitMessage();
   }
   
 }
 
 
 
 public void processSalesReport()
 {
   int size, qtrCounter, monthCounter;
   String aSalesReport = "";
   SalesReport anotherObj = new SalesReport();
   
   
   System.out.printf("%n%nTANDEM ENTERPRISES%n");
   
   anotherObj.setProjectedSales();
   size=anotherObj.setNoSalesReps();
   reports = new SalesReport[size];
  
   
   for (int i = 0; i < reports.length; i++ )
   {
     
     
     qtrCounter = 1;
     
    
     
     reports[i] = new SalesReport();
     reports[i].setSalesRep(i + 1);
     reports[i].setNoQtrs();
     
     while (qtrCounter <= reports[i].getNoQtrs())
     {
       monthCounter = 1;
       reports[i].chooseQtr(qtrCounter);
       
       while ( monthCounter <= reports[i].getNoMonths())
       {
         reports[i].determineMonthNo(monthCounter);
         reports[i].setSalesRevenue();
         reports[i].calculateQtrlySales();
         ++monthCounter;
       }
       ++qtrCounter;
        
     }
     
     reports[i].calculateAnnualSales();
     aSalesReport += reports[i].getSalesRepRevReport();
     aSalesReport += reports[i].getRepTargetMsg();
     salesReports.add(aSalesReport);
     
     aSalesReport = "\n\nTANDEM ENTERPRISES\n";
   }
   
   for (String eachReport : salesReports)
   {
     System.out.printf("%s", eachReport);
   }
   anotherObj.getCompanyTargetMsg(); 
     
   }
   
   
   
   public void writeSalesRepData() 
    {
        String record = "";
        boolean fileError = false;
        PrintWriter outputFile = null;
        
        try
        {
            System.out.printf("%nEnter the file name for sales report (WARNING: This will erase a pre-existing file!): ");
            fileName = input.next();
            outputFile = new PrintWriter(fileName);
            for (SalesReport eachReport : reports)
            {
                record = String.format("%s, %d, %s, %.2f%n", 
                                       eachReport.getDate(), 
                                       eachReport.getNoQtrs(), 
                                       eachReport.getSalesRep(), 
                                       eachReport.getQuarterlySales());
                
                outputFile.printf("%s", record);
            }
        }
        catch (IOException e)
        {
            System.err.printf("%nFile cannot be created.%n");
            fileError = true;
        }
        if (!fileError)
        {
            outputFile.close();
            System.out.printf("%nData written to the %s file.%n", fileName);
        }
    }
   
   
   
 public void checkInputFile() 
    {
        String fileRecord = "";
        boolean fileNotFound = false;
        File file = null;
        Scanner inputFile = null;
        
        try
        {
            System.out.printf("%nEnter the name for the sales report file: ");
            fileName = input.next();
            file = new File(fileName);
            inputFile = new Scanner(file);
            while (inputFile.hasNext())
            {
                fileRecord = inputFile.nextLine();
                System.out.printf("%n%s", fileRecord);
            }
            System.out.println();
        }
        catch (IOException e)
        {
            System.err.printf("%nFile not found!%n");
            fileNotFound = true;
        }
        catch (NullPointerException e)
        {
            System.err.printf("%nRecord couldn’t be accessed or read.%n");
            fileNotFound = true;
        }
        if (!fileNotFound)
        {
            inputFile.close();
        }
    }   
  
 
 
 
  
 
 
 public void exitMessage()
 {
   System.out.printf("%nExiting Sales System%n");
 }
 
 

 

 
 
}