package com.example.data.mappers

import com.example.data.models.RegistrationResponse
import com.example.domain.core.Mapper
import com.example.domain.entities.UserIdEntity
import javax.inject.Inject

class UserIdDomainToRegistrationResponse @Inject constructor() : Mapper<UserIdEntity, RegistrationResponse> {
    override fun map(model: UserIdEntity): RegistrationResponse = with(model) {
        RegistrationResponse(id)
    }

}