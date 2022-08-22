package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.RegistrationModel
import com.example.domain.entities.RegistrationResponseEntity
import javax.inject.Inject

class RegistrationResponseMapper @Inject constructor(): BaseMapper<RegistrationModel, RegistrationResponseEntity> {

    override fun map(entity: RegistrationResponseEntity): RegistrationModel {
        TODO("Not yet implemented")
    }

    override fun map(model: RegistrationModel): RegistrationResponseEntity =
        RegistrationResponseEntity(
            id = model.id,
            username = model.username ?: " ")
}