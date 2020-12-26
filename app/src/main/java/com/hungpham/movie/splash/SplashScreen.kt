package com.hungpham.movie.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import com.hungpham.app_utils.extract_parents.ParentHost
import com.hungpham.design_kit.MovieTheme
import com.hungpham.movie.foundation.FoundationActivity
import com.hungpham.movie.splash.di.DaggerSplashComponent
import com.hungpham.movie.splash.di.SplashDependencies
import javax.inject.Inject

class SplashScreen : AppCompatActivity(), SplashView {

    @Inject
    lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerSplashComponent.builder()
            .bindDependencies((applicationContext as ParentHost).extractParent(SplashDependencies::class) as SplashDependencies)
            .bindView(this)
            .build()
            .inject(this)

        setContent {
            MovieTheme {
                Surface(color = MaterialTheme.colors.background) {
                    splashScreen()
                }
            }
        }

        presenter.fetchData()
    }

    override fun closeSplashScreen() {
        startActivity(Intent(this, FoundationActivity::class.java))
    }
}

@Composable
fun splashScreen() {
    Text(text = "Splash Screen")
}