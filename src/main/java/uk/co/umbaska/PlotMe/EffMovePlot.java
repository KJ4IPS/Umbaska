/*
 * EffMovePlot.class - Made by nfell2009
 * nfell2009.uk (C) nfell2009 | 2014 - 2015
 * Submitted to: Umbaska
 * 
*/

package uk.co.umbaska.PlotMe;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.World;
import org.bukkit.event.Event;

public class EffMovePlot extends Effect {

    private Expression<String> plot1;
    private Expression<String> plot2;
    private Expression<World> world;

    @Override
    protected void execute(Event event){
        String pl1 = plot1.getSingle(event);
        String pl2 = plot2.getSingle(event);
        World w = world.getSingle(event);
        PluginPlotMe.movePlot(
                w,
                PluginPlotMe.getPlotByWorldAndStringId(w,pl1).getId(),
                PluginPlotMe.getPlotByWorldAndStringId(w,pl2).getId()
        );
    }


    @Override
    public String toString(Event event, boolean b){
        return "Move a plot to another plot";
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
        plot1 = (Expression<String>) expressions[0];
        plot2 = (Expression<String>) expressions[1];
        world = (Expression<World>) expressions[2];
        return true;
    }
}