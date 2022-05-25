package com.example.carracinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity(), GameTask {
    lateinit var rootlayout : LinearLayout
    lateinit var strtbtn : Button
    lateinit var myGameView: GameView
    lateinit var  score : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootlayout = findViewById(R.id.rootLayout)
        strtbtn = findViewById(R.id.startBtn)
        score = findViewById(R.id.score)
        myGameView = GameView(this,this)

        strtbtn.setOnClickListener {
            myGameView.setBackgroundResource(R.drawable.road_image)
            rootlayout.addView(myGameView)
            strtbtn.visibility = View.GONE
            score.visibility = View.GONE
        }

    }

    override fun closeGame(mScore : Int){
        score.text = " Score : $mScore"
        rootlayout.removeView(myGameView)
        strtbtn.visibility = View.VISIBLE
        score.visibility = View.VISIBLE
    }
}