package krasnikov.project.gofapp.behavioral.observer

fun main() {
    val observableInt = Observable(0)

    val observer = { value: Int ->
        println("new value $value")
    }
    observableInt.observe(observer)

    observableInt.updateValue(3)

    println(observableInt.hasObservers)
    observableInt.removeObserver(observer)
    println(observableInt.hasObservers)
}

class Observable<T>(private var value: T) {

    private val observers = mutableListOf<Observer<T>>()

    val hasObservers
        get() = observers.isNotEmpty()

    fun observe(observer: Observer<T>) {
        observers.add(observer)
    }

    fun updateValue(value: T) {
        this.value = value

        if (hasObservers) {
            observers.forEach { it.onChanged(value) }
        }
    }

    fun removeObserver(observer: Observer<T>) {
        observers.remove(observer)
    }

    fun interface Observer<T> {
        fun onChanged(value: T)
    }
}