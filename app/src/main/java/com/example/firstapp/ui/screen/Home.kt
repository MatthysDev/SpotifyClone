package com.example.firstapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.firstapp.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

 @OptIn(ExperimentalMaterial3Api::class)
@Composable
 fun Home(navController: NavHostController) {
     val navControllerHome = rememberNavController()


    val listChips = listOf("Musique", "Podcasts et émissions", "Radio")
    val firebaseAuth = Firebase.auth

    firebaseAuth.createUserWithEmailAndPassword("test@efficom.fr", "Azerty123").addOnCompleteListener {
        if (it.isSuccessful){
        }else if(it.isCanceled){
        }
    }.addOnFailureListener {
    }
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "Bonjour") },
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            titleContentColor = Color.White,
                            containerColor = Color.Black,
                        ),
                        actions = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_music_note_24),
                                contentDescription = "musique",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(24.dp)
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_watch_later_24),
                                contentDescription = "musique",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(24.dp)
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                                contentDescription = "musique",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(24.dp)
                            )
                        }
                    )
                },
                bottomBar = {
                    val navBackStackEntry by navControllerHome.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    NavigationBar(containerColor = Color.Black) {
                        NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any { it.route == "home" } == true, onClick = { navControllerHome.navigate("home");},
                            label = { Text(text = "Accueil") },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_baseline_home_24),
                                    contentDescription = null
                                )
                            }
                        )
                        NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any { it.route == "search" } == true, onClick = { navControllerHome.navigate("search");},
                            label = { Text(text = "Recherche") },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_baseline_search_24),
                                    contentDescription = null
                                )
                            }
                        )
                        NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any { it.route == "library" } == true, onClick = { navControllerHome.navigate("library");},
                            label = { Text(text = "Bibliothèque") },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_baseline_library_books_24),
                                    contentDescription = null
                                )
                            }
                        )
                    }

                }

            ) {
                Column(modifier = Modifier.padding(it)) {
                    LazyRow(modifier = Modifier.padding(16.dp)) {
                        items(listChips) { item ->
                            InputChip(
                                label = { Text(text = item) },
                                onClick = {},
                                modifier = Modifier.padding(4.dp),
                                selected = true,
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(16.dp, 0.dp)
                            .height(60.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Black,
                                contentColor = Color.White
                            )
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                AsyncImage(
                                    modifier = Modifier.weight(0.25f),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://i.scdn.co/image/ab67706c0000da84f6fc20d267d4ed3b2e85786d")
                                        .build(),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    modifier = Modifier
                                        .weight(.7f)
                                        .padding(10.dp),
                                    text = "Titres likés",
                                    textAlign = TextAlign.Left
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Black,
                                contentColor = Color.White
                            )
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                AsyncImage(
                                    modifier = Modifier.weight(0.25f),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://static.fnac-static.com/multimedia/Images/FR/NR/f8/b2/d3/13873912/1540-1/tsp20211109110103/Civilisation.jpg")
                                        .build(),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    modifier = Modifier
                                        .weight(.7f)
                                        .padding(10.dp),
                                    text = "Civilisation",
                                    textAlign = TextAlign.Left
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(16.dp, 0.dp)
                            .height(60.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Black,
                                contentColor = Color.White
                            )
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                AsyncImage(
                                    modifier = Modifier.weight(0.25f),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://www.goutemesdisques.com/uploads/tx_gmdchron/pi1/vald_v.jpg")
                                        .build(),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    modifier = Modifier
                                        .weight(.7f)
                                        .padding(10.dp),
                                    text = "V",
                                    textAlign = TextAlign.Left
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Black,
                                contentColor = Color.White
                            )
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                AsyncImage(
                                    modifier = Modifier.weight(0.25f),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://xn--mosaque-rza.com/wp-content/uploads/2020/12/qalf.jpg")
                                        .build(),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    modifier = Modifier
                                        .weight(.7f)
                                        .padding(10.dp),
                                    text = "QALF",
                                    textAlign = TextAlign.Left
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(16.dp, 0.dp)
                            .height(60.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Black,
                                contentColor = Color.White
                            )
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                AsyncImage(
                                    modifier = Modifier.weight(0.25f),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://www.abcdrduson.com/wp-content/uploads/2020/03/laylow-trinity.jpeg")
                                        .build(),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    modifier = Modifier
                                        .weight(.7f)
                                        .padding(10.dp),
                                    text = "Trinity",
                                    textAlign = TextAlign.Left
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Black,
                                contentColor = Color.White
                            )
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                AsyncImage(
                                    modifier = Modifier.weight(0.25f),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://m.media-amazon.com/images/I/61UuJ3UntBL._UF894,1000_QL80_.jpg")
                                        .build(),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    modifier = Modifier
                                        .weight(.7f)
                                        .padding(10.dp),
                                    text = "Flip",
                                    textAlign = TextAlign.Left
                                )
                            }
                        }
                    }


                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)) {
                        AsyncImage(
                            // image en rond
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://i.scdn.co/image/ab6761610000e5eb5d2b5b05339fb37b1efbc641")
                                .build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .weight(0.18f)
                                .padding(10.dp)
                                .size(60.dp)
                                .clip(CircleShape)
                        )
                        Column(modifier = Modifier.weight(0.75f)) {
                            Text(
                                text = "Dernière sortie de ",
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Caballero & JeanJass",
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .padding(8.dp, 0.dp)
                            .height(110.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        )
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(
                                modifier = Modifier
                                    .weight(0.32f)
                                    .width(100.dp),
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data("https://images.genius.com/e6b0271e4f1d2a8d2513e3c5d1a24433.1000x1000x1.jpg")
                                    .build(),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                            )
                            Column(modifier = Modifier
                                .weight(0.75f)
                                .padding(10.dp)
                                .width(10.dp) ) {
                                Text(
                                    text = "Tchernobyl",
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Single - Caballero & JeanJass, Kaaris",
                                    textAlign = TextAlign.Left,
                                    fontSize = 12.sp
                                )
                            }
                            Icon(
                                modifier = Modifier
                                    .padding(10.dp),
                                painter = painterResource(id = R.drawable.ic_baseline_music_note_24),
                                contentDescription = "musique"
                            )
                        }


                    }
                    Text(text = "Conçu pour vous",
                        modifier = Modifier.padding(10.dp, 20.dp, 0.dp, 0.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp)
                    Card(
                        modifier = Modifier
                            .padding(8.dp, 10.dp)
                            .height(110.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        )
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Column(modifier = Modifier
                                .weight(1f)
                                .padding(10.dp)
                                .width(10.dp) ) {
                                AsyncImage(
                                    modifier = Modifier
                                        .weight(0.40f)
                                        .width(70.dp),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://dailymix-images.scdn.co/v2/img/ab6761610000e5ebb78f77c5583ae99472dd4a49/1/en/default")
                                        .build(),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    modifier = Modifier.padding(0.dp,5.dp,0.dp,0.dp),
                                    text = "Mix n°1",
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                )

                            }
                            Column(modifier = Modifier
                                .weight(1f)
                                .padding(10.dp)
                                .width(10.dp) ) {
                                AsyncImage(
                                    modifier = Modifier
                                        .weight(0.40f)
                                        .width(70.dp),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://i1.sndcdn.com/artworks-001022042416-0ss27g-t500x500.jpg")
                                        .build(),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    modifier = Modifier.padding(0.dp,5.dp,0.dp,0.dp),
                                    text = "Mix n°2",
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                )

                            }
                            Column(modifier = Modifier
                                .weight(1f)
                                .padding(10.dp)
                                .width(10.dp) ) {
                                AsyncImage(
                                    modifier = Modifier
                                        .weight(0.40f)
                                        .width(70.dp),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://dailymix-images.scdn.co/v2/img/ab6761610000e5ebea73434f5cb3017a1a099a22/3/en/default")
                                        .build(),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    modifier = Modifier.padding(0.dp,5.dp,0.dp,0.dp),
                                    text = "Mix n°3",
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                )

                            }
                            Column(modifier = Modifier
                                .weight(1f)
                                .padding(10.dp)
                                .width(10.dp) ) {
                                AsyncImage(
                                    modifier = Modifier
                                        .weight(0.40f)
                                        .width(70.dp),
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data("https://i1.sndcdn.com/artworks-000895588099-kfmiqd-t500x500.jpg")
                                        .build(),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                )
                                Text(
                                    modifier = Modifier.padding(0.dp,5.dp,0.dp,0.dp),
                                    text = "Mix n°4",
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                )

                            }
                        }


                    }
                }
                NavHost(navControllerHome, startDestination = "home", modifier = Modifier.fillMaxSize()) {
                    composable("home") { Home(navController = navController) }
                    composable("search") { Search(navController = navController) }
                    composable("library") { Library(navController = navController) }
                }

            }
        }
