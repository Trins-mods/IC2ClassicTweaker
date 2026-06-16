## Compressor

### Class

```java
import mods.ic2.Compressor;
```

### Method

#### `addRecipe`

```java
/*
 * Arguments: output, input, exp (optional)
 *   - IItemStack output
 *   - IIngredient input      Can be an ItemStack, OreDict, or other IIngredient types.
 *   - float exp (optional)   Experience gained from this recipe. Defaults to 0 if not specified.
 */
Compressor.addRecipe(<minecraft:diamond_block>, <minecraft:dirt> * 64, 0.5f);
```

This is equivalent to adding the following lines to `config/ic2/customMachineRecipes.json`:

```json
{
    "recipeType": "compressor",
    "outputs":
    [
      {
        "item": "minecraft:diamond_block",
        "meta": 0,
        "amount": 1
      }
    ],
    "recipeExperience": 0.5,
    "input":
      {
        "inputType": "item",
        "item": "minecraft:dirt",
        "meta": 0,
        "amount": 64
      }
}
```

To remove an existing recipe, use the `removeRecipe` method. You can also disable the corresponding entry in `config/ic2/ic2machineRecipes.json`.

Use `addLateRecipe` instead of `addRecipe` if you want the recipe to be loaded later.

#### `removeRecipe`

```java
/*
 * Arguments: input
 *   - IIngredient input      Removes the recipe that match this input.
 */
Compressor.removeRecipe(<minecraft:snowball>);
```
