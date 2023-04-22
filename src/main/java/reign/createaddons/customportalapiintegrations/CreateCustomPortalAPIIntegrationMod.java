package reign.createaddons.customportalapiintegrations;

import com.simibubi.create.Create;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.item.Items;

import net.minecraft.world.level.block.Blocks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateCustomPortalAPIIntegrationMod implements ModInitializer {
	public static final String ID = "createcustomportalapiintegration";
	public static final String NAME = "Create Custom Portal API Integration";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
		LOGGER.info(EnvExecutor.unsafeRunForDist(
				() -> () -> "{} is accessing Porting Lib from the client!",
				() -> () -> "{} is accessing Porting Lib from the server!"
		), NAME);
		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.DIAMOND_BLOCK)
				.lightWithItem(Items.ENDER_EYE)
				.destDimID(new ResourceLocation("the_end"))
				.tintColor(45,65,101)
				.registerPortal();
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
