package com.example.mytextrecognition


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mytextrecognition.StrokeManager.clear
import com.example.mytextrecognition.StrokeManager.download
import com.example.mytextrecognition.StrokeManager.recognize


class MainActivity : AppCompatActivity() {
    private lateinit var btnRecognize: Button
    private lateinit var btnClear: Button
    private lateinit var drawView: DrawView
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRecognize = findViewById(R.id.buttonRecognize)
        btnClear = findViewById(R.id.buttonClear)
        drawView = findViewById(R.id.draw_view)
        textView = findViewById(R.id.textResult)

        hideTitleBar()

        download()
        btnRecognize.setOnClickListener {
            recognize(
                textView
            )
        }
        btnClear.setOnClickListener {
            drawView.clear()
            clear()
            textView.text = ""
        }
    }

    private fun hideTitleBar() {
        this.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

    override fun onResume() {
        super.onResume()
        hideTitleBar()
    }

    override fun onPause() {
        super.onPause()
        hideTitleBar()
    }

    override fun onStop() {
        super.onStop()

        hideTitleBar()
    }
}