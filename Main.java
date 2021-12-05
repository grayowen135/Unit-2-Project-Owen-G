import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

class Main {

  // Tax Method //
  public static void myTaxMethod(Object[][] array_all, int itemnumb) {
    array_all[itemnumb][3] = ((float) array_all[itemnumb][1] * 1.13f);
  }

  // Initializing Lists and variables //
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    boolean bool_B = false;
    boolean bool_C = false;
    int itemnumb = 5;
    Object[][] array_all = new Object[itemnumb][5];

    // Adding The File //
    File saved_inventory = new File("Saved_Inventory.txt");
    saved_inventory.createNewFile();
    FileWriter write_file = new FileWriter("Saved_Inventory.txt");

    for (byte i = 0; i < 5; i++) {
      System.out.println("Enter the name of item " + (i + 1));
      array_all[i][0] = input.nextLine();
      if (i != 0) {
        array_all[i][0] = input.nextLine();
      }
      System.out.println("Enter the price of item " + (i + 1));
      array_all[i][1] = input.nextFloat();
      System.out.println("Enter the quantity of the item " + (i + 1));
      array_all[i][2] = input.nextByte();
      while (bool_B == false) {
        System.out.println("Enter the 10 digit product number for the item " + (i + 1));
        array_all[i][4] = input.nextLong();
        try {
          if ((Long.toString((long) array_all[i][4]).length() != 10)) {
            throw new ArithmeticException();
          } else {
            bool_B = true;
          }
        } catch (Exception e) {
          System.out.println("The product number must be 10 digits, please enter a valid number.");
        }
      }
      bool_B = false;

      // Calling Tax Method //
      myTaxMethod(array_all, i);

      // Writing to the File //
        for (byte j = 0; j < 5; j++) {
          write_file.write(array_all[i][j] + "\n");
        }
        if (i == 4) {
          write_file.close();
        }
    }
    // Entering the Loop //
    System.out.println("What would you like to do? \nA. Add an Item \nB. Show current inventory \nC. Exit");
    char choice_select = input.next().charAt(0);
    char choiceSelectCaps = Character.toUpperCase(choice_select);
    while (bool_C == false) {
      try {
        if (choiceSelectCaps != 'A' && choiceSelectCaps != 'B' && choiceSelectCaps != 'C') {
          throw new ArithmeticException();
        } else {
          bool_C = true;
        }
      } catch (Exception e) {
        System.out.println("Not an availible option.");
      }
    }

    while (choiceSelectCaps != 'C') {
      // new GUI(itemnumb, array_all);

      // Adding an Item //
      if (choiceSelectCaps == 'A') {
        itemnumb++;
        byte l = 0;
        System.out.println("Enter the name of the item");
        input.nextLine();
        array_all[l + 5][0] = input.nextLine();
        System.out.println("Enter the price of the item");
        array_all[l + 5][1] = input.nextFloat();
        System.out.println("Enter the quantity of the item");
        array_all[l + 5][2] = input.nextByte();
        while (bool_B == false) {
          System.out.println("Enter the 10 digit product number for the item");
          array_all[l + 5][4] = input.nextLong();
          try {
            if ((Long.toString((long) array_all[l + 5][4]).length() != 10)) {
              throw new ArithmeticException();
            } else {
              bool_B = true;
            }
          } catch (Exception e) {
            System.out.println("The product number must be 10 digits, please enter a valid number.");
          }
        }
        bool_B = false;

        // Calling Tax Method //
        myTaxMethod(array_all, itemnumb);

        // Writing to the File //
        for (byte i = 0; i < itemnumb; i++) {
          for (byte j = 0; j < 5; j++) {
            write_file.write(array_all[i][j] + "\n");
          }
        }
        write_file.close();
        System.out.println("What would you like to do? \nA. Add an Item \nB. Show current inventory \nC. Exit");
        choice_select = input.next().charAt(0);
        choiceSelectCaps = Character.toUpperCase(choice_select);
        while (bool_C == false) {
          try {
            if (choiceSelectCaps != 'A' && choiceSelectCaps != 'B' && choiceSelectCaps != 'C') {
              throw new ArithmeticException();
            } else {
              bool_C = true;
            }
          } catch (Exception e) {
            System.out.println("Not an availible option.");
          }
        }
      }

      // Show Inventory //
      else if (choiceSelectCaps == 'B') {
        Scanner myReader = new Scanner(saved_inventory);
        while (myReader.hasNextLine()) {
          String file_out = myReader.nextLine();
          System.out.println(file_out);
        }
        myReader.close();
        System.out.println("What would you like to do? \nA. Add an Item \nB. Show current inventory \nC. Exit");
        choice_select = input.next().charAt(0);
        choiceSelectCaps = Character.toUpperCase(choice_select);
        while (bool_C == false) {
          try {
            if (choiceSelectCaps != 'A' && choiceSelectCaps != 'B' && choiceSelectCaps != 'C') {
              throw new ArithmeticException();
            } else {
              bool_C = true;
            }
          } catch (Exception e) {
            System.out.println("Not an availible option.");
          }
        }
      }
    }
  }
}