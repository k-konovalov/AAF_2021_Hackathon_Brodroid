package com.brodroid.aacademia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brodroid.aacademia.ui.FragmentPdfView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    
    /*How to use presentation fragment
    * start with url
    *  val url = "https://docs.google.com/presentation/d/1LyB8p2C4ZowWQRIxchMPDbrpBrdDN8MgXeQGEJVScJk/edit#slide=id.ga4a15a5964_0_76"
    *
      FragmentPdfView.newInstance(url)
    * */
}