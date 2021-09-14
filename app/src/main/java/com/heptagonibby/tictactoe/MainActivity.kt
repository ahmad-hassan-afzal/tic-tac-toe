package com.heptagonibby.tictactoe

import androidx.appcompat.app.AppCompatActivity
import com.heptagonibby.tictactoe.R
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var activePlayer = 0
    var gameState = intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2)
    var winPosition = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )

    fun playerTape(view: View) {
        val img = view as ImageView
        val tappedImage = img.tag.toString().toInt()
        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer
            img.translationY = -1000f
            activePlayer = if (activePlayer == 0) {
                img.setImageResource(R.drawable.cr)
                1
            } else {
                img.setImageResource(R.drawable.z)
                0
            }
        }
        img.animate().translationYBy(1000f).duration = 400
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}