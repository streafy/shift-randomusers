package components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.streafy.shiftrandomusers.core.ui.R

@Composable
fun ErrorDialog(
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
    errorMessage: String
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(stringResource(R.string.error_dialog_ok))
            }
        },
        title = {
            Text(stringResource(R.string.error_dialog_title))
        },
        text = {
            Text(errorMessage)
        }
    )
}

@Preview
@Composable
private fun ErrorDialogPreview() {
    ErrorDialog(
        onDismissRequest = {},
        onConfirm = {},
        errorMessage = "Error message"
    )
}