package dev.xxjanisxx.interfaces.interfaces

import com.noxcrew.interfaces.interfaces.Interface
import com.noxcrew.interfaces.interfaces.TitledInterface
import com.noxcrew.interfaces.pane.Pane
import com.noxcrew.interfaces.view.InterfaceView
import dev.xxjanisxx.interfaces.grid.mapping.DropperGridMapper
import dev.xxjanisxx.interfaces.view.DropperInterfaceView
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player

/** An interface that uses a dropper GUI. */
class DropperInterface internal constructor(
    override val titleSupplier: (suspend (Player) -> Component?)?,
    override val builder: DropperInterfaceBuilder
) : Interface<DropperInterface, Pane>, TitledInterface {

    companion object {
        /** The number of rows for a dropper GUI. */
        const val NUMBER_OF_ROWS: Int = 3
    }

    override val rows: Int = NUMBER_OF_ROWS
    override val includesPlayerInventory: Boolean = false
    override val mapper: DropperGridMapper = DropperGridMapper()

    override fun createPane(): Pane = Pane()

    override suspend fun open(player: Player, parent: InterfaceView?, reload: Boolean): DropperInterfaceView {
        val view = DropperInterfaceView(player, this, parent)
        view.open(reload)
        return view
    }
}
