package edu.mnscu

import org.apache.commons.math3.complex.Complex;

Complex.metaClass.plus = { Complex addend -> delegate.add(addend) }

Complex c1 = new Complex(1.0d, 2.0d)
Complex c2 = new Complex(3.0d, 4.0d)
println c1.add(c2)
assert c1 + c2 == c1.add(c2)
println c1 * c2