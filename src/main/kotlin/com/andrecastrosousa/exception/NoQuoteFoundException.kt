package com.andrecastrosousa.exception

import com.andrecastrosousa.utils.Messages
import io.micronaut.http.HttpStatus

class NoQuoteFoundException(message: String? = Messages.NO_QUOTE_EXCEPTION_MESSAGE) : QuoteException(message, HttpStatus.NOT_FOUND)