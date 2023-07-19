package lafolie.golf;

import lafolie.golf.util.GolfIdentifier;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public final class GolfItems
{
	private GolfItems() {}

	public static final Item CLUB = new Item(new FabricItemSettings().maxCount(1));
	public static final Item BALL = new Item(new FabricItemSettings().maxCount(64));


	public static void init()
	{
		Registry.register(Registries.ITEM, GolfIdentifier.content("golf_club"), CLUB);
		Registry.register(Registries.ITEM, GolfIdentifier.content("golf_ball"), BALL);
	}
}
