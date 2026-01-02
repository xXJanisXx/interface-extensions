package dev.xxjanisxx.interfaces.view

import com.noxcrew.interfaces.InterfacesListeners
import com.noxcrew.interfaces.pane.Pane
import com.noxcrew.interfaces.utilities.TitleState
import com.noxcrew.interfaces.view.AbstractInterfaceView
import com.noxcrew.interfaces.view.InterfaceView
import dev.xxjanisxx.interfaces.interfaces.HopperInterface
import dev.xxjanisxx.interfaces.inventory.HopperInterfacesInventory
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

/** Implements a hopper view. */
class HopperInterfaceView internal constructor(
    player: Player,
    backing: HopperInterface,
    parent: InterfaceView?,
) : AbstractInterfaceView<HopperInterfacesInventory, HopperInterface, Pane>(
    player,
    backing,
    parent,
),
    InventoryHolder {

    private val titleState = TitleState()

    override fun title(value: Component) {
        titleState.current = value
    }

    override fun createInventory(): HopperInterfacesInventory =
        HopperInterfacesInventory(
            holder = this,
            title = titleState.current,
            mapper = backing.mapper,
        )

    override fun openInventory() {
        player.openInventory(this.inventory)
        InterfacesListeners.INSTANCE.completeRendering(player.uniqueId, this)
    }

    override suspend fun updateTitle() {
        titleState.current = backing.titleSupplier?.invoke(player)
    }

    override fun requiresNewInventory(): Boolean =
        super.requiresNewInventory() || titleState.hasChanged

    override fun getInventory(): Inventory =
        currentInventory.hopperInventory

    override fun isOpen(): Boolean =
        player.openInventory.topInventory.getHolder(false) == this
}
