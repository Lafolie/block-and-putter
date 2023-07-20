package lafolie.golf;

import lafolie.golf.entities.GolfBallEntity;
import lafolie.golf.util.GolfIdentifier;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GolfBallEntityRenderer extends EntityRenderer<GolfBallEntity>
{
	private ModelPart base;
	private Identifier ID = GolfIdentifier.content("golf_ball");
	protected GolfBallEntityRenderer(Context ctx)
	{
		super(ctx);
		base = ctx.getPart(GolfClient.GOLF_BALL_MODEL_LAYER);
	}

	@Override
	public Identifier getTexture(GolfBallEntity var1)
	{
		// TODO Auto-generated method stub
		return GolfIdentifier.content("textures/entity/golf_ball/golf_ball.png");
	}

	@Override
	public void render(GolfBallEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light)
	{
		VertexConsumer vertices = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(getTexture(entity)));
		base.render(matrices, vertices, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
		super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
	}
	
	
}
