import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter the number of players: ");
        try (Scanner s = new Scanner(System.in)) {
            n = s.nextInt();
        }
        guess game=new guess();
        game.start(n);
    }
}