package lafolie.golf;

import lafolie.golf.util.GolfIdentifier;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class GolfClient implements ClientModInitializer
{
	public static final EntityModelLayer GOLF_BALL_MODEL_LAYER = new EntityModelLayer(GolfIdentifier.content("golf_ball"), "main");

	@Override
	public void onInitializeClient()
	{
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		EntityRendererRegistry.register(GolfEntities.GOLF_BALL, (context) ->
		{
			return new GolfBallEntityRenderer(context);
		});

		EntityModelLayerRegistry.registerModelLayer(GOLF_BALL_MODEL_LAYER, GolfBallEntityModel::getTexturedModelData);
	}
}