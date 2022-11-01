package db;

import java.util.List;

public record UserDSResponse (String username, String password, String lastLogin, List<PortfolioDSResponse> portfolios){
}