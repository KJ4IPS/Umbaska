package uk.co.umbaska.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.util.Set;

/**
 * Created by KJ4IPS on 7/12/2015.
 */
public class UmbaskaCommandSender implements CommandSender {
    @Override
    public void sendMessage(String s) {
        //ignored
    }

    @Override
    public void sendMessage(String[] strings) {
        //ignored
    }

    @Override
    public Server getServer() {
        return Bukkit.getServer();
    }

    @Override
    public String getName() {
        return "UMBASKA";
    }

    @Override
    public boolean isPermissionSet(String s) {
        return true;
    }

    @Override
    public boolean isPermissionSet(Permission permission) {
        return true;
    }

    @Override
    public boolean hasPermission(String s) {
        return true;
    }

    @Override
    public boolean hasPermission(Permission permission) {
        return true;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
        throw new UnsupportedOperationException("Umbaska command sender does not allow permissions attachments");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        throw new UnsupportedOperationException("Umbaska command sender does not allow permissions attachments");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
        throw new UnsupportedOperationException("Umbaska command sender does not allow permissions attachments");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int i) {
        throw new UnsupportedOperationException("Umbaska command sender does not allow permissions attachments");
    }

    @Override
    public void removeAttachment(PermissionAttachment permissionAttachment) {
        throw new UnsupportedOperationException("Umbaska command sender does not allow permissions attachments");

    }

    @Override
    public void recalculatePermissions() {
        //ignored
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new UnsupportedOperationException("Umbaska command sender does not allow permissions attachments");
    }

    @Override
    public boolean isOp() {
        return true;
    }

    @Override
    public void setOp(boolean b) {
        throw new UnsupportedOperationException("Umbaska's operator status cannot be modified");
    }
}
