import java.util.Random;
import java.util.Scanner;

public class CabBookingChatbot {

    static final String[] CAB_NAMES = {"Auto", "Sedan", "SUV"};
    static final int[] CAB_RATES = {12, 18, 25};              // Rs per km

    static final String[] SOURCES = {"Pune Station", "Swargate", "Hinjawadi"};
    static final String[] DESTINATIONS = {"Shivajinagar", "Kothrud", "Wakad"};
    static final int[] DISTANCES = {5, 8, 10};                // km

    static int readChoice(Scanner sc) {
        String line = sc.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=====================================");
        System.out.println("   Welcome to the Cab Booking Chatbot");
        System.out.println("=====================================");

        while (true) {
            System.out.println("\n----------- MAIN MENU -----------");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int mainChoice = readChoice(sc);

            if (mainChoice == 2) {
                System.out.println("\nThank you for using the Cab Booking Chatbot. Goodbye!");
                break;
            } else if (mainChoice != 1) {
                System.out.println("Invalid choice! Please enter 1 or 2.");
                continue;
            }

            System.out.println("\n--- Choose Cab Type ---");
            System.out.println("1. Auto  (Rs." + CAB_RATES[0] + "/km)");
            System.out.println("2. Sedan (Rs." + CAB_RATES[1] + "/km)");
            System.out.println("3. SUV   (Rs." + CAB_RATES[2] + "/km)");
            System.out.print("Enter cab choice: ");
            int cabChoice = readChoice(sc);

            if (cabChoice < 1 || cabChoice > 3) {
                System.out.println("Invalid cab choice! Returning to main menu.");
                continue;
            }
            String cabName = CAB_NAMES[cabChoice - 1];
            int rate = CAB_RATES[cabChoice - 1];

            System.out.println("\n--- Choose Route ---");
            for (int i = 0; i < SOURCES.length; i++) {
                System.out.println((i + 1) + ". " + SOURCES[i] + " to " + DESTINATIONS[i]
                        + " (" + DISTANCES[i] + " km)");
            }
            System.out.print("Enter route number: ");
            int routeChoice = readChoice(sc);

            if (routeChoice < 1 || routeChoice > 3) {
                System.out.println("Invalid route choice! Returning to main menu.");
                continue;
            }
            String source = SOURCES[routeChoice - 1];
            String destination = DESTINATIONS[routeChoice - 1];
            int distance = DISTANCES[routeChoice - 1];

            int fare = rate * distance;

            System.out.println("\n======= RIDE SUMMARY =======");
            System.out.println("Cab Type    : " + cabName);
            System.out.println("Source      : " + source);
            System.out.println("Destination : " + destination);
            System.out.println("Distance    : " + distance + " km");
            System.out.println("Rate        : Rs." + rate + "/km");
            System.out.println("Total Fare  : " + distance + " x " + rate + " = Rs." + fare);
            System.out.println("============================");

            System.out.println("\n1. Confirm & Share OTP");
            System.out.println("2. Cancel Ride");
            System.out.print("Enter your choice: ");
            int confirmChoice = readChoice(sc);

            if (confirmChoice == 2) {
                System.out.println("\nYour ride has been CANCELLED. No OTP was shared.");
                continue;
            } else if (confirmChoice != 1) {
                System.out.println("Invalid choice! Booking not confirmed and no OTP shared. "
                        + "Returning to main menu.");
                continue;
            }

            int otp = 1000 + random.nextInt(9000);   
            System.out.println("\nOTP shared with you: " + otp);
            System.out.println("NOTE: Once the OTP is shared, the ride CANNOT be cancelled.");
            System.out.println("Booking Confirmed! Your " + cabName + " is on the way from "
                    + source + " to " + destination + ".");
        }

        sc.close();
    }
}
