package io.github.bpteammc.mitrek.client.gui;

import io.github.bpteammc.mitrek.Mitrek;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;


public class ShipGUI extends GuiScreen {

    static final int GUI_WIDTH = 600;
    static final int GUI_HEIGHT = 400;

    GuiButton warp;
    GuiTextField xcoord;
    GuiTextField ycoord;
    GuiTextField zcoord;
    GuiTextField dim;

    public static final ResourceLocation TEXTURE = new ResourceLocation(Mitrek.MODID, "textures/gui/gui_ship.png");

    private Minecraft mc;
    private FontRenderer fr;

    public ShipGUI() {
        mc = Minecraft.getMinecraft();
        fr = mc.fontRenderer;
    }

    public class LargeButton extends GuiButton {

        int BUTTON_WIDTH = 100;
        int BUTTON_HEIGHT = 120;

        public LargeButton(int buttonId, int x, int y, String buttonText) {
            super(buttonId, x, y, buttonText);
        }

        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
            this.width = BUTTON_WIDTH;
            this.height = BUTTON_HEIGHT;
            FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            int i = this.getHoverState(this.hovered);

            int j = 14737632;

            if (packedFGColour != 0) {
                j = packedFGColour;
            } else if (!this.enabled) {
                j = 10526880;
            } else if (this.hovered) {
                j = 16777120;
            }
            this.drawCenteredString(fontrenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, j);
        }

    }

    @Override
    public void initGui() {
        int x = width / 2 - 15;
        int y = height / 2 - 15;
        String warpButton = "Warp";

        int yOffset = fr.FONT_HEIGHT + 3;

        xcoord = new GuiTextField(0, fr, x - 40, y * 1 + 10, 100, fr.FONT_HEIGHT);
        ycoord = new GuiTextField(1, fr, x - 40, y + yOffset * 2, 100, fr.FONT_HEIGHT);
        zcoord = new GuiTextField(2, fr, x - 40, y + yOffset * 3 + 1, 100, fr.FONT_HEIGHT);
        warp = new GuiButton(3, x + 11, y + yOffset * 9, warpButton);
        dim = new GuiTextField(4, fr, x - 40, y + yOffset * 4 + 3, 100, fr.FONT_HEIGHT);
        // TODO fix buttons and send info to ship
        warp.x -= warp.width / 2;
        dim.x -= dim.width / 2;
        xcoord.setFocused(true);

        this.buttonList.clear();
        this.addButton(warp);
    }


    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        xcoord.mouseClicked(mouseX, mouseY, mouseButton);
        ycoord.mouseClicked(mouseX, mouseY, mouseButton);
        zcoord.mouseClicked(mouseX, mouseY, mouseButton);
        dim.mouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        int x = (width - GUI_WIDTH) / 2;
        int y = (height - GUI_HEIGHT) / 2;

        mc.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(x, y, 0, 0, GUI_WIDTH, GUI_HEIGHT);
        xcoord.drawTextBox();
        ycoord.drawTextBox();
        zcoord.drawTextBox();
        dim.drawTextBox();


        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        xcoord.textboxKeyTyped(typedChar, keyCode);
        ycoord.textboxKeyTyped(typedChar, keyCode);
        zcoord.textboxKeyTyped(typedChar, keyCode);
        dim.textboxKeyTyped(typedChar, keyCode);
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public void updateScreen() {
        xcoord.updateCursorCounter();
        ycoord.updateCursorCounter();
        zcoord.updateCursorCounter();
        dim.updateCursorCounter();
        super.updateScreen();
    }
}