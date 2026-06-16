## Extractor

### Class

```java
import mods.ic2.Extractor;
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
Extractor.addRecipe(<minecraft:gunpowder> * 2, <minecraft:netherrack>, 0.5f);
```

This is equivalent to adding the following lines to `config/ic2/customMachineRecipes.json`:

```json
{
    "recipeType": "extractor",
    "outputs":
    [
      {
        "item": "minecraft:gunpowder",
        "meta": 0,
        "amount": 2
      }
    ],
    "recipeExperience": 0.5,
    "input":
      {
        "inputType": "item",
        "item": "minecraft:netherrack",
        "meta": 0,
        "amount": 1
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
Extractor.removeRecipe(<minecraft:gravel>);
```
