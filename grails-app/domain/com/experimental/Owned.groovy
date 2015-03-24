package com.experimental

class Owned {

    String name

    static belongsTo = [OwnerA, OwnerB]
    static constraints = { }
}