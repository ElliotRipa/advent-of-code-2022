import java.util.ArrayList;

public class day02 {

    public static void main(String[] args) {

        ArrayList<String> input = FileReader.readFile(".\\input\\day02input.txt");

        char opponentChoice;
        char result;
        char playerChoice;
        int totalScore = 0;

        for (String line : input) {
            opponentChoice = line.charAt(0);
            result = line.charAt(2);

            playerChoice = getPlayerChoice(opponentChoice, result);

            totalScore +=roundResult(opponentChoice, playerChoice);

        }

        System.out.println(totalScore);

    }


    public static char getPlayerChoice(char opponent, char result) {

        int playerChoiceInt = Math.floorMod(result, 3);
        char playerChoiceChar;

        switch (playerChoiceInt) {
            case 0:
                playerChoiceChar = (char) (Math.floorMod(opponent, 3));       //Win
                break;
            case 1:
                playerChoiceChar = (char) ((Math.floorMod(opponent, 3))+1);       //Lose
                break;
            case 2:
                playerChoiceChar = (char) ((Math.floorMod(opponent, 3))+2);         //Draw
                break;
            default:
                playerChoiceChar = 'E';
                break;
        }

        return playerChoiceChar;
    }


    public static int roundResult(char opponent, char player) {
        int result = Math.floorMod((player - opponent), 3);

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

        switch (Math.floorMod(player, 3)) {
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
