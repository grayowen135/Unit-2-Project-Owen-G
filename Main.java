import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

class Main {

  // TRYING to start a gui //
  public static void GUI(String[] args) {
    JFrame frame = new JFrame ("Iventory");
  }

  // Initializing Lists and variables // 
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    byte i = 0;
    System.out.println("Enter how many items you want.");
    byte item_numb = input.nextByte();
    ArrayList<String> list_name = new ArrayList<String>();
    ArrayList<Float> list_price = new ArrayList<Float>();
    ArrayList<Byte> list_quantity = new ArrayList<Byte>();

    // Adding The File //
    File saved_inventory = new File("Saved_Inventory.txt");
    saved_inventory.createNewFile();
    FileWriter write_file = new FileWriter("Saved_Inventory.txt");

    // Entering the Loop //
    System.out.println("What would you like to do? \nA. Add Items \nB. Show current inventory \nC. Exit");
    char choice_select = input.next().charAt(0);
    char choiceSelectCaps = Character.toUpperCase(choice_select);
    while (choiceSelectCaps != 'D') {

      // Adding Items //
      if (choiceSelectCaps == 'A') {
        for (i = 0; i < item_numb; i++) {
          System.out.println("Enter the name of item " + (i + 1));
          input.nextLine();
          String add_name = input.nextLine();
          list_name.add(add_name);
          System.out.println("Enter the price of item " + (i + 1));
          float add_price = input.nextFloat();
          list_price.add(add_price);
          System.out.println("Enter the quantity of item " + (i + 1));
          byte add_quantity = input.nextByte();
          list_quantity.add(add_quantity);
          write_file.write(list_name.get(i) + ": $" + list_price.get(i) + ", there are " + list_quantity.get(i) + " in inventory.\n");
        }
        write_file.close();
        System.out.println("What would you like to do? \nA. Add Items \nB. Show current inventory \nC. Exit");
        choice_select = input.next().charAt(0);
        choiceSelectCaps = Character.toUpperCase(choice_select);
      } 

      // Show w/ Tax //
      else if (choiceSelectCaps == 'B') {
        System.out.println("Which item would you like to calculate tax for?");
        byte itemToTax = input.nextByte();
        float item_taxed = ((list_price.get(itemToTax))*1.13f);
        System.out.println(item_taxed);
        System.out.println("What would you like to do? \nA. Add Items \nB. Show current inventory \nC. Exit");
        choice_select = input.next().charAt(0);
        choiceSelectCaps = Character.toUpperCase(choice_select);
      }

      // Show Inventory //
      else if (choiceSelectCaps == 'C') {
        Scanner myReader = new Scanner(saved_inventory);
        while (myReader.hasNextLine()) {
          String file_out = myReader.nextLine();
          System.out.println(file_out);
        }
        myReader.close();
        System.out.println("What would you like to do? \nA. Add Items \nB. Show current inventory \nC. Exit");
        choice_select = input.next().charAt(0);
        choiceSelectCaps = Character.toUpperCase(choice_select);
      }
    }
  }
}