interface Layer {
    val name: String
}

data class Linear(override val name: String = "Linear") : Layer

data class Conv2D(
    override  val name: String = "Convolution",
    val in_channels: Int,
    val out_channels:Int
): Layer

data class BatchNorm2D(override val name: String = "BN", val channels: Int) : Layer

data class ReLU(override val name: String = "ReLU") : Layer


class Model() {
    var name: String = "model"
    val layers = mutableListOf<Layer>()

    fun build(block: Model.() -> Unit): Model {
        val model = Model()
        model.block()
        return model
    }
}