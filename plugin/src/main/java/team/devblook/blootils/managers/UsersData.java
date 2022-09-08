package team.devblook.blootils.managers;

import team.devblook.blootils.api.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UsersData {

    private final Map<UUID, User> userMap;

    public UsersData() {
        this.userMap = new HashMap<>();
    }

    public void addUser(User user) {
        this.userMap.put(user.getUuid(), user);
    }

    public void removeUser(User user) {
        this.userMap.remove(user.getUuid());
    }

    public User getUser(UUID uuid) {
        return this.userMap.get(uuid);
    }
}
