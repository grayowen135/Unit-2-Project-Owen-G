import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

class Main {

  public static void myTaxMethod(Object [][] array_all, byte item_numb) {
    for (int i = 0; i < item_numb; i++) {
    array_all[i][3] = (Float.parseFloat(String.valueOf(array_all[i][1]))*1.13f);
    }
  }

  // Initializing Lists and variables // 
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    byte i = 0; byte j = 0; boolean bool = false; byte item_numb = 0;

    // Making sure item number is greater than or equal to 5 //
    while (bool == false) {
    System.out.println("Enter how many items you want.");
    item_numb = input.nextByte();
      try {
        if (item_numb < 5) {
          throw new ArithmeticException();
        }
        else {
          bool = true;
        }
      }
      catch (Exception e) {
        System.out.println("5 items minimum, please enter a number bigger or equal to 5");
      }
    }

    // Adding The File //
    File saved_inventory = new File("Saved_Inventory.txt");
    saved_inventory.createNewFile();
    FileWriter write_file = new FileWriter("Saved_Inventory.txt");

    // Entering the Loop //
    System.out.println("What would you like to do? \nA. Add Items \nB. Show current inventory \nC. Exit");
    char choice_select = input.next().charAt(0);
    char choiceSelectCaps = Character.toUpperCase(choice_select);

    Object [][] array_all= new Object [item_numb][4];
    while (choiceSelectCaps != 'D') {
      //new GUI(item_numb, array_all);

      // Adding Items //
      if (choiceSelectCaps == 'A') {
        for (i = 0; i < item_numb; i++){
          System.out.println("Enter the name of item " + (i + 1));
          input.nextLine();
          array_all[i][0] = input.nextLine();
          System.out.println("Enter the price of item " + (i + 1));
          array_all[i][1] = input.nextFloat();
          System.out.println("Enter the quantity of item " + (i + 1));
          array_all[i][2] = input.nextByte();
        }

        // Calling Tax Method //
        myTaxMethod(array_all, item_numb);

        // Writing to the File //     
        for (i = 0; i < item_numb; i++) {
          for (j = 0; j < 4; j++) {
            write_file.write(array_all[i][j]+" ");
            System.out.println("\t");
          }
        }
        write_file.close();
        System.out.println("What would you like to do? \nA. Add Items \nB. Show current inventory \nC. Exit");
        choice_select = input.next().charAt(0);
        choiceSelectCaps = Character.toUpperCase(choice_select); 
      }

      // Show Inventory //
      else if (choiceSelectCaps == 'B') {
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