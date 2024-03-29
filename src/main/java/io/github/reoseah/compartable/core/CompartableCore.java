package io.github.reoseah.compartable.core;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CompartableCore {
    public static void initialize() {
        Registry.register(Registries.BLOCK, new Identifier("compartable", "part_container"), PartContainerBlock.INSTANCE);
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier("compartable", "part_container"), PartContainerBlockEntity.TYPE);
    }

    public static void initializeClient() {
        BlockEntityRendererRegistry.register(PartContainerBlockEntity.TYPE, PartContainerEntityRenderer::new);

        ClientPlayNetworking.registerGlobalReceiver(PartContainerPackets.UPDATE, PartContainerPackets::receiveUpdate);
    }
}
