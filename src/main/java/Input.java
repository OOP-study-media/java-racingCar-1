import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    private static final int MAX_NAME_LENGTH = 5;

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<String> names;
    private int times;

    public boolean setup() throws Exception {
        return setupNames() && setupTimes();
    }

    private boolean setupNames() throws Exception {
        names = inputNames();
        return checkNameLength(names);
    }

    private boolean setupTimes() throws Exception {
        String inputTimes = inputTimes();
        if (!checkTimes(inputTimes)) {
            return false;
        }
        times = Integer.parseInt(inputTimes);
        return true;
    }

    private List<String> inputNames() throws Exception {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return new ArrayList<>(Arrays.asList(br.readLine().split(",")));
    }

    private String inputTimes() throws Exception {
        System.out.println("시도할 횟수는 몇회인가요?");
        return br.readLine();
    }

    private boolean checkNameLength(List<String> names) {
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

    private boolean checkTimes(String times) {
        int parseTimes;
        try {
            parseTimes = Integer.parseInt(times);
        } catch (Exception e) {
            return false;
        }
        return parseTimes > 0;
    }

    public Game makeGame() {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
        return new Game(cars, times);
    }
}
