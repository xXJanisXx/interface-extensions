package dev.xxjanisxx.interfaces.grid.mapping

import com.noxcrew.interfaces.grid.mapping.AbstractGridMapper
import com.noxcrew.interfaces.grid.mapping.GridMapper

/** Handles [com.noxcrew.interfaces.grid.GridPoint] mapping for [org.bukkit.event.inventory.InventoryType.ANVIL] containers. */
class AnvilGridMapper : AbstractGridMapper(), GridMapper.TopInventory {

    companion object {
        private const val ANVIL_COLUMNS = 3
        private const val ANVIL_ROWS = 1
    }

    override fun forEachInGrid(function: (row: Int, column: Int) -> Unit) {
        com.noxcrew.interfaces.utilities.forEachInGrid(
            ANVIL_ROWS,
            ANVIL_COLUMNS,
            function
        )
    }

    override fun toTopInventorySlot(row: Int, column: Int): Int {
        require(row == 0) { "Anvil has only one row" }
        require(column in 0..2) { "Column $column out of bounds for Anvil" }

        return column
    }

    override fun isPlayerInventory(row: Int, column: Int): Boolean =
        row >= ANVIL_ROWS
}
