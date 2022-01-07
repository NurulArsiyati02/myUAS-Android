package com.nurul.myuas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.nurul.myuas.adapter.Adapter
import com.nurul.myuas.api.ApiRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MebelActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var jerseyAdapter: Adapter
    private lateinit var lisNote : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mebel)
        setupList()

    }

    private fun setupList(){
        lisNote = findViewById(R.id.list_film)
        jerseyAdapter = Adapter(arrayListOf())
        lisNote.adapter = jerseyAdapter
    }

    override fun onStart() {
        super.onStart()
        getNote()
    }

    private fun getNote(){
        api.data().enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.am_mebel
                    jerseyAdapter.setData( listData )
                }
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("hadir",t.toString())
            }

        })
    }
}