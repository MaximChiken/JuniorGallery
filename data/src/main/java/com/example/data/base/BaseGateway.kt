package com.example.data.base

import com.example.domain.base.BaseEntity
import io.reactivex.rxjava3.core.Single

interface BaseGateway {

    fun <R : BaseModel, E : BaseEntity> withMapper(
        mapper: BaseMapper<R, E>,
        block: () -> Single<R>,
    ): Single<E> {
        return block().flatMap {
            Single.just(mapper.map(it))
        }
    }
}
