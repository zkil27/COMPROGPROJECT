import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        //Mga Variables
        boolean ordering = true;
        int choice , numRecipt = 0;
        String userName;
        String firstOrder = "(Mag mcdo nalang kami)";
        int randomName = (int)(Math.random() * 12);// Nag Gegenerate ng RNG para iba iba yung waiter mo
        Scanner scan = new Scanner(System.in);

        // Kung nasaan yung mga Arrays
        String[] listName = {"Kiel", "Kylde", "Chan", "Ej", "Matt", "Riri", "Gette", "Cj", "Wency", "Nicco", "Althea", "Boy Dagul"};
        String[] listDish = {"Kiełbasa en Moutarde", "Klyde au Poulete", "Chanterelle aux Noisettes", "Eclairs de Jambon", "Matelote de Poisson", "Rôti de Roberto", "Riz de la Reine", "Galette de Gette"};
        int[] listDishPrices = {150, 120, 130, 100, 120, 100, 120, 100};
        String[] listDessert = {"Crêpes Jamboree", "Wensy Madeleine", "Nicoise Tarte", "Althéa Parisienne", "Biscuit Dagul", "Chambre de Chocolat", "Dôme de Meringue Dominador", "Anastasia Tarte"};
        int[] listDessertPrices = {250, 220, 230, 200, 220, 200, 220, 200};
        String[] listDrinks = {"Rafraîchissement Rodrigo", "Tisane Sora", "Margarita au Negrita", "Daiquiri Jonathan", "Aril Fizz", "Pamplemousse Cacao", "Mojito Rose", "Joselito Jus de Litch"};
        int[] listDrinksPrices = {50, 20, 30, 5, 20, 111, 20, 30};
        String[] listPayment = {"Cash", "Debit Card", "Credit Card", "Gcash", "Paymaya", "PayPal"};
        double[] listFee = {0, 0, .5, .05, .005, .0005};

        String[] shoppingCart = new String[100];
        int[] shoppingTotal = new int[100];
        int[] shoppingCost = new int[100];

        // D2 magiistart yung resto
        System.out.println("Welcome to La Famille Caldo! My name is " + listName[randomName] + " , and I will be your serveur personnel for tonight");
        System.out.print("I would like to know your name, s'il vous plaît: ");
        userName = scan.nextLine();
        System.out.println("\nNice to meet you, " + userName + "! Voici notre menu\n");

            // Do while loop to, magloop siya hanggang sa mag decide ka na na ayaw mo na mag order, which is yung case 4
        do {
            if(numRecipt != 0){
                anolang();
            }
            System.out.println("___________________________  La Famille Caldo  _________________________________\n");
            System.out.println("1. Dish" +
                                "\n2. Dessert" +
                                "\n3. Drinks" +
                                "\n\n4. " +  firstOrder);
            System.out.println("\n_________________  Savor the warmth, partagez la joie.  ________________________");


            System.out.print("\n\n\n\n\n\nReady to order? Just type the number of your selection here: ");
            choice = scan.nextInt();

            // Yung Switch Case nama yung bahala para makapili tayo kung Dish, Desserts or Drinks ba yung bibilhin natin
            // Ginawa ko lang jan is inaba ko lang yung variables na nilagay ko sa parameters
            switch (choice) {
                case 1:
                    hahahaha(scan, listDish, userName, shoppingCost, shoppingTotal, shoppingCart, numRecipt, listDishPrices);
                    numRecipt ++;
                    break;
                case 2:
                    hahahaha(scan, listDessert, userName, shoppingCost, shoppingTotal, shoppingCart, numRecipt, listDessertPrices);
                    numRecipt ++;
                    break;
                case 3:
                    hahahaha(scan, listDrinks, userName, shoppingCost, shoppingTotal, shoppingCart, numRecipt, listDrinksPrices);
                    numRecipt ++;
                    break;
                case 4:
                    if(numRecipt == 0) { //checheck kung 1st time palang mag oorder
                        ordering = false;
                        System.out.println("Thank you for visiting La Famille Caldo. Merci for stopping by!");
                    } else {
                        anolang();
                        ykona(scan, shoppingCart, userName, shoppingTotal, numRecipt, shoppingCost, listFee, listPayment);
                        ordering = false;
                    }
                    break;
                default:
                    System.out.println("Sir/Ma'am, " + userName + ", you can only choose 1 to 6, s'il vous plaît.");
                    break;
            }
            firstOrder = "I think I've ordered enough, laissez-moi voir ma receipt.";
        } while (ordering);
    }
    //D2 yung mga maangas na function
    // Yung function na to yung mag kukuhan ng information satin at mag iistore n2
    public static void hahahaha(Scanner scan, String foodArray[], String name, int costArray[], int totalArray[], String cartArray[], int loopCount, int priceArray[]){
        anolang();
        System.out.println("___________________________  La Famille Caldo  _________________________________\n");

        for (int i = 0; i  < foodArray.length; i++){
            System.out.println((i + 1) + ". " + foodArray[i] + " ----- ₱" + priceArray[i]);
        }

        System.out.println("\n_________________  Savor the warmth, partagez la joie.  ________________________");


        System.out.println("\n\n\n\n\n\nYou currently have " + loopCount + " food ordered, Sir/Ma'am " + name + ".");
        System.out.print("Is there anything else you want, Sir/Ma'am, " + name + "? Qu'est-ce que vous désirez? ");
        int userChoice = scan.nextInt() - 1;
        while (userChoice < 0 || userChoice >= foodArray.length) { //D2 checheck kung valid ba yung number na nilagay mo
            System.out.print("Ah, " + name + ", your choices are limited to 1 through 8, s'il vous plaît! ");
            userChoice = scan.nextInt() - 1;
        }
        System.out.print("How many of " + foodArray[userChoice] + " would you like, Sir/Ma'am " + name + "? Combien en voulez-vous? ");
        int quantity = scan.nextInt();

        // Sa mga Arrays na to iststore yung mga values na iinput natin
        //cartArray for yung name ng pagkain, total is for ilan yung oorderin natin sa pagkain na yon, at costArray naman is para pang store sa presyo neto na gagamitin natin pang compute later
        cartArray[loopCount] = foodArray[userChoice];
        totalArray[loopCount] = quantity;
        costArray[loopCount]  = priceArray[userChoice];
    }

    // this function naman is para sa pag print, calculate, at pagkuha ng bayad satin para sa resib
    public static void ykona(Scanner scan, String cartArray[], String name, int totalArray[], int loopCount, int priceArray[] , double conviArray[], String paymentArray[]) {
        double subTotal = 0;
        double taxAdd = 0.15;

        // pang display ng time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        String formattedDate = date.format(formatter);

        // dito cacalculate yung subtotal by multipying yung index "i" na price sa corresponding "i" neto sa total. loloop niya naman yung statement "loopCount" number of times which is kung ilan yung items na inorder mo,
        for (int i = 0; i < loopCount; i++) {
            subTotal += totalArray[i] * priceArray[i];
        }
        double Total = subTotal * (1 + taxAdd);

        //dito ka na magbabayad
        System.out.println("___________________________  La Famille Caldo  _________________________________\n");

        for (int i = 0; i  < paymentArray.length; i++){
            System.out.println((i + 1) + ". " + paymentArray[i]);
        }
        System.out.println("______________________________   PAYMENT  _______________________________________\n");
        System.out.printf("\n\n\n\n\n\nYour total amount without convenience fee is ₱%.2f\n", Total);
        System.out.print("What mode of Payment do you prefer Sir/Ma'am " + name + "? ");
        int paymentMode = scan.nextInt() - 1;
        while (paymentMode < 0 || paymentMode >= paymentArray.length) { //D2 checheck kung valid ba yung number na nilagay mo
            System.out.print("Ah, " + name + ", your choices are limited to 1 through 4, s'il vous plaît! ");
            paymentMode = scan.nextInt() - 1;
        }
        double conviFee = Total * conviArray[paymentMode];
        double totalwFee = Total + conviFee;

        System.out.print("\n\nUsing " + paymentArray[paymentMode] + " will have "); System.out.printf("%.0f", (conviArray[paymentMode] * 100 )); System.out.println("% convenience fee."); System.out.printf("Which totals you to ₱%.2f\n", totalwFee);
        System.out.println("Please enter the amount of payment here, Sir. Quel montant souhaitez-vous payer? ");
        System.out.print("================ ₱");
        double Payment = scan.nextDouble();


        double Change = Payment - totalwFee;
        while (!(Change >= 0)) {
            System.out.printf("\nInsufficient payment, please enter another amount of payment. Il vous reste encore ₱%.2f à payer, ", Math.abs(Change)); System.out.print(name);
            System.out.print("\n================ ₱");
            Payment = scan.nextDouble();
        }
        System.out.printf("\nWe receive: ₱%.2f", Payment);
        System.out.printf("\nTotal Amount is: ₱%.2f", totalwFee);
        System.out.printf("\nYour Change is: ₱%.2f", Change); // Display change

        // Priprint mo na yung resibo
        System.out.println("\n\n\n___________________________  La Famille Caldo  _________________________________\n");
        System.out.println("\nDate:  " + formattedDate);
        System.out.println("Guest: " + name + "\n");

        // Loloop niya yung statement "loopCount" amount of times para ma display niya lahat ng inorder mo na naka store sa "shopping arrays"
        // Yung "i" is yung value na iincrement na gagamitin natin para ma display lahat ng inorder natin,
        // sample, sa unang run value ng i is zero so cartArray[0], totalArray[0] at priceArray[0] muna yung ma priprint, then kada loop mag iincrement yung i displaying naman yung ibang index ng mga arrays
        // may i + 1 tayo sa numbering para hindi mag start sa zero yung number
        for (int i = 0; i < loopCount; i++) {
            System.out.println((i + 1) + ". " + cartArray[i] + " --  QTY: " + totalArray[i] + "  --  PRICE: ₱" + (priceArray[i] * totalArray[i]));
        }
        System.out.println("\nPayment Method                              " + paymentArray[paymentMode]);
        System.out.printf("\nSubtotal:                                   ₱%.2f", subTotal);
        System.out.printf("\nTax:                                        ₱%.2f\n", subTotal * taxAdd);
        System.out.print("Convenience fee:                            "); System.out.printf("₱%.2f ", conviFee);
        System.out.println("\n________________________________________________________");
        System.out.printf("\nTotal:                                      ₱%.2f\n\n", totalwFee);
        System.out.println("\n\n_________________  Merci de votre visite, La Famille Caldo  ____________________");
    }
    public static void anolang(){
        for (int i = 0; i < 50; i++){
            System.out.println("\n\n\n\n\n");
        }
    }
}
