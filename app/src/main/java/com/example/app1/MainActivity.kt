package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.example.app1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val initialTextViewTranslationY = binding.textViewProgress.translationY

        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textViewProgress.text = progress.toString()

                val translationDistance = (initialTextViewTranslationY +
                        progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                binding.textViewProgress.animate().translationY(translationDistance)
                if (!fromUser)
                    binding.textViewProgress.animate().setDuration(500).rotationBy(360f)
                        .translationY(initialTextViewTranslationY)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        binding.buttonReset.setOnClickListener { v: View ->
            binding.seekBar.progress = 0
        }
    }
}