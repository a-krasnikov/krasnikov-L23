package krasnikov.project.gofapp.structural.decorator

fun main() {
    val dataSource: DataSource = CompressionDecorator(LocalDataSource())

    dataSource.saveData("data")
}

interface DataSource {
    fun saveData(data: String)
}

class LocalDataSource() : DataSource {
    override fun saveData(data: String) {
        println(data)
    }
}

abstract class DataSourceDecorator(private val dataSource: DataSource) : DataSource {
    override fun saveData(data: String) {
        dataSource.saveData(data)
    }
}

class CompressionDecorator(dataSource: DataSource) : DataSourceDecorator(dataSource) {

    override fun saveData(data: String) {
        super.saveData(compress(data))
    }

    private fun compress(data: String): String = "$data compress"
}