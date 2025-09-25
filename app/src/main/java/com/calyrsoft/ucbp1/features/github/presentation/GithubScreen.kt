package com.calyrsoft.ucbp1.features.github.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GithubScreen(
    modifier: Modifier = Modifier,
    vm: GithubViewModel = koinViewModel()
) {
    var nickname by remember { mutableStateOf("") }
    val state by vm.state.collectAsState()

    Scaffold(

    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            OutlinedTextField(
                value = nickname,
                onValueChange = { nickname = it },
                label = { Text("Github Nickname") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(12.dp))

            Button(
                onClick = { vm.fetchAlias(nickname) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Buscar perfil")
            }

            Spacer(Modifier.height(24.dp))

            when (val st = state) {
                is GithubViewModel.GithubStateUI.Error -> {
                    Text(
                        text = st.message,
                        color = MaterialTheme.colorScheme.error,
                        fontWeight = FontWeight.Bold
                    )
                }

                GithubViewModel.GithubStateUI.Init -> {
                    Text("Ingresa un nickname para comenzar")
                }

                GithubViewModel.GithubStateUI.Loading -> {
                    CircularProgressIndicator()
                }

                is GithubViewModel.GithubStateUI.Success -> {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            AsyncImage(
                                model = st.github.pathUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(120.dp),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(Modifier.height(12.dp))

                            Text(
                                text = st.github.nickname,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(Modifier.height(4.dp))

                            Text(
                                text = st.github.pathUrl,
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }
                    }
                }
            }
        }
    }
}
