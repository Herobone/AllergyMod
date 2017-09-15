package com.herobone.allergy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.herobone.allergy.capability.Allergy;
import com.herobone.allergy.capability.AllergyStorage;
import com.herobone.allergy.capability.BiomeCap;
import com.herobone.allergy.capability.BiomeCapStorage;
import com.herobone.allergy.capability.IAllergy;
import com.herobone.allergy.capability.IIntolerance;
import com.herobone.allergy.capability.IBiomeCap;
import com.herobone.allergy.capability.Intolerance;
import com.herobone.allergy.capability.IntoleranceStorage;
import com.herobone.allergy.handler.CapabilityHandler;
import com.herobone.allergy.handler.CloneHandler;
import com.herobone.allergy.handler.EatHandler;
import com.herobone.allergy.handler.PlayerJoinHandler;
import com.herobone.allergy.handler.UpdateHandler;
import com.herobone.allergy.proxy.CommonProxy;
import com.herobone.allergy.registry.BlockRegistry;
import com.herobone.allergy.registry.CraftingRegistry;
import com.herobone.allergy.registry.ItemRegistry;
import com.herobone.allergy.registry.SmeltingRegistry;
import com.herobone.allergy.registry.TabRegister;
import com.herobone.allergy.util.EnumColor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AllergyMod.MODID, version = AllergyMod.VERSION, name = AllergyMod.NAME, dependencies = "required-after:AppleCore;")
public class AllergyMod
{
    public static final String MODID = "allergy";
    public static final String VERSION = "1.0";
    public static final String NAME = "Allergy Mod";
    public static final Logger LOGGER = LogManager.getLogger("Allergy Mod");
    
    @Instance(MODID)
    public static AllergyMod instance = new AllergyMod();
    
    @SidedProxy(modId = MODID, serverSide = "com.herobone.allergy.proxy.CommonProxy", clientSide = "com.herobone.allergy.proxy.ClientProxy")
    public static CommonProxy proxy = new CommonProxy();
    
    public static final RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
    public static final RenderItem itemRenderer = Minecraft.getMinecraft().getRenderItem();
    
    public TabRegister tab;
    
    public static final String CHATPREFIX = EnumColor.DARK_BLUE + "[Allergy Mod] ";
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    	ItemRegistry items;
        BlockRegistry blocks;
    	
    	OBJLoader.INSTANCE.addDomain(AllergyMod.MODID);
    	
    	tab = new TabRegister();
    	
    	items = new ItemRegistry();
    	items.init();
    	items.register();
    	
    	blocks = new BlockRegistry();
    	blocks.init();
    	blocks.register();
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	CraftingRegistry crafting;
        SmeltingRegistry smelting;
    	
    	crafting = new CraftingRegistry();
    	crafting.unregister();
    	crafting.register();
    	
    	smelting = new SmeltingRegistry();
    	smelting.unregister();
    	smelting.register();
    	
    	CapabilityManager.INSTANCE.register(IAllergy.class, new AllergyStorage(), Allergy.class);
    	CapabilityManager.INSTANCE.register(IIntolerance.class, new IntoleranceStorage(), Intolerance.class);
    	CapabilityManager.INSTANCE.register(IBiomeCap.class, new BiomeCapStorage(), BiomeCap.class);
		
    	MinecraftForge.EVENT_BUS.register(new PlayerJoinHandler());
    	MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
    	MinecraftForge.EVENT_BUS.register(new CloneHandler());
    	MinecraftForge.EVENT_BUS.register(new EatHandler());
    	MinecraftForge.EVENT_BUS.register(new UpdateHandler());
    	
    	proxy.registerModelBakeryVariants();
    	
    	proxy.init();
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    	proxy.registerModels();
    }
}
