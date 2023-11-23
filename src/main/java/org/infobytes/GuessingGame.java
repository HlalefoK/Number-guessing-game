package org.infobytes;

public class GuessingGame {
    private final String code;
    private final Player player;

    public GuessingGame(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
        this.player = player;

    }
    public GuessingGame(){
        this(new CodeGenerator(), new Player());
    }

    public void runGame(){
        System.out.println("3-digit Code has been set. Digits in range 1 to 9. You have 12 turns to break it.");
//        CodeGenerator generator = new CodeGenerator();
//        String code = generator.generateCode();

        while (player.getNumGuesses() > 0) {
            String guess = player.getGuess();

            player.lose();
            int correctNumber = 0;
            int correctPosition = 0;
            for (int i = 0; i < guess.length(); i++) {
                char guessNumber = guess.charAt(i);
                if (guessNumber == code.charAt(i)) {
                    correctPosition++;
                } else if (code.indexOf(guessNumber) != -1) {
                    correctNumber++;
                }
            }
            if (guess.equals(code)) {
                System.out.println("Number of correct digits in correct place: " + correctPosition);
                System.out.println("Number of correct digits not in correct place: " + correctNumber);
                System.out.println("Congratulations! You are a codebreaker!");
                System.out.println("The code was: " + code);
                return;
            }
            System.out.println("Number of correct digits in correct place: " + correctPosition);
            System.out.println("Number of correct digits not in correct place: " + correctNumber);
            if (player.getNumGuesses() > 0) {
                System.out.println("Turns left: " + player.getNumGuesses());}

        }
        System.out.println("No more turns left.");
        System.out.println("The code was: " + code);
    }

    public static void main(String[] args){
        GuessingGame game = new GuessingGame();
        game.runGame();
    }
}

