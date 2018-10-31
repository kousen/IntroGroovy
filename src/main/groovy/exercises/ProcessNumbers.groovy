package exercises

class ProcessNumbers {
    static List<Number> positives(Number... args) {
        args.findAll { it > 0 }
    }
}
