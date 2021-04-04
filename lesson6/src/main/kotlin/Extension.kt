fun Long.findFiniteInverse(z: Long): Long {
    if (z <= 0) {
        throw Exception("Modulo should be positive.")
    }
    if (NT().gcd(this, z) != 1L)
        throw Exception("There is no inverse for $this in Z/${z}Z Ring.")
    val x = this
    for (i in 0 until z) {
        if ((x * i) % z == 1L) {
            return i
        }
    }
    return 1
}