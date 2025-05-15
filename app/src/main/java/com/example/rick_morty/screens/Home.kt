package com.example.rick_morty.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rick_morty.R
import com.example.rick_morty.model.Character
import com.example.rick_morty.model.Result
import com.example.rick_morty.service.RetrofitFactory
import retrofit2.Callback

@Composable
fun Home(modifier: Modifier = Modifier) {

    var characterList = remember {
        mutableStateOf(listOf<Character>())
    }

    //obter um retrofit factory
    var callCharacters = RetrofitFactory()
        .getCharacterService()
        .listAll()

    // enviar a requisicao
    callCharacters.enqueue(object : Callback<Result>{

    })

    Box(
        modifier = Modifier.fillMaxSize()
            .height(100.dp)


    ){
        Image(
            painter = painterResource(R.drawable.rick_morty),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color(0x66000000))
        )
        Column (
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ){
            Text(
                text = "Rick & Morty",
                color = Color.White,
                fontSize = 48.dp
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(ImageVector = Icons.Default.Search,

                            )
                    }
                }

            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Character List",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            for (i in 1){
                CharacterCard()
            }
        }
    }
}


@Preview
@Composable
private fun HomePreview() {
    Home()
}