import cli.Path
import cli.Pathy
import cli.Print
import com.github.ajalt.clikt.core.subcommands

fun main(args: Array<String>) = Pathy()
    .subcommands(Print(), Path())
    .main(args)

