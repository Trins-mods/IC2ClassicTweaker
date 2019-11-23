package trinsdar.ic2classictweaker;

import crafttweaker.api.item.IIngredient;
import ic2.core.item.misc.ItemDisplayIcon;
import ic2.core.item.recipe.AdvRecipe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class AdvRecipeCT extends AdvRecipe {

    public AdvRecipeCT(ItemStack out, IIngredient[][] ingredients){
        super(ItemDisplayIcon.createWithFluidStack(new FluidStack(FluidRegistry.WATER, 1000)), new Object[]{"w", 'w', ItemDisplayIcon.createWithFluidStack(new FluidStack(FluidRegistry.LAVA, 1000)), true});

        // commented this out for now because of compile errors
        /*this.xOffset = -1; // currently private
        this.yOffset = -1; // currently private

        this.output = out.copy();
        List<String> template = new ArrayList();
        Character lastChar = null;
        Map<Character, IRecipeInput> charToItem = new HashMap();

        int height = ingredients.length;
        int width = 0;

        if (height <= 3) {
            int total = 0;
            this.length = -1;

            for(int i = 0; i < height; i++) {
                ++this.height;
                width = ingredients[i].length;

                if (width > 3){
                    throw new RuntimeException("All inner arrays must have 3 or less elements");
                }

                total = total + width;
                if (this.length != -1 && this.length != width) {
                    throw new RuntimeException("All inner arrays need to have the same length");
                }

                this.length = width;
            }

            if (this.length * this.height != total) {
                throw new RuntimeException("Template is not Matching");
            } else {
                this.input = new IRecipeInput[this.length * this.height]; // currently private
                int slot = 0;

                for(int i = 0; i < this.height; ++i) {
                    for (int j = 0; j < length; ++j){
                        IRecipeInput obj = IC2RecipeInputs.of(input[i][j]);
                        this.input[slot] = obj;
                        IRecipeObject entry = this.addObject(slot, obj);
                        ++slot;
                        if (entry != null) {
                            this.objects.add(entry);
                        }
                    }

                }

                this.recipeID = getRecipeID(Arrays.asList(this.input), Arrays.asList(this.output), recipeID);
                this.setRegistryNameFixed(this.recipeID);

                slot = 0;
                this.ingredients = NonNullList.withSize(9, Ingredient.EMPTY);

                for(int y = 0; y < this.height; ++y) {
                    for(int x = 0; x < this.length; ++x) {
                        IRecipeInput obj = IC2RecipeInputs.of(input[y][x]);
                        IRecipeObject entry = this.addObject(x + y * 3, obj); // currently private
                        ++slot;
                        if (entry != null) {
                            this.ingredients.set(entry.getSlot(), Ingredient.fromStacks((ItemStack[])entry.getItems().toArray(new ItemStack[0])));
                        }
                    }
                }

            }
        } else {
            throw new RuntimeException("Template is not Matching");
        }*/
    }
}
