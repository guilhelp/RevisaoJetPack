package com.example.appintroducao

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appintroducao.ui.theme.AppIntroducaoTheme
import com.example.appintroducao.ui.theme.DebugButtonColors
import com.example.appintroducao.ui.theme.ErrorButtonColors
import com.example.appintroducao.ui.theme.InfoButtonColors
import com.example.appintroducao.ui.theme.WarningButtonColors

const val TAG = "Test Android"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppIntroducaoTheme {
                App()
            }
        }
    }
}

@Composable
private fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column( // Criando uma coluna vertical com os itens no centro
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting("Introdução ao JetPack Compose!")
            ActionButton( // Botão do Debug
                text = "Debug",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                /* Ação do Botão */
                Log.d(TAG, "App: Clicou em DEBUG!")
            }
            ActionButton( // Botão do Info
                text = "Info",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.i(TAG, "App: Clicou em INFO!")
            }
            ActionButton( // Botão do Warning
                text = "Warning",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                Log.w(TAG, "App: Clicou em Warning")
            }
            ActionButton( // Botão do Error
                text = "Error",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ){
                try {
                    throw RuntimeException("")
                }catch(ex: Exception){
                    Log.e(TAG, "${ex.message}")
                }
            }
        }
    }
}

@Preview(widthDp = 200, heightDp = 50)
@Composable
fun ActionButtonPreviewDebug(){
        Column( // Criando uma coluna vertical com os itens no centro
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ActionButton( // Botão do Debug
                text = "Debug",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                /* Ação do Botão */
                Log.d(TAG, "App: Clicou em DEBUG!")
            }
        }
    }

@Preview(widthDp = 200, heightDp = 50)
@Composable
fun ActionButtonPreviewInfo(){
    Column( // Criando uma coluna vertical com os itens no centro
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActionButton( // Botão do Info
            text = "Info",
            buttonColors = InfoButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Log.i(TAG, "App: Clicou em INFO!")
        }
    }
}

@Preview(widthDp = 200, heightDp = 50)
@Composable
fun ActionButtonPreviewWarning(){
    Column( // Criando uma coluna vertical com os itens no centro
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActionButton( // Botão do Warning
            text = "Warning",
            buttonColors = WarningButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ){
            Log.w(TAG, "App: Clicou em Warning")
        }
    }
}

@Preview(widthDp = 200, heightDp = 50)
@Composable
fun ActionButtonPreviewError(){
    Column( // Criando uma coluna vertical com os itens no centro
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ActionButton( // Botão do Error
            text = "Error",
            buttonColors = ErrorButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ){
            try {
                throw RuntimeException("")
            }catch(ex: Exception){
                Log.e(TAG, "${ex.message}")
            }
        }
    }
}

@Composable
fun ActionButton( // Configurando a personalização de cada botão
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true, widthDp = 200, heightDp = 200)
@Composable
fun AppPreview(){ // Criando o preview para a tela e os botões
    AppIntroducaoTheme {
        App()
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview(){ // Criando o preview para o botão cadastrar
    ActionButton(text = "Cadastrar") {

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() { // Criando o preview para o texto de aula de JetPack
    AppIntroducaoTheme {
        Greeting("Introdução ao JetPack Compose!")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) { // Criando o texto de JetPack
    Text(
        text = "Aula de $name!",
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold
        ),
        color = MaterialTheme.colorScheme.secondary
    )
}



