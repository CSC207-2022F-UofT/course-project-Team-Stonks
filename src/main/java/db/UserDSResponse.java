package db;

import java.sql.Date;
import java.util.List;

public record UserDSResponse (String username, String password, Date lastLogin, List<PortfolioDSResponse> portfolios){
}