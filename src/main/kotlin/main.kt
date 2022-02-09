import com.github.ajalt.clikt.core.subcommands

fun main(args: Array<String>) = Pathy().subcommands(Print()).main(args) {
    println("Hello World!")
}
