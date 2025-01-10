import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment_3.User
import com.example.assignment_3.data.database.AppDatabase
import com.example.assignment_3.data.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepository: UserRepository
    val allUsers: LiveData<List<User>>

    init {
        val userDao = AppDatabase.getDatabase(application).userDao()
        userRepository = UserRepository(userDao)
        allUsers = userRepository.allUsers
    }
    fun insert(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }
    fun update(user: User) {
        viewModelScope.launch {
            userRepository.update(user)
        }
    }
    fun delete(user: User) {
        viewModelScope.launch {
            userRepository.delete(user)
        }
    }
}
