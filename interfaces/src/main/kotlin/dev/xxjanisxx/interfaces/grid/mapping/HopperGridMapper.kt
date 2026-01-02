package dev.xxjanisxx.interfaces.grid.mapping

import com.noxcrew.interfaces.grid.mapping.AbstractGridMapper
import com.noxcrew.interfaces.grid.mapping.GridMapper
import dev.xxjanisxx.interfaces.interfaces.HopperInterface

/** Handles [com.noxcrew.interfaces.grid.GridPoint] mapping for [org.bukkit.event.inventory.InventoryType.HOPPER] containers. */
class HopperGridMapper : AbstractGridMapper(), GridMapper.TopInventory {

    companion object {
        private const val HOPPER_COLUMNS = 5
    }

    override fun forEachInGrid(function: (row: Int, column: Int) -> Unit) {
        com.noxcrew.interfaces.utilities.forEachInGrid(
            HopperInterface.NUMBER_OF_ROWS,
            HOPPER_COLUMNS,
            function
        )
    }

    override fun toTopInventorySlot(row: Int, column: Int): Int {
        require(row == 0) { "Row $row out of bounds for Hopper" }
        require(column in 0..4) { "Column $column out of bounds for Hopper" }

        return column
    }

    override fun isPlayerInventory(row: Int, column: Int): Boolean =
        row >= HopperInterface.NUMBER_OF_ROWS
}
