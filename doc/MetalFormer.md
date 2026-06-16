## MetalFormer

> **Note:** This documentation covers three separate machines from `ic2c_extras`: **Cutter**, **Roller**, and **Extruder**. For compatibility with existing scripts, they are grouped under the `MetalFormer` class name. Recipes for IC2C Extras machines cannot be modified via JSON files; use CraftTweaker methods only.

### Class

```java
import mods.ic2.MetalFormer;
```

### Methods

The methods in this class correspond to three separate machines from `ic2c_extras`:

| Machine | Add Method | Add Late Method | Remove Method |
|---------|------------|-----------------|---------------|
| Cutter | `addCuttingRecipe` | `addLateCuttingRecipe` | `removeCuttingRecipe` |
| Roller | `addRollingRecipe` | `addLateRollingRecipe` | `removeRollingRecipe` |
| Extruder | `addExtrudingRecipe` | `addLateExtrudingRecipe` | `removeExtrudingRecipe` |

---

#### `addCuttingRecipe`

```java
/*
 * Arguments: output, input, exp (optional)
 *   - IItemStack output      The result of cutting the input (for the Cutter).
 *   - IIngredient input      Can be an ItemStack, OreDictEntry, or other IIngredient types.
 *   - float exp (optional)   Experience gained from this recipe. Defaults to 0 if not specified.
 */
MetalFormer.addCuttingRecipe(<minecraft:diamond_block>, <minecraft:dirt> * 64, 0.1f);
```

Use `addLateCuttingRecipe` instead of `addCuttingRecipe` if you want the recipe to be loaded later.

#### `addRollingRecipe`

```java
/*
 * Arguments: output, input, exp (optional)
 *   - IItemStack output      The result of rolling the input (for the Roller).
 *   - IIngredient input      Can be an ItemStack, OreDictEntry, or other IIngredient types.
 *   - float exp (optional)   Experience gained from this recipe. Defaults to 0 if not specified.
 */
MetalFormer.addRollingRecipe(<minecraft:diamond_block>, <minecraft:dirt> * 64, 0.2f);
```

Use `addLateRollingRecipe` instead of `addRollingRecipe` if you want the recipe to be loaded later.

#### `addExtrudingRecipe`

```java
/*
 * Arguments: output, input, exp (optional)
 *   - IItemStack output      The result of extruding the input (for the Extruder).
 *   - IIngredient input      Can be an ItemStack, OreDictEntry, or other IIngredient types.
 *   - float exp (optional)   Experience gained from this recipe. Defaults to 0 if not specified.
 */
MetalFormer.addExtrudingRecipe(<minecraft:diamond_block>, <minecraft:dirt> * 64, 0.1f);
```

Use `addLateExtrudingRecipe` instead of `addExtrudingRecipe` if you want the recipe to be loaded later.

---

#### `removeCuttingRecipe`

```java
/*
 * Arguments: input
 *   - IIngredient input      Removes the recipe that match this input.
 */
MetalFormer.removeCuttingRecipe(<minecraft:planks>);
MetalFormer.removeCuttingRecipe(<ore:plankWood>);
```

#### `removeRollingRecipe`

```java
/*
 * Arguments: input
 *   - IIngredient input      Removes the recipe that match this input.
 */
MetalFormer.removeRollingRecipe(<ic2c_extras:iron_plate>);
```

#### `removeExtrudingRecipe`

```java
/*
 * Arguments: input
 *   - IIngredient input      Removes the recipe that match this input.
 */
MetalFormer.removeExtrudingRecipe(<minecraft:gold_ingot>);
```
