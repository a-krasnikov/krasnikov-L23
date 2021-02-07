package krasnikov.project.gofapp.creational.factorymethod

fun main() {
    val remoteDataLoader: DataLoader = RemoteDataLoader()
    val localDataLoader: DataLoader = LocalDataLoader()

    println(remoteDataLoader.loadData())
    println(localDataLoader.loadData())
}

abstract class DataLoader {
    protected abstract fun createDataSource(): DataSource

    fun loadData(): String {
        val dataSource = createDataSource()
        return dataSource.loadData()
    }
}

class LocalDataLoader : DataLoader() {
    override fun createDataSource() = LocalDataSource()
}

class RemoteDataLoader : DataLoader() {
    override fun createDataSource() = RemoteDataSource()
}

interface DataSource {
    fun loadData(): String
}

class RemoteDataSource : DataSource {
    override fun loadData(): String = "Data from Remote"
}

class LocalDataSource : DataSource {
    override fun loadData(): String = "Data from Local"
}