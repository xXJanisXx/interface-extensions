package dev.xxjanisxx.interfaces.grid.mapping

import com.noxcrew.interfaces.grid.mapping.AbstractGridMapper
import com.noxcrew.interfaces.grid.mapping.GridMapper
import com.noxcrew.interfaces.utilities.gridPointToBukkitIndex
import com.noxcrew.interfaces.view.AbstractInterfaceView
import dev.xxjanisxx.interfaces.interfaces.DropperInterface

/** Handles [com.noxcrew.interfaces.grid.GridPoint] mapping for [org.bukkit.event.inventory.InventoryType.DROPPER] containers. */
class DropperGridMapper : AbstractGridMapper(), GridMapper.TopInventory {

    override fun forEachInGrid(function: (row: Int, column: Int) -> Unit) {
        com.noxcrew.interfaces.utilities.forEachInGrid(DropperInterface.NUMBER_OF_ROWS, AbstractInterfaceView.COLUMNS_IN_CHEST, function)
    }

    override fun toTopInventorySlot(row: Int, column: Int): Int {
        return gridPointToBukkitIndex(row, column)
    }

    override fun isPlayerInventory(row: Int, column: Int): Boolean = row >= DropperInterface.NUMBER_OF_ROWS
}
