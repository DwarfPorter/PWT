package ru.marslab.pocketwordtranslator.presentation.viewmodels

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import ru.marslab.pocketwordtranslator.domain.model.Translations
import ru.marslab.pocketwordtranslator.presentation.model.AppAction
import ru.marslab.pocketwordtranslator.presentation.model.AppViewState

interface TranslationViewModel {
    val translationsState: StateFlow<AppViewState>
    val searchWordDialogAction: SharedFlow<AppAction>

    fun getTranslations(word: String)
    fun showSearchDialog()
}