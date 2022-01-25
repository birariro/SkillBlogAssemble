package com.skillblog.api.common.response.result.body

class SetResult<T>(
        val set:Set<T>
): CommonResult()
