package com.hungpham.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.hungpham.design_kit.MovieTheme
import com.hungpham.login.di.DaggerLoginComponent
import com.hungpham.login.ui.login.LoginViewModel
import javax.inject.Inject


class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerLoginComponent.builder()
            .bindContext(this)
            .build()
            .inject(this)

        setContent {
            MovieTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    loginPage {
                        viewModel.login(it.first, it.second)
                    }
                }
            }
        }
    }
}


@Composable
fun loginPage(onLoginClicked: (Pair<String, String>) -> Unit) {
    var userNameValue by remember { mutableStateOf(TextFieldValue("")) }
    var passwordValue by remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier.padding(16.dp).fillMaxHeight()) {
        OutlinedTextField(
            value = userNameValue,
            onValueChange = {
                userNameValue = it
            },
            label = {
                Text("User name")
            }
        )
        OutlinedTextField(
            value = passwordValue,
            onValueChange = {
                passwordValue = it
            },
            keyboardType = KeyboardType.Password,
            label = {
                Text("Password")
            }
        )
        TextButton(
            onClick = {
                onLoginClicked(Pair(userNameValue.text, passwordValue.text))
                userNameValue = TextFieldValue()
                passwordValue = TextFieldValue()
            },

            ) {
            Text("Login")
        }
    }
}