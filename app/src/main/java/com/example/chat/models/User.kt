package com.example.chat.models

data class User(
    //свойства user
    val id: String = "",
    var phone: String = "",
    var username: String = "",
    var bio: String = "",
    var fullname: String = "",
    var status: String = "",
    var photoUrl: String = ""
)