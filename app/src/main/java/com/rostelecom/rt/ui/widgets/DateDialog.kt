package com.rostelecom.rt.ui.widgets

import androidx.compose.runtime.Composable
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate

@Composable
fun DateDialog(inputDate: (date :LocalDate)->Unit , callback: ()-> Unit) {
    val dialogState = rememberMaterialDialogState()

    MaterialDialog(
        dialogState = dialogState,
        buttons = {
            positiveButton("Сохранить", onClick = callback)
            negativeButton("Закрыть", onClick = callback)
        },
        onCloseRequest = {  }
    ) {
        datepicker { date ->
            inputDate(date)
        }
    }
    dialogState.show()

}