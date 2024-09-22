package trinsdar.ic2classictweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.item.ElectricItem;
import ic2.api.item.ICustomDamageItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenExpansion("crafttweaker.item.IItemStack")
@ZenRegister
public class IC2ExtendedItemProperties {
    @ZenMethod
    @ZenGetter("ic2Charge")
    public static double getIC2Charge(IItemStack value) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        return ElectricItem.manager.getCharge(nativeItemStack);
    }

    @ZenMethod
    @ZenGetter("ic2Energy")
    public static double getIC2Energy(IItemStack value) {
        return getIC2Charge(value);
    }

    @ZenMethod
    @ZenGetter("ic2MaxCharge")
    public static double getIC2MaxCharge(IItemStack value) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        return ElectricItem.manager.getMaxCharge(nativeItemStack);
    }

    @ZenMethod
    @ZenGetter("ic2MaxEnergy")
    public static double getIC2MaxEnergy(IItemStack value) {
        return getIC2MaxCharge(value);
    }

    @ZenMethod
    @ZenSetter("ic2Charge")
    public static void setIC2Charge(IItemStack value, double charge) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        double current = ElectricItem.manager.getCharge(nativeItemStack);
        if (current < charge) {
            // Current EU < target EU, adding the missing
            ElectricItem.manager.charge(nativeItemStack, charge - current, 1, true, false);
        } else if (current > charge) {
            // Current EU > target EU, subtract the surplus
            ElectricItem.manager.discharge(nativeItemStack, current - charge, 1, true, false, false);
        }
    }

    @ZenMethod
    @ZenSetter("ic2MaxEnergy")
    public static void setIC2Energy(IItemStack value, double charge) {
        setIC2Charge(value, charge);
    }

    @ZenMethod
    @ZenGetter("ic2Damage")
    public static int getIC2Damage(IItemStack value) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        Item nativeItem = nativeItemStack.getItem();
        if (nativeItem instanceof ICustomDamageItem) {
            return ((ICustomDamageItem) nativeItem).getCustomDamage(nativeItemStack);
        }
        return -1;
    }

    @ZenMethod
    @ZenSetter("ic2Damage")
    public static void setIC2Damage(IItemStack value, int damage) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        Item nativeItem = nativeItemStack.getItem();
        if (nativeItem instanceof ICustomDamageItem) {
            ((ICustomDamageItem) nativeItem).setCustomDamage(nativeItemStack, damage);
        }
    }

    @ZenMethod
    @ZenGetter("ic2MaxDamage")
    public static int getIC2MaxDamage(IItemStack value) {
        ItemStack nativeItemStack = CraftTweakerMC.getItemStack(value);
        Item nativeItem = nativeItemStack.getItem();
        if (nativeItem instanceof ICustomDamageItem) {
            return ((ICustomDamageItem) nativeItem).getMaxCustomDamage(nativeItemStack);
        }
        return -1;
    }
}
