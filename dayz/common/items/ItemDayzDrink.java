package dayz.common.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dayz.common.misc.Util;
import dayz.common.playerdata.PlayerStats;

public class ItemDayzDrink extends ItemFood
{
    private final int thirst;
    private int textureIndex;

    /**
     * Day Z Drink Item
     * @param itemID The ID of the item
     * @param saturationmodifier The hunger bar saturation to be restored
     * @param drinkEffect Potion effect of the drink
     */
    public ItemDayzDrink(int itemID, int thirst, int index)
    {
        super(itemID, 0, thirst, false);
        this.thirst = thirst;
        this.maxStackSize = 1;
        this.textureIndex = index;
    }

    @Override
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	PlayerStats.subtractThirst(par3EntityPlayer, thirst);
    	par1ItemStack.stackSize--;
        par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
        return par1ItemStack;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }
    
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    { 	
        entityplayer.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
        return itemstack;
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
    	switch(this.textureIndex)
    	{
    		case 0: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":lemonade"); return;
    		case 1: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":canSodaCoke"); return;
    		case 2: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":canSodaCoke"); return;
    		case 3: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":canSodaMountainDew"); return;
    		case 4: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":canSodaPepsi"); return;
    		case 5: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":appleDrink");return;
    		case 6: this.itemIcon = par1IconRegister.registerIcon(Util.ID + ":orangeDrink");return;
    	}
    }
}
