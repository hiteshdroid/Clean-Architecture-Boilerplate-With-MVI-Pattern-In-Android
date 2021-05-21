package com.hddroid.clean.domain.repository

import com.hddroid.clean.core.domain.repository.BaseRepository

interface TranslationsRepository: BaseRepository {
    suspend fun fetchTranslations(): Map<String, String>
}
