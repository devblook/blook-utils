package team.devblook.blootils.api;

import java.util.UUID;

public class User {

    private UUID uuid;
    private String name;
    private String displayName;
    private String prefix;
    private String suffix;

    public User(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
