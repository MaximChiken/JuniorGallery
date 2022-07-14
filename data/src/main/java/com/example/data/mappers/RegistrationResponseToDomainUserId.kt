package com.example.data.mappers

import com.example.data.models.RegistrationResponse
import com.example.domain.core.Mapper
import com.example.domain.entities.UserFullInfoEntity
import com.example.domain.entities.UserIdEntity
import javax.inject.Inject

class RegistrationResponseToDomainUserId @Inject constructor() : Mapper<RegistrationResponse, UserIdEntity> {
    override fun map(model: RegistrationResponse): UserIdEntity = with(model) {
        UserIdEntity(id)
    }
}