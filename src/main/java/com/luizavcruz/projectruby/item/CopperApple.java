package com.luizavcruz.projectruby.item;

import com.luizavcruz.projectruby.ruby;
import com.luizavcruz.projectruby.util.KeyboardHelper;
//import com.mojang.datafixers.types.templates.List;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class CopperApple extends Item {

    public CopperApple() {
        super(new Properties().group(ruby.RUBY_TAB)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(1.5f)
                        .effect(() -> new EffectInstance(Effects.GLOWING, 300, 1), 0.5f)
                        .build()));
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flag)
    {
        if(KeyboardHelper.isHoldingShift())
        {
            tooltip.add(new StringTextComponent("Transforma ovelhas em ovelhas de cobre temporariamente"));
        }
        else {
            tooltip.add(new StringTextComponent("Segure " + "\u00A7e" + "SHIFT" + "\u00A77" + " para mais informacao!"));
        }

        //super.addInformation(stack, world, tooltip, flag);
    }
}
