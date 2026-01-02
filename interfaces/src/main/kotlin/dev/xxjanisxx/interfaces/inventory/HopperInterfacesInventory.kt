package dev.xxjanisxx.interfaces.inventory

import com.noxcrew.interfaces.inventory.CachedInterfacesInventory
import dev.xxjanisxx.interfaces.grid.mapping.HopperGridMapper
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

/** A wrapper around an [Inventory] for a hopper. */
class HopperInterfacesInventory(
    holder: InventoryHolder,
    title: Component?,
    private val mapper: HopperGridMapper,
) : CachedInterfacesInventory() {

    /** The [hopperInventory] being used to place items in. */
    val hopperInventory: Inventory = if (title != null) {
        Bukkit.createInventory(holder, InventoryType.HOPPER, title)
    } else {
        Bukkit.createInventory(holder, InventoryType.HOPPER)
    }

    override fun get(row: Int, column: Int): ItemStack? {
        val slot = mapper.toTopInventorySlot(row, column)
        if (slot !in 0..4) return null
        return hopperInventory.getItem(slot)
    }

    override fun setInternal(row: Int, column: Int, item: ItemStack?) {
        val slot = mapper.toTopInventorySlot(row, column)
        if (slot !in 0..4) return
        hopperInventory.setItem(slot, item)
    }
}
