package com.teasummer.andy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("teasummer")

public class teasummer {
    public teasummer() {
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}

class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "teasummer");
    public static RegistryObject<tea> tea = ITEMS.register("tea", () -> {
        return new tea();
    });
    public static RegistryObject<cuptea> cuptea = ITEMS.register("cup_of_tea", () -> {
        return new cuptea();
    });
    public static RegistryObject<teasword> teasword = ITEMS.register("tea_sword", () -> {
        return new teasword();
    });
    public static RegistryObject<teapickaxe> teapickaxe = ITEMS.register("tea_pickaxe", () -> {
        return new teapickaxe();
    });
    public static RegistryObject<Item> teablock = ITEMS.register("tea_block", () -> {
        return new BlockItem(BlockRegistry.teablock.get(), new Item.Properties().group(ModGroup.itemGroup));
    });
}

class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, "teasummer");
    public static RegistryObject<Block> teablock = BLOCKS.register("tea_block" , () -> {
        return new teablock();
    });
}

class teasummergroup extends ItemGroup {
    public teasummergroup() {
        super("teasummer_group");
    }
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.tea.get());
    }
}

class ModGroup {
    public static ItemGroup itemGroup = new teasummergroup();
}

class tea extends Item {
    public tea() {
        super(new Properties().group(ModGroup.itemGroup));
    }
}

class cuptea extends Item{
    public static Food food = (new Food.Builder())
            .saturation(10)
            .hunger(5)
            .build();
    public cuptea() {
        super(new Properties().food(food).group(ModGroup.itemGroup));
    }
}

class teasword extends SwordItem {
    private static final IItemTier iItemTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 10;
        }
        @Override
        public float getEfficiency() {
            return 1.0F;
        }
        @Override
        public float getAttackDamage() {
            return 10.0F;
        }
        @Override
        public int getHarvestLevel() {
            return 10;
        }
        @Override
        public int getEnchantability() {
            return 30;
        }
        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(ItemRegistry.tea.get());
        }
    };
    public teasword() {
        super(iItemTier, 3, -2.0F, new Item.Properties().group(ModGroup.itemGroup));
    }
    }
class teablock extends Block {
    public teablock() {
        super(Properties.create(Material.LEAVES).hardnessAndResistance(1));
    }
}

class teapickaxe extends PickaxeItem {
    private static final IItemTier iItemTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 1644;
        }
        @Override
        public float getEfficiency() {
            return 0.5F;
        }
        @Override
        public float getAttackDamage() {
            return 1.5F;
        }
        @Override
        public int getHarvestLevel() {
            return 2;
        }

        @Override
        public int getEnchantability() {
            return 30;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(ItemRegistry.tea.get());
        }
    };

    public teapickaxe() {
        super(iItemTier,1 ,-5F, new Item.Properties().group(ModGroup.itemGroup));
    }
}