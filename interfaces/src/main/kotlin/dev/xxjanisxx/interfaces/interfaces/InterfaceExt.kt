package dev.xxjanisxx.interfaces.interfaces

/** Creates a new [DropperInterface] using a [DropperInterfaceBuilder]. */
public inline fun buildChestInterface(builder: DropperInterfaceBuilder.() -> Unit): DropperInterface =
    DropperInterfaceBuilder().also(builder).build()