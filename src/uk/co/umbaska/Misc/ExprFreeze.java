package uk.co.umbaska.Misc;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.util.coll.CollectionUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import uk.co.umbaska.Main;

/**
 * Created by Zachary on 12/2/2014.
 */
public class ExprFreeze extends SimplePropertyExpression<Player, Boolean> {
	@Override
	public Boolean convert(Player ent) {
		if(ent == null)
			return null;
		return Main.freezeListener.isFrozen(ent);
	}

	@Override
	public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
		Player ent = getExpr().getSingle(e); //Called to get the Target which is Player in this case.
		if(ent == null)
			return;
		if(ent.getType() != EntityType.ARMOR_STAND){
			return;
		}
		Boolean b = (Boolean) (delta[0]);
		if (mode == Changer.ChangeMode.SET){
            Main.freezeListener.setFreezeState(ent, b);
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public Class<?>[] acceptChange(final Changer.ChangeMode mode) {
		if (mode == Changer.ChangeMode.SET) //SET can be replaced with REMOVE ADD or similiar stuff.
			return CollectionUtils.array(Number.class); //The Class should be the TypeToGet and in this case Number.
		if (mode == Changer.ChangeMode.REMOVE)
			return CollectionUtils.array(Number.class);
		return null;
	}

	@Override
	public Class<? extends Boolean> getReturnType() { //ReturnType is TypeToGet and in this case Number.
		return Boolean.class;

	}
	@Override
	protected String getPropertyName() {
		// TODO Auto-generated method stub
		return "Player Frozen State";
	}

}
