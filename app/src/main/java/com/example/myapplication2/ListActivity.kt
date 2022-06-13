package com.example.myapplication2



import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.data.DogsAPIClient
import com.example.myapplication2.data.cb.DataRetrieved
import com.example.myapplication2.data.model.Breeds

private const val TAG = "ListActivity"

class ListActivity : AppCompatActivity(), DataRetrieved {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        setup()
        DogsAPIClient.getListOfBreeds(this)
    }

    private fun setup() {
        findViewById<RecyclerView>(R.id.rv_breeds).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = BreedsAdapter()
        }
    }

    //region DataRetrieved

    override fun onDataFetchedSuccess(breeds: List<Breeds>) {
        Log.d(TAG, "onDataFetched Success | ${breeds.size} new breeds")
        val adapter = findViewById<RecyclerView>(R.id.rv_breeds).adapter as BreedsAdapter
        adapter.submitList(breeds)
    }

    override fun onDataFetchedFailed() {
        Log.e(TAG, "Unable to retrieve new data")
    }

}
