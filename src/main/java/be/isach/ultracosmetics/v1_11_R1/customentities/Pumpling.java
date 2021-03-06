package be.isach.ultracosmetics.v1_11_R1.customentities;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.pets.IPetCustomEntity;
import be.isach.ultracosmetics.util.Particles;
import be.isach.ultracosmetics.util.UtilParticles;
import net.minecraft.server.v1_11_R1.*;
import org.bukkit.entity.Zombie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sacha on 18/10/15.
 */
public class Pumpling extends EntityZombie implements IPetCustomEntity {

    public Pumpling(World world) {
        super(world);
    }

    public org.bukkit.entity.Entity getEntity() {
        return getBukkitEntity();
    }

    @Override
    protected SoundEffect G() { // say
        if (isCustomEntity()) {
            a(SoundEffects.bM, 0.05f, 2f);
            return null;
        } else {
            return super.G();
        }
    }

    //previously bV
    @Override
    protected SoundEffect bW() { // Hurt
        if (isCustomEntity()) {
            return null;
        } else {
            return super.bW();
        }
    }

    //previously bW
    @Override
    protected SoundEffect bX() { // Death
        if (isCustomEntity()) {
            return null;
        } else {
            return super.bX();
        }
    }

    @Override
    protected void a(BlockPosition blockposition, Block block) {
        if (isCustomEntity()) {
            return;
        }
        super.a(blockposition, block);
    }

    //previously m
    @Override
    public void A_() {
        super.A_();
        if (!isCustomEntity()) {
            return;
        }
        fireTicks = 0;
        UtilParticles.display(Particles.FLAME, 0.2f, 0.2f, 0.2f, ((Zombie) getBukkitEntity()).getEyeLocation(), 3);
        UltraCosmetics.getInstance().getPathfinderUtil().removePathFinders(getBukkitEntity());
        setInvisible(true);
        setBaby(true);
        setSlot(EnumItemSlot.HEAD, new ItemStack(Blocks.PUMPKIN));
    }

    private boolean isCustomEntity() {
        return CustomEntities.customEntities.contains(this);
    }

}
