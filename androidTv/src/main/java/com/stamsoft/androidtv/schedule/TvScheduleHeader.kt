package com.stamsoft.androidtv.schedule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.tv.material3.Button
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.stamsoft.androidtv.R

@Composable
fun TvScheduleHeader(
    titleResId: Int,
    onReload: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(titleResId),
            style = MaterialTheme.typography.headlineMedium
        )
        Button(onClick = onReload) {
            Text(stringResource(R.string.tv_reload))
        }
    }
}
