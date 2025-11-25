import java.util.*;

public class VotingSystem {

    public static void main(String[] args) {

        // Map: candidate → votes
        Map<String, Integer> votes = new HashMap<>();

        // Simulated votes (10 votes)
        String[] castVotes = {
            "Amit", "Riya", "Amit", "Mohan", "Riya",
            "Amit", "Riya", "Amit", "Mohan", "Amit"
        };

        // Count votes
        for (String candidate : castVotes) {
            if (votes.containsKey(candidate)) {
                votes.put(candidate, votes.get(candidate) + 1);
            } else {
                votes.put(candidate, 1);
            }
        }

        // Print total votes
        System.out.println("----- Total Votes -----");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Determine winner
        String winner = "";
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\nWinner: " + winner + " with " + maxVotes + " votes.");
    }
}
