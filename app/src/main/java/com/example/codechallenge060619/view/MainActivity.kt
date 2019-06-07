package com.example.codechallenge060619.view

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codechallenge060619.R
import com.example.codechallenge060619.Util
import com.example.codechallenge060619.dependencyInjection.CustomApp
import com.example.codechallenge060619.network.ImgDetail
import com.example.codechallenge060619.viewModel.CustomViewModel
import kotlinx.android.synthetic.main.activity_main.*

import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainActivityInterface {
    @Inject lateinit var viewModel: CustomViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (this.application as CustomApp).appComponent.inject(this)

        checkInternetPermission()
    }


    private fun fetchImgList() {
        viewModel.
            getImgData().
            observe(this, Observer {
                setUpRecyclerView(it)
        })
    }


    private fun setUpRecyclerView(imgDetailList: List<ImgDetail>) {
        recyclerView.adapter = CustomAdapter(imgDetailList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


    private fun checkInternetPermission() {
        // check permission
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.INTERNET),
                Util.INTERNET_PERMISSION_REQUESTCODE)
        }
        else{
            fetchImgList()
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        }
        else{
            Toast.makeText(this, "Internet permission is required to fetch img list", Toast.LENGTH_SHORT)
                .show()
        }
    }
}
