package com.lahzouz.addok.domain

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
data class Feature(
        var geometry: Geometry?,
        var properties: Properties?,
        var type: String?
)