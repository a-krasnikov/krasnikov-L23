package krasnikov.project.gofapp.creational.factory

fun main() {
    val localDataSource = LocalDataSourceFactory().createDataSource()
    val remoteDataSource = RemoteDataSourceFactory().createDataSource()

    localDataSource.loadData()
    remoteDataSource.loadData()
}

interface DataSource {
    fun loadData(): String
}

class RemoteDataSource(val dbName: String) : DataSource {
    override fun loadData(): String = "Data from Remote"
}

class LocalDataSource(val url: String) : DataSource {
    override fun loadData(): String = "Data from Local"
}

interface DataSourceFactory {
    fun createDataSource(): DataSource
}

class RemoteDataSourceFactory() : DataSourceFactory {
    override fun createDataSource(): DataSource = RemoteDataSource("db")

}

class LocalDataSourceFactory() : DataSourceFactory {
    override fun createDataSource(): DataSource = LocalDataSource("url")
}