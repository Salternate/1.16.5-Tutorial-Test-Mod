package net.malachis.tutorialmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class VoidChannelSaturationCommand {
    public VoidChannelSaturationCommand(CommandDispatcher<CommandSource> dispatcher)
    {
        dispatcher.register(Commands.literal("channel").then(Commands.literal("saturation").then(Commands.argument("value", IntegerArgumentType.integer(1)).executes((command) -> { return channelSaturation(command.getSource(), IntegerArgumentType.getInteger(command, "value")); }))));
    }

    private int channelSaturation(CommandSource source, float saturation) throws CommandSyntaxException
    {
        ServerPlayerEntity player = source.asPlayer();
        float playerSaturation = player.getFoodStats().getSaturationLevel();
        int playerHunger = player.getFoodStats().getFoodLevel();
        float leftOverInput = saturation - player.getFoodStats().getSaturationLevel();


        if(leftOverInput < 0)
        {
            leftOverInput = 0;
        }
        float channeledSaturation = saturation - leftOverInput;
        float channeledHunger = leftOverInput * 2;

        player.setAbsorptionAmount(player.getAbsorptionAmount() + (channeledSaturation) + (channeledHunger / 2));
        player.getFoodStats().setFoodSaturationLevel(playerSaturation - (channeledSaturation));
        player.getFoodStats().setFoodLevel(playerHunger - (int)channeledHunger);

        //player.getPersistentData().putIntArray(TutorialMod.MOD_ID + ""); Not needed for this type of command

        String channeledComplete;
        if(leftOverInput == 0)
        {
            channeledComplete = "Channeled " + channeledSaturation + " Saturation for " + channeledSaturation + " Absorption";
        }
        else
        {
            channeledComplete = "Channeled " + channeledSaturation + " Saturation and " + channeledHunger + " Hunger for " + saturation + " Absorption";
        }
        source.sendFeedback(new StringTextComponent(channeledComplete), true);

        return 1;
    }
}

