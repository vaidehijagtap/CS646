package com.pprior.quizz.data.constants

import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface
import java.util.Collections

val host = getLocalIpAddress()

fun getLocalIpAddress(): String? {
    return try {
        getLocalIpFromNetworkInterfaces()
    } catch (ex: Exception) {
        ex.printStackTrace()
        null
    }
}

private fun getLocalIpFromNetworkInterfaces(): String? {
    val interfaces = Collections.list(NetworkInterface.getNetworkInterfaces())

    for (i in interfaces) {
        val addresses = Collections.list(i.inetAddresses)


        for (address in addresses) {
            if (address.isNonLoopbackIPv4Address()) {
                return address.hostAddress
            }
        }
    }

    return null
}

private fun InetAddress.isNonLoopbackIPv4Address() = !isLoopbackAddress && this is Inet4Address