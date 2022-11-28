package SearchStockTest;

import SearchStockUseCase.ViewStockUseCaseInteractor;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class SearchStockInteractorTest {
    private static ViewStockUseCaseInteractor interactor;
    private static final String incorrectSymbol = "incorrectSymbol";

    @BeforeAll
    public static void setUp() {
        interactor = new ViewStockUseCaseInteractor();
    }

    /**
     * Inputs invalid symbol to receive an Exception
     */
    @Test
    public void incorrectSymbol() {
        try {
            boolean isValid = interactor.searchStock(incorrectSymbol);
            assert !isValid;
        } catch (Exception e) {
            assert true;
        }
    }

}