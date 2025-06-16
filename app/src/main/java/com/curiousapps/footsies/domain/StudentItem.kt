package com.curiousapps.footsies.domain


import com.google.gson.annotations.SerializedName

data class StudentItem(
    @SerializedName("actor")
    var actor: String,
    @SerializedName("alive")
    var alive: Boolean,
    @SerializedName("alternate_actors")
    var alternateActors: List<String>,
    @SerializedName("alternate_names")
    var alternateNames: List<String>,
    @SerializedName("ancestry")
    var ancestry: String,
    @SerializedName("dateOfBirth")
    var dateOfBirth: String,
    @SerializedName("eyeColour")
    var eyeColour: String,
    @SerializedName("gender")
    var gender: String,
    @SerializedName("hairColour")
    var hairColour: String,
    @SerializedName("hogwartsStaff")
    var hogwartsStaff: Boolean,
    @SerializedName("hogwartsStudent")
    var hogwartsStudent: Boolean,
    @SerializedName("house")
    var house: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("patronus")
    var patronus: String,
    @SerializedName("species")
    var species: String,
    @SerializedName("wand")
    var wand: Wand,
    @SerializedName("wizard")
    var wizard: Boolean,
    @SerializedName("yearOfBirth")
    var yearOfBirth: Int
)