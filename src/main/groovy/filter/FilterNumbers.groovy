package filter

class FilterNumbers {
    Collection<Number> findPositives(Number... numbers) {
        numbers.findAll { it > 0 }
    }
}
