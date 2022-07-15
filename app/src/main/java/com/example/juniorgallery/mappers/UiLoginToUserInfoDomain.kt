package com.example.juniorgallery.mappers

import com.example.domain.core.Mapper
import com.example.domain.entities.UserInfoEntity
import com.example.juniorgallery.models.UiLogin
import javax.inject.Inject

class UiLoginToUserInfoDomain @Inject constructor() : Mapper<UiLogin, UserInfoEntity> {
    override fun map(model: UiLogin): UserInfoEntity = with(model) {
        UserInfoEntity(
            username, password
        )
    }
}