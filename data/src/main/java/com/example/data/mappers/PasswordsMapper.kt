package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.PasswordsModel
import com.example.domain.entities.PasswordsEntity

class PasswordsMapper:BaseMapper<PasswordsModel, PasswordsEntity> {

    override fun map(entity: PasswordsEntity) = PasswordsModel(
        newPassword = entity.newPassword,
        oldPassword = entity.oldPassword
    )

    override fun map(model: PasswordsModel): PasswordsEntity {
        TODO("Not yet implemented")
    }
}