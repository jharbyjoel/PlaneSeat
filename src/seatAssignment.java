import java.util.Scanner;

public class seatAssignment {
    static int filled = 0;

    public static void main(String[] args){

        //multidimensional array
        char[][] seats = new char[7][4];
        //for loop to create the seats
        for(int i = 0; i< 7; i++){
            seats[i][0]='A';
            seats[i][1]='B';
            seats[i][2]='C';
            seats[i][3]='D';
        }
        String seatNumber = "";
        String q = "";
        System.out.println("Below are the available seats for your flight:");
        System.out.println("Please enter the seat you wish to reserve. (ex - 3C)");
        System.out.println("Enter q if you wish to exit.");
        printSeats(seats);
        Scanner scan = new Scanner(System.in);
        seatNumber = scan.nextLine();
        if(seatNumber.equals("q")){
            System.out.println("Program ended");
            System.exit(0);
        }
        while(filled < 28 && seatNumber.length() > 0){
            int row = seatNumber.charAt(0) - '1';
            int col = seatNumber.charAt(1) - 'A';
            if(row < 0 || row > 7 || col < 0 || col > 4){
                System.out.println("Error! Please enter a valid seat. (ex - 1A)");
                seatNumber = scan.nextLine();
                if(seatNumber.equals("q")){
                    System.out.println("Program ended.");
                    System.exit(0);
                }
            } else{
                if(seats[row][col] != 'X'){
                    seats[row][col] = 'X';
                    filled++;
                    System.out.println("");
                    printSeats(seats);
                }
                if(filled < 28){
                    System.out.println(" Please select another seat or q to exit.");
                    seatNumber = scan.nextLine();
                    if(seatNumber.equals("q")){
                        System.out.println("Program ended.");
                        System.exit(0);
                    }
                }
            }
        }
    }
    private static void printSeats(char[][] seats) {
        System.out.println("Row");
        for (int i = 0; i < seats.length; i++) {
            System.out.println((i + 1) + "  " + seats[i][0] + " " + seats[i][1] + "  " + seats[i][2] + " " + seats[i][3]);

        }

    }

}
