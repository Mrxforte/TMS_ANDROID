package com.example.tms_android.Lessons.Lesson22.Task3

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel : ViewModel() {
    private val _formState = MutableLiveData<String>("")
    val formState: LiveData<String> = _formState

    private val _nameError = MutableLiveData<String?>()
    val nameError: LiveData<String?> = _nameError

    private val _emailError = MutableLiveData<String?>()
    val emailError: LiveData<String?> = _emailError

    private val _passwordError = MutableLiveData<String?>()
    val passwordError: LiveData<String?> = _passwordError

    private val _isFormValid = MutableLiveData<Boolean>(false)
    val isFormValid: LiveData<Boolean> = _isFormValid

    private var nameIsValid = false
    private var emailIsValid = false
    private var passwordIsValid = false

    fun validateName(name: String) {
        nameIsValid = name.isNotEmpty()
        if (name.isEmpty()) {
            _nameError.value = "Name cannot be empty"
        } else {
            _nameError.value = null
        }
        checkOverallValidation()
    }

    fun validateEmail(email: String) {
        emailIsValid = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if (email.isEmpty()) {
            _emailError.value = "Email cannot be empty"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailError.value = "Invalid email format"
        } else {
            _emailError.value = null
        }
        checkOverallValidation()
    }

    fun validatePassword(password: String) {
        passwordIsValid = password.isNotEmpty() && password.length >= 6
        if (password.isEmpty()) {
            _passwordError.value = "Password cannot be empty"
        } else if (password.length < 6) {
            _passwordError.value = "Password must be at least 6 characters"
        } else {
            _passwordError.value = null
        }
        checkOverallValidation()
    }

    private fun checkOverallValidation() {
        _isFormValid.value = nameIsValid && emailIsValid && passwordIsValid
    }

    fun formValidation(name: String, email: String, password: String): Boolean {
        validateName(name)
        validateEmail(email)
        validatePassword(password)

        val isValid = _nameError.value == null &&
                _emailError.value == null &&
                _passwordError.value == null

        if (isValid) {
            _formState.value = "Success"
        } else {
            _formState.value = "Error"
        }
        return isValid
    }

    fun clearState() {
        _formState.value = ""
    }
}


