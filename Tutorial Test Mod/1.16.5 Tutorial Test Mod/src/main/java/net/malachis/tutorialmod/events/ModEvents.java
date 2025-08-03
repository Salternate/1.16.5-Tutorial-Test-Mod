package net.malachis.tutorialmod.events;

import net.malachis.tutorialmod.TutorialMod;
import net.malachis.tutorialmod.commands.VoidChannelHealthCommand;
import net.malachis.tutorialmod.commands.VoidChannelSaturationCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister (RegisterCommandsEvent event)
    {
        new VoidChannelHealthCommand(event.getDispatcher());
        new VoidChannelSaturationCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}
