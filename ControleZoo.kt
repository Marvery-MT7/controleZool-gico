import java.util.*

// Enum para o tipo de gaiola
enum class TipoGaiola {
    SAVANA,
    AQUARIO,
    FLORESTA,
    OUTRO
}

// Classe Animal
class Animal(
    val apelido: String,
    val origem: String,
    val dieta: String,
    val tipoGaiola: TipoGaiola,
    val localizacao: String
) {
    override fun toString(): String {
        return "Apelido: $apelido\n" +
                "Origem: $origem\n" +
                "Dieta: $dieta\n" +
                "Tipo de Gaiola: $tipoGaiola\n" +
                "Localização na Sela: $localizacao"
    }
}

// Classe Zoológico para gerenciar os animais
class Zoologico {
    private val animais: MutableList<Animal> = mutableListOf()

    // Método para adicionar um animal ao zoológico
    fun adicionarAnimal(animal: Animal) {
        animais.add(animal)
    }

    // Método para listar todos os animais no zoológico
    fun listarAnimais() {
        println("Animais no Zoológico:")
        for (animal in animais) {
            println(animal)
            println()
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val zoo = Zoologico()

    // Exemplo de cadastro de animais
    val leao = Animal("Leão", "África", "Carnívoro", TipoGaiola.SAVANA, "Sela 1")
    val tigre = Animal("Tigre", "Ásia", "Carnívoro", TipoGaiola.SAVANA, "Sela 2")
    val golfinho = Animal("Golfinho", "Oceano", "Peixe", TipoGaiola.AQUARIO, "Aquário Principal")

    // Adicionando animais ao zoológico
    zoo.adicionarAnimal(leao)
    zoo.adicionarAnimal(tigre)
    zoo.adicionarAnimal(golfinho)

    var opcao: Int

    do {
        println("\nSelecione uma opção:")
        println("1 - Cadastrar novo animal")
        println("2 - Listar animais cadastrados")
        println("0 - Sair")
        print("Opção: ")

        opcao = scanner.nextInt()

        when (opcao) {
            1 -> {
                println("\nCadastro de Novo Animal:")
                print("Apelido: ")
                val apelido = scanner.next()
                print("Origem: ")
                val origem = scanner.next()
                print("Dieta: ")
                val dieta = scanner.next()
                print("Tipo de Gaiola (SAVANA, AQUARIO, FLORESTA, OUTRO): ")
                val tipoGaiola = scanner.next().uppercase()
                print("Localização na Sela: ")
                val localizacao = scanner.next()

                val novoAnimal = Animal(apelido, origem, dieta, TipoGaiola.valueOf(tipoGaiola), localizacao)
                zoo.adicionarAnimal(novoAnimal)
                println("Novo animal cadastrado com sucesso!")
            }
            2 -> {
                zoo.listarAnimais()
            }
            0 -> println("Saindo...")
            else -> println("Opção inválida!")
        }
    } while (opcao != 0)
}
