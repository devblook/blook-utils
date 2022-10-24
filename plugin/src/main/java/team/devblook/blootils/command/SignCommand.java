package team.devblook.blootils.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import team.devblook.blootils.utils.PlayerView;

import java.util.List;

public class SignCommand implements TabExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {
            if (p.hasPermission("blootils.sign")) {
                if (p.getTargetBlock(null, 5).getType() == Material.ACACIA_SIGN|| p.getTargetBlock(null, 5).getType() == Material.ACACIA_WALL_SIGN) {
                    if (args.length == 0) {
                        p.sendMessage(ChatColor.RED + "/sign edit <line> <text>");
                        p.sendMessage(ChatColor.RED + "/sign clear <line>");
                        p.sendMessage(ChatColor.RED + "/sign clear all");

                        return true;

                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("edit")){
                            p.sendMessage(ChatColor.RED + "/sign edit <line> <text>");

                        }else if(args[0].equalsIgnoreCase("clear")){
                            p.sendMessage(ChatColor.RED + "/sign clear <line>");
                            p.sendMessage(ChatColor.RED + "/sign clear all");
                            return true;

                        }

                        return true;
                    }if (args.length==2){
                        if(args[1].equalsIgnoreCase("clearAll")){
                            PlayerView.clearAll(p);
                            p.sendMessage(ChatColor.GREEN + "Cleared all lines");
                            return true;
                        }
                        else{
                            if (args[1].equalsIgnoreCase("1")) {
                                PlayerView.viewBlockActual(p, 0, "");
                                p.sendMessage(ChatColor.GREEN + "Cleared line 1");
                                return true;
                            }else if (args[1].equalsIgnoreCase("2")) {
                                PlayerView.viewBlockActual(p, 1, "");
                                p.sendMessage(ChatColor.GREEN + "Cleared line 2");
                                return true;
                            } else if (args[1].equalsIgnoreCase("3")) {
                                PlayerView.viewBlockActual(p, 2, "");
                                p.sendMessage(ChatColor.GREEN + "Cleared line 3");
                                return true;
                            } else if (args[1].equalsIgnoreCase("4")) {
                                PlayerView.viewBlockActual(p, 3, "");
                                p.sendMessage(ChatColor.GREEN + "Cleared line 4");
                                return true;
                            } else {
                                p.sendMessage(ChatColor.RED + "Invalid line number");
                                return true;
                            }
                        }
                    }
                    if (args.length==3) {
                       // try {
                            int line = Integer.parseInt(args[1])-1;
                            if (line == 0 || line == 1 || line == 2 || line == 3) {
                                String text = args[2];
                                text = ChatColor.translateAlternateColorCodes('&', text);

                                if (text == null) {
                                    p.sendMessage(ChatColor.RED + "You must enter text!");
                                    return false;
                                }
                                PlayerView.viewBlockActual(p, line, text);
                                return true;


                            } else {
                                p.sendMessage(ChatColor.RED + "Please enter a valid line number");
                            }
                       // }catch (NumberFormatException e){
                            p.sendMessage(ChatColor.RED + "Please enter a valid line number");
                       // }

                    }else{
                        p.sendMessage(ChatColor.RED + "Need more arguments!");

                    }


                }  else {
                    p.sendMessage(ChatColor.BOLD + "You are not looking at a sign");
                }

            }else {
                p.sendMessage(ChatColor.RED + "You don't have the enough permissions to access this command.");
                return true;


            }
            return true;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length == 1) {

            return List.of("edit", "clear");
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("edit")) {
                return List.of("1", "2", "3", "4");

            } else if (args[0].equalsIgnoreCase("clear")) {
                return List.of("clearAll", "1", "2", "3", "4");
            }

        } else if (args.length == 3) {
            int line = Integer.parseInt(args[1]);
            if (line==1) {
                String text = PlayerView.returnText(p, 0);
                return List.of(text);
            } else if (line==2) {
                String text = PlayerView.returnText(p, 1);
                return List.of(text);
            } else if (line==3) {
                String text = PlayerView.returnText(p, 2);
                return List.of(text);
            } else if (line==4) {
                String text = PlayerView.returnText(p, 3);
                return List.of(text);
            }

            }


        return null;}

}
