import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

fun main() {
    // Créer une instance de Retrofit pour effectuer des requêtes HTTP
    val retrofit = Retrofit.Builder()
        .baseUrl("https://655938ffe93ca47020aa258e.mockapi.io/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    // Créer une instance de l'interface ApiService pour définir les points d'entrée de l'API
    val apiService = retrofit.create(ApiService::class.java)

    // Effectuer la requête pour obtenir la liste des utilisateurs
    val response = apiService.getUsers().execute()

    // Vérifier si la requête a réussi
    if (response.isSuccessful) {
        // Afficher les utilisateurs dans la console
        response.body().forEachIndexed { index, user ->
            println("User : ${index + 1} | name : ${user.name} | email : ${user.email} | password : ${user.password}")
        }
        println("Youpiiiii!!!!!!!!")
    } else {
        println("Erreur lors de la récupération des utilisateurs: ${response.code()}")
    }
}
