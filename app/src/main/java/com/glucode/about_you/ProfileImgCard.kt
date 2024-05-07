package com.glucode.about_you
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.glucode.about_you.R

class ProfileImgCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private val profileImage: ImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.profile_design, this, true)
        profileImage = findViewById(R.id.profile_image)

        // Set click listener for profile image
        profileImage.setOnClickListener {

        }
    }

    // Optionally, you can add methods to set profile image programmatically
    fun setProfileImage(imageResId: Int) {
        profileImage.setImageResource(imageResId)
    }
}
