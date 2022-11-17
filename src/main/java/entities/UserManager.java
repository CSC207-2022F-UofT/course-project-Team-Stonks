package entities;

import db.UserDSRequest;
import db.UserDSResponse;
import db.iEntityDBGateway;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private final List<User> users;
    private final iEntityDBGateway dbGateway;
    private final UserFactory userFactory = new UserFactory();

    public UserManager(iEntityDBGateway dbGateway) {
        users = new ArrayList<>();
        this.dbGateway = dbGateway;
    }

    public UserManager(iEntityDBGateway dbGateway, List<User> users) {
        this.users = users;
        this.dbGateway = dbGateway;
    }

    /**
     * @param username non-empty string
     * @param password non-empty string
     * @return the user from the system that has the given username password pair
     * or null if it doesn't exist
     */
    public User getUser(String username, String password, Date loginDate) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.isPassword(password)) {
                    user.updateLoginDate(loginDate);
                    return user;
                }

                return null;
            }
        }

        User user = convertUserDSResponse(dbGateway.findUserPortfolios(username, password));

        if (user != null) {
            users.add(user);
            user.updateLoginDate(loginDate);
        }

        return user;
    }

    /**
     * @param username non-empty string
     * @return true if a user in the system has a matching username, false otherwise
     */
    public boolean userExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }

        return dbGateway.findUser(username);
    }

    /**
     * <p>
     * Creates new user that doesn't exist in the system already
     * and adds it to the database
     * </p>
     *
     * @param username    unique username that does not exist in the system already
     * @param password    non-empty string satisfying valid password parameters
     * @param dateCreated String describing a date
     */
    public void createUser(String username, String password, Date dateCreated) {
        users.add(userFactory.createUser(username, password, dateCreated, dbGateway));
    }

    private User convertUserDSResponse(UserDSResponse userDSResponse) {
        if (userDSResponse == null) {
            return null;
        }

        return userFactory.createUser(userDSResponse.username(), userDSResponse.password(), userDSResponse.lastLogin(), userDSResponse.portfolios(), dbGateway);
    }
}