package com.example.codechallenge060619.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codechallenge060619.R
import com.example.codechallenge060619.Util
import com.example.codechallenge060619.network.ImgDetail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailActivityInterface {
    private val mainImgUrl = "https://source.unsplash.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgDetail: ImgDetail = intent!!.extras!!.getParcelable<ImgDetail>(Util.IMG_DETAIL)!!

        tvId.text = imgDetail.id.toString()
        tvAuthor.text = imgDetail.author
        tvAuthorUrl.text = imgDetail.authorUrl
        tvFilename.text = imgDetail.filename
        tvFormat.text = imgDetail.format
        tvPostUrl.text = imgDetail.postUrl
        tvHeight.text = imgDetail.height.toString()
        tvWidth.text = imgDetail.width.toString()

        val fileNameWithoutIdAndExtension = imgDetail.filename.substring(imgDetail.filename.indexOf("_")+1,
            imgDetail.filename.lastIndexOf('.'))
        Picasso.get().load(mainImgUrl + fileNameWithoutIdAndExtension).into(imageView)
    }
}
