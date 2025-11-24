import java.util.Scanner;

public class RockPaperScissorsStats {

    // Get computer choice using Math.random()
    public static String getComputerChoice() {
        int r = (int) (Math.random() * 3); // 0,1,2
        if (r == 0) return "rock";
        if (r == 1) return "paper";
        return "scissors";
    }

    // Determine winner: 0 = tie, 1 = player wins, 2 = computer wins
    public static int findWinner(String player, String computer) {
        if (player.equals(computer)) return 0;

        switch (player) {
            case "rock":
                return (computer.equals("scissors")) ? 1 : 2;
            case "paper":
                return (computer.equals("rock")) ? 1 : 2;
            case "scissors":
                return (computer.equals("paper")) ? 1 : 2;
            default:
                return 2; // if invalid player input, treat as computer wins
        }
    }

    // Build stats table [Name, wins, percentage]
    public static String[][] buildStatsTable(int playerWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][3];

        double playerPercent = totalGames == 0 ? 0 : (playerWins * 100.0) / totalGames;
        double computerPercent = totalGames == 0 ? 0 : (computerWins * 100.0) / totalGames;

        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.valueOf(playerPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf(computerPercent);

        return stats;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many games do you want to play? ");
        int games = sc.nextInt();
        sc.nextLine(); // consume newline

        int playerWins = 0;
        int computerWins = 0;
        int ties = 0;

        System.out.println("\nGame\tPlayer\tComputer\tResult");
        System.out.println("----------------------------------------");

        for (int i = 1; i <= games; i++) {
            String playerChoice;

            // Get valid player choice
            while (true) {
                System.out.print("Game " + i + " - Enter rock/paper/scissors: ");
                playerChoice = sc.nextLine().toLowerCase();
                if (playerChoice.equals("rock") || playerChoice.equals("paper") || playerChoice.equals("scissors")) {
                    break;
                } else {
                    System.out.println("Invalid choice, try again.");
                }
            }

            String compChoice = getComputerChoice();
            int result = findWinner(playerChoice, compChoice);

            String resultText;
            if (result == 0) {
                ties++;
                resultText = "Tie";
            } else if (result == 1) {
                playerWins++;
                resultText = "Player Wins";
            } else {
                computerWins++;
                resultText = "Computer Wins";
            }

            System.out.println(i + "\t" + playerChoice + "\t" + compChoice + "\t\t" + resultText);
        }

        System.out.println("\nTies: " + ties);

        String[][] stats = buildStatsTable(playerWins, computerWins, games);

        System.out.println("\nWin Statistics:");
        System.out.println("Name\tWins\tWin %");
        System.out.println("---------------------------");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }
}
