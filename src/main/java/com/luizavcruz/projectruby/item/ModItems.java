package com.luizavcruz.projectruby.item;

import com.luizavcruz.projectruby.block.ModBlocks;
import com.luizavcruz.projectruby.ruby;
import com.luizavcruz.projectruby.util.Registration;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot",
                    () -> new Item(new Item.Properties().group(ruby.RUBY_TAB)));

    public static final RegistryObject<Item> COPPER_WIRE =
            Registration.ITEMS.register("copper_wire",
                    () -> new Item(new Item.Properties().group(ruby.RUBY_TAB)));

    public static final RegistryObject<Item> COPPER_APPLE =
            Registration.ITEMS.register("copper_apple",
                    CopperApple::new);

    public static final RegistryObject<Item> COPPER_SHOVEL =
            Registration.ITEMS.register("copper_shovel",
                    () -> new ShovelItem(ModItemTier.COPPER, 0f, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.SHOVEL, 2)
                                            .group(ruby.RUBY_TAB)));

    public static final RegistryObject<Item> COPPER_SWORD =
            Registration.ITEMS.register("copper_sword",
                    () -> new SwordItem(ModItemTier.COPPER, 2, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .group(ruby.RUBY_TAB)));

    public static final RegistryObject<Item> COPPER_PICKAXE =
            Registration.ITEMS.register("copper_pickaxe",
                    () -> new PickaxeItem(ModItemTier.COPPER, 0, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.PICKAXE, 2)
                                    .group(ruby.RUBY_TAB)));

    public static final RegistryObject<Item> COPPER_HOE =
            Registration.ITEMS.register("copper_hoe",
                    () -> new HoeItem(ModItemTier.COPPER, 0, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.HOE, 2)
                                    .group(ruby.RUBY_TAB)));

    public static final RegistryObject<Item> COPPER_AXE =
            Registration.ITEMS.register("copper_axe",
                    () -> new AxeItem(ModItemTier.COPPER, 0, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.AXE, 2)
                                    .group(ruby.RUBY_TAB)));

    public static final RegistryObject<Item> COPPER_HELMET =
            Registration.ITEMS.register("copper_helmet",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD,
                            new Item.Properties().group(ruby.RUBY_TAB)));

    public static final RegistryObject<Item> COPPER_CHESTPLATE =
            Registration.ITEMS.register("copper_chestplate",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST,
                            new Item.Properties().group(ruby.RUBY_TAB)));

    public static final RegistryObject<Item> COPPER_LEGGINGS =
            Registration.ITEMS.register("copper_leggings",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS,
                            new Item.Properties().group(ruby.RUBY_TAB)));

    public static final RegistryObject<Item> COPPER_BOOTS =
            Registration.ITEMS.register("copper_boots",
                    () -> new ArmorItem(ModArmorMaterial.COPPER, EquipmentSlotType.FEET,
                            new Item.Properties().group(ruby.RUBY_TAB)));

    public static final RegistryObject<Item> ZUCCINI_SEED =
            Registration.ITEMS.register("zuccini_seed",
            () -> new BlockItem(ModBlocks.ZUCCINI_CROP.get(), new Item.Properties().group(ruby.RUBY_TAB)));

    public static void register() { }

    public enum ModArmorMaterial implements IArmorMaterial
    {
        COPPER(50, new int[] { 2, 7, 5, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                Ingredient.fromStacks(new ItemStack(ModItems.COPPER_INGOT.get())), ruby.MOD_ID + ":copper", 0, 0.1f);

        private final int durability;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final Ingredient repairMaterial;
        private final String name;
        private final float toughness;
        private final float knockbackResistance;

        ModArmorMaterial(int durability, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent,
                         Ingredient repairMaterial, String name, float toughness, float knockbackResistance) {
            this.durability = durability;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.repairMaterial = repairMaterial;
            this.name = name;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
        }


        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return durability;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return knockbackResistance;
        }
    }

    public enum ModItemTier implements IItemTier
    {
        COPPER(2, 150, 2.5f, 1f, 15,
                Ingredient.fromStacks(new ItemStack(ModItems.COPPER_INGOT.get())));

        private final int harvestlevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient RepairMaterial;

        ModItemTier(int harvestlevel, int maxUses, float efficiency, float attackDamage, int enchantability, Ingredient repairMaterial) {
            this.harvestlevel = harvestlevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            RepairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses() {
            return harvestlevel;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestlevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return RepairMaterial;
        }
    }

}
