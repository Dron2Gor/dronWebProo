package logic;

public class ServicesForPages {

    private static int step = 2;

    public static int getAmountPages(int amount) {
        if (amount==0) return 0;
        if (amount % step == 0)
            return amount / step;
        else return amount / step + 1;
    }

    public static int getStep() {
        return step;
    }

    public static void main(String[] args) {
        System.out.println(getAmountPages(5));
    }

}
