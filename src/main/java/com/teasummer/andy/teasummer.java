package com.teasummer.andy;

import net.minecraft.command.arguments.ItemParser;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("teasummer")

public class teasummer {
    public teasummer() {
        ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}

class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "teasummer");
    public static RegistryObject<Testitem> Testitem = ITEMS.register("test_item", () -> {
        return new Testitem();
    });
    public static RegistryObject<com.teasummer.andy.Testfood> Testfood = ITEMS.register("test_food", () -> {
        return new Testfood();
    });
    public static RegistryObject<com.teasummer.andy.Testsword> Testsword = ITEMS.register("test_sword", () -> {
        return new Testsword();
    });
}

class Testitem extends Item {
    public Testitem() {
        super(new Properties().group(ModGroup.itemGroup));
    }
}

class teasummergroup extends ItemGroup {
    public teasummergroup() {
        super("teasummer_group");
    }
    public ItemStack createIcon() {
        return new ItemStack(ItemRegistry.Testitem.get());
    }
}

class ModGroup {
    public static ItemGroup itemGroup = new teasummergroup();
}

class Testfood extends Item{
    public static Food food = (new Food.Builder())
            .saturation(10)
            .hunger(5)
            .build();
    public Testfood() {
        super(new Properties().food(food).group(ModGroup.itemGroup));
    }
}

class Testsword extends SwordItem {
    private static IItemTier iItemTier = new IItemTier() {
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
            final float v = 1000F;
            return v;
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
            return Ingredient.fromItems(ItemRegistry.Testitem.get());
        }
    };
    public Testsword() {
        super(iItemTier, 1000, -2.0F, new Item.Properties().group(ModGroup.itemGroup));
    }
}
