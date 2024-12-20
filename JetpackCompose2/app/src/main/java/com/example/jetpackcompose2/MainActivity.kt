package com.example.jetpackcompose2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose2.ui.theme.JetpackCompose2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val painter= painterResource(R.drawable.foto)
            val description="Ali Bilir's job is CNC operating"
            val title="Have a great fun!!"
            ImageCard(
                painter =painter,
                contentDescription =description ,
                title=title)

        }
    }
}
@Composable
fun ImageCard(
    painter:Painter,//Resim göstermemizi sağlıyor
    contentDescription:String,//Resmimizde açıklama görmemizi sağlar
    title:String,//Resmimizin bir başlığı olacak
    modifier: Modifier=Modifier,

){
    Card(
        modifier=modifier.fillMaxWidth(),
        shape= RoundedCornerShape(15.dp),//yuvarlatılmış köşeler
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ){
        Box(modifier = Modifier.height(200.dp)){
            Image(

                painter=painter,
                contentDescription=contentDescription,
                contentScale = ContentScale.Crop,
                )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                    contentAlignment= Alignment.BottomStart
            ){
                Text(title, style = TextStyle(color = Color.Black, fontSize = 16.sp))
                Text(contentDescription, style =TextStyle(color = Color.Black, fontSize = 25.sp) )

            }//buraya kadar görselimiz için bi rkutu oluşturduk görselin üstünde de bir kutu
            //oluşturduk ve başlık ekledik düzenlemeler yaptık
        }
    }
}


