package uk.co.umbaska.PlotMe;

import com.worldcretornica.plotme_core.ClearReason;
import com.worldcretornica.plotme_core.Plot;
import com.worldcretornica.plotme_core.PlotId;
import com.worldcretornica.plotme_core.PlotMeCoreManager;
import com.worldcretornica.plotme_core.api.IWorld;
import com.worldcretornica.plotme_core.api.Vector;
import com.worldcretornica.plotme_core.bukkit.api.BukkitCommandSender;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import uk.co.umbaska.Utils.UmbaskaCommandSender;

/**
 * Created by KJ4IPS on 7/12/2015.
 * This utility class keeps a handle for plotme related interactions
 */
public class PluginPlotMe {
    private static PlotMeCoreManager manager = null;

    public static IWorld plotWorld(World world){
        return getManager().getWorld(world.getName());
    }

    public static World bukkitWorld(IWorld world){
        return Bukkit.getWorld(world.getUUID());
    }

    public static com.worldcretornica.plotme_core.api.Location plotLoc(Location l){
        return new com.worldcretornica.plotme_core.api.Location(
                plotWorld(l.getWorld()),
                new Vector(l.getX(),l.getY(),l.getZ()));
    }

    public static Location bukkitLoc(com.worldcretornica.plotme_core.api.Location l){
        return new Location(bukkitWorld(l.getWorld()),
                l.getX(), l.getY(), l.getZ());
    }

    public static void movePlot(World w, PlotId fromPlot, PlotId toPlot){
        getManager().movePlot(plotWorld(w),fromPlot, toPlot);
    }

    public static void clearPlot(Plot inPlot){
        getManager().clear(inPlot, new BukkitCommandSender(new UmbaskaCommandSender()),
                ClearReason.Clear);
    }

    public static void denyUser(Plot plot, OfflinePlayer player){
        plot.addDenied(player.getName());
        plot.removeMember(player.getName());
    }

    public static PlotMeCoreManager getManager(){
        if(manager == null)
            manager = PlotMeCoreManager.getInstance();
        return manager;
    }

    public static Plot getPlotByWorldAndStringId(World w, String n){
        IWorld plotWorld = getManager().getWorld(w.getName());
        if(!getManager().isPlotWorld(plotWorld)){
            throw new RuntimeException("Attempt to get plot on non-plotme world");
        }
        PlotId plotId = new PlotId(n);
        return getManager().getPlotById(plotId, plotWorld);
    }

    public static Plot getPlotByLocation(Location l){
        return getManager().getPlot(plotLoc(l));
    }

    public static org.bukkit.util.Vector bukkitVector(Vector plotVector) {
        return new org.bukkit.util.Vector(plotVector.getX(), plotVector.getY(), plotVector.getZ());
    }
}
