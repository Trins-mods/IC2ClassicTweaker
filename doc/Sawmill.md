## Sawmill

### Class

```java
import mods.ic2.Sawmill;
```

### Method

```java
/*
 * Arguments: output, input
 *   - IItemStack output
 *   - IIngredient input
 */
Sawmill.addRecipe(<minecraft:diamond_block>, <minecraft:dirt> * 64);
```

This is equivalent to add the following lines to `config/ic2/customMachineRecipes.json`:

```json
        {
			"recipeType": "sawmill",
			"outputs":
			[
				{
					"item": "minecraft:diamond",
					"meta": 0,
					"amount": 1
				}
			],
			"input":
			{
				"inputType": "item",
				"item": "minecraft:dirt",
				"meta": 0,
                "amount": 64
			}
		}
```

To remove an existed recipe, simply disable the corresponding recipe in `config/ic2/ic2machineRecipes.json`.