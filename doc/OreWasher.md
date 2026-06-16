## OreWasher

> **Note:** This machine requires the `ic2c_extras` addon mod to be installed.

### Class

```java
import mods.ic2.OreWasher;
```

### Method

#### `addRecipe`

```java
/*
 * Arguments: outputs, input, water (optional, defaults to 1000)
 *   - IItemStack[] outputs    The results of washing the input. Can be up to 3 items.
 *   - IIngredient input       Can be an ItemStack, OreDict, or other IIngredient types.
 *   - int water (optional)    Amount of water (in mB) consumed by this recipe. Defaults to 1000 if not specified.
 */
OreWasher.addRecipe([<minecraft:diamond>, <minecraft:emerald>, <minecraft:nether_star>], <minecraft:dirt>, 500);
```

Use `addLateRecipe` instead of `addRecipe` if you want the recipe to be loaded later.

#### `removeRecipe`

```java
/*
 * Arguments: input
 *   - IIngredient input      Removes the recipe that match this input.
 */
OreWasher.removeRecipe(<ic2c_extras:ironcrushedore>);
```
