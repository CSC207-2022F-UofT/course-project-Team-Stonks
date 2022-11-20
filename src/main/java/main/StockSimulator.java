package main;

import LoginUseCase.UserLoginPresenter;

public class StockSimulator {
    public static void main(String[] args) {
        new UserLoginPresenter(OuterLayerFactory.instance.getUserLoginGUI());
    }
}