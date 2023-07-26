package com.example.app.api.constant

import java.net.URI

class UriList {
    companion object {
        const val V1 = "/v1"
        const val COMPANIES = "/companies"
        const val COMPANIES_ENDPOINT = "$V1$COMPANIES"
        val COMPANY_URI = URI.create(COMPANIES_ENDPOINT)
    }
}