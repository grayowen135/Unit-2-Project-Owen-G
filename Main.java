import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    int i;
    System.out.println("Enter how many items you want.");
    int itemNumb = input.nextInt();
    ArrayList<String> listName = new ArrayList<String>();
    ArrayList<Float> listPrice = new ArrayList<Float>();
    ArrayList<Byte> listQuantity = new ArrayList<Byte>();
    for (i=0; i < itemNumb; i++) {
      System.out.println("Enter the name of item " + (i+1));
      input.nextLine();
      String addName = input.nextLine();
      listName.add(addName);
      System.out.println("Enter the price of item " + (i+1));
      float addPrice = input.nextFloat();
      listPrice.add(addPrice);
      System.out.println("Enter the quantity of item " + (i+1));
      byte addQuantity = input.nextByte();
      listQuantity.add(addQuantity);
      System.out.println("Items Qualities Saved: " + listName.get(i) + " for $" + listPrice.get(i) + " you have " + listQuantity.get(i) + " in inventory.");
    }
  }
}