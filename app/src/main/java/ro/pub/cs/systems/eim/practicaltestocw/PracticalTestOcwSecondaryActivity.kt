package ro.pub.cs.systems.eim.practicaltestocw

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.Toast

class PracticalTestOcwSecondaryActivity : AppCompatActivity() {

    var total_count = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test_ocw_secondary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var count_left = intent.getIntExtra("count_left", 0)
        var count_right = intent.getIntExtra("count_right", 0)
        total_count = count_left + count_right

        var but_cnt = findViewById<TextView>(R.id.TextView_Total_Count)
        but_cnt.hint = total_count.toString()

        var btn_ok = findViewById<Button>(R.id.Button_Ok).setOnClickListener { v->
            Toast.makeText(v.context, "OK A FOST APASAT", Toast.LENGTH_SHORT).show()
            finish()
        }
        var btn_cancel = findViewById<Button>(R.id.Button_Calcel).setOnClickListener { v->
            Toast.makeText(v.context, "CANCEL A FOST APASAT", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}