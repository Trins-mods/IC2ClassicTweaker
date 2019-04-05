## Canning Machine

### Class

```java
import mods.ic2.CanningMachine;
```

### Method

```java
    /*
	 * Register Existing filled tin can inputs for the Effect you want.
	 *
	 * 1: Hunger (Rotten Flesh) (80% chance)
	 * 2: Poison (Spider Eye)
	 * 3: Hunger (Raw Chicken) (30% chance)
	 * 4: Golden Apple
	 * 5: Notch Apple
	 * 6: Corus Fruit
	 *
	 * Arguments: effectID, inputs
	 *   - int effectID              The effectID you want to apply to the specified items.
	 *   - IItemStack... inputs       Has to be an ItemStack, no oredict or other stuff.
	 */
	CanningMachine.registerItemsForEffect(4, <minecraft:fish>);
```

```java
    /*
	 * Deletes existing effects from input items. Also can remove the inputs with that effect from filled can ingredients.
	 *
	 *
	 * Arguments: effectID, deleteItems
     *   - int effectID              The effectID you want to remove from filled can.
     *   - boolean deleteItems       Whether to remove items with that effect from filed can too. Currently this boolean may not work.
	 */
	CanningMachine.deleteEffectId(5, false);
```

    For info on how fuel cans work: https://github.com/TinyModularThings/IC2Classic/wiki/Fuel-Cans
```java
	/*
	 * Registers new fuel value for the input items. Used for filling a fuel can.
	 *
	 *
	 * Arguments: fuelValue, input
     *   - int fuelValue          How much fuel the specified item is worth.
     *   - IItemStack input       The item to register that fuel value for. It can even be items with existing values, in which case the previously specified value will be overwritten. Note: must be an itemstack, no oredicts allowed.
	 */
    CanningMachine.registerFuelValue(10, <minecraft:diamond_block>);
    CanningMachine.registerFuelValue(1274, <ic2:itemmisc:102>); //Formerly had a value of 2548.
```

```java
	/*
	 * Registers new fuel multiplier for the input items. Used for filling a fuel can. It is overriden by fuel value when the recipe is progressing.
	 *
	 *
	 * Arguments: fuelMultiplier, input
     *   - float fuelMultiplier          What percentage the previously input value is increased by. for example 1 = 100%, 0.5 = 50%, 0 = 0%, ect.
     *   - IItemStack input              The item to register that fuel multiplier for. It can even be items with existing multipliers, in which case the previously specified multiplier will be overwritten. Note: must be an itemstack, no oredicts allowed.
	 */
    CanningMachine.registerFuelMultiplier(0.5f, <minecraft:diamond>);
```

```java
	/*
	 * Removes an item from being an input for a fuel can.
	 *
	 *
	 * Arguments: input
     *   - IItemStack input              The item to remove from the fuel can.
	 */
    CanningMachine.deleteItemFuel(<ic2:itemmisc:102>);
```

```java
	/*
	 * Adds Regular canning recipe to the Canning Machine.
	 *
	 *
	 * Arguments: fuelMultiplier, input
     *   - IItemStack output             The output of the recipe
     *   - IIngredient input             The input of the recipe.
	 *   - IItemStack container          the item the input is being "filled or canned into" to produce the output. Must be an ItemStack.
	 */
    CanningMachine.addCanningRecipe(<minecraft:emerald>, <minecraft:diamond>, <minecraft:bucket>);
```
