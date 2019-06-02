## Electrolyzer

### Class

```java
import mods.ic2.ClassicElectrolyzer;
```

### Method

#### `addBothRecipe`

```java
/*
 * Arguments: output, input, energy  This is basically a Charge and Discharge recipe combined.
 *   - IItemStack output
 *   - IItemStack input       Has to be an ItemStack, no oredict or other stuff.
 *   - int energy             Total eu received from discharge part and total energy used for charge part of the recipe.
 */
ClassicElectrolyzer.addBothRecipe(<minecraft:diamond>, <minecraft:dirt> * 64, 500);
```

This is equivalent to add the following lines to `config/ic2/customMachineRecipes.json`:

```json
        {
			"recipeType": "electrolyzer",
			"recipeEnergy": 500,
			"direction": "both",
			"input":
			{
				"item": "minecraft:dirt",
				"meta": 0,
				"amount": 64
			},
			"output":
			{
				"item": "minecraft:diamond",
				"meta": 0,
				"amount": 1
			}
		}
```

To remove an existed recipe, simply disable the corresponding recipe in `config/ic2/ic2machineRecipes.json`.

#### `addChargeRecipe`

```java
/*
 * Arguments: output, input, energy
 *   - IItemStack output
 *   - IItemStack input       Has to be an ItemStack, no oredict or other stuff.
 *   - int energy             Total eu used in the recipe.
 */
ClassicElectrolyzer.addChargeRecipe(<minecraft:emerald>, <minecraft:stone> * 64, 500);
```

This is equivalent to add the following lines to `config/ic2/customMachineRecipes.json`:

```json
        {
			"recipeType": "electrolyzer",
			"recipeEnergy": 500,
			"direction": "charge",
			"input":
			{
				"item": "minecraft:stone",
				"meta": 0,
				"amount": 64
			},
			"output":
			{
				"item": "minecraft:emerald",
				"meta": 0,
				"amount": 1
			}
		}
```

To remove an existed recipe, simply disable the corresponding recipe in `config/ic2/ic2machineRecipes.json`.

#### `addDischargeRecipe`

```java
/*
 * Arguments: output, input, energy
 * Technically the output gets discharged into the input.
 *   - IItemStack output      This is what goes into the discharge slot, aka output slot.
 *   - IItemStack input       Has to be an ItemStack, no oredict or other stuff. This is what comes out the charge slot, aka the input slot.
 *   - int energy             Total eu received from the recipe.
 */
ClassicElectrolyzer.addDischargeRecipe(<minecraft:cobblestone> * 64, <minecraft:bedrock>, 500);
```

This is equivalent to add the following lines to `config/ic2/customMachineRecipes.json`:

```json
        {
			"recipeType": "electrolyzer",
			"recipeEnergy": 500,
			"direction": "discharge",
			"input":
			{
				"item": "minecraft:bedrock",
				"meta": 0,
				"amount": 1
			},
			"output":
			{
				"item": "minecraft:cobblestone",
				"meta": 0,
				"amount": 64
			}
		}
```

To remove an existed recipe, simply disable the corresponding recipe in `config/ic2/ic2machineRecipes.json`.
```