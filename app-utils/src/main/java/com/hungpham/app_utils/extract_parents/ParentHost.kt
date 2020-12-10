package com.hungpham.app_utils.extract_parents

import kotlin.reflect.KClass


interface ParentHost {

    fun <T : Any> extractParent(cls: KClass<T>): T?
}