package fr.reivon.kotkot

class Recipe(var name: String, var ingredients: List<Ingredient>, var steps: List<String>)
data class Ingredient(var name: String, var quantity: Long = 1, var measureUnit: String = "")

operator fun Ingredient.plus(ingredient2: Ingredient): Ingredient =
        Ingredient(this.name, this.quantity + ingredient2.quantity, this.measureUnit)

operator fun Ingredient.plus(nb: Int): Ingredient =
        this.copy(quantity = this.quantity + nb)