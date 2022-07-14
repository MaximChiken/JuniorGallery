package com.example.data.mappers

import com.example.data.models.RegistrationRequest
import com.example.domain.core.Mapper
import com.example.domain.entities.UserFullInfoEntity
import javax.inject.Inject

class UserDomainToRegistrationRequest @Inject constructor() : Mapper<UserFullInfoEntity, RegistrationRequest> {
    override fun map(model: UserFullInfoEntity): RegistrationRequest = with(model) {
        RegistrationRequest(
            email, birthday, userName, password
        )
    }
}