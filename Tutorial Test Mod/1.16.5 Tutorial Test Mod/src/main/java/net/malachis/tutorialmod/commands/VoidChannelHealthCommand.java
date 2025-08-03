package net.malachis.tutorialmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.malachis.tutorialmod.TutorialMod;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class VoidChannelHealthCommand {
    public VoidChannelHealthCommand(CommandDispatcher<CommandSource> dispatcher)
    {
        dispatcher.register(Commands.literal("channel").then(Commands.literal("health").then(Commands.argument("value", IntegerArgumentType.integer(1)).executes((command) -> { return channelHealth(command.getSource(), IntegerArgumentType.getInteger(command, "value")); }))));
    }

    private int channelHealth(CommandSource source, float health) throws CommandSyntaxException
    {
        ServerPlayerEntity player = source.asPlayer();
        float playerHealth = player.getHealth();
        String channeledHealth = "Channeled " + health + " Health for " + health + " Saturation";

        player.setAbsorptionAmount(player.getAbsorptionAmount() + health);
        player.setHealth(player.getHealth() - health);

        //player.getPersistentData().putIntArray(TutorialMod.MOD_ID + ""); Not needed for this type of command

        source.sendFeedback(new StringTextComponent(channeledHealth), true);

        return 1;
    }
}
