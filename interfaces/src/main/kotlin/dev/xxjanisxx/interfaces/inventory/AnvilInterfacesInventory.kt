package dev.xxjanisxx.interfaces.inventory

import com.noxcrew.interfaces.inventory.CachedInterfacesInventory
import dev.xxjanisxx.interfaces.grid.mapping.AnvilGridMapper
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

/** A wrapper around an [Inventory] for an anvil. */
class AnvilInterfacesInventory(
    holder: InventoryHolder,
    title: Component?,
    private val mapper: AnvilGridMapper,
) : CachedInterfacesInventory() {

    /** The [anvilInventory] being used to place items in. */
    val anvilInventory: Inventory = if (title != null) {
        Bukkit.createInventory(holder, InventoryType.ANVIL, title)
    } else {
        Bukkit.createInventory(holder, InventoryType.ANVIL)
    }

    override fun get(row: Int, column: Int): ItemStack? {
        val slot = mapper.toTopInventorySlot(row, column)
        if (slot !in 0..2) return null
        return anvilInventory.getItem(slot)
    }

    override fun setInternal(row: Int, column: Int, item: ItemStack?) {
        val slot = mapper.toTopInventorySlot(row, column)
        if (slot !in 0..2) return
        anvilInventory.setItem(slot, item)
    }
}
