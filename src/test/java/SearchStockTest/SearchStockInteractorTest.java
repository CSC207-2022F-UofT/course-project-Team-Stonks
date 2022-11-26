package SearchStockTest;

import SearchStockUseCase.ViewStockUseCaseInteractor;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class SearchStockInteractorTest {
    private static ViewStockUseCaseInteractor interactor;
    private static final String incorrectSymbol = "incorrectSymbol";
    private static final String correctSymbol = "TSLA";

    @BeforeAll
    public static void setUp() {
        interactor = new ViewStockUseCaseInteractor();
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void incorrectSymbol() {
        try {
            interactor.searchStock(incorrectSymbol);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    @Test
    public void correctSymbol() {
        try {
            interactor.searchStock(correctSymbol);
            assert true;
        } catch (Exception e) {
            assert false;
        }


    }
}
