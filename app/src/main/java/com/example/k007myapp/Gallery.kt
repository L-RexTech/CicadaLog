package com.example.k007myapp

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Gallery : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val gridLayout: GridLayout = findViewById(R.id.galleryGridLayout)

        val imageList = intArrayOf(
            R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5, R.drawable.image6
        )

        for ((index, imageResId) in imageList.withIndex()) {
            val frameLayout = FrameLayout(this)
            frameLayout.layoutParams = GridLayout.LayoutParams().apply {
                width = ViewGroup.LayoutParams.WRAP_CONTENT
                height = ViewGroup.LayoutParams.WRAP_CONTENT
                setMargins(16, 16, 16, 16)
                rowSpec = GridLayout.spec(index / 3)
                columnSpec = GridLayout.spec(index % 3)
            }

            val drawable = GradientDrawable().apply {
                setColor(Color.WHITE)
                cornerRadius = 20f
                setStroke(4, Color.LTGRAY)
            }

            val imageView = ImageView(this)
            imageView.setImageResource(imageResId)
            imageView.layoutParams = FrameLayout.LayoutParams(
                300, 300
            ).apply {
                gravity = Gravity.CENTER
            }
            imageView.background = drawable
            imageView.elevation = 8f
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(16, 16, 16, 16)

            imageView.setOnClickListener {
                Toast.makeText(this, "You clicked image #${index + 1}", Toast.LENGTH_SHORT).show()
            }

            frameLayout.addView(imageView)
            gridLayout.addView(frameLayout)
        }
    }
}
