package com.nurul.myuas

class Model (
    val am_mebel: List<Data>
) {
    data class Data (val id:String?, val jenis:String?, val kategori:String?)
}
