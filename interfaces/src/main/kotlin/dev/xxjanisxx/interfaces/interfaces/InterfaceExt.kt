package dev.xxjanisxx.interfaces.interfaces

/** Creates a new [DropperInterface] using a [DropperInterfaceBuilder]. */
inline fun buildDropperInterface(builder: DropperInterfaceBuilder.() -> Unit): DropperInterface =
    DropperInterfaceBuilder().also(builder).build()

/** Creates a new [HopperInterface] using a [HopperInterfaceBuilder]. */
inline fun buildHopperInterface(builder: HopperInterfaceBuilder.() -> Unit): HopperInterface =
    HopperInterfaceBuilder().also(builder).build()