class Castle(override val healthCapacity: Int=200, override val regenSpeed: Int=20,
             override val armorCapacity: Int=100
) : Building {
    override var health: Int=healthCapacity
        private set
    override var armor: Int=armorCapacity
        private set

    override fun heal() {
        while (armor < armorCapacity)
            armor += regenSpeed
        if (armor > armorCapacity)
            armor = armorCapacity

        while (health < healthCapacity)
            health += regenSpeed
        if (health > healthCapacity)
            health = healthCapacity
        println("We will not surrender!")
    }
}