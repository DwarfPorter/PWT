package ru.marslab.pocketwordtranslator.domain.interactor

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.marslab.pocketwordtranslator.data.room.MainDatabase
import ru.marslab.pocketwordtranslator.data.toDomain
import ru.marslab.pocketwordtranslator.domain.model.HistoryWord

class HistoryInteractorImpl(
    database: MainDatabase
) : HistoryInteractor {
    private val historyDao = database.historyDao()

    override suspend fun loadHistory(): Observable<HistoryWord> =
        historyDao.getHistory()
            .flattenAsObservable {
                it.map { item ->
                    item.toDomain()
                }
            }
            .subscribeOn(Schedulers.io())
}