import java.util.Scanner;

public class pf {
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private static char[][] seats = new char[ROWS][COLUMNS];
    
    public static void main(String[] args) {
        initializeSeats();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Seat Booking System ---");
            System.out.println("1. Display Seating Arrangement");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displaySeating();
                    break;
                case 2:
                    bookSeat(scanner);
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void initializeSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seats[i][j] = 'O'; // 'O' indicates an available seat
            }
        }
    }

    private static void displaySeating() {
        System.out.println("\nCurrent Seating Arrangement:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bookSeat(Scanner scanner) {
        System.out.print("Enter row (0 to " + (ROWS - 1) + "): ");
        int row = scanner.nextInt();
        System.out.print("Enter column (0 to " + (COLUMNS - 1) + "): ");
        int column = scanner.nextInt();

        if (isValidSeat(row, column)) {
            seats[row][column] = 'X'; // 'X' indicates a booked seat
            System.out.println("Seat booked successfully!");
        } else {
            System.out.println("Invalid seat selection or seat already booked!");
        }
    }

    private static void cancelBooking(Scanner scanner) {
        System.out.print("Enter row (0 to " + (ROWS - 1) + "): ");
        int row = scanner.nextInt();
        System.out.print("Enter column (0 to " + (COLUMNS - 1) + "): ");
        int column = scanner.nextInt();

        if (isValidSeat(row, column) && seats[row][column] == 'X') {
            seats[row][column] = 'O'; // Reset to available
            System.out.println("Booking cancelled successfully!");
        } else {
            System.out.println("Invalid seat selection or seat not booked!");
        }
    }

    private static boolean isValidSeat(int row, int column) {
        return row >= 0 && row < ROWS && column >= 0 && column < COLUMNS;
    }
}
