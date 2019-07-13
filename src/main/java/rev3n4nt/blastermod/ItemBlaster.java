package rev3n4nt.blastermod;

// import com.google.common.collect.ImmutableMap;
// import com.google.common.collect.Maps;
// import com.google.common.collect.Multimap;
// import java.util.Map;
// import net.minecraft.block.Block;
// import net.minecraft.block.BlockState;
// import net.minecraft.block.Blocks;
// import net.minecraft.entity.LivingEntity;
// import net.minecraft.entity.player.PlayerEntity;
// import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;

// import net.minecraft.item.HoeItem;
// import net.minecraft.item.ShovelItem;;

public class ItemBlaster extends Item {

   @ObjectHolder(BlasterMod.MODID + ":blaster_ready")
   public static SoundEvent SOUND_BLASTER_READY;

   @ObjectHolder(BlasterMod.MODID + ":blaster_fire")
   public static SoundEvent SOUND_BLASTER_FIRE;

   // private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.CLAY, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.FARMLAND, Blocks.GRASS_BLOCK, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.RED_SAND, Blocks.SNOW_BLOCK, Blocks.SNOW, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.WHITE_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER);
   // protected static final Map<Block, BlockState> field_195955_e = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.GRASS_PATH.getDefaultState()));

   public ItemBlaster( Item.Properties builder){
      super(builder);
   }

   /**
    * Called when this item is used when targetting a Block
    */
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {

      World world = context.getWorld();
      BlockPos blockpos = context.getPos();

// TODO : use TileEntity, timer on block;
// look how to create TileEntity, put into scanned block
// serialize \ deserialize
// parameters: blockstate, timer

      if (!world.isRemote) {
         world.removeBlock(blockpos, false);
         // TODO : check if lower block exist & not air
         // if(block != null){
            world.removeBlock(blockpos.down(), false);

            // world.removeBlock(blockpos.offset(front), false);

            world.removeBlock(blockpos.north(), false);
            world.removeBlock(blockpos.east(), false);
            world.removeBlock(blockpos.north().east(), false);
            
            world.removeBlock(blockpos.north().down(), false);
            world.removeBlock(blockpos.east().down(), false);
            world.removeBlock(blockpos.north().east().down(), false);
         // }
      }
      PlayerEntity player = context.getPlayer();

      player.playSound(SOUND_BLASTER_FIRE, 0.9f, 1);

      //    BlockState blockstate = HOE_LOOKUP.get(world.getBlockState(blockpos).getBlock());
      //    if (blockstate != null) {
      //       PlayerEntity playerentity = context.getPlayer();
      //       world.playSound(playerentity, blockpos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
      //       if (!world.isRemote) {
      //          world.setBlockState(blockpos, blockstate, 11);
      //          if (playerentity != null) {
      //             context.getItem().damageItem(1, playerentity, (p_220043_1_) -> {
      //                p_220043_1_.sendBreakAnimation(context.getHand());
      //             });
      //          }
      //       }

      //       return ActionResultType.SUCCESS;
      //    }
      // }
      return ActionResultType.SUCCESS;
   }
}