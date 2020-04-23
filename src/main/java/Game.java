import java.util.List;

public class Game {
    private final List<Car> cars;
    private int times;

    public Game(List<Car> cars, int times) {
        this.cars = cars;
        this.times = times;
    }

    public void playGame() {
        System.out.println("실행 결과");
        while (times != 0) {
            for (Car car : cars) {
                car.moveCars();
                Output.printCarResult(car);
            }
            times--;
            System.out.println(" ");
        }
        Output.printWinner(new Winner(cars).winners());
    }
}
