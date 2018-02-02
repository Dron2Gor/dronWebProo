package logic;

import beans.Good;

import java.util.ArrayList;
import java.util.List;

public class ModelForGood {
    List<Good> listOfGoods = new ArrayList<>();

    private void makeListOfGoods() {
        Good good1 = new Good();
        good1.setName("PRODUCT #1");
        good1.setDescription("This is test good. It is very very kind!!!");
        good1.setPrice(88.44);
        good1.setCount(6);
        good1.setArticul(0);

        Good good2 = new Good();
        good2.setName("PRODUCT #2");
        good2.setDescription("This is good #2. It is not very kind!!!");
        good2.setPrice(22.22);
        good2.setCount(4);
        good2.setArticul(1);
        listOfGoods.add(good1);
        listOfGoods.add(good2);

    }

    public Good getGood(int articul) {
        makeListOfGoods();
        return listOfGoods.get(articul);
    }

    public static void main(String[] args) {
        ModelForGood modelForGood = new ModelForGood();
        Good good = modelForGood.getGood(0);
        System.out.println(good.getName());
    }

}
