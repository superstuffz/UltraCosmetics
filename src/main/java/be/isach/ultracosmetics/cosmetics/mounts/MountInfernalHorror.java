package be.isach.ultracosmetics.cosmetics.mounts;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.UltraCosmeticsData;
import be.isach.ultracosmetics.cosmetics.type.MountType;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.Particles;
import be.isach.ultracosmetics.util.UtilParticles;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftHorse;

import java.util.UUID;

/**
 * Created by sacha on 10/08/15.
 */
public class MountInfernalHorror extends Mount {

    public MountInfernalHorror(UltraPlayer owner, UltraCosmetics ultraCosmetics) {
        super(owner, MountType.INFERNALHORROR, ultraCosmetics);
    }

    @Override
    public void onEquip() {
        super.onEquip();
        if (entity instanceof CraftHorse) {
            CraftHorse horse = (CraftHorse) entity;
            horse.setVariant(CraftHorse.Variant.SKELETON_HORSE);
            variant = CraftHorse.Variant.SKELETON_HORSE;
            horse.setVariant(CraftHorse.Variant.SKELETON_HORSE);
            horse.setJumpStrength(0.7);
            UltraCosmeticsData.get().getVersionManager().getEntityUtil().setHorseSpeed(horse, 0.4d);
        }
    }

    @Override
    public void onUpdate() {
        UtilParticles.display(Particles.FLAME, 0.4f, 0.2f, 0.4f, entity.getLocation().clone().add(0, 1, 0), 5);
    }
}
