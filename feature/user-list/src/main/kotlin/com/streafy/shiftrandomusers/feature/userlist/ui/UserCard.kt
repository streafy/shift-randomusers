package com.streafy.shiftrandomusers.feature.userlist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.ColorImage
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler
import com.streafy.shiftrandomusers.feature.userlist.R
import com.streafy.shiftrandomusers.feature.userlist.domain.User

@Composable
fun UserCard(
    user: User,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            UserPhoto(user.photoUrl)
            UserInfo(user)
        }
    }
}

@Composable
private fun UserPhoto(photoUrl: String) {
    AsyncImage(
        model = photoUrl,
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(6.dp))
    )
}

@Composable
private fun UserInfo(user: User) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        UserName(user.firstName, user.lastName)
        UserInfoRow(Icons.Default.Phone, user.phone)
        UserInfoRow(Icons.Default.Place, user.address)
    }
}

@Composable
private fun UserName(
    firstName: String,
    lastName: String
) {
    Text(
        text = stringResource(R.string.user_card_name_pattern, firstName, lastName),
        style = MaterialTheme.typography.titleLarge,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
private fun UserInfoRow(
    icon: ImageVector,
    text: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null)
        Text(
            text = text,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@OptIn(ExperimentalCoilApi::class)
@Preview()
@Composable
private fun UserCardPreview() {
    val user = User(
        id = "1",
        firstName = "User",
        lastName = "User",
        photoUrl = "https://randomuser.me/api/portraits/med/women/1.jpg",
        address = "Some Address",
        phone = "098-66732533"
    )

    val previewHandler = AsyncImagePreviewHandler {
        ColorImage(Color.Red.toArgb())
    }

    CompositionLocalProvider(LocalAsyncImagePreviewHandler provides previewHandler) {
        UserCard(user, onClick = {})
    }
}