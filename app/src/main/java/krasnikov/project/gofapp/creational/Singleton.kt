package krasnikov.project.gofapp.creational

class DataSource private constructor() {

    companion object {
        val dataSource by lazy { DataSource() }
    }
}