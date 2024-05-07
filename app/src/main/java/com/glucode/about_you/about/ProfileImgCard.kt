package com.glucode.about_you.about

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import com.glucode.about_you.R
import com.glucode.about_you.databinding.ProfileDesignBinding

class ProfileImgCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    private val requestGalleryLauncher: ActivityResultLauncher<Intent>  // Inject ActivityResultLauncher
) : CardView(context, attrs, defStyleAttr) {

    private val binding: ProfileDesignBinding

    init {
        binding = ProfileDesignBinding.inflate(LayoutInflater.from(context), this, true)

        binding.picCardVw.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        requestGalleryLauncher.launch(intent)
    }

    fun setProfileImage(imageUri: Uri) {
        binding.profileImage.setImageURI(imageUri)
    }

    companion object {
        private const val REQUEST_IMAGE_SELECT = 100  // Can be removed if not strictly needed
    }
}