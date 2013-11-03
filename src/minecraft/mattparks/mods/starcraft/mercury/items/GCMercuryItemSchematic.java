package mattparks.mods.starcraft.mercury.items;

import java.util.List;

import mattparks.mods.starcraft.core.StarcraftCore;
import micdoodle8.mods.galacticraft.api.recipe.ISchematicItem;
import micdoodle8.mods.galacticraft.core.items.GCCoreItemSchematic;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCMercuryItemSchematic extends GCCoreItemSchematic implements ISchematicItem
{
    protected Icon[] icons = new Icon[1];

    public static final String[] names = { "schematic_rocketT4" };

    public GCMercuryItemSchematic(int itemID)
    {
        super(itemID, "schematic");
    }

    @Override
    public CreativeTabs getCreativeTab()
    {
        return StarcraftCore.starcraftMercuryTab;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < GCMercuryItemSchematic.names.length; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.icons = new Icon[GCMercuryItemSchematic.names.length];
        
        for (int i = 0; i < GCMercuryItemSchematic.names.length; i++)
        {
            this.icons[i] = iconRegister.registerIcon(StarcraftCore.ASSET_PREFIX + GCMercuryItemSchematic.names[i]);
        }
        
    }

    @Override
    public Icon getIconFromDamage(int damage)
    {
        if (this.icons.length > damage)
        {
            return this.icons[damage];
        }

        return super.getIconFromDamage(damage);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        if (par2EntityPlayer.worldObj.isRemote)
        {
            switch (par1ItemStack.getItemDamage())
            {
            case 0:
                par3List.add(LanguageRegistry.instance().getStringLocalization("schematic.rocketT4.name"));
                break;
            }
        }
    }
}
