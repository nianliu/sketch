package ftp

import org.apache.commons.net.ftp.FTPClientConfig
import org.apache.commons.net.ftp.FTPSClient

fun main(args:Array<String>) {
    val client = FTPSClient(false)
    val config = FTPClientConfig()
    client.configure(config)
    client.connect("host")
    client.login("user name","password")
    client.execPBSZ(0) // set buffer size, for TLS, 0 is required, and must precede the PROT command.
    client.execPROT("P") // for an encrypted data-channel.
    client.enterLocalPassiveMode()

}