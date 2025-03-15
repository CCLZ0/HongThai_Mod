package net.cclz.HongThaiMod.item;

import net.cclz.HongThaiMod.HongThaiMod;
import net.cclz.HongThaiMod.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HongThaiMod.MOD_ID);

    public static final RegistryObject<Item> HONGTHAI = ITEMS.register("hongthai",
            () -> new Item(new Item.Properties().food(ModFoods.HONGTHAI)));

    public static final RegistryObject<Item> BOTTLE = ITEMS.register("bottle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KELP_PLASTIC = ITEMS.register("kelp_plastic",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MINT = ITEMS.register("mint",
            () -> new Item(new Item.Properties().food(ModFoods.MINT)));

    public static final RegistryObject<Item> MINT_SEEDS = ITEMS.register("mint_seeds",
            () -> new ItemNameBlockItem(ModBlocks.MINT_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
