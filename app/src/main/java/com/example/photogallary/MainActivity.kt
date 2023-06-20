package com.example.photogallary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.photogallary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var image: ImageView
    private var currentImage= 0
    private val names= arrayOf("Vikram", "Yash", "Shahid Kapur")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.ivPrevious.setOnClickListener {
            val currentImageIdString= "img$currentImage"
            val currentImageIdInt= this.resources.getIdentifier(currentImageIdString,"id",packageName)
            image= findViewById(currentImageIdInt)
            image.alpha= 0F

           currentImage= (3+currentImage-1) % 3

            val imageToShowString= "img$currentImage"
            val imageToShowInt= this.resources.getIdentifier(imageToShowString,"id",packageName)
            image= findViewById(imageToShowInt)
            image.alpha= 1F
            binding.tvNames.text= names[currentImage]
        }

        binding.ivNext.setOnClickListener {
            val currentImageIdString= "img$currentImage"
            val currentImageIdInt= this.resources.getIdentifier(currentImageIdString,"id",packageName)
            image= findViewById(currentImageIdInt)
            image.alpha= 0F

            currentImage= (3+currentImage+1) % 3
            val imageToShowString= "img$currentImage"
            val imageToShowInt= this.resources.getIdentifier(imageToShowString,"id",packageName)
            image= findViewById(imageToShowInt)
            image.alpha= 1F
            binding.tvNames.text= names[currentImage]

        }
    }
}