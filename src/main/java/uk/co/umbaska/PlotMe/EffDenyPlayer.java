/*
 * EffDenyPlayer.class - Made by nfell2009
 * nfell2009.uk (C) nfell2009 | 2014 - 2015
 * Submitted to: Umbaska
 * 
*/

package uk.co.umbaska.PlotMe;


import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.worldcretornica.plotme_core.Plot;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.event.Event;

public class EffDenyPlayer extends Effect {

    private Expression<String> plot;
    private Expression<World> world;
    private Expression<OfflinePlayer> player;

    @Override
    protected void execute(Event event){
        Plot inPlot = PluginPlotMe.getPlotByWorldAndStringId(world.getSingle(event), plot.getSingle(event));
        PluginPlotMe.denyUser(inPlot,player.getSingle(event));
    }


    @Override
    public String toString(Event event, boolean b){
        return "Deny a player from a plot";
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
        plot = (Expression<String>) expressions[0];
        player = (Expression<OfflinePlayer>) expressions[1];
        world = (Expression<World>) expressions[2];
        return true;
    }
}