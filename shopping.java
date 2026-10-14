public class ShoppingBill {

  
    public static double calculateElectronicsGST(double a, double b) {
        double subtotal = a + b;
        return subtotal + (subtotal * 18 / 100);
    }

  
    public static double calculateFashionGST(double c, double d) {
        double subtotal = c + d;
        return subtotal + (subtotal * 13 / 100);
    }


    public static double calculateFoodGST(double e) {
        return e + (e * 7 / 100);
    }

    public static double totalBill(double a, double b, double c, double d, double e) {
        return calculateElectronicsGST(a, b)
             + calculateFashionGST(c, d)
             + calculateFoodGST(e);
    }

    public static double calculateDiscountedBill(double a, double b, double c, double d, double e) {
        double total = totalBill(a, b, c, d, e);
        double discount = total * 20 / 100;
        return total - discount;
    }

    public static void main(String[] args) {
        double a = 100, b = 100, c = 100, d = 100, e = 100;

        double total = totalBill(a, b, c, d, e);
        double discount = total * 20 / 100;
        double finalAmount = calculateDiscountedBill(a, b, c, d, e);

        System.out.println("Electronics: " + String.format("%.2f", calculateElectronicsGST(a, b)));
        System.out.println("Fashion: " + String.format("%.2f", calculateFashionGST(c, d)));
        System.out.println("Food: " + String.format("%.2f", calculateFoodGST(e)));
        System.out.println("Total after GST = " + String.format("%.2f", total)
                + " | Discount = " + String.format("%.2f", discount)
                + " | Final payable amount = " + String.format("%.2f", finalAmount));
    }
}



/* output :
Electronics: 236.00
Fashion: 226.00
Food: 107.00
Total after GST = 569.00 | Discount = 113.80 | Final payable amount = 455.20*/
