package Datas;

import java.util.Random;

public class RandomText {
    private static final DataUtil data = new DataUtil();
    public static String getRandomText() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = data.readConfig().getLenRandomText();
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}