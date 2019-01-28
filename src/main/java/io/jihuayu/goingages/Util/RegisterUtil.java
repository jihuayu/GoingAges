package io.jihuayu.goingages.Util;

import com.google.common.collect.Maps;
import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.api.GARegister;
import io.jihuayu.goingages.api.GAUnRegister;
import net.minecraft.item.Item;

import java.util.Map;
import java.util.Set;

@Deprecated
public class RegisterUtil {
    public static Map<String,Item> items = Maps.newHashMap();
    public static Set<Class<?>> mc =  ReflectUtil.getClasses(GoingAges.class.getPackage().getName());
    public static void registerItem(){
        try {
            for(Class i :mc) {
                if(GAUnRegister.class.isAssignableFrom(i))return;
                if (!GARegister.class.isAssignableFrom(i)) continue;
                if (Item.class.isAssignableFrom(i)) {
                    Item obj = (Item) i.newInstance();
                    items.put(obj.getUnlocalizedName(),obj);
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
