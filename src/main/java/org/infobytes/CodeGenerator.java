package org.infobytes;

import java.util.Random;

public class CodeGenerator {
    private final Random random;

    public CodeGenerator(){


        this.random = new Random();
    }

    public CodeGenerator(Random random){
        this.random = random;
    }

    /**
     * Generates a random 3 digit code, using this.random, where each digit is in the range 1 to 9 only.
     * Duplicated digits are allowed.
     * @return the generated 3-digit code
     */
    public String generateCode(){

        StringBuilder code = new StringBuilder();
        for ( int i = 0; i < 3; i++) {
            int number = random.nextInt(9) + 1;
            code.append(number);
        }
        return code.toString();
    }
}

