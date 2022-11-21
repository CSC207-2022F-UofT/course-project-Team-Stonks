package entities;

import main.OuterLayerFactory;

public class EntityHolder {
    public static final EntityHolder instance = new EntityHolder();
    private final UserManager userManager;

    private EntityHolder() {
        userManager = new UserManager(OuterLayerFactory.instance.getEntityDSGateway());
    }

    public UserManager getUserManager() {
        return userManager;
    }
}