package com.example.gridlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridlist.data.DataSource
import com.example.gridlist.model.Topic
import com.example.gridlist.ui.theme.GridListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridLayout()
                }
            }
        }
    }
}
@Composable
fun GridLayout(){
    GridList(
        DataSource.topics
    )
}


//a single element of the list
@Composable
fun GridCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier){
        Row{
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
                modifier.size(68.dp)
            )
            Column{
                Text(text = stringResource(id = topic.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
                )

                Row {
                    Icon(Icons.Outlined.Menu,
                        contentDescription = stringResource(R.string.menu),
                        modifier = modifier
                            .padding(start = 16.dp, end = 8.dp)
                    )
                    Text(text = "${topic.integerResource}",
                        style = MaterialTheme.typography.labelMedium,
                        modifier = modifier
                            .padding(top = 4.dp)
                    )
                }
            }

        }
    }
}

@Composable
fun GridList(topics: List<Topic>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ){
        //remember to import items into a items with a list input, not int
        items(topics){topic ->
            GridCard(
                topic = topic,
            )
        }
    }
}
@Preview
@Composable
fun GreetingPreview() {
        GridCard(Topic(R.string.architecture, 58, R.drawable.architecture))
}