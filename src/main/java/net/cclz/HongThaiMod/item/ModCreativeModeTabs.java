package net.cclz.HongThaiMod.item;

import net.cclz.HongThaiMod.HongThaiMod;
import net.cclz.HongThaiMod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HongThaiMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> HONGTHAI_TAB = CREATIVE_MODE_TABS.register("hongthai_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HONGTHAI.get()))
                    .title(Component.translatable("creativetab.hongthai_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.HONGTHAI.get());
                        output.accept(ModItems.BOTTLE.get());
                        output.accept(ModItems.KELP_PLASTIC.get());
                        output.accept(ModItems.MINT.get());
                        output.accept(ModItems.MINT_SEEDS.get());

                        output.accept(ModBlocks.KELP_PLASTIC_BLOCK.get());

                        output.accept(ModBlocks.EUCALYPTUS_LOG.get());
                        output.accept(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get());
                        output.accept(ModBlocks.EUCALYPTUS_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get());

                        output.accept(ModBlocks.EUCALYPTUS_PLANKS.get());
                        output.accept(ModBlocks.EUCALYPTUS_LEAVES.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
