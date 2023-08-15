package example.lordne.tieredhoppers.mixin;

import net.minecraft.block.HopperBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HopperBlock.class)
public interface IMixinHopperBlock {
    @Accessor
    static VoxelShape getTOP() {
        throw new UnsupportedOperationException();
    }

    @Accessor
    static VoxelShape getDOWN_SHAPE() {
        throw new UnsupportedOperationException();
    }

    @Accessor
    static VoxelShape getEAST_SHAPE() {
        throw new UnsupportedOperationException();
    }

    @Accessor
    static VoxelShape getNORTH_SHAPE() {
        throw new UnsupportedOperationException();
    }

    @Accessor
    static VoxelShape getSOUTH_SHAPE() {
        throw new UnsupportedOperationException();
    }

    @Accessor
    static VoxelShape getWEST_SHAPE() {
        throw new UnsupportedOperationException();
    }

    @Accessor
    static VoxelShape getBASE() {
        throw new UnsupportedOperationException();
    }
}
