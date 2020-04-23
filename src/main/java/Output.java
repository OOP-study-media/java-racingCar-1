import java.util.List;

public class Output {
    private static final int LAST_COMMA_LOCATION = 2;

    public static void printWinner(List<Car> winners) {
        StringBuilder result = new StringBuilder();
        for (Car car : winners) {
            result.append(car.getName()).append(", ");
        }
        result.delete(result.length() - LAST_COMMA_LOCATION, result.length());
        System.out.println(result.append("가 최종 우승했습니다."));
    }

    public static void printCarResult(Car car) {
        String result = car.getName() + ":" + "-".repeat(Math.max(0, car.getPosition()));
        System.out.println(result);
    }
}
