package example.lordne.tieredhoppers.common.block;

import example.lordne.tieredhoppers.mixin.IMixinHopperBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HopperBlock;
import net.minecraft.util.BlockVoxelShape;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.tileentity.TileEntity;

import mcp.MethodsReturnNonnullByDefault;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class AbstractHopperBlock extends HopperBlock {
    public AbstractHopperBlock(Properties properties) {
        super(properties);
    }

    @Override
    public abstract TileEntity newBlockEntity(IBlockReader reader);

    protected static VoxelShape DOWN_SUPPORT_SHAPE = VoxelShapes.or(IMixinHopperBlock.getDOWN_SHAPE(), IMixinHopperBlock.getTOP());
    protected static VoxelShape EAST_SUPPORT_SHAPE = VoxelShapes.or(IMixinHopperBlock.getEAST_SHAPE(), IMixinHopperBlock.getTOP());
    protected static VoxelShape NORTH_SUPPORT_SHAPE = VoxelShapes.or(IMixinHopperBlock.getNORTH_SHAPE(), IMixinHopperBlock.getTOP());
    protected static VoxelShape SOUTH_SUPPORT_SHAPE = VoxelShapes.or(IMixinHopperBlock.getSOUTH_SHAPE(), IMixinHopperBlock.getTOP());
    protected static VoxelShape WEST_SUPPORT_SHAPE = VoxelShapes.or(IMixinHopperBlock.getWEST_SHAPE(), IMixinHopperBlock.getTOP());
    protected static VoxelShape BASE_SUPPORT_SHAPE = VoxelShapes.or(IMixinHopperBlock.getBASE(), IMixinHopperBlock.getTOP());

    @Override
    public VoxelShape getBlockSupportShape(BlockState blockState, IBlockReader blockReader, BlockPos blockPos) {
        switch((Direction)blockState.getValue(FACING)) {
            case DOWN:
                return DOWN_SUPPORT_SHAPE;
            case NORTH:
                return NORTH_SUPPORT_SHAPE;
            case SOUTH:
                return SOUTH_SUPPORT_SHAPE;
            case WEST:
                return WEST_SUPPORT_SHAPE;
            case EAST:
                return EAST_SUPPORT_SHAPE;
            default:
                return BASE_SUPPORT_SHAPE;
        }
    }

}
