package com.example.componentesestado

import android.R.attr.contentDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentesestado.ui.theme.ComponentesEstadoTheme
import com.example.componentesestado.ui.theme.Righteus

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponetsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponetsScreen(modifier: Modifier = Modifier) {
    // Criando um componente "Column"
    Column(
        modifier = modifier
            .fillMaxSize() // Ocupa o espaço disponível
            .background(Color(239, 247, 207))
    ) {
        // Criando um componente "Text"
        Text(
            text = "Aulas Android",
            fontSize = 32.sp, // Aumenta o tamnaho da fonte
            fontWeight = FontWeight.Bold, // Aumenta a largura da fonte
            color = Color(0xFF3DDC84), // Muda a cor da fonte
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .fillMaxWidth(), // Largura total disponível
            textAlign = TextAlign.End, // Alinha no fim da linha (horizontamente)
            letterSpacing = 2.sp // Espaçamento entre as letras
        )
        Text(
            text = "Com jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(66, 133, 244),
            fontFamily = Righteus, // Colocando a fonte que nós adicionamos  (res/font , type.kt/Cria a variável da fonte lá e chama o arquivo da res/font)
            modifier = Modifier.align(Alignment.CenterHorizontally) // Alinha no centro horizontamente
        )

        // Chamando o composable que nós criamos
        AndroidEnemy(
            color = Color.Red,
            modifier = Modifier
                .size(100.dp)
        )

        AndroidEnemy(
            color = Color.Blue,
            modifier = Modifier
                .size(150.dp)
        )
    }
}

@Composable
fun AndroidEnemy (
    color: Color,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter =  ColorFilter.tint(color),
        contentDescription = "Android Enemy"
    )
}
