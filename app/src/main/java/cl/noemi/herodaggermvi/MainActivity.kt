package cl.noemi.herodaggermvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cl.noemi.herodaggermvi.presentation.navgraph.HeroNav
import cl.noemi.herodaggermvi.ui.theme.HeroDaggerMVITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeroDaggerMVITheme {
                HeroNav()
            }
        }
    }
}