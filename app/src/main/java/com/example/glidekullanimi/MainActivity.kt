package com.example.glidekullanimi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.glidekullanimi.ui.theme.GlideKullanimiTheme
import com.skydoves.landscapist.glide.GlideImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlideKullanimiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@Composable
fun Sayfa() {
    val resim_adi = remember {mutableStateOf("django.png")}
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlideImage(
            imageModel = "http://kasimadalan.pe.hu/filmler/resimler/${resim_adi.value}",
            modifier = Modifier.size(
                100.dp, 150.dp
            )
        )
        Button(onClick = { resim_adi.value = "inception.png" }) {
            Text(text = "Resim 1")
        }
        Button(onClick = { resim_adi.value = "interstellar.png" }) {
            Text(text = "Resim 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GlideKullanimiTheme {
        Sayfa()
    }
}