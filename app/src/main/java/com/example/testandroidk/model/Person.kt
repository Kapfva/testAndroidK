package com.example.testandroidk.model

data class Person (var name : String ?= null, var birthdate : String ?= null,var contactNumber : String ?= null, var active : Boolean) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (name != other.name) return false
        if (birthdate != other.birthdate) return false
        if (contactNumber != other.contactNumber) return false
        if (active != other.active) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (birthdate?.hashCode() ?: 0)
        result = 31 * result + (contactNumber?.hashCode() ?: 0)
        result = 31 * result + active.hashCode()
        return result
    }
}
