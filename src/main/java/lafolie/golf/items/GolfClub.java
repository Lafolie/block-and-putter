package lafolie.golf.items;

import java.util.List;

import lafolie.golf.Golf;
import lafolie.golf.entities.GolfBallEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GolfClub extends Item
{
	private float pitchOffset;
	private double drivePower;

	public GolfClub(Settings settings, float pitchOffset, double drivePower)
	{
		super(settings);
		this.pitchOffset = pitchOffset;
		this.drivePower = drivePower;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEnt, Hand hand)
	{
		if(world.isClient())
		{
			return super.use(world, playerEnt, hand);
		}

		GolfBallEntity ball = findBall(world, playerEnt);

		if(ball != null)
		{
			Golf.LOG.info("Hit a ball!");
			hitBall(ball, playerEnt);
			return TypedActionResult.success(playerEnt.getStackInHand(hand));
		}
		else
		{
			return TypedActionResult.pass(playerEnt.getStackInHand(hand));
		}
	}

	private void hitBall(GolfBallEntity ball, PlayerEntity playerEnt)
	{
		Golf.LOG.info("Pitch: {}", playerEnt.getPitch());
		Vec3d forward = Vec3d.fromPolar(playerEnt.getPitch() + pitchOffset, playerEnt.getYaw());
		ball.hitWithClub(forward.multiply(drivePower));
	}

	private Box getCollisionBox(PlayerEntity playerEnt)
	{
		Vec3d pos = playerEnt.getPos();
		Vec3d forward = Vec3d.fromPolar(0f, playerEnt.getYaw());
		return Box.of(pos.add(forward.multiply(0.5d)), 1.5d, 1.5d, 1.5d);
	}

	private GolfBallEntity findBall(World world, PlayerEntity playerEnt)
	{
		List<Entity> entities = world.getOtherEntities(playerEnt, getCollisionBox(playerEnt));
		for(Entity ent : entities)
		{
			Golf.LOG.info("Found ent {}", ent.toString());
			if(ent instanceof GolfBallEntity)
			{
				return (GolfBallEntity)ent;
			}
		}
		return null;
	}
}
