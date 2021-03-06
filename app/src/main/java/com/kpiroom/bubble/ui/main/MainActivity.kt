package com.kpiroom.bubble.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kpiroom.bubble.R
import com.kpiroom.bubble.databinding.ActivityMainBinding
import com.kpiroom.bubble.ui.core.CoreActivity
import com.kpiroom.bubble.ui.progress.ProgressActivity
import com.kpiroom.bubble.util.livedata.addSource
import com.kpiroom.bubble.util.progressState.ProgressState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ProgressActivity<MainLogic, ActivityMainBinding>() {
    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logic.fetchUserData()

        navigation.setupWithNavController(findNavController(R.id.host_fragment))
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.host_fragment).navigateUp()

    override fun provideLogic(): MainLogic = ViewModelProviders.of(this).get(MainLogic::class.java)

    override fun provideLayout(): LayoutBuilder = LayoutBuilder(R.layout.activity_main) {
        logic = this@MainActivity.logic
    }
}
