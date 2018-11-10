import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeShop {
    private List<Fruit> fruits = new ArrayList<>();

    public void addFruits(String pathToJsonFile) throws IOException {
        String json;
        json = Files.readFromFile(pathToJsonFile);
        fruits.addAll(JSON.parseArray(json, Fruit.class));
        System.out.println("Fruits are loaded from " + pathToJsonFile);
    }
// saving DB to file
    public void save(String pathToJsonFile) throws IOException {
        String json = JSON.toJSONString(fruits);
        Files.writeToFile(json, pathToJsonFile);
    }

    public void load(String pathToJsonFile) throws IOException {
        fruits.clear();
        print(fruits);
        addFruits(pathToJsonFile);
    }

    public void print(List<Fruit> fruitList) {
        for(Fruit temp : fruitList) {
            String str = String.valueOf(temp.getType()) + " \t" + temp.getDate() + " \t" + temp.getShelfLife() + " \t" + temp.getPrice();
            System.out.println(str);
        }
    }

    public List<Fruit> getFruits() {
        return fruits;
    }

    public List<Fruit> getSpoiledFruits(Date date) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for(Fruit temp : fruits) {
            Date dateExpiration = Dates.getDateExpiration(temp.getDate(), temp.getShelfLife());
            if(Dates.isSpoiled(dateExpiration, date)) {
                fruitList.add(temp);
            }
        }
        return fruitList;
    }

    public List<Fruit> getAvailableFruits(Date date) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for(Fruit temp : fruits) {
            Date dateExpiration = Dates.getDateExpiration(temp.getDate(), temp.getShelfLife());
            if(!Dates.isSpoiled(dateExpiration, date)) {
                fruitList.add(temp);
            }
        }
        return fruitList;
    }

    public List<Fruit> getSpoiledFruits(Date date1, Fruit.Type fruitType) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for(Fruit temp : fruits) {
            if(temp.getType().equals(fruitType)) {
                Date dateExpiration = Dates.getDateExpiration(temp.getDate(), temp.getShelfLife());
                if(Dates.isSpoiled(dateExpiration, date1)) {
                    fruitList.add(temp);
                }
            }
        }
        return fruitList;
    }

    public List<Fruit> getAvailableFruits(Date date, Fruit.Type fruitType) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for(Fruit temp : fruits) {
            if (temp.getType().equals(fruitType)) {
                Date dateExpiration = Dates.getDateExpiration(temp.getDate(), temp.getShelfLife());
                if (!Dates.isSpoiled(dateExpiration, date)) {
                    fruitList.add(temp);
                }
            }
        }
        return fruitList;
    }

    public List<Fruit> getAddedFruits(Date date) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for(Fruit temp : fruits) {
            if(Dates.convertStringToDate(temp.getDate()).equals(date)) {
                fruitList.add(temp);
            }
        }
        return fruitList;
    }

    public List<Fruit> getAddedFruits(Date date, Fruit.Type fruitType) throws ParseException {
        List<Fruit> fruitList = new ArrayList<>();
        for(Fruit temp : fruits) {
            if (temp.getType().equals(fruitType)) {
                if (Dates.convertStringToDate(temp.getDate()).equals(date)) {
                    fruitList.add(temp);
                }
            }
        }
        return fruitList;
    }
}
