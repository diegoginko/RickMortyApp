package com.diegoginko.rickmortyapp.ui.home.tabs.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.diegoginko.rickmortyapp.domain.model.CharacterModel
import com.diegoginko.rickmortyapp.ui.core.ex.vertical
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import rickmortyapp.composeapp.generated.resources.Res
import rickmortyapp.composeapp.generated.resources.rickface

@Composable
fun CharactersScreen(){
    val charactersViewModel = koinViewModel<CharactersViewModel>()
    val state by charactersViewModel.state.collectAsState()
    val characters: LazyPagingItems<CharacterModel> = state.characters!!.collectAsLazyPagingItems()

    Column(Modifier.fillMaxSize()) {
//        if(state.value.characterOfTheDay != null){
//            Text(state.value.characterOfTheDay.name)
//        }
        //De esta forma utiliza el estado que vio al checkear que no fuera nulo, ya que si esta dentro de un if, puede cambiar luego de comprobarlo
//        state.characterOfTheDay?.let {
//            Text(it.name)
//        }
//        CharacterOfTheDay(state.characterOfTheDay)
        CharactersGridList(characters, state)
    }
}

@Composable
fun CharactersGridList(characters: LazyPagingItems<CharacterModel>, state: CharactersState) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){

        item(span = { GridItemSpan(2) }){
            CharacterOfTheDay(state.characterOfTheDay)
        }

        when{
            characters.loadState.refresh is LoadState.Loading && characters.itemCount == 0 -> {
                //carga inicial
                item(span = { GridItemSpan(2) }){
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator(Modifier.size(64.dp), color = Color.Red)
                    }
                }
            }

            characters.loadState.refresh is LoadState.NotLoading && characters.itemCount == 0-> {
                //No hay datos
                item{
                    Text("No hay personajes")
                }
            }

            else -> {
                //Recorremos los items
                items(characters.itemCount){pos ->
                    characters[pos]?.let { characterModel ->
                        CharacterItemList(characterModel)
                    }
                }


                if(characters.loadState.append is LoadState.Loading){
                    item(span = { GridItemSpan(2) }){
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxHeight().height(100.dp)) {
                            CircularProgressIndicator(Modifier.size(64.dp), color = Color.Red)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterItemList(x0: CharacterModel) {
    Box(modifier = Modifier.clip(RoundedCornerShape(24))
        .border(2.dp,Color.Green, shape = RoundedCornerShape(0, 24, 0,24)).fillMaxWidth().height(150.dp)
        .clickable{},
        contentAlignment = Alignment.BottomCenter

    ) {
        AsyncImage(
            model = x0.image,
            contentDescription = x0.name,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(Res.drawable.rickface)
        )
        Box(modifier = Modifier.fillMaxWidth().height(60.dp).background(
            brush = Brush.verticalGradient(
                listOf(
                    Color.Black.copy(alpha = 0f),
                    Color.Black.copy(alpha = 0.6f),
                    Color.Black.copy(alpha = 1f)
                )
            )
        ), contentAlignment = Alignment.Center){
            Text(x0.name, color = Color.White, fontSize = 18.sp)
        }
    }
}

@Composable
fun CharacterOfTheDay(characterModel: CharacterModel? = null){
    Card(modifier = Modifier.fillMaxWidth().height(400.dp), shape = RoundedCornerShape(12) ) {
        if(characterModel == null){
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(color = Color.Green)
            }
        }else{
            Box(contentAlignment = Alignment.BottomStart){
//                Box(modifier = Modifier.fillMaxSize().background(Color.Green.copy(alpha = 0.5f)))

                AsyncImage(
                    model = characterModel.image,
                    contentDescription = "Character of the day",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Box(modifier = Modifier.fillMaxSize().background(
                    Brush.horizontalGradient(
                        0f to Color.Black.copy(alpha = 0.9f),
                        0.4f to Color.White.copy(alpha = 0f),
                    )
                ))
                Text(characterModel.name,
                    fontSize = 40.sp,
                    maxLines = 1,
                    minLines = 1,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
                        .fillMaxHeight()
                        .vertical()
                        .rotate(-90f)
                    )
            }
        }
    }

}