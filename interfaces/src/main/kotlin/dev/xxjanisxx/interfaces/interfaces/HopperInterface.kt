package dev.xxjanisxx.interfaces.interfaces

import com.noxcrew.interfaces.interfaces.Interface
import com.noxcrew.interfaces.interfaces.TitledInterface
import com.noxcrew.interfaces.pane.Pane
import com.noxcrew.interfaces.view.InterfaceView
import dev.xxjanisxx.interfaces.grid.mapping.HopperGridMapper
import dev.xxjanisxx.interfaces.view.HopperInterfaceView
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player

/** An interface that uses a hopper GUI. */
class HopperInterface internal constructor(
    override val titleSupplier: (suspend (Player) -> Component?)?,
    override val builder: HopperInterfaceBuilder
) : Interface<HopperInterface, Pane>, TitledInterface {

    companion object {
        /** The number of rows for a hopper GUI. */
        const val NUMBER_OF_ROWS: Int = 1
    }

    override val rows: Int = NUMBER_OF_ROWS
    override val includesPlayerInventory: Boolean = true
    override val mapper: HopperGridMapper = HopperGridMapper()

    override fun createPane(): Pane = Pane()

    override suspend fun open(
        player: Player,
        parent: InterfaceView?,
        reload: Boolean
    ): HopperInterfaceView {
        val view = HopperInterfaceView(player, this, parent)
        view.open(reload)
        return view
    }
}
