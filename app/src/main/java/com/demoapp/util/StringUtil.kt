package com.demoapp.util

class StringUtil {

    companion object {

        fun isEmpty(str: String?): Boolean {
            return str == null || str.trim { it <= ' ' } == ""
        }
    }
}