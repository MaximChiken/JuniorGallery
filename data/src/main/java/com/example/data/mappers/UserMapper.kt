package com.example.data.mappers

import com.example.data.base.BaseMapper
import com.example.data.models.UserModel
import com.example.domain.entities.UserEntity
import javax.inject.Inject

class UserMapper @Inject constructor() : BaseMapper<UserModel, UserEntity> {

    override fun map(entity: UserEntity): UserModel  = UserModel(
        email = entity.email,
        birthday = entity.birthday ?: "00/00/0001",
        username = entity.username,
        id = entity.id.toInt()
    )


    override fun map(model: UserModel): UserEntity =
        UserEntity(
            id = model.id.toString(),
            username = model.username ?: " ",
            email = model.email ?: " ",
            birthday = model.birthday?.let { reverseDate(it.substring(0, 10)) } ?: " ")

    private fun reverseDate(date: String): String {
        val splitDate = date.split("-")
        return splitDate[2] + "." + splitDate[1] + "." + splitDate[0]
    }
}