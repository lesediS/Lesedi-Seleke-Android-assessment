package com.glucode.about_you.about

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import android.util.AttributeSet
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.cardview.widget.CardView
import com.glucode.about_you.R

class ProfileImgCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : CardView(context, attrs, defStyle) {

    private var profileImageView: ImageView
    private var pickImageLauncher: ActivityResultLauncher<Intent>? = null
    private val RESULT_OK = 100

    init {
        inflate(context, R.layout.profile_design, this)
        profileImageView = findViewById(R.id.profile_image)!!
        profileImageView.setOnClickListener { openImagePicker() }
    }

    fun setPickImageLauncher(pickImageLauncher: ActivityResultLauncher<Intent>) {
        this.pickImageLauncher = pickImageLauncher
        profileImageView.setOnClickListener {
            openImagePicker()
        }
    }

    private fun openImagePicker() {
        if (context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) !=
            PackageManager.PERMISSION_GRANTED
        ) {
        } else {
            pickImageLauncher?.launch(
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    .setType("image/*")
            )
        }
    }
}
