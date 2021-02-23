class Warrior(override val power: Int=20, override val healthCapacity: Int=100, override val regenSpeed: Int=10) : MeleeUnit {
    override var health: Int=healthCapacity
        private set


    fun attack(other: Warrior) {
        other.health -= power
        println("Omae wa mou shindeiru!")
    }

    override fun heal() {
        println("health : ${health}")
        while (health < healthCapacity) {
            health += regenSpeed
            println("health : ${health}")
        }
        if (health > healthCapacity)
            health = healthCapacity
        println("Ready to fight again!")
    }
}