package com.lahzouz.addok.domain

import io.quarkus.runtime.annotations.RegisterForReflection

@RegisterForReflection
data class Addok(
        var attribution: String?,
        var features: List<Feature?>?,
        var licence: String?,
        var query: String?,
        var type: String?,
        var version: String?)

