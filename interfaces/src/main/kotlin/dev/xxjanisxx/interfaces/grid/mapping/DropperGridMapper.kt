package dev.xxjanisxx.interfaces.grid.mapping

import com.noxcrew.interfaces.grid.mapping.AbstractGridMapper
import com.noxcrew.interfaces.grid.mapping.GridMapper
import dev.xxjanisxx.interfaces.interfaces.DropperInterface

/** Handles [com.noxcrew.interfaces.grid.GridPoint] mapping for [org.bukkit.event.inventory.InventoryType.DROPPER] containers. */
class DropperGridMapper : AbstractGridMapper(), GridMapper.TopInventory {

    companion object {
        private const val DROPPER_COLUMNS = 3
    }

    override fun forEachInGrid(function: (row: Int, column: Int) -> Unit) {
        com.noxcrew.interfaces.utilities.forEachInGrid(
            DropperInterface.NUMBER_OF_ROWS,
            DROPPER_COLUMNS,
            function
        )
    }

    override fun toTopInventorySlot(row: Int, column: Int): Int {
        require(row in 0..2) { "Row $row out of bounds for Dropper" }
        require(column in 0..2) { "Column $column out of bounds for Dropper" }

        return row * 3 + column
    }

    override fun isPlayerInventory(row: Int, column: Int): Boolean =
        false
}
