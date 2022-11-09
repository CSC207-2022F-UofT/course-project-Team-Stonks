package db;

import java.util.List;

public record PortfolioDSResponse (String name, double balance, List<StockDSResponse> stocks) {
}