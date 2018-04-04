package implementation;

public class Checkout {

    int total;

    public void add(int count, int price) {
        total += (price * count);
    }

    public int total() {
        return total;
    }

}
