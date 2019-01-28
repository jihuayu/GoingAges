package io.jihuayu.goingages;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
@IFMLLoadingPlugin.SortingIndex(-7500)
//@IFMLLoadingPlugin.TransformerExclusions("io.jihuayu.goingages")
public class GALoadingPlugin implements IFMLLoadingPlugin {

    public GALoadingPlugin() {
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.goingages.item.json");
    }

    @Override public String[] getASMTransformerClass() {  return new String[0]; }
    @Override public String getModContainerClass() { return null; }
    @Nullable
    @Override public String getSetupClass() { return null; }
    @Override public void injectData(Map<String, Object> data) {}
    @Override public String getAccessTransformerClass() { return null; }
}
