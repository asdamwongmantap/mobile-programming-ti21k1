package com.example.belajarapiuser

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.belajarapiuser.api.ApiConfig
import com.example.belajarapiuser.api.adapter.UserAdapter
import com.example.belajarapiuser.api.model.Users
import com.example.belajarapiuser.api.model.UsersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var recylerView: RecyclerView
    private lateinit var call: Call<UsersResponse>
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        swipeRefresh = findViewById(R.id.refresh_layout)
        recylerView = findViewById(R.id.recyler_view)
        userAdapter = UserAdapter{user -> userOnClick(user) }
        recylerView.adapter = userAdapter
        recylerView.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL,false)

        swipeRefresh.setOnRefreshListener {
            getData()
        }
        getData()
    }

    private fun userOnClick(user: Users){
        Toast.makeText(applicationContext,user.firstName, Toast.LENGTH_SHORT).show()
    }

    private fun getData(){
        swipeRefresh.isRefreshing = true

        call = ApiConfig.userService.getAll()
        call.enqueue(object : Callback<UsersResponse> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<UsersResponse>,
                response: Response<UsersResponse>
            ) {
                swipeRefresh.isRefreshing = false
                if (response.isSuccessful){
                    userAdapter.submitList(response.body()?.users)
                    userAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                swipeRefresh.isRefreshing = true
                Toast.makeText(applicationContext,t.localizedMessage, Toast.LENGTH_SHORT)
            }

        })
    }
}