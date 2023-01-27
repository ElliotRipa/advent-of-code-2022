import java.util.ArrayList;

public class day02 {

    public static void main(String[] args) {

        ArrayList<String> input = FileReader.readFile(".\\input\\day02input.txt");

        char opponentChoice;
        char playerChoice;
        int totalScore = 0;

        for (String line : input) {
            opponentChoice = line.charAt(0);
            playerChoice = line.charAt(2);
            totalScore +=roundResult(opponentChoice, playerChoice);

        }

        System.out.println(totalScore);

    }

    public static int roundResult(char opponent, char player) {
        int result = (player - opponent) % 3;

        int playerScore = 0;

        switch (result){
            case 0:                     // 0 -> Win -> 6 pts.
                playerScore = 6;
                break;
            case 1:                     // 1 -> Loss -> 0 pts.
                playerScore = 0;
                break;
            case 2:                     // 2 -> Draw -> 3 pts.
                playerScore = 3;
                break;
        }

        switch (player % 3) {
            case 0:                     // 0 -> Scissors -> 3 pts.
                playerScore += 3;
                break;
            case 1:                     // 1 -> Rock -> 1 pt.
                playerScore += 1;
                break;
            case 2:                     // 2 -> Paper -> 2 pts.
                playerScore += 2;
                break;
        }

        return playerScore;
    }

}
