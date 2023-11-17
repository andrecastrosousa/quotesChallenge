package com.andrecastrosousa.exception

import com.andrecastrosousa.utils.Messages
import io.micronaut.http.HttpStatus

class AuthorRequiredException(message: String? = Messages.AUTHOR_REQUIRED_EXCEPTION_MESSAGE) :
    QuoteException(message, HttpStatus.BAD_REQUEST)