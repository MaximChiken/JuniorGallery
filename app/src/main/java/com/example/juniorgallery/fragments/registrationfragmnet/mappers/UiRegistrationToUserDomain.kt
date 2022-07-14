package com.example.juniorgallery.fragments.registrationfragmnet.mappers

import com.example.domain.core.Mapper
import com.example.domain.entities.UserFullInfoEntity
import com.example.juniorgallery.fragments.registrationfragmnet.models.UiRegistration
import javax.inject.Inject

class UiRegistrationToUserDomain @Inject constructor() : Mapper<UiRegistration, UserFullInfoEntity> {
    override fun map(model: UiRegistration): UserFullInfoEntity = with(model) {
        UserFullInfoEntity(
            email, birthday, userName, password
        )
    }
}