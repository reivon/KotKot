package fr.reivon.kotkot

/**
 *
 * @author Tony MEMBOT
 * @since 16/04/2018
 */

fun main(args: Array<String>) {

    val egg = Ingredient("Oeuf", 4)
    val sel = Ingredient("Sel", measureUnit = "pinch")
    val butter = Ingredient("Beurre", 25, "g")

    val recipe = Recipe("Omelette", listOf(egg, sel), listOf("Battre les oeufs dans un bol", "Les faire cuire dans une poële"))
    val recipe2 = Recipe("Oeufs à la coque", listOf(egg, sel, butter), listOf("Faire fondre le beurre dans la poële", "Quand bien chaud, ajouter oeufs et remuer doucement"))

    println("I show the first recipe")

    tabbedPrint(recipe, 4)

    println("I show an addition of two list")

    tabbedPrint(recipe.ingredients + recipe2.ingredients, 4)

    println("I want to group my ingredient by name")

    tabbedPrint(listOf(recipe, recipe2).flatMap { it.ingredients }.groupBy({ it.name }, { it.quantity }), 4)

    println("I want a simple map with the sum their quantity to make my buying list (with hypothesis of same unit measure)")

    tabbedPrint(getMapOfMergedIngredientFromRecipe(recipe, recipe2), 4)

    println("I want a list of ingredient with their quantity summed to make my buying list (with hypothesis of same unit measure)")

    tabbedPrint(getListOfMergedIngredientFromRecipe(recipe, recipe2), 4)

    println("I want a list of ingredient with their quantity summed to make my buying list (with hypothesis of same unit measure)")

    tabbedPrint(getListOfMergedIngredientFromRecipePlus(recipe, recipe2), 4)

    println("I want a list of ingredient with their quantity summed to make my buying list (with hypothesis of same unit measure)")

    tabbedPrint(egg + 2, 4)
}

fun tabbedPrint(mess: Any, space: Int) = println("".padStart(space, ' ') + mess)

fun getListOfMergedIngredientFromRecipe(vararg recipes: Recipe): List<Ingredient> =
        recipes.flatMap { it.ingredients }
                .groupBy { it.name }
                .values.map {
            it.reduce { acc, item -> Ingredient(item.name, acc.quantity + item.quantity, item.measureUnit) }
        }

fun getListOfMergedIngredientFromRecipePlus(vararg recipes: Recipe): List<Ingredient> =
        recipes.flatMap { it.ingredients }
                .groupBy { it.name }
                .values.map {
            it.reduce { acc, item -> acc + item }
        }

fun getMapOfMergedIngredientFromRecipe(vararg recipes: Recipe): Map<String, Long> =
        recipes.flatMap { it.ingredients }
                .groupBy { it.name }
                .mapValues {
                    it.value.map { it.quantity }.sum()
                }