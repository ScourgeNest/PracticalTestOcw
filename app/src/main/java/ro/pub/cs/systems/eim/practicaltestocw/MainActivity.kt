package ro.pub.cs.systems.eim.practicaltestocw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01MainActivity : AppCompatActivity() {

    var count_left = 0;

    var count_right = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var button_press = findViewById<Button>(R.id.Button_press_me)

        var button_press_too = findViewById<Button>(R.id.Button_press_me_too)

        var c1 = findViewById<TextView>(R.id.TextView_Left)

        var c2 = findViewById<TextView>(R.id.TextView_Right)

        button_press.setOnClickListener {
            count_left++
            c1.hint = count_left.toString()
        }

        button_press_too.setOnClickListener {
            count_right++
            c2.hint = count_right.toString()
        }

        var nav = findViewById<Button>(R.id.Button_nav).setOnClickListener { v ->
            val intent = Intent(this@PracticalTest01MainActivity, PracticalTestOcwSecondaryActivity::class.java)
            intent.putExtra("count_left", count_left)
            intent.putExtra("count_right", count_right)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("count_left", count_left.toString())
        outState.putString("count_right", count_right.toString())

    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        var count_l = findViewById<TextView>(R.id.TextView_Left)
        var count_r = findViewById<TextView>(R.id.TextView_Right)
        count_left = savedInstanceState.getString("count_left")?.toInt() ?: 0
        count_right = savedInstanceState.getString("count_right")?.toInt() ?: 0

        count_l.hint = count_left.toString()
        count_r.hint = count_right.toString()
    }
}