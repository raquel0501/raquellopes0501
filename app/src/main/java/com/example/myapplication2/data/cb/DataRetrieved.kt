package com.example.myapplication2.data.cb

import com.example.myapplication2.data.model.Breeds

interface DataRetrieved {
     fun onDataFetchedSuccess(breeds:List<Breeds>)

     fun onDataFetchedFailed()
}
