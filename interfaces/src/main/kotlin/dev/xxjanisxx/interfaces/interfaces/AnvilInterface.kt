package dev.xxjanisxx.interfaces.interfaces

import com.noxcrew.interfaces.interfaces.Interface
import com.noxcrew.interfaces.interfaces.TitledInterface
import com.noxcrew.interfaces.pane.Pane
import com.noxcrew.interfaces.view.InterfaceView
import dev.xxjanisxx.interfaces.grid.mapping.AnvilGridMapper
import dev.xxjanisxx.interfaces.view.AnvilInterfaceView
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player

/** An interface that uses an anvil GUI. */
class AnvilInterface internal constructor(
    override val titleSupplier: (suspend (Player) -> Component?)?,
    override val builder: AnvilInterfaceBuilder
) : Interface<AnvilInterface, Pane>, TitledInterface {

    companion object {
        /** The number of rows for an anvil GUI. */
        const val NUMBER_OF_ROWS: Int = 1
    }

    override val rows: Int = NUMBER_OF_ROWS
    override val includesPlayerInventory: Boolean = true
    override val mapper: AnvilGridMapper = AnvilGridMapper()

    override fun createPane(): Pane = Pane()

    override suspend fun open(player: Player, parent: InterfaceView?, reload: Boolean): AnvilInterfaceView {
        val view = AnvilInterfaceView(player, this, parent)
        view.open(reload)
        return view
    }
}
