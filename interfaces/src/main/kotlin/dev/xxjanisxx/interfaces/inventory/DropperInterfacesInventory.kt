package dev.xxjanisxx.interfaces.inventory

import com.noxcrew.interfaces.inventory.CachedInterfacesInventory
import dev.xxjanisxx.interfaces.grid.mapping.DropperGridMapper
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

/** A wrapper around an [Inventory] for a dropper. */
class DropperInterfacesInventory(
    holder: InventoryHolder,
    title: Component?,
    private val mapper: DropperGridMapper,
) : CachedInterfacesInventory() {

    /** The [dropperInventory] being used to place items in. */
    val dropperInventory: Inventory = if (title != null) {
        Bukkit.createInventory(holder, InventoryType.DROPPER, title)
    } else {
        Bukkit.createInventory(holder, InventoryType.DROPPER)
    }

    override fun get(row: Int, column: Int): ItemStack? {
        return dropperInventory.getItem(mapper.toTopInventorySlot(row, column))
    }

    override fun setInternal(row: Int, column: Int, item: ItemStack?) {
        dropperInventory.setItem(mapper.toTopInventorySlot(row, column), item)
    }
}
