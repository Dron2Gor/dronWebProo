package beans;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private HashMap<Integer, Integer> basket;

    public Basket() {
    basket=new HashMap<>();
    }

    public HashMap<Integer, Integer> getBasket() {
        return basket;
    }
    public void setBasket(HashMap<Integer, Integer> basket) {
        this.basket = basket;
    }

    public void addProductToBasket(int idProduct) {
        if (basket.containsKey(idProduct)) {
            int count = basket.get(idProduct);
            basket.replace(idProduct, count + 1);
        } else basket.put(idProduct, 1);
    }
    public void removeProductFromBasket(int  idProduct){
        if (basket.containsKey(idProduct))
            basket.remove(idProduct);
    }
    public int getAmountProductsInBusket(){
        int amount=0;
        for (Map.Entry<Integer,Integer> pair:basket.entrySet()){
            amount+=pair.getValue();
        }
        return  amount;
    }
}
