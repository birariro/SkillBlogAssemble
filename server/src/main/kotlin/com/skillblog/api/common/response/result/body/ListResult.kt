package com.skillblog.api.common.response.result.body

class ListResult<T>(
        val list:List<T>
) : CommonResult()
