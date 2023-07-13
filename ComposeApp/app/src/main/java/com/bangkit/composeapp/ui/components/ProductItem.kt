package com.bangkit.composeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bangkit.composeapp.R
import com.bangkit.composeapp.ui.theme.ComposeAppTheme
import com.bangkit.composeapp.ui.theme.Shapes

@Composable
fun ProductItem(
    image: Int,
    title: String,
    price: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .size(width = 110.dp, height = 215.dp)
    ){
        Column(
            modifier = modifier.padding(horizontal = 5.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(vertical = 5.dp),
                contentAlignment = Alignment.Center
            )
            {
                Image(painter = painterResource(image),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .size(width = 100.dp, height = 160.dp)
                        .clip(Shapes.medium)
                        .clip(RoundedCornerShape(5.dp))
                )
            }
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.price, price),
                maxLines = 1,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProductItemPreview() {
    ComposeAppTheme {
        ProductItem(R.drawable.book_a_little_princess, "A little Princess", 488000)
    }
}

@Composable
@Preview(showBackground = true)
fun ProductItemPreview2() {
    ComposeAppTheme {
        ProductItem(R.drawable.book_dinosaur_who_lost, "The Dinosaur Who Lost His Roar", 999999)
    }
}