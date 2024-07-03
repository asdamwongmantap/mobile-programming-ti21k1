package com.example.helloworldti21k1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloworldti21k1.ui.theme.HelloWorldTI21K1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTI21K1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Asdam",
                        kelas = "TI21K1",
                        prodi = "Teknik Informatika",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String,kelas: String,prodi: String, modifier: Modifier = Modifier) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Biodata\n")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Nama: ")
            }
            append(name,"\n")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Kelas: ")
            }
            append(kelas,"\n")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Program Studi: ")
            }
            append(prodi,"\n")
        },
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldTI21K1Theme {
        Greeting("Asdam","TI21K1","Teknik Informatika")
    }
}