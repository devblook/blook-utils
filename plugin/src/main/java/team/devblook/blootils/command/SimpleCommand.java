package team.devblook.blootils.command;

public class SimpleCommand {

    private String name;
    private String description;
    private String usage;
    private String permission;
    private String[] aliases;

    public SimpleCommand(String name, String description, String usage, String permission, String[] aliases) {
        this.name = name;
        this.description = description;
        this.usage = usage;
        this.permission = permission;
        this.aliases = aliases;
    }

}
