package com.hungpham.network_support

class NetException(exceptionModel: ExceptionModel) :
    Throwable(message = exceptionModel.message)