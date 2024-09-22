package trinsdar.ic2classictweaker;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiErrorScreen;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.client.CustomModLoadingErrorDisplayException;
import net.minecraftforge.fml.client.IDisplayableError;
import net.minecraftforge.fml.common.EnhancedRuntimeException;

public class IncompatibleModException extends CustomModLoadingErrorDisplayException {

    @Override
    public String getMessage() {
        return "Mod ic2_classic_tweaker (IC2 Classic Tweaker) is incompatible with mod ic2_tweaker (IC2 Tweaker). Please remove IC2 Tweaker";
    }

    @Override
    public void initGui(GuiErrorScreen errorScreen, FontRenderer fontRenderer) {

    }

    @Override
    public void drawScreen(GuiErrorScreen errorScreen, FontRenderer fontRenderer, int mouseRelX, int mouseRelY, float tickTime) {
        String modMissingDependenciesText = I18n.format("ic2_classic_tweaker.messages.mod.incompatible", TextFormatting.BOLD + "IC2 Classic Tweaker" + TextFormatting.RESET);
        errorScreen.drawCenteredString(fontRenderer, modMissingDependenciesText, errorScreen.width / 2, errorScreen.height / 2, 0xFFFFFF);
        String incompatibleText2 = I18n.format("ic2_classic_tweaker.messages.mod.incompatible.1");
        errorScreen.drawCenteredString(fontRenderer, incompatibleText2, errorScreen.width / 2, errorScreen.height / 2 + 10, 0xFFFFFF);
    }
}
