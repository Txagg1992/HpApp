package com.curiousapps.footsies.domain


import com.google.gson.annotations.SerializedName

data class Wand(
    @SerializedName("core")
    var core: String,
    @SerializedName("length")
    var length: Double,
    @SerializedName("wood")
    var wood: String
)