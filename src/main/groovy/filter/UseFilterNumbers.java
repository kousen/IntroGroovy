package filter;

public class UseFilterNumbers {
    public static void main(String[] args) {
        FilterNumbers filterNumbers = new FilterNumbers();
        System.out.println(filterNumbers.findPositives(-1, -2, 1, 2, 3));
        System.out.println(filterNumbers.findPositives(1, 2, 3));
        System.out.println(filterNumbers.findPositives(-1, -2, -3, -4));
    }
}
