package com.niranjan.composeplayground.ui.superhero

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.niranjan.composeplayground.R
import com.niranjan.composeplayground.data.hero.Hero
import com.niranjan.composeplayground.data.hero.HeroesRepository
import com.niranjan.composeplayground.ui.theme.ComposePlayGroundTheme

@Composable
@ExperimentalMaterial3Api
fun HeroesScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = stringResource(id = R.string.title_super_heroes),
                    style = MaterialTheme.typography.displayLarge
                )
            })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            contentPadding = paddingValues,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(HeroesRepository.heroes) {
                HeroCard(hero = it)
            }
        }
    }

}

@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeroDetails(
                nameRes = hero.nameRes,
                descriptionRes = hero.descriptionRes,
                modifier = Modifier.weight(1f)
            )
            HeroImage(imageRes = hero.imageRes)
        }
    }
}

@Composable
fun HeroImage(@DrawableRes imageRes: Int) {
    Image(
        modifier = Modifier
            .size(72.dp)
            .clip(shape = MaterialTheme.shapes.small),
        painter = painterResource(id = imageRes),
        contentDescription = null
    )
}

@Composable
fun HeroDetails(
    @StringRes nameRes: Int,
    @StringRes descriptionRes: Int,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Text(text = stringResource(id = nameRes), style = MaterialTheme.typography.displaySmall)
        Text(text = stringResource(id = descriptionRes), style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
@ExperimentalMaterial3Api
fun HeroesScreenPreview() {
    ComposePlayGroundTheme {
        HeroesScreen()
    }
}

@Preview(showBackground = true)
@Composable
@ExperimentalMaterial3Api
fun HeroesScreenDarkPreview() {
    ComposePlayGroundTheme(darkTheme = true) {
        HeroesScreen()
    }
}

