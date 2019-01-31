package io.jihuayu.goingages.recipe;

import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class SieveRecipe {
    private static Map<Item,Float> recipe= new HashMap<>();
    public static void addRecipe(Item item,Float num){
        if(num>1.0f)num=1.0f;
        if(recipe.containsKey(item))
            recipe.put(item,recipe.get(item)+num);
        else
            recipe.put(item,num);
    }
    public static void deleteRecipe(Item item){
        recipe.remove(item);
    }
    public static Map<Item,Float> getRecipe(){
        return new HashMap<>(recipe) ;
    }
}
