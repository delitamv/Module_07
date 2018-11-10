import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatingJson {
    private String[] date = {"06/11/2018",
                            "07/11/2018",
                            "08/11/2018",
                            "09/11/2018"};

    public CreatingJson() throws IOException {
        generateSupplyFiles();
    }

    private void generateSupplyFiles() throws IOException {
        for(int i = 0; i < date.length; i++) {
            List<Fruit> fruitsList = new ArrayList<>();
            fruitsList.add(new Fruit (Fruit.Type.STRAWBERRY, 10, date[i], 100));
            fruitsList.add(new Fruit (Fruit.Type.APPLE, 30, date[i], 10));
            fruitsList.add(new Fruit (Fruit.Type.PEAR, 10, date[i], 10));
            fruitsList.add(new Fruit (Fruit.Type.KIWI, 25, date[i], 30));
            fruitsList.add(new Fruit (Fruit.Type.GRAPES, 20, date[i], 80));
            fruitsList.add(new Fruit (Fruit.Type.ORANGE, 30, date[i], 25));
            fruitsList.add(new Fruit (Fruit.Type.PEACH, 15, date[i], 90));
            fruitsList.add(new Fruit (Fruit.Type.TANGERINE, 28, date[i], 35));
            fruitsList.add(new Fruit (Fruit.Type.MELON, 22, date[i], 80));
            fruitsList.add(new Fruit (Fruit.Type.CHERRY, 5, date[i], 150));
            String json = JSON.toJSONString(fruitsList);
            try {
                Files.writeToFile(json, "File_Supply" + (i+1) + ".json");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
