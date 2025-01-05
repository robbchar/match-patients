package com.sb.match_patients

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HttpCatchAllController {

    @RequestMapping("/**/{[path:[^.]*}")
    fun getAnything(): String {
        return "forward:/"
    }
}