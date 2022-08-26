package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.RegistrationModel
import com.example.domain.entities.RegistrationResponseEntity
import javax.inject.Inject

class RegistrationResponseMapper @Inject constructor() : BaseMapper<RegistrationModel, RegistrationResponseEntity> {

    override fun map(entity: RegistrationResponseEntity): RegistrationModel  = RegistrationModel(
        email = entity.email,
        birthday = entity.birthday,
        username = entity.username,
        id = entity.id
    )


    override fun map(model: RegistrationModel): RegistrationResponseEntity =
        RegistrationResponseEntity(
            id = model.id,
            username = model.username ?: " ",
            email = model.email ?: " ",
            birthday = model.birthday?.let { reverseDate(it.substring(0, 10)) } ?: " ")

    private fun reverseDate(date: String): String {
        val splitDate = date.split("-")
        return splitDate[2] + "." + splitDate[1] + "." + splitDate[0]
    }
}