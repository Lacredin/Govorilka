package lacredin.messenger.govorilka.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import lacredin.messenger.govorilka.R
import lacredin.messenger.govorilka.ui.cycle.LifeCycleBaseActivity
import lacredin.messenger.govorilka.ui.view.ViewModelBaseActivity


class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        lifecycle.addObserver(LifeCycleBaseActivity())

        val model = ViewModelProviders.of(this).get(ViewModelBaseActivity::class.java)
    }

}
