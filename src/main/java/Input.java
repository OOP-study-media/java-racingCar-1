import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Input {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> inputNames() throws Exception {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = new ArrayList<>(Arrays.asList(br.readLine().split(",")));

        return Collections.unmodifiableList(names);
    }

    public static String inputTimes() throws Exception {
        System.out.println("시도할 횟수는 몇회인가요?");
        return br.readLine();
    }
}
