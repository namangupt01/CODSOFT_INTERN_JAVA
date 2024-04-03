import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;



class Account{
    // here we are putting all the members as private so that it can be accesible only within the same class and can
    // not be altered by the outside class

    private int customerNumber;  // this is for the privacy so that it can not be accessible by other clases

    private int pinNumber;
    private double checkingBalance=0;  // for checking balance
    private double savingBalance=0; // for saving balance


    Scanner input=new Scanner(System.in);
    DecimalFormat moneyFormat=new DecimalFormat("'$' ###,##0.00");

    public int setCustomerNumber(int customerNumber)  // methof fot setting the customer number
    {
        this.customerNumber=customerNumber;                   // applying the setter method to set the value through this keyword
        return customerNumber;

    }

    public int getCustomerNumber()
    {                                           // applying getter method for retrieving the value
        return customerNumber;
    }

    public int setPinNumber(int pinNumber)
    {
        this.pinNumber=pinNumber;       // setter method for the pinnumber
        return pinNumber;
    }

    public int getPinNumber()
    {
        return pinNumber;      // getter method for the pinnumber

    }

    public double getCheckingBalance()
    {
        return checkingBalance;
    }

    public double getSavingBalance()    // these all are the getter and setter method used over here
    {
        return savingBalance;
    }

    public double calCheckingWithdraw(double amount)
    {
        checkingBalance = (checkingBalance-amount);
        return checkingBalance;
    }

    public double calSavingWithdraw(double amount)
    {
        savingBalance = (savingBalance-amount);
        return savingBalance;
    }

    public double calCheckingDeposit(double amount)
    {
        checkingBalance = (checkingBalance+amount);
        return checkingBalance;
    }

    public double calSavingDeposit(double amount)
    {
        savingBalance = (savingBalance+amount);
        return savingBalance;
    }


    public void getCheckingWithdrawInput()
    {
        System.out.println("CHECKING ACCOUNT BALANCE --> "+ moneyFormat.format(checkingBalance));
        System.out.println("AMOUNT THAT YOU WANT TO WITHDRAW FROM THE ACCOUNT");
        double amount = input.nextDouble();

        if((checkingBalance-amount)>0)
        {
            calCheckingWithdraw(amount);
            System.out.println("NEW ACCOUNT BALANCE :-->" + moneyFormat.format(checkingBalance));
        }
        else{
            System.out.println("BALANCE CAN'T BE NEGATIVE"+"\n");

        }

    }


    public void getCheckingDepositInput()
    {
        System.out.println("CHECKING ACCOUNT BALANCE --> "+ moneyFormat.format(checkingBalance));
        System.out.println("AMOUNT THAT YOU WANT DEPOSIT INTO THE  ACCOUNT");
        double amount = input.nextDouble();

        if((checkingBalance+amount)>0)
        {
            calCheckingDeposit(amount);
            System.out.println("NEW ACCOUNT BALANCE :-->" + moneyFormat.format(checkingBalance));
        }
        else{
            System.out.println("BALANCE CAN'T BE NEGATIVE"+"\n");

        }

    }


}








class ATM_MENU extends Account  // this class extending the properties of the Account class
{

    Scanner input_data= new Scanner(System.in);
    int x=1;

    DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");
    HashMap<Integer,Integer> data = new HashMap <Integer,Integer>();  /* for the unique pin code with their customer number */
// here i have hash map to use the key - value pair to merge the customer number to their pin number
    // which helps in log in to the account if helps throws an error
    public void getLogin() //  this is the login method defined over here
    {
        int p=1;
        do{
            try{
                data.put(868462,68448);
                data.put(534153,99669469);
                data.put(4646694,8484864);

                System.out.println("I AM YOUR ATM MACHINE AND YOU ARE MOST WELCOME ");
                System.out.println("PLEASE ENTER YOUR CUSTOMER NUMBER");
                setCustomerNumber(input_data.nextInt());

                System.out.println("now enter your pin number:");
                setPinNumber(input_data.nextInt());
            }
            catch(Exception e)
            {
                System.out.println("\n"+ "you have entered invalid characters "+"\n");
                x=2;

            }
            int c_n= getCustomerNumber();
            int p_n= getPinNumber();
// c_n & p_n are there to get both these number to get compared in the collection framework to call the
            // accounttype method to log in to the system if matches
            if(data.containsKey(c_n)&& data.get(c_n)==p_n)
            {
                getAccountType();

            }
            else{
                System.out.println(" WRONG CUSTOMER NUMBER OR THE PIN NUMBER "+"\n");
            }
        }    while(x==1);



    }
    public void getAccountType()
    {
        System.out.println("Select the account that you want to check ");
        System.out.println("ENTER 1 FOR CHECKING ACCOUNT ");
        System.out.println("ENTER 2 FOR SAVING ACCOUNT");
        System.out.println("ENTER 3 FOR EXIT ");

        int selection = input_data.nextInt();

        switch (selection)
        {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thankyou for using our ATM SERVICES ! HAVE A GOOD DAY ");

            default:
                System.out.println("Invalid choice");

        }
    }

    public void getChecking()
    {
        System.out.println(".....CHECKING ACCOUNT.....");
        System.out.println("TYPE 1---> View Balance");
        System.out.println("TYPE 2--> Withdraw funds");
        System.out.println("TYPE 3--> Deposit funds");
        System.out.println("Type 4-->Exit");
        System.out.println("Choice:");

        int selection = input_data.nextInt();

        switch(selection)
        {
            case 1:
                System.out.println("Checking Account Balance:"+moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("THANKYOU FOR USING OUR SERVICES ! YOU CAN EXIT THE APPLICATION! BYE!");
                break;
            default:
                System.out.println("\n"+"Invalid choice"+"\n");
                getChecking();

        }



    }
    public void getSaving()
    {
        System.out.println(".....SAVING ACCOUNT.....");
        System.out.println("TYPE 1---> View Balance");
        System.out.println("TYPE 2--> Withdraw funds");
        System.out.println("TYPE 3--> Deposit funds");
        System.out.println("Type 4-->Exit");
        System.out.println("Choice:");

        int selection = input_data.nextInt();

        switch(selection)
        {
            case 1:
                System.out.println("Saving Account Balance:"+moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("THANKYOU FOR USING OUR SERVICES ! YOU CAN EXIT THE APPLICATION! BYE!");
                break;
            default:
                System.out.println("\n"+"Invalid choice"+"\n");
                getChecking();

        }


    }

}











public class atm extends ATM_MENU{  // this is the main class extendinf the atm_menu and perform inhertence over there






    public static void main(String [] args)
    {
        ATM_MENU X= new ATM_MENU()  ;
        X.getLogin();
    }


}
