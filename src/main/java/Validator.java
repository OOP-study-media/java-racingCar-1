import java.util.List;

public class Validator {
    private static final int MAX_NAME_LENGTH = 5;

    public static boolean checkNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH) {
                System.out.println("이름은 5자 이하로 해주세요");
                return false;
            }
            if (name.length() == 0) {
                System.out.println("이름은 1글자 이상이어야 합니다");
                return false;
            }
        }
        return true;
    }

    public static boolean checkTimes(String times) {
        int parseTimes;
        try {
            parseTimes = Integer.parseInt(times);
        } catch (Exception e) {
            return false;
        }
        return parseTimes > 0;
    }
}
