## ThermalCentrifuge

> **Note:** This machine requires the `ic2c_extras` addon mod to be installed. Recipes for IC2C Extras machines cannot be modified via JSON files; use CraftTweaker methods only.

### Class

```java
import mods.ic2.ThermalCentrifuge;
```

### Method

#### `addRecipe`

```java
/*
 * Arguments: outputs, input, minHeat (optional, defaults to 1000)
 *   - IItemStack[] outputs    The results of centrifuging the input. Can be up to 3 items.
 *   - IIngredient input       Can be an ItemStack, OreDictEntry, or other IIngredient types.
 *   - int minHeat (optional)  Minimum heat required (in HU) for this recipe. Defaults to 1000 if not specified.
 */
ThermalCentrifuge.addRecipe([<minecraft:diamond>, <minecraft:emerald>, <minecraft:nether_star>], <minecraft:dirt>, 500);
```

Use `addLateRecipe` instead of `addRecipe` if you want the recipe to be loaded later.

#### `removeRecipe`

```java
/*
 * Arguments: input
 *   - IIngredient input      Removes the recipes that match this input.
 */
ThermalCentrifuge.removeRecipe(<ic2c_extras:ironpurifiedcrushedore>>);
```