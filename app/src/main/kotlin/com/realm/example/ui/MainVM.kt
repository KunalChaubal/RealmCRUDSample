package com.realm.example.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.realm.example.data.remote.employee.EmployeeRepo
import com.realm.example.data.remote.model.Employee
import com.realm.example.livedata.AbsentLiveData

class MainVM(private val employeeRepo: EmployeeRepo) : ViewModel() {

    fun addUpdateEmployee(id: String, name: String, location: String): LiveData<String> {
        if (id.isNotEmpty() && name.isNotEmpty() && location.isNotEmpty()) {
            val employee = Employee(id.toInt(), name, location)
            employeeRepo.createEmployee(employee)
            return Transformations.map(getEmployeeData()) {
                it
            }
        }
        return AbsentLiveData.create()
    }

    fun clearAll(): LiveData<String> {
        employeeRepo.clearAll()
        return Transformations.map(getEmployeeData()) {
            it
        }

    }

    fun getEmployeeData(): LiveData<String> {
        return Transformations.map(employeeRepo.getEmployee()) {
            formatEmployeeData(it)
        }
    }

    private fun formatEmployeeData(list: List<Employee>): String {
        var response = ""
        list.forEach {
            response += "${it.id} -- ${it.name} -- ${it.location}\n"
        }
        return response
    }
}