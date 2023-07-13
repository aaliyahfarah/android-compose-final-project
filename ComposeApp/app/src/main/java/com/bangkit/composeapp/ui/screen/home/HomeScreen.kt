package com.bangkit.composeapp.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bangkit.composeapp.R
import com.bangkit.composeapp.di.Injection
import com.bangkit.composeapp.model.OrderProduct
import com.bangkit.composeapp.ui.ViewModelFactory
import com.bangkit.composeapp.ui.common.UiState
import com.bangkit.composeapp.ui.components.ProductItem
import com.bangkit.composeapp.ui.components.SectionText

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit,
){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllProducts()
            }
            is UiState.Success -> {
                HomeContent(
                    orderProduct = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail,
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    orderProduct: List<OrderProduct>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionText(stringResource(R.string.section_newAdded))
        LazyRow(
            modifier = modifier.padding(16.dp)
        ) {
            items(orderProduct.shuffled().take(10)) { data ->
                ProductItem(
                    image = data.product.image,
                    title = data.product.title,
                    price = data.product.price,
                    modifier = Modifier.clickable {
                        navigateToDetail(data.product.id)
                    }
                )
            }
        }
        SectionText(stringResource(R.string.section_AllBook))
        LazyVerticalGrid(
            columns = GridCells.Adaptive(110.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
        ) {
            items(orderProduct) { data ->
                ProductItem(
                    image = data.product.image,
                    title = data.product.title,
                    price = data.product.price,
                    modifier = Modifier.clickable {
                        navigateToDetail(data.product.id)
                    }
                )
            }
        }
    }
}
