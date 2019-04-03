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

```java

    CanningMachine.registerFuelValue(10, <minecraft:diamond_block>);
    CanningMachine.registerFuelValue(1274, <ic2:itemmisc:102>);
```

```java

    CanningMachine.registerFuelMultiplier(0.5f, <minecraft:diamond>);
```