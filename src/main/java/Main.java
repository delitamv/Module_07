import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        TradeShop tradeShop = new TradeShop();
        CreatingJson creatingJson = new CreatingJson();
        System.out.println("Task_1: ");
        // load
        tradeShop.addFruits("File_Supply1.json");
        tradeShop.addFruits("File_Supply2.json");
        tradeShop.addFruits("File_Supply3.json");
        tradeShop.addFruits("File_Supply4.json");

        // show DataBase
        System.out.println("\n" + "DataBase ");
        tradeShop.print(tradeShop.getFruits());

        // save DataBase to file
        tradeShop.save("File_DataBase.json");

        // load DataBase
        tradeShop.load("File_DataBase.json");

        // show DataBase
        System.out.println("\n" + "DataBase ");
        tradeShop.print(tradeShop.getFruits());

        System.out.println("\n" + "Task_2: ");
        Date date = Dates.convertStringToDate("25/11/2018");
        List<Fruit> fruitsSpoiled = tradeShop.getSpoiledFruits(date);
        System.out.println("List of spoiled fruits:");
        tradeShop.print(fruitsSpoiled);


        // List of fruits available on date
        List<Fruit> fruitAvailable = tradeShop.getAvailableFruits(date);

        // print List of fruits available
        System.out.println("\n" + "List of fruits available: ");
        tradeShop.print(fruitAvailable);


        System.out.println("\n" + "Task_3: ");
        Fruit.Type fruitType = Fruit.Type.CHERRY;

        // get list of fruits spoiled on date
        List<Fruit> fruitsSpoil = tradeShop.getSpoiledFruits(date, fruitType);

        // show list
        System.out.println("\n" + "List of spoiled fruits:");
        tradeShop.print(fruitsSpoil);

        fruitType = Fruit.Type.KIWI;
        List<Fruit> fruitAvail = tradeShop.getAvailableFruits(date, fruitType);
        System.out.println("\n" + "List of fruits KIWI available on date ");
        tradeShop.print(fruitAvail);

        // check supply on specific date
        Date date1 = Dates.convertStringToDate("09/11/2018");
        List<Fruit> fruitsCheck = tradeShop.getAddedFruits(date1);
        System.out.println("\n" + "List of fruits added on " + date1);
        tradeShop.print(fruitsCheck);

        // check supply
        fruitType = Fruit.Type.ORANGE;
        fruitsCheck = tradeShop.getAddedFruits(date1, fruitType);
        System.out.println("\n" + "List of fruits ORANGE added on ");
        tradeShop.print(fruitsCheck);
    }
}
