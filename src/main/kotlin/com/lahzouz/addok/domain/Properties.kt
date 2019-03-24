package com.lahzouz.addok.domain

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
data class Properties(
        var city: String?,
        var context: String?,
        var housenumber: String?,
        var id: String?,
        var label: String?,
        var name: String?,
        var postcode: String?,
        var score: Double?,
        var type: String?
)