package com.example.domain.core

interface Mapper<I: Any, R: Any> {
    fun map(model: I): R
}