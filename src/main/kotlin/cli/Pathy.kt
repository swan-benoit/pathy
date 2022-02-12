package cli

import com.github.ajalt.clikt.core.CliktCommand

class Pathy: CliktCommand() {

    override fun run() = Unit

    fun main(args: Array<String>, function: () -> Unit) {
        super.main(args)
    }

}
