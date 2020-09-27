package com.yzp.mvvmlibrary.app

import androidx.lifecycle.ViewModelProvider
import com.yzp.mvvmlibrary.base.ViewModelFactory

/**
 *   @auther : Aleyn
 *   time   : 2019/11/12
 */
class GlobalConfig {
    var viewModelFactory: ViewModelProvider.NewInstanceFactory = ViewModelFactory()
}