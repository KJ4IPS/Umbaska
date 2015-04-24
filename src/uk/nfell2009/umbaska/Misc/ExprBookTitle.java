package uk.nfell2009.umbaska.Misc;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import uk.nfell2009.umbaska.GattSk.Extras.Collect;

import java.util.ArrayList;

/**
 * Created by Zachary on 4/24/2015.
 */
public class ExprBookTitle extends SimpleExpression<String> {

    private Expression<ItemStack> item;

    public Class<? extends String> getReturnType() {

            return String.class;
    }

    @Override
    public boolean isSingle() {
            return true;
            }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] args, int arg1, Kleenean arg2, SkriptParser.ParseResult arg3) {
            this.item = (Expression<ItemStack>) args[0];
            return true;
            }

    @Override
    public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
            return "return title of book";
            }

    @Override
    @javax.annotation.Nullable
    protected String[] get(Event arg0) {
        ItemStack items = item.getSingle(arg0);
        if (items == null){
            return null;
        }
        else{
            if (items.getType() != Material.WRITTEN_BOOK){
                return Collect.asArray(items.getItemMeta().getDisplayName());
            }
            else{
                BookMeta bm = (BookMeta)items.getItemMeta();
                return Collect.asArray(bm.getTitle());
            }
        }
    }

}