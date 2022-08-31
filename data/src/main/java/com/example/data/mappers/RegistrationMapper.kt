package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.RegistrationModel
import com.example.domain.entities.RegistrationEntity
import javax.inject.Inject

class RegistrationMapper @Inject constructor(): BaseMapper<RegistrationModel, RegistrationEntity> {

    override fun map(entity: RegistrationEntity): RegistrationModel = RegistrationModel(
        email = entity.email,
        birthday = entity.birthday,
        userName = entity.userName,
        password = entity.password
    )

    override fun map(model: RegistrationModel): RegistrationEntity {
        TODO("Not yet implemented")
    }
}