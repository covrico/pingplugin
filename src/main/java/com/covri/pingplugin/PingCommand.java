package com.covri.pingplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            boolean currentStatus = PingPlugin.getInstance().getPingListener().isPingEnabled(player);
            PingPlugin.getInstance().getPingListener().setPingEnabled(player, !currentStatus);
            player.sendMessage("Ping notifications are now " + (currentStatus ? "disabled" : "enabled"));
            return true;
        }
        sender.sendMessage("This command can only be used by players.");
        return false;
    }
}