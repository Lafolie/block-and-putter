package lafolie.golf;

import lafolie.golf.entities.GolfBallEntity;
import lafolie.golf.util.GolfIdentifier;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public final class GolfEntities
{
	private GolfEntities() {}

	public static final EntityType<GolfBallEntity> GOLF_BALL = Registry.register(
		Registries.ENTITY_TYPE,
		GolfIdentifier.content("golf_ball"),
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, GolfBallEntity::new)
			.dimensions(EntityDimensions.fixed(0.25f, 0.25f))
			.build());

	public static void init()
	{
		// don't think we need to register attributes for this
	}
}
