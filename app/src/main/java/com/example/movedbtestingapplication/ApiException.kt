package com.example.movedbtestingapplication

import java.io.IOException

class ApiException(s: String, cause : Throwable? = null) : IOException(s,cause) {

}
