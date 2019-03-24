package com.lahzouz.addok.domain

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
data class Geometry(
        var coordinates: List<Double?>?,
        var type: String?
)