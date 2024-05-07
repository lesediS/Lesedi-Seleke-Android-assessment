package com.glucode.about_you
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.glucode.about_you.R
import com.glucode.about_you.databinding.ProfileDesignBinding

class ProfileImgCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

//    private val profileImage: ImageView
    private val binding: ProfileDesignBinding

    init {
        //LayoutInflater.from(context).inflate(R.layout.profile_design, this, true)
        binding = ProfileDesignBinding.inflate(LayoutInflater.from(context), this, true)

        binding.picCardVw.setOnClickListener{
            openGallery();
        }

//        profileImage = findViewById(R.id.profile_image)
//        profileImage.setOnClickListener {
//
//        }
    }

    private fun openGallery() {
        TODO("Not yet implemented")
    }

    fun setProfileImage(imageResId: Int) {
        binding.profileImage.setImageResource(imageResId)
    }
}
