package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.RegistrationRequestModel
import com.example.domain.entities.RegistrationRequestEntity
import javax.inject.Inject

class RegistrationRequestMapper @Inject constructor(): BaseMapper<RegistrationRequestModel, RegistrationRequestEntity> {

    override fun map(entity: RegistrationRequestEntity): RegistrationRequestModel = RegistrationRequestModel(
        email = entity.email,
        birthday = entity.birthday,
        userName = entity.userName,
        password = entity.password
    )

    override fun map(model: RegistrationRequestModel): RegistrationRequestEntity {
        TODO("Not yet implemented")
    }
}