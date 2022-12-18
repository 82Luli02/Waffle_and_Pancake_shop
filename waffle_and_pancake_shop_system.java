import java.util.Scanner;  //Needed for Scanner class

 /**
 *
 * @author Alia AlGhamdi
 *
 **/

public class waffle_and_pancake_shop_system {
    
    public static void main(String[] args) {
        
    /* ---Def. of declared variables--
     *order* takes the number of the order chosen by the user 
     *Pieces* indicates to the number of Pieces of the order chosen by the user (initialized by zero)
     *souses* indicates to the souse option chosen by the user 
     *toppings* indicates to the topping option chosen by the user 
     *price* holds the price through the program (initialized by zero) 
     *TAX_RATE* constant holds the general amount of tax
     *totalTax* store the amount of the order's tax  
     *discount* indicates to the percent of discount (initialized by zero) 
     *totalPrice* stores the total price including tax and discount (initialized by zero) 
     *sweetType* indicates to type of the sweet whether it is Waffle or Pancake 
     *souseType* indicates to type of the souse chosen from the menu 
     *toppingType* indicates to type of the topping chosen from the menu
     *input* used to store string input 
     *letter* used inside the first loop as a flag that enables the user to re-enter 
     *keyboard* scanner object to read input */
    
    int order, Pieces=0, souses, toppings; 
    double price=0.0,totalPrice=0.0, totalTax, discount=0.0;
    String input,sweetType="", souseType="", toppingType="";
    final double TAX_RATE=0.15;
    char letter='n'; 
    Scanner keyboard = new Scanner(System.in);
    
    //do-While loop
    do{
        System.out.println("-------------------------------------------------------------"); 
        System.out.println("\t Welcome to Waffle&Pancake Sweets System "); //Printing the header
        System.out.println("-------------------------------------------------------------");
        mainMenu(); //calling mainMenu method
        System.out.print("Enter the choice : "); 
        order=keyboard.nextInt(); //reads the input(order number) of type integer
        
        switch(order){
           case 1:
           sweetType="Waffle";
           System.out.print("Enter the number of Pieces : "); 
           Pieces=keyboard.nextInt(); //reads the input(number of pieces)of type integer
           price=10*Pieces;
           letter='n';
           break;
           
           case 2:
           sweetType="Pancake";
           System.out.print("Enter the number of Pieces : "); 
           Pieces=keyboard.nextInt(); //reads the input(number of pieces)of type integer
           price=5*Pieces;
           letter='n'; //to make sure the user will not re-enter the program
           break;
           
           case 3:
           System.out.println("Program ended, Thank you");
           break;
           
           default:
           System.out.println("Sorry! wrong input");
        }
            keyboard.nextLine(); // Consume the new line
            if(order!=3&&Pieces<=0){
            System.out.println("Try Again (Y / N)? ");
            input=keyboard.nextLine(); //reads the input of type string
            letter=input.charAt(0); //reads the first character 
            switch(letter){ 
                case 'Y':
                case 'y':
                    break;
                case 'N':
                case 'n':
                    System.out.println("Program ended, Thank you"); 
                    break; 
            }//end of nested switch
        }//end of if
    }while(letter != 'N'&& letter != 'n'); //condition to enable the user to re-enter the loop 
      
    //condition to make sure that the user has chosen one of the valid options
    if(sweetType=="Waffle"||sweetType=="Pancake"){
    System.out.println("-------------------------------------------------------------");
    System.out.println("\t\t    Choose the Souse "); //Printing the header
    System.out.println("-------------------------------------------------------------");
    sousesMenu(); //calling sousesMenu method
    System.out.print("Enter the Choice No. : "); 
    souses=keyboard.nextInt(); //reads the input(number of souse option)of type integer
        switch(souses){
            case 1:
            {souseType="Chocolate souse";
              price+=2;}
              break;
            case 2:
            {souseType="Honey souse";
                price+=2; }
                break;
            case 3:
            {souseType="Carmel souse";
                price+=2;}
                break;     
            case 4:
            {souseType="Pistatio souse";
                price+=2; }
                break;    
            case 5:
            {souseType="No souse";
               price+=0; }
               break; 
            default:
            { System.out.println("Sorry! Wrong Input, Exiting the program");  
              break; }
        }//end of switch(souses) 
    
    //condition to make sure that the user has chosen one of the valid options 
    if(souses<=5&&souses>=0){
    System.out.println("-------------------------------------------------------------");
    System.out.println("\t\t    Choose the Toppings "); //Printing the header
    System.out.println("-------------------------------------------------------------");
    toppingsMenu(); //calling toppingsMenu method
    System.out.print("Enter the Choice No. : "); 
    toppings=keyboard.nextInt(); //reads the input(number of topping option)of type integer
    
        switch(toppings){
        case 1:
        {toppingType="strawberry";
            price+=5;
            break;}
        case 2:
        {toppingType="banana";
           price+=5;
           break;}
        case 3: 
        {toppingType="nuts";
           price+=3;
           break;}
        case 4:
        {toppingType="ice cream"; 
           price+=10; 
           break; }
        /*I added ice cream option according to the table of souses(it wasn't listed with run samples)
        so there option no.4 indicates to ice cream while option no.5 indicates to no addings */
        case 5:
        {toppingType="No addings";
           price+=0;
           break; }
        default:
        { System.out.println("Sorry! Wrong Input, Exiting the program");  
         break; }
    }//end of switch(toppings)
    
    //condition to make sure that the user has chosen one of the valid options
    if(toppings<=5&&toppings>=0){
        
      if("Waffle".equals(sweetType)&&Pieces>5){
        discount=0.10;
       } //end of nested if
      else if("Pancake".equals(sweetType)&&Pieces>10){
        discount=0.10;
      } //end of else if(nested)
    
  
    //To calculate the amount of tax
    totalTax=(TAX_RATE*(price-(price*discount))); 
    //To calculate the total price including tax and discount
    totalPrice=totalTax+(price-(price*discount)); 
    //Note: discount and tax applied on the total price(after adding the Souses and toppings price)
    
    
    //   -----------------printing the summary of the order---------------------
    System.out.println("-------------------------------------------------------------");
    System.out.println("\t\t    your order information ");
    System.out.println("-------------------------------------------------------------");
    System.out.printf("\nsweet type: %s\t Number of pieces: %d"
    +"\nsouses: %s\t Toppings: %s",sweetType,Pieces,souseType,toppingType);
    System.out.printf("\nDiscount: %.0f%% \t\t Tax : %.0f%%" 
            +"\nTotal Price: %.2f SR\n",discount*100,TAX_RATE*100,totalPrice);
    
       }//end of toppings if (3rd if)
      }//end of souses if (2nd if)
     }//end of upper if (1st if)
    }//end of main
    
    /**
     *  mainMenu method -> void(does not return any value) and has no parameters 
     *  just prints the main menu for the user to start an order
     */
    public static void mainMenu(){
    System.out.println("\t Enter \"1\" for Waffle");
    System.out.println("\t Enter \"2\" for Pancake");
    System.out.println("\t Enter \"3\" for Exiting the program\n");
    }//end of mainMenu
    
    /**
     *  sousesMenu method -> void(does not return any value) and has no parameters 
     *  just prints the menu of souse options for the user to choose from
     */
    public static void  sousesMenu(){
    System.out.println("\t 1:Chocolate souse \n\t 2:Honey souse");
    System.out.println("\t 3:Carmel souse \n\t 4:Pistatio souse");
    System.out.println("\t 5:No souse");
    }//end of sousesMenu
    
    /**
     *  toppingsMenu method -> void(does not return any value) and has no parameters 
     *  just prints the menu of toppings options for the user to choose from
     */
    public static void toppingsMenu(){
    System.out.println("\t 1:strawberry \n\t 2:banana");
    System.out.println("\t 3:nuts \n\t 4:ice cream ");
    System.out.println("\t 5:No addings");   
    /*I added ice cream option according to the table of souses(it wasn't listed with run samples)
     so there option no.4 indicates to ice cream while option no.5 indicates to no addings */
    }//end of toppingsMenu
}//end of class 
