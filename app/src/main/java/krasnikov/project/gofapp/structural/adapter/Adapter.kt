package krasnikov.project.gofapp.structural.adapter

fun main() {
    val text = BoldText()
    val image = TextAdapter(text)

    println(image.drawImage())
}

interface Text {
    fun printText(): String
}

class BoldText : Text {
    override fun printText(): String = "BoldText"
}

interface Image {
    fun drawImage(): String
}

class TextAdapter(private val text: Text) : Image {
    override fun drawImage(): String = "Image {${text.printText()}}"
}