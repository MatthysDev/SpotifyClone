package com.example.firstapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.InputChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
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
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.firstapp.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Library(navController: NavHostController)
{


                val navControllerHome = rememberNavController()
                val listChips = listOf("Musique", "Podcasts et émissions", "Radio")

                Scaffold(

                ) {
                    Column(modifier = Modifier.padding(it)) {
                        LazyRow(modifier = Modifier.padding(12.dp,64.dp,0.dp,0.dp)) {
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
                                .height(220.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(180.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Black,
                                    contentColor = Color.White
                                )
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    AsyncImage(
                                        modifier = Modifier.weight(0.75f),
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("https://i.scdn.co/image/ab67706c0000da84f6fc20d267d4ed3b2e85786d")
                                            .build(),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                    )

                                }
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(180.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Black,
                                    contentColor = Color.White
                                )
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    AsyncImage(
                                        modifier = Modifier.weight(0.75f),
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("https://static.fnac-static.com/multimedia/Images/FR/NR/f8/b2/d3/13873912/1540-1/tsp20211109110103/Civilisation.jpg")
                                            .build(),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                    )

                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .padding(16.dp, 0.dp)
                                .height(220.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(180.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Black,
                                    contentColor = Color.White
                                )
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    AsyncImage(
                                        modifier = Modifier.weight(0.75f),
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("https://www.goutemesdisques.com/uploads/tx_gmdchron/pi1/vald_v.jpg")
                                            .build(),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                    )

                                }
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(180.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Black,
                                    contentColor = Color.White
                                )
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    AsyncImage(
                                        modifier = Modifier.weight(0.75f),
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("https://xn--mosaque-rza.com/wp-content/uploads/2020/12/qalf.jpg")
                                            .build(),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                    )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .padding(16.dp, 0.dp)
                                .height(220.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(180.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Black,
                                    contentColor = Color.White
                                )
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    AsyncImage(
                                        modifier = Modifier.weight(0.75f),
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("https://www.abcdrduson.com/wp-content/uploads/2020/03/laylow-trinity.jpeg")
                                            .build(),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                    )

                                }
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(180.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.Black,
                                    contentColor = Color.White
                                )
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    AsyncImage(
                                        modifier = Modifier.weight(0.75f),
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data("https://m.media-amazon.com/images/I/61UuJ3UntBL._UF894,1000_QL80_.jpg")
                                            .build(),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                    )

                                }
                            }
                        }







                                }


                            }


                        }









