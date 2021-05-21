package com.hddroid.clean.data

import com.hddroid.clean.domain.Constants
import com.hddroid.clean.domain.repository.TranslationsRepository

class MainTranslationService:
    TranslationsRepository {
    override suspend fun fetchTranslations(): Map<String, String> {
        val translations = mutableMapOf<String, String>()
        translations[Constants.Error.Header().DATA_FETCH_ERROR] = "Oops!"
        translations[Constants.Error.Title().DATA_FETCH_ERROR] = "Something went wrong"
        translations[Constants.Error.Message().DATA_FETCH_ERROR] = "Please retry"
        return translations
    }
}