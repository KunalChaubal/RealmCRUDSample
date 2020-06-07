import com.realm.example.data.remote.employee.EmployeeRepo
import com.realm.example.manager.RealmManager
import org.koin.dsl.module

val employeeModule = module {
    single { EmployeeRepo(get()) }
    single { RealmManager() }
}