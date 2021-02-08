package krasnikov.project.gofapp.behavioral.strategy

fun main() {
    val repository = Repository()

    repository.loadData(LocalDataSource())
    repository.loadData(RemoteDataSource())
}

class Repository {

    fun loadData(dataSource: DataSource) {
        dataSource.loadData()
    }
}

interface DataSource {
    fun loadData()
}

class LocalDataSource : DataSource {
    override fun loadData() {
        println("load from local")
    }
}

class RemoteDataSource : DataSource {
    override fun loadData() {
        println("load from remote")
    }
}

