package dev.xxjanisxx.interfaces.interfaces

/** Creates a new [DropperInterface] using a [DropperInterfaceBuilder]. */
inline fun buildDropperInterface(builder: DropperInterfaceBuilder.() -> Unit): DropperInterface =
    DropperInterfaceBuilder().also(builder).build()