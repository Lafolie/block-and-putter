package lafolie.golf;

import lafolie.golf.entities.GolfBallEntity;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

public class GolfBallEntityModel extends EntityModel<GolfBallEntity>
{
	private ModelPart base;

	public GolfBallEntityModel(ModelPart modelPart)
	{
		base = modelPart.getChild(EntityModelPartNames.CUBE);
	}

	@Override
	public void setAngles(GolfBallEntity var1, float var2, float var3, float var4, float var5, float var6) {
		// TODO Auto-generated method stub
		// throw new UnsupportedOperationException("Unimplemented method 'setAngles'");
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha)
	{
		base.render(matrices, vertices, light, overlay, red, green, blue, alpha);
	}
	
	public static TexturedModelData getTexturedModelData()
	{
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild(
			EntityModelPartNames.CUBE,
			ModelPartBuilder.create().uv(0, 0).cuboid(-2f, -2f, -2f, 4f, 4f, 4f), 
			ModelTransform.pivot(0f, 0f, 0f));
		
		return TexturedModelData.of(modelData, 16, 16);
	}
}
