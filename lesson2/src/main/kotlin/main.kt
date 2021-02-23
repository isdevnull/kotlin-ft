fun main() {
    var strongestWarrior = Warrior(power=50)
    var x = Warrior(healthCapacity = 200)
    var y = Warrior(healthCapacity = 300, power = 20)
    val arena = listOf(x, y)
    arena.forEach { it -> strongestWarrior.attack(it) }

    var z = Castle()
    val units = listOf(x, y, z)
    units.forEach { it -> it.heal() }
}