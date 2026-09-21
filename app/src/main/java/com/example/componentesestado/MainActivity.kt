package com.example.componentesestado

import android.R.attr.contentDescription
import android.R.attr.letterSpacing
import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle
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

    // Criando uma variável para guardar o valor do textField
    val textFieldValue = remember {
        mutableStateOf("")
    }

    var numberTextField by remember { // Usando o "by" para substituir o ".value"
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    // Criando uma variável para o checkBox
    var checkBox1 by remember {
        mutableStateOf(false)
    }

    // Criando uma variável para o checkBox
    var checkBox2 by remember {
        mutableStateOf(false)
    }

    // Criando uma variável para o checkBox
    var checkBox3 by remember {
        mutableStateOf(false)
    }

    var sistemaSelecionado by remember {
        mutableStateOf(0)
    }

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

        // Criando uma caixa de texto
        TextField(
            value = textFieldValue.value,
            onValueChange = {novoValor -> textFieldValue.value = novoValor},
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, capitalization = KeyboardCapitalization.Characters), // Mudando os atributos do teclado (número ou textual, começar com letra maiúscula ou minúscula)
            placeholder = { // Texto demonstrataivo que fica dentro da caixa de texto
                Text(text = "Digite o seu nome (PLACEHOLDER)")
            },
            label = { // Texto que fica acima do texto que o usuário digita "etiqueta"
                Text(text = "Nome e Sobrenome (LABEL)")
            },
            leadingIcon = { // Adiciona um ícone na caixa de texto (cadeado, avatar e etc)
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Ícone de pessoa",
                    tint = Color.Gray
                )
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Blue, // Muda a cor quando o foco estiver lá
                unfocusedTextColor = Color.Red, // Muda a cor quando o foco não estiver lá
                unfocusedPlaceholderColor = Color.Magenta, // Muda a cor do placeholder quando o foco não estiver lá

            )
        )

        Spacer(modifier = Modifier.height(16.dp)) // Adicionando um componente vazio para servir de espaço

        TextField(
            value = numberTextField,
            onValueChange = { novoValor -> numberTextField = novoValor },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = {
                Text(text = "Digete sua idade")
            }
        )

        Spacer(modifier = Modifier.height(16.dp)) // Adicionando um componente vazio para servir de espaço

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = {
                Text(text = "Digite seu email")
            },
            label = {
                Text(text = "email")
            },
            shape = RoundedCornerShape( // Mudando o formato da caixa de texto
                topStart = 32.dp,
                bottomEnd = 32.dp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Red
            )
        )

        Spacer(modifier = Modifier.height(16.dp)) // Adicionando um componente vazio para servir de espaço

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkBox1,
                onCheckedChange = {checkBox1 = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor =  Color.Red
                )
            )

            Text(text = "Texto para o CheckBox")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkBox2,
                onCheckedChange = {checkBox2 = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor =  Color.Red
                )
            )

            Text(text = "Texto para o CheckBox")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkBox3,
                onCheckedChange = {checkBox3 = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor =  Color.Red
                )
            )

            Text(text = "Texto para o CheckBox")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 0,
                onClick = {sistemaSelecionado = 0}
            )

            Text(text = "Windons")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 1,
                onClick = {sistemaSelecionado = 1}
            )

            Text(text = "MacOS")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 2,
                onClick = {sistemaSelecionado = 2}
            )

            Text(text = "Linux")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                 onClick = {},
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Blue,
                    containerColor = Color.Green
                )
             ){
                Text(text = "Clique Aqui")
            }
        }

//        // Chamando o composable que nós criamos
//        AndroidEnemy(
//            color = Color.Red,
//            modifier = Modifier
//                .size(100.dp)
//        )
//
//        AndroidEnemy(
//            color = Color.Blue,
//            modifier = Modifier
//                .size(150.dp)
//        )
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
