package com.example.lesson9

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class ResourceNotFoundException : ResponseStatusException(HttpStatus.NOT_FOUND)