package exercises

import groovy.transform.*

@CompileStatic // Good -- enforces type
List<Integer> getNumbers() {
    [3, 1, 4, 1, 5, 9]
}

//@TypeChecked // Bad -- prevents conversion to List
List<String> getStrings() {
    'this is a list of strings'.split()
}

List<Integer> nums = this.numbers
nums << new Date()

strings