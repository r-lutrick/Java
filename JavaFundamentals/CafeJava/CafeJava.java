public class CafeJava {
    public static void main(String[] args) {
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        double mochaPrice = 3.50;
        double coffeePrice = 2.50;
        double lattePrice = 3.00;
        double cappuccinoPrice = 5.50;

        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        // String customer3 = "Jimmy";
        String customer4 = "Noah";

        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        // boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        // Cindhuri
        if (isReadyOrder1) {
            System.out.println(generalGreeting + customer1 + readyMessage);
        } else {
            System.out.println(generalGreeting + customer1 + pendingMessage);
        }
        // Noah
        if (isReadyOrder4) {
            System.out
                    .println(generalGreeting + customer4 + readyMessage + ". " + displayTotalMessage + cappuccinoPrice);
        } else {
            System.out.println(generalGreeting + customer4 + pendingMessage);
        }
        // Sam
        System.out.println(generalGreeting + customer2);
        double total = lattePrice + lattePrice;
        System.out.println(displayTotalMessage + total);
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
        } else {
            System.out.println(customer2 + pendingMessage);
        }
        // Jimmy
        double difference = coffeePrice - lattePrice;
        System.out.println(difference);

        // Logic testing
        mochaPrice = 4.0;
        coffeePrice = 2.75;
        lattePrice = 3.25;
        cappuccinoPrice = 5;
        System.out.println(mochaPrice + coffeePrice + lattePrice + cappuccinoPrice);
    }
}
