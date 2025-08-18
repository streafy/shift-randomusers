package com.streafy.shiftrandomusers.feature.userdetails.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.streafy.shiftrandomusers.feature.userdetails.domain.UserDetails

@Composable
internal fun UserDetailsCard(
    userDetails: UserDetails,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        with(userDetails) {
            Header(
                photoUrl = photoUrl,
                firstName = firstName,
                lastName = lastName,
                username = username
            )
            Contacts(
                email = email,
                phone = phone
            )
            Address(
                streetNumber = streetNumber,
                streetName = streetName,
                city = city,
                state = state,
                country = country,
                latitude = latitude,
                longitude = longitude
            )
            UserInfo(
                dateOfBirthDate = dateOfBirthDate,
                dateOfBirthAge = dateOfBirthAge,
                registeredDate = registeredDate,
                registeredAge = registeredAge,
                nationality = nationality
            )
        }
    }
}

@Composable
private fun Header(
    photoUrl: String,
    firstName: String,
    lastName: String,
    username: String
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(6.dp))
        )
        Column {
            Text(text = "$firstName $lastName", style = MaterialTheme.typography.titleLarge)
            Text("@$username", color = MaterialTheme.colorScheme.outline)
        }
    }
}

@Composable
private fun Contacts(
    email: String,
    phone: String,
) {
    val context = LocalContext.current

    UserDetailsBlock(titleText = "Contacts") {
        UserDetailsItem(
            name = "Email",
            value = email,
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            onClick = { context.sendEmailTo(email) }
        )
        UserDetailsItem(
            name = "Phone",
            value = phone,
            onClick = { context.dialPhoneNumber(phone) }
        )
    }
}

@Composable
private fun Address(
    streetNumber: Int,
    streetName: String,
    city: String,
    state: String,
    country: String,
    latitude: String,
    longitude: String
) {
    val context = LocalContext.current

    UserDetailsBlock(titleText = "Location") {
        UserDetailsItem(
            name = "Address",
            value = "$streetNumber $streetName, $city, $state, $country",
            onClick = { context.showOnMap(address = "$streetNumber $streetName, $city, $state, $country") }
        )
        UserDetailsItem(
            name = "Coordinates",
            value = "$latitude $longitude",
            onClick = { context.showOnMap(latitude = latitude, longitude = longitude) }
        )
    }
}

@Composable
private fun UserInfo(
    dateOfBirthDate: String,
    dateOfBirthAge: Int,
    registeredDate: String,
    registeredAge: Int,
    nationality: String
) {
    UserDetailsBlock(titleText = "Info") {
        UserDetailsItem(
            name = "Date of Birth",
            value = "$dateOfBirthDate ($dateOfBirthAge years)"
        )
        UserDetailsItem(
            name = "Registered",
            value = "$registeredDate ($registeredAge years ago)"
        )
        UserDetailsItem(
            name = "Nationality",
            value = nationality
        )
    }
}

@Composable
private fun UserDetailsBlock(
    titleText: String,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Column(modifier = Modifier.padding(12.dp)) {
        Text(
            text = titleText,
            modifier = Modifier.padding(horizontal = 4.dp),
            style = MaterialTheme.typography.titleLarge
        )
        content()
    }
}

@Composable
private fun UserDetailsItem(
    name: String,
    value: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val clickableModifier = if (onClick != null) {
        modifier
            .clip(RoundedCornerShape(4.dp))
            .clickable(onClick = onClick)
    } else {
        modifier
    }
    val valueColor = if (onClick != null) MaterialTheme.colorScheme.primary else Color.Unspecified

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = value,
            modifier = clickableModifier.padding(4.dp),
            color = valueColor,
            textAlign = TextAlign.End,
        )
    }
}