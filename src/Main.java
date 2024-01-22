import java.util.*;

public class Main {
    private static ArrayList<String> groceryList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
           int option;

        do {
            printMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                        case 1:
                        System.out.println("Eklemek istediğiniz ürünü giriniz");
                        addItems();
                        break;
                        case 2:
                        System.out.println("Çıkarmak istediğiniz ürünü giriniz");
                        removeItems();
                        break;
                        case 0:
                        System.out.println("Uygulama kapatıldı.");
                        break;
                        default:
                        System.out.println(option + ", is not valid");
                        break;
                }
            } while (option != 0);
        }

    public static void printMenu(){
        System.out.println("0: Uygulamayı Sonlandır");
        System.out.println("1: Ürün Ekle");
        System.out.println("2: Ürün Çıkar");
    }
    public static void addItems(){
        String line = scanner.nextLine();;
        String[] addedGroceries = line.split(",");
        for(String grocery: addedGroceries){
            if(!checkItem(grocery)){
                groceryList.add(grocery);
                Collections.sort(groceryList);
                System.out.println(grocery + " added to List");
            } else {
                System.out.println("Bu ürün zaten listede bulunuyor");
            }

        }
        System.out.println("Grocery List: " + groceryList);

    }
    public static void removeItems(){
        String line = scanner.nextLine();
        String[] removedGroceries = line.split(",");
        for (String grocery: removedGroceries){
          if(checkItem(grocery)){
                groceryList.remove(grocery);
                Collections.sort(groceryList);
                System.out.println(grocery + " removed from List");

            } else {
                System.out.println("Listede böyle bir ürün yok.");
            }

        }
        System.out.println("Grocery List: " + groceryList);
    }

    public static boolean checkItem(String item){
        return groceryList.contains((item));
    }

    }

