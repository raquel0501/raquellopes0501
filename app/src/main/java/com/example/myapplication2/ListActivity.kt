package com.example.mytinder



import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication2.R
import com.example.myapplication2.data.DogsAPIClient

class ListActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        DogsAPIClient.getListOfBreeds()
    }

}
