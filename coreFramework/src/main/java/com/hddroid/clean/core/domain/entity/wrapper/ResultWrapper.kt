package com.hddroid.clean.core.domain.entity.wrapper
import com.hddroid.clean.core.domain.entity.CustomException

sealed class ResultWrapper<out ResultData : Any, out Exception : CustomException> {
    data class Success<out ResultData : Any>(val data: ResultData) : ResultWrapper<ResultData, Nothing>()
    data class Failure<out Exception : CustomException>(val exception: Exception) : ResultWrapper<Nothing, Exception>()
}