package dev.xxjanisxx.interfaces.interfaces

import com.noxcrew.interfaces.interfaces.InterfaceBuilder
import com.noxcrew.interfaces.pane.Pane
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player

/** Assists in building a [AnvilInterface]. */
class AnvilInterfaceBuilder :
    InterfaceBuilder<Pane, AnvilInterface>() {

    /** Supplies the title of this interface. */
    var titleSupplier: (suspend (Player) -> Component?)? = null

    override fun build(): AnvilInterface = AnvilInterface(
        titleSupplier,
        this
    )
}
