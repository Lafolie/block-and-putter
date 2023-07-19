package lafolie.golf.entities;

import lafolie.golf.GolfItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GolfBallEntity extends PersistentProjectileEntity
{
	public GolfBallEntity(EntityType<? extends PersistentProjectileEntity> type, World world)
	{
		this(type, 0d, 0d, 0d, world);
	}

	protected GolfBallEntity(EntityType<? extends PersistentProjectileEntity> type, double x, double y, double z, World world)
	{
		super(type, x, y, z, world);
		//TODO Auto-generated constructor stub
	}

	// @Override
	// protected void initDataTracker()
	// {
	// 	// TODO Auto-generated method stub
	// 	// throw new UnsupportedOperationException("Unimplemented method 'initDataTracker'");
	// }

	@Override
	protected ItemStack asItemStack()
	{
		// TODO Auto-generated method stub
		// throw new UnsupportedOperationException("Unimplemented method 'asItemStack'");
		return new ItemStack(GolfItems.GOLF_BALL);
	}
	
}
