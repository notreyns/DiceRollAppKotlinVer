package com.example.dicerollapp

import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var firstImg: ImageView
    private lateinit var secondImg: ImageView
    private lateinit var rollBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstImg= findViewById(R.id.first_image_view)
        secondImg= findViewById(R.id.second_image_view)
        rollBtn= findViewById(R.id.roll_button)
        if (savedInstanceState != null){
            firstImg.setImageResource(savedInstanceState.getInt("img1"))
            secondImg.setImageResource(savedInstanceState.getInt("img2"))
        }
        rollBtn.setOnClickListener {
            var rand1: Int = (1..6).random()
            var img1 = resources.getIdentifier("dice" + rand1, "drawable", "com.example.dicerollapp")
            firstImg.setImageResource(img1)
            firstImg.setTag(img1)

            var rand2: Int = (1..6).random()
            var img2 = resources.getIdentifier("dice" + rand2, "drawable", "com.example.dicerollapp")
            secondImg.setImageResource(img2)
            secondImg.setTag(img2)
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("img1", firstImg.getTag() as Int)
        outState.putInt("img2", secondImg.getTag() as Int)
    }

   /* override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        firstImg.setImageBitmap(savedInstanceState.getParcelable("img1"))
        secondImg.setImageBitmap(savedInstanceState.getParcelable("img2"))
    }*/
}
