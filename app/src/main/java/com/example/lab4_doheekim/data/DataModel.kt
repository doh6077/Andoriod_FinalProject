package com.example.lab4_doheekim.data

data class DataModel(var email: String)

class DataRepository{
    private var _email = DataModel("")

    fun getEmail() = _email





}