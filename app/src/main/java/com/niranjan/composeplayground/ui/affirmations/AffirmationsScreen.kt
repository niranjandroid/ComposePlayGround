package com.niranjan.composeplayground.ui.affirmations

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.niranjan.composeplayground.data.affirmation.Datasource
import com.niranjan.composeplayground.data.affirmation.model.Affirmation
import com.niranjan.composeplayground.ui.theme.ComposePlayGroundTheme

@Composable
fun AffirmationsScreen() {

    val affirmationList = Datasource().loadAffirmations()

    LazyColumn {
        items(affirmationList) { affirmation ->
            AffirmationCard(affirmation, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            AffirmationImage(affirmation = affirmation)
            AffirmationText(stringResourceId = affirmation.stringResourceId)
        }
    }

}

@Composable
fun AffirmationText(@StringRes stringResourceId: Int) {
    Text(
        text = LocalContext.current.getString(stringResourceId),
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.headlineSmall
    )
}

@Composable
fun AffirmationImage(affirmation: Affirmation) {
    Image(
        painter = painterResource(affirmation.imageResourceId),
        contentDescription = stringResource(affirmation.stringResourceId),
        modifier = Modifier
            .fillMaxWidth()
            .height(194.dp),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ComposePlayGroundTheme {
        AffirmationsScreen()
    }
}
