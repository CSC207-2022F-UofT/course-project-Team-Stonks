package entities;

import db.PortfolioDSResponse;

import java.util.Date;
import java.util.List;

public class UserFactory {
    public static User createUser(String username, String password, Date creationTime) {
        return new User(username, password, creationTime);
    }

    public static User createUser(String username, String password, Date creationTime, List<PortfolioDSResponse> portfolios) {
        return new User(username, password, creationTime);
    }
}