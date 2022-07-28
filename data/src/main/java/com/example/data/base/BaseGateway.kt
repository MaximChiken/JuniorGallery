package com.example.data.base

import com.example.domain.base.BaseEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface BaseGateway {

    /**
     * Функция, которая маппит модель Retrofit в сущность бизнес-логики
     * @param block Блок кода, в который мы прокидываем полученную модель
     * @return Объект типа Single
     */
    fun <R : BaseModel, E : BaseEntity> withMapper(
        mapper: BaseMapper<R, E>,
        block: () -> Single<R>
    ): Single<E> {
        return block().flatMap {
            Single.just(mapper.map(it))
        }
    }

    /**
     * Функция, которая маппит сущность в модель для Retrofit
     * @param entity Сущсность, которая будет маппиться
     * @param block Блок кода, в который мы прокидываем полученную модель
     */
    fun <R : BaseModel, E : BaseEntity> withMapper(
        mapper: BaseMapper<R, E>,
        entity: E,
        block: (R) -> Completable
    ): Completable {
        val retrofitModel = mapper.map(entity)
        return block(retrofitModel)
    }

    fun <R : BaseModel, E : BaseEntity> withListMapper(
        mapper: BaseMapper<R, E>,
        block: () -> Single<List<R>>
    ): Single<List<E>> {
        return block().flatMap {
            Single.just(it.map { item -> mapper.map(item) })
        }
    }
}