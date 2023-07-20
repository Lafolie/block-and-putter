package lafolie.golf;

import lafolie.golf.items.GolfClub;
import lafolie.golf.util.GolfIdentifier;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public final class GolfItems
{
	private GolfItems() {}

	public static final GolfClub CLUB = new GolfClub(new FabricItemSettings().maxCount(1), 0f, 2d);
	public static final Item GOLF_BALL = new Item(new FabricItemSettings().maxCount(64));


	public static void init()
	{
		Registry.register(Registries.ITEM, GolfIdentifier.content("golf_club"), CLUB);
		Registry.register(Registries.ITEM, GolfIdentifier.content("golf_ball"), GOLF_BALL);
	}
}
