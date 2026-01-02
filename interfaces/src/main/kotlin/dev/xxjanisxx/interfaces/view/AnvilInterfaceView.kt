package dev.xxjanisxx.interfaces.view

import com.noxcrew.interfaces.InterfacesListeners
import com.noxcrew.interfaces.pane.Pane
import com.noxcrew.interfaces.utilities.TitleState
import com.noxcrew.interfaces.view.AbstractInterfaceView
import com.noxcrew.interfaces.view.InterfaceView
import dev.xxjanisxx.interfaces.interfaces.AnvilInterface
import dev.xxjanisxx.interfaces.inventory.AnvilInterfacesInventory
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

/** Implements an anvil view. */
class AnvilInterfaceView internal constructor(
    player: Player,
    backing: AnvilInterface,
    parent: InterfaceView?,
) : AbstractInterfaceView<AnvilInterfacesInventory, AnvilInterface, Pane>(
    player,
    backing,
    parent,
),
    InventoryHolder {

    private val titleState = TitleState()

    override fun title(value: Component) {
        titleState.current = value
    }

    override fun createInventory(): AnvilInterfacesInventory =
        AnvilInterfacesInventory(
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

    override fun getInventory(): Inventory = currentInventory.anvilInventory

    override fun isOpen(): Boolean =
        player.openInventory.topInventory.getHolder(false) == this
}
