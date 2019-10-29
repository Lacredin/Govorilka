package testing.task.local.govorilka.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import testing.task.local.govorilka.R

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}
