package com.niranjan.composeplayground.ui.grid

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.niranjan.composeplayground.R
import com.niranjan.composeplayground.data.grid.GridDataSource
import com.niranjan.composeplayground.data.grid.Topic
import com.niranjan.composeplayground.ui.theme.ComposePlayGroundTheme

@Composable
fun GridScreen() {

    val topics = GridDataSource.topics

    LazyVerticalGrid(
        modifier = Modifier.padding(16.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(topics) { topic ->
            GridItem(topic)
        }
    }
}


@Composable
fun GridItem(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier.height(68.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.size(68.dp), painter = painterResource(id = topic.image),
                contentDescription = stringResource(id = topic.name)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stringResource(id = topic.name),
                    style = MaterialTheme.typography.bodySmall
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = "${topic.name} has ${topic.count}"
                    )
                    Text(
                        text = topic.count.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    ComposePlayGroundTheme {
        GridScreen()
    }
}