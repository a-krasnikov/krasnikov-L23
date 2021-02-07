package krasnikov.project.gofapp.creational.singleton

class DataSource private constructor() {

    companion object {
        val dataSource by lazy { DataSource() }
    }
}