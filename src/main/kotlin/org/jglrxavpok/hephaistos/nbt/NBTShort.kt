package org.jglrxavpok.hephaistos.nbt

import java.io.DataInputStream
import java.io.DataOutputStream
import java.util.*

class NBTShort(value: Short) : NBTNumber<Short>(value) {
    override val ID = NBTTypes.TAG_Short

    // help Java compiler to find the correct type (boxed vs primitive types)
    fun getValue(): Short = value

    override fun writeContents(destination: DataOutputStream) {
        destination.writeShort(value.toInt())
    }

    override fun toSNBT(): String {
        return "${value}S"
    }

    override fun deepClone() = this

    companion object: NBTReaderCompanion<NBTShort> {
        override fun readContents(source: DataInputStream): NBTShort {
            return NBTShort(source.readShort())
        }
    }
}
