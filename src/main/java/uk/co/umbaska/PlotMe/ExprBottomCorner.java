/*
 * ExprBottomCorner.class - Made by nfell2009
 * nfell2009.uk (C) nfell2009 | 2014 - 2015
 * Submitted to: Umbaska
 * 
*/

package uk.co.umbaska.PlotMe;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.worldcretornica.plotme_core.api.Vector;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.Event;

public class ExprBottomCorner extends SimpleExpression<Location>{

    private Expression<String> plot;
    private Expression<World> world;

    public Class<? extends Location> getReturnType() {

        return Location.class;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] args, int arg1, Kleenean arg2, ParseResult arg3) {
        this.plot = (Expression<String>) args[0];
        this.world = (Expression<World>) args[1];
        return true;
    }

    @Override
    public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
        return "return owner of plot";
    }

    @Override
    @javax.annotation.Nullable
    protected Location[] get(Event e) {

        World inWorld = world.getSingle(e);
        Vector thePlotLocation = PluginPlotMe.getPlotByWorldAndStringId(world.getSingle(e),plot.getSingle(e)).getPlotBottomLoc();
        return new Location[]{
                new Location(
                        inWorld,
                        thePlotLocation.getX(),
                        thePlotLocation.getY(),
                        thePlotLocation.getZ()
                )
        };
    }

}