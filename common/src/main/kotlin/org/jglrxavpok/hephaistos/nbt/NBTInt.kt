package org.jglrxavpok.hephaistos.nbt

import java.io.DataInputStream
import java.io.DataOutputStream

class NBTInt constructor(value: Int) : NBTNumber<Int>(value) {
    override val ID = NBTType.TAG_Int

    // help Java compiler to find the correct type (boxed vs primitive types)
    fun getValue(): Int = value

    override fun writeContents(destination: DataOutputStream) {
        destination.writeInt(value)
    }

    override fun toSNBT(): String {
        return "$value"
    }

    companion object: NBTReaderCompanion<NBTInt> {
        override fun readContents(source: DataInputStream): NBTInt {
            return NBTInt(source.readInt())
        }
    }
}
