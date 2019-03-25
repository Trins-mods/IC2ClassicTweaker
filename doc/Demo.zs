import mods.ic2.Sawmill;
import mods.ic2.ClassicElectrolyzer;
import mods.ic2.LiquidFuelGenerator;
import mods.ic2.RareEarthExtractor;

/*
 * Arguments: output, input
 *   - IItemStack output
 *   - IIngredient input
 */
Sawmill.addRecipe(<minecraft:diamond_block>, <minecraft:dirt> * 64);

/*
 * Arguments: output, input, energy  This is basically a Charge and Discharge recipe combined.
 *   - IItemStack output
 *   - IItemStack input       Has to be an ItemStack, no oredict or other stuff.
 *   - int energy             Total eu received from discharge part and total energy used for charge part of the recipe.
 */
ClassicElectrolyzer.addBothRecipe(<minecraft:diamond>, <minecraft:dirt> * 64, 500);

/*
 * Arguments: output, input, energy
 *   - IItemStack output
 *   - IItemStack input       Has to be an ItemStack, no oredict or other stuff.
 *   - int energy             Total eu used in the recipe.
 */
ClassicElectrolyzer.addChargeRecipe(<minecraft:emerald>, <minecraft:stone> * 64, 500);

/*
 * Arguments: output, input, energy
 *   - IItemStack output
 *   - IItemStack input       Has to be an ItemStack, no oredict or other stuff.
 *   - int energy             Total eu received from the recipe.
 */
ClassicElectrolyzer.addDischargeRecipe(<minecraft:cobblestone> * 64, <minecraft:bedrock>, 500);

/*
 * Arguments: liquid, ticks, powerOutput
 *   - ILiquidStack liquid    The liquid which can be used as fuel in semi-fluid generator
 *   - int ticks              The time in ticks the liquid will burn for.
 *   - int powerOutput        EU/tick produced by the liquid.
 */
LiquidFuelGenerator.addFluid(<liquid:water>, 1000, 32);

/*
 * Arguments: value, inputs
 *   - float value
 *   - IItemStack... inputs      Can have more then one specified for the input. If so all the specified items give the same spcified value.
 */
RareEarthExtractor.addRareEarthEntries(1.0F, <minecraft:bedrock>, <minecraft:iron_block>);

//TODO: Get this to actually work.
/*
 * Arguments: inputs            Currently this doesn't actually work.
 *   - IItemStack... inputs     Removes all the specified items from the list of items giving rare earth values.
 */
RareEarthExtractor.removeRareEarthEntries(<minecraft:iron_block>);