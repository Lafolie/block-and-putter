package lafolie.golf.util;

import lafolie.golf.Golf;
import net.minecraft.util.Identifier;

public final class GolfIdentifier
{
	private GolfIdentifier() {}

	public static Identifier content(String path)
	{
		return new Identifier(Golf.MODID, path);
	}
}
