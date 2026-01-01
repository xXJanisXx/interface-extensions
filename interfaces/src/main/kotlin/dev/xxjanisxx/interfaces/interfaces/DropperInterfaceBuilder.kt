package dev.xxjanisxx.interfaces.interfaces

import com.noxcrew.interfaces.interfaces.InterfaceBuilder
import com.noxcrew.interfaces.pane.Pane
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player

/** Assists in building a [DropperInterface]. */
class DropperInterfaceBuilder :
    InterfaceBuilder<Pane, DropperInterface>() {

    /** Supplies the title of this interface. */
    var titleSupplier: (suspend (Player) -> Component?)? = null

    override fun build(): DropperInterface = DropperInterface(
        titleSupplier,
        this
    )
}
