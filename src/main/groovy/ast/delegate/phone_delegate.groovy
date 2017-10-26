package ast.delegate

class Phone {
    String vendor = 'Samsung'
    String dial(String number) { "dialing $number" }
}

class Camera {
    String vendor = 'Nikon'
    String takePicture() { "taking picture" }
}

class SmartPhone {
    @Delegate Phone phone = new Phone()
    @Delegate Camera camera = new Camera()

    String getVendor() {
        "Phone: ${phone.vendor}, Camera: ${camera.vendor}"
    }
}

SmartPhone sp = new SmartPhone()
assert sp.dial('555-1234') == 'dialing 555-1234'
assert sp.takePicture() == 'taking picture'
println sp.vendor