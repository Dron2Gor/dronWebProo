package beans;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private HashMap<Integer, Integer> basket;

    public Basket() {
        basket = new HashMap<>();
    }

    public HashMap<Integer, Integer> getBasket() {
        return basket;
    }

    public void addProductToBasket(int idProduct) {
        if (basket.containsKey(idProduct)) {
            int count = basket.get(idProduct);
            basket.replace(idProduct, count + 1);
        } else basket.put(idProduct, 1);
    }

    public void removeOneProductFromBasket(int idProduct) {
        Integer count = basket.get(idProduct)-1;
        if (count == 0) {
            basket.remove(idProduct);
        } else basket.put(idProduct,count);
    }

    public int getAmountProductsInBasket() {
        int amount = 0;
        for (Map.Entry<Integer, Integer> pair : basket.entrySet()) {
            amount += pair.getValue();
        }
        return amount;
    }

}
