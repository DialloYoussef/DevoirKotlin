import retrofit2.Call
import retrofit2.http.GET

// Interface définissant les points d'entrée de l'API
interface ApiService {
    // Annotation GET indiquant que cette méthode effectue une requête GET vers l'endpoint "users"
    @GET("users")
    // La méthode retourne un objet de type Call<List<User>>
    // , indiquant que la requête renverra une liste d'objets User
    fun getUsers(): Call<List<User>>
}
