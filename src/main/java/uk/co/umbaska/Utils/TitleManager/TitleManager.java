package uk.co.umbaska.Utils.TitleManager;

import org.bukkit.entity.Player;

/**
 * Created by KJ4IPS on 7/12/2015.
 */
public class TitleManager {
    static AbstractTitleManager backend;

    public static void init() {
        //TODO: Use reflection and plugin loads to figure out which backend to use
        backend = new TitleManager_ProtocolLib();
    }

    public static void sendTitle(Player p, String title) {
        backend.sendTitle(p, title);
    }

    public static void sendActionTitle(Player p, String action){
        backend.sendActionTitle(p, action);
    }

    public static void sendSubTitle(Player p, String subtitle) {
        backend.sendSubTitle(p,subtitle);
    }
}
