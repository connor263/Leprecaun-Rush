package com.starmakerinteractive.starmak.utils.web


fun String.comstarmakerinteractivestarmak(encrypt: Boolean = false): String {
    val llmhnbv = StringBuilder()
    val fadsff = "comstarmakerinteractivestarmak"
    var dsfabah = 0

    this.forEach {
        if (it !in 'a'..'z') {
            llmhnbv.append(it)
            return@forEach
        }
        val wlfgflga = if (encrypt) {
            (it.code + fadsff[dsfabah].code - 90) % 26
        } else {
            (it.code - fadsff[dsfabah].code + 26) % 26
        }
        dsfabah++
        if (dsfabah > fadsff.length - 1) dsfabah = 0
        llmhnbv.append(wlfgflga.plus(97).toChar())
    }
    return llmhnbv.toString()
}