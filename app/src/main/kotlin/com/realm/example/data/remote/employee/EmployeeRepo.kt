package com.realm.example.data.remote.employee

import androidx.lifecycle.LiveData
import com.realm.example.extensions.asLiveData
import com.realm.example.data.remote.model.Employee
import com.realm.example.manager.RealmManager

class EmployeeRepo(private val realmManager: RealmManager) {

    fun createEmployee(model: Employee) {
        realmManager.add(model)
    }

    fun clearAll() {
        realmManager.clearAll<Employee>()
    }

    fun getEmployee(): LiveData<List<Employee>> {
        return realmManager.findAll<Employee>().asLiveData()
    }
}