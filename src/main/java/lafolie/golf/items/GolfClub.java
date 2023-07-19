package lafolie.golf.items;

import lafolie.golf.Golf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GolfClub extends Item
{
	private double pitchOffset;
	private double drivePower;

	public GolfClub(Settings settings, double pitchOffset, double drivePower)
	{
		super(settings);
		this.pitchOffset = pitchOffset;
		this.drivePower = drivePower;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEnt, Hand hand)
	{
		GolfBall ball = findBall(world, playerEnt);

		if(ball != null)
		{
			Golf.LOG.info("Hit a ball!");
			return TypedActionResult.success(playerEnt.getStackInHand(hand));
		}
		else
		{
			return TypedActionResult.pass(playerEnt.getStackInHand(hand));
		}
	}

	private GolfBall findBall(World world, PlayerEntity playerEnt)
	{
		return null;
	}
}
