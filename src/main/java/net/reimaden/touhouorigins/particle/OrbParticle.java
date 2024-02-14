package net.reimaden.touhouorigins.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import org.jetbrains.annotations.Nullable;

public class OrbParticle extends SpriteBillboardParticle {

    private final SpriteProvider spriteProvider;

    protected OrbParticle(ClientWorld clientWorld, double x, double y, double z,
                          SpriteProvider spriteProvider, double xd, double yd, double zd) {
        super(clientWorld, x, y, z, xd, yd, zd);
        this.scale *= 1.75f;
        this.maxAge = 4;
        this.spriteProvider = spriteProvider;
        this.setSpriteForAge(spriteProvider);

        float f = this.random.nextFloat() * 0.4f + 0.6f;
        this.red = this.darken(0.550f, f);
        this.green = this.darken(0.690f, f);
        this.blue = this.darken(0.882f, f);
    }

    private float darken(float colorComponent, float multiplier) {
        return (this.random.nextFloat() * 0.3f + 0.8f) * colorComponent * multiplier;
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        fadeOut();
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            this.setSpriteForAge(this.spriteProvider);
        }
    }

    private void fadeOut() {
        this.alpha = (-(1/(float) maxAge) * age + 1.0f);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    protected int getBrightness(float tint) {
        return 240;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {

        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Nullable
        @Override
        public Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double dx, double dy, double dz) {
            return new OrbParticle(world, x, y, z, this.spriteProvider, dx, dy, dz);
        }
    }
}
