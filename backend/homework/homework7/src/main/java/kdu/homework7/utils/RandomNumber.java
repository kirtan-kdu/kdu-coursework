package kdu.homework7.utils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomNumber {
    private static final Random random = new SecureRandom();
    private RandomNumber(){

    }
    public static int generate(int range){
        return random.nextInt(range);
    }
}
