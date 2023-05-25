package com.malfa.bancodefilmes.utils

sealed class Tela(val rota: String){
    object Main: Tela("main_screen")
    object Info: Tela("info_screen")/*  "info_screen/{id}"
        fun passId(id: Int) : String
            return "info_screen/{$id}"
    */
}
