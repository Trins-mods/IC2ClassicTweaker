## Recycler

### Class

```java
import mods.ic2.Recycler;
```

### Method

#### `addBlacklist`

```java
/*
 * Arguments: ingredient
 *   - IIngredient ingredient      Items matching this ingredient will be blacklisted from the recycler.
 *                                 Can be an ItemStack, OreDict, or other IIngredient types.
 */
Recycler.addBlacklist(<minecraft:dirt>);
Recycler.addBlacklist(<ore:gemDiamond>);
```

Blacklisted items will never be recycled by the recycler, even there is any recipe exist.

#### Add Recycler List

**This function is provided by IC2Classic. It is documented here for completeness.**

Add the following lines to `config/ic2/customMachineRecipes.json`

```json
{
  "recipeType": "recycler",
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

#### `removeRecipe`

```java
/*
 * Arguments: input
 *   - IIngredient input      Removes the recipe that match this input.
 */
Recycler.removeRecipe(<minecraft:rotten_flesh>);
```

You can also disable the corresponding entry in `config/ic2/ic2machineRecipes.json` to remove recipes.

Once disabled, the output will only be scrap.
