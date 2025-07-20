@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.project23_scaffold_topappbar

import android.R.attr.title
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.GraphicsContext
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project23_scaffold_topappbar.ui.theme.Project23_Scaffold_TopAppBARTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project23_Scaffold_TopAppBARTheme {
                MainScreen(applicationContext)
            }
        }
    }
}

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(context: Context) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        containerColor = Color.Yellow,
        contentColor = Color.White,
        modifier = Modifier.padding(30.dp),
        topBar = {

            TopAppBar(
                title = {
                    Text("Menu")
                        },
                        Modifier
                            .background(color = Color.Blue)
                            .padding(5.dp),
                                navigationIcon = {
                                    IconButton(
                                        onClick = {
                                            Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show()
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Menu,
                                            contentDescription = "Menu")

                                    }
                                },
                        actions = {
                            IconButton(
                                onClick = {
                                    scope.launch {
                                        val result = snackbarHostState.showSnackbar(
                                            message = "Item Delete!",
                                            actionLabel = "Undone"
                                        )
                                        if(result == SnackbarResult.ActionPerformed){
                                            Toast.makeText(context, "Item recovered", Toast.LENGTH_SHORT)
                                                .show()
                                        }

                                    }

                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Delete,
                                    contentDescription = "Delete")

                            }
                            IconButton(
                                onClick = {
                                    Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show()
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Share,
                                    contentDescription = "Share")

                            }
                        }

                )
        }
    ) {

    }
}

