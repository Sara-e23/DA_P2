package com.example.clasetrabajo.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.clasetrabajo.data.database.AppDatabase
import com.example.clasetrabajo.data.database.DatabaseProvider
import com.example.clasetrabajo.data.model.AccountEntity
import com.example.clasetrabajo.ui.components.FavoriteAccountCard
import com.example.clasetrabajo.ui.components.TopBarComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun FavoriteAccountsScreen(navController: NavController) {
    val db: AppDatabase = DatabaseProvider.getDatabase(LocalContext.current)
    val accountDao = db.accountDao()
    var accountsdb by remember { mutableStateOf<List<AccountEntity>>(emptyList()) }

    LaunchedEffect(Unit) {
        accountsdb = withContext(Dispatchers.IO) {
            accountDao.getAll()
        }
    }

    Column(modifier = Modifier.background(MaterialTheme.colorScheme.tertiary)) {
        TopBarComponent("Favorite Accounts", navController, "favAcScreen")
        val listState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = listState
        ) {
            items(accountsdb) { accountdb ->
                FavoriteAccountCard(
                    id = accountdb.id ?: 0,
                    name = accountdb.name ?: "",
                    username = accountdb.username ?: "",
                    password = accountdb.password ?: "",
                    imageURL = accountdb.imageURL ?: "",
                    description = accountdb.description ?: "",
                    onDeleteClick = {
                        CoroutineScope(Dispatchers.IO).launch {
                            try{
                                accountDao.delete(accountdb)
                                accountsdb = withContext(Dispatchers.IO){
                                    accountDao.getAll()
                                }
                                Log.d("debug-db", "Account deleted successfully")
                            } catch(exception: Exception) {
                                Log.d("debug-db", "ERROR: $exception")
                            }
                        }
                    }
                )
            }
        }
        TopBarComponent("FavoriteAccounts", navController, "favAcScreen")
    }
}
