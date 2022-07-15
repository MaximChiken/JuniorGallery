package com.example.juniorgallery.mappers

import com.example.domain.core.Mapper
import com.example.domain.entities.UserFullInfoEntity
import com.example.juniorgallery.models.UiRegistration
import javax.inject.Inject

class UiRegistrationToUserFullInfoDomain @Inject constructor() : Mapper<UiRegistration, UserFullInfoEntity> {
    override fun map(model: UiRegistration): UserFullInfoEntity = with(model) {
        UserFullInfoEntity(
            email, birthday, userName, password
        )
    }
}