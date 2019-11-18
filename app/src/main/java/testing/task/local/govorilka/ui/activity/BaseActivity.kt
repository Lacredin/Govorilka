package testing.task.local.govorilka.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModelProviders
import testing.task.local.govorilka.ui.cycle.LifeCycleBaseActivity
import testing.task.local.govorilka.ui.view.ViewModelBaseActivity


class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(testing.task.local.govorilka.R.layout.activity_base)

        lifecycle.addObserver(LifeCycleBaseActivity())

        val model = ViewModelProviders.of(this).get(ViewModelBaseActivity::class.java)
    }

}
