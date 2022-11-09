import LoginUseCase.UserLoginGUI;
import LoginUseCase.UserLoginPresenter;

public class StockSimulator {
    private static UserLoginPresenter userLoginPresenter;

    public static void main(String[] args) {
        userLoginPresenter = new UserLoginPresenter();
    }
}