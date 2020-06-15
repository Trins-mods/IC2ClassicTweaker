package trinsdar.ic2classictweaker;

import crafttweaker.api.item.IIngredient;
import ic2.api.classic.recipe.crafting.IRecipeObject;
import ic2.api.recipe.IRecipeInput;
import ic2.core.item.misc.ItemDisplayIcon;
import ic2.core.item.recipe.AdvRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import java.util.Arrays;
import java.util.Collections;

public class AdvRecipeCT extends AdvRecipe {

    public AdvRecipeCT(ItemStack out, IIngredient[][] ingredients, boolean hidden){
        super(ItemDisplayIcon.createWithFluidStack(new FluidStack(FluidRegistry.WATER, 1000)), new Object[]{"w", 'w', ItemDisplayIcon.createWithFluidStack(new FluidStack(FluidRegistry.LAVA, 1000)), true});

        this.recipeID = "shaped_" + out.getUnlocalizedName();
        this.xOffset = -1;
        this.yOffset = -1;
        this.height = 0;
        this.hidden = hidden;

        int nullAmount = 0;
        int ingredientAmount = 0;
        for (IIngredient[] iIngredients : ingredients){
            for (IIngredient iIngredient : iIngredients){
                ingredientAmount++;
                if (iIngredient == null){
                    nullAmount++;
                }
            }
        }
        if (nullAmount == ingredientAmount){
            throw new RuntimeException("Recipe must have at least one nonnull input!");
        }

        this.output = out.copy();

        int height = ingredients.length;
        int width = 0;

        if (height <= 3) {
            int total = 0;
            this.length = -1;

            for(int i = 0; i < height; i++) {
                ++this.height;
                width = ingredients[i].length;

                if (width > 3){
                    throw new RuntimeException("All inner arrays must have 3 or less inputs!");
                }

                total = total + width;
                if (this.length != -1 && this.length != width) {
                    throw new RuntimeException("All inner arrays must be the same length!");
                }

                this.length = width;
            }

            if (this.length * this.height != total) {
                throw new RuntimeException("Template is not Matching");
            } else {
                this.input = new IRecipeInput[this.length * this.height];
                int slot = 0;

                for(int i = 0; i < this.height; ++i) {
                    for (int j = 0; j < length; ++j){
                        IRecipeInput obj = IC2RecipeInputs.of(ingredients[i][j]);
                        this.input[slot] = obj;
                        IRecipeObject entry = this.addObject(slot, obj);
                        ++slot;
                        if (entry != null) {
                            this.objects.add(entry);
                        }
                    }

                }

                this.recipeID = getRecipeID(Arrays.asList(this.input), Collections.singletonList(this.output), recipeID);
                this.setRegistryNameFixed(this.recipeID);

                slot = 0;
                this.ingredients = NonNullList.withSize(9, Ingredient.EMPTY);

                for(int y = 0; y < this.height; ++y) {
                    for(int x = 0; x < this.length; ++x) {
                        IRecipeInput obj = IC2RecipeInputs.of(ingredients[y][x]);
                        IRecipeObject entry = this.addObject(x + y * 3, obj);
                        ++slot;
                        if (entry != null) {
                            this.ingredients.set(entry.getSlot(), Ingredient.fromStacks((ItemStack[])entry.getItems().toArray(new ItemStack[0])));
                        }
                    }
                }

            }
        } else {
            throw new RuntimeException("Outer Recipe Array can only have a max of 3 inner arrays!");
        }
    }

    @Override
    protected IRecipe setRegistryNameFixed(String resourcePath) {
        IC2ClassicTweaker.logger.info("Registry name: " + resourcePath);
        if (!resourcePath.contains("itemDisplayIcon25")){
            super.setRegistryNameFixed(resourcePath);
        }
        return this;
    }
}
