package com.realm.example.data.remote.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Employee(
    @PrimaryKey
    var id: Int = 0,
    var name: String = "",
    var location: String = ""
) : RealmObject()