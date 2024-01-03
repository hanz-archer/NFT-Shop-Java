import java.util.Objects;
import java.util.Scanner;
import java.util.InputMismatchException;
public class SystemOOP {
    static char ShopSelector, TokenSelector, ProductInfo, Navigator;
    static Scanner ShopScan = new Scanner(System.in);
    static String register_username, register_password;
    static int ageVerify = 18, userAge;
    static int moon_Price = 18650;
    static void SystemShop(){

        System.out.println("\t**************************************");
        System.out.println("\tWelcome to the Non-Fungible Token Shop");
        System.out.println("\t**************************************");
        try {
            System.out.println("\tPlease Verify Your Age First: ");
            userAge = ShopScan.nextInt();
            if(userAge >= ageVerify){
                Register.RegisterMember();
            }
            else{
                System.out.println("\tYou're a minor you are not allowed here.");
                SystemShop();
            }
        }
        catch(InputMismatchException e){
            System.out.println("\tInput not specified/not age please try again. Thank you.");
            SystemShop();
        }
    }
}
class Register extends SystemOOP{
    static void RegisterMember() {
        Scanner LoginScan = new Scanner(System.in);
        System.out.println("\t**************************************");
        System.out.println("\tRegister Account");
        System.out.println("\tPlease register desired username: ");
        register_username = LoginScan.nextLine();
        System.out.println("\tPlease register desired password: ");
        register_password = LoginScan.nextLine();
        System.out.println("\t**************************************");
        Login();
    }
    static void Login(){
        Scanner LogScan = new Scanner(System.in);
        System.out.println("\tLogin");
        System.out.println("\tPlease Enter Username: ");
        String username = LogScan.nextLine();
        System.out.println("\tPlease Enter Password: ");
        String password = LogScan.nextLine();
        System.out.println("\t**************************************");
        if (Objects.equals(username, register_username) && Objects.equals(password, register_password)) {
            ShopMainMenu.Menu();
        }
        else{
            System.out.println("\tUsername & Password not clear please try logging in again.");
            Login();
        }
    }
}
class ShopMainMenu extends SystemOOP{
    static void Menu() {
        Scanner MenuScan = new Scanner(System.in);
        try {
            System.out.println("\tNon-Fungible Token Shop");
            System.out.println("\t[A]Tokens List for Sale");
            System.out.println("\t[B]My Tokens");
            System.out.println("\t[C]Cart");
            System.out.println("\t[D]My Account Info");
            System.out.println("\t[E]Logout");
            System.out.println("\t**************************************");
            ShopSelector = ShopScan.next().charAt(0);
            if (ShopSelector == 'A') {
                Tokens.TokensInfo();
            }
            if (ShopSelector == 'B') {
                myTokensBought.myTokensBought();
            }
            if (ShopSelector == 'C') {
                Cart.CartList();
            }
            if (ShopSelector == 'D') {
                Account.myInfo();
            }
            if (ShopSelector == 'E') {
                SystemOOP.SystemShop();
            }
        }
        catch (Exception InputMisMatchException){
            System.out.println("Wrong Input");
        }
    }
}
class Tokens extends SystemOOP{
    static void TokensInfo(){
        Scanner TokensScan = new Scanner(System.in);
        System.out.println("\tAvailable Tokens");
        System.out.println("\tCategories:");
        System.out.println("\t[A]Astrophotography");
        System.out.println("\t[B]Cats Photos");
        System.out.println("\t[C]Nature Photos");
        System.out.println("\t[D]Coin Tokens");
        System.out.println("\t[E]Back");
        System.out.println("\t**************************************");
        TokenSelector = TokensScan.nextLine().charAt(0);
        switch(TokenSelector){
            case 'A':
                System.out.println("\tAstro Tokens:");
                System.out.println("\t[A]Moon Shot");
                System.out.println("\t[B]Milky Way Shot");
                System.out.println("\t[C]Moon Shot x80");
                System.out.println("\t[D]Milky Way Shot December");
                ProductInfo = TokensScan.nextLine().charAt(0);
                if(ProductInfo == 'A'){
                    System.out.println("Moon Shot Latest Price: "+moon_Price);
                    System.out.println("This Moon shot was photographed during August 2020 and was put to sale by October 2020");
                    System.out.println("[X] Buy || [Y] Add to Cart [B] Back");
                    Navigator = TokensScan.nextLine().charAt(0);
                    if(Navigator == 'X'){

                    }
                }
                break;

            case 'B':
                System.out.println("\tCat Photo Tokens:");
                System.out.println("\t[A]Orange Cat Picture");
                System.out.println("\t[B]Hitler Faced Cat Picture");
                System.out.println("\t[C]White Cat Picture");
                System.out.println("\t[D]White half orange Cat Picture");
                break;

            case 'C':
                System.out.println("\tNature Photo Tokens:");
                System.out.println("\t[A]Sunset Photo");
                System.out.println("\t[B]Sunrise Shot");
                System.out.println("\t[C]Forest Shot");
                System.out.println("\t[D]Sea Shot");
                break;

            case 'D':
                System.out.println("\tCoin Tokens:");
                System.out.println("\t[A]Bit Coin");
                System.out.println("\t[B]Ethereum");
                System.out.println("\t[C]Dodge Coin");
                System.out.println("\t[D]Stars Coin");
                break;

            case 'E':
                ShopMainMenu.Menu();
                break;
        }

    }
}
class myTokensBought extends Tokens{
    static void myTokensBought(){
        System.out.println("\tMy Tokens Owned");
    }
}
class Cart extends Tokens{
    static void CartList(){
        System.out.println("\tMy Cart");
    }
}
class Account extends SystemOOP{
    static void myInfo(){
        System.out.println("\tMy Account Details");
        System.out.println("\tUsername: "+register_username);
        System.out.println("\tPassword: "+register_password);
    }
}
class Main{
    public static void main(String[] args) {
        SystemOOP So = new SystemOOP();
        SystemOOP.SystemShop();
    }
}