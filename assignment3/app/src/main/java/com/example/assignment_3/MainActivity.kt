package com.example.assignment_3

import UserViewModel
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private lateinit var userNameInput: EditText
    private lateinit var userEmailInput: EditText
    private lateinit var addUserButton: Button
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        userNameInput = findViewById(R.id.userNameInput)
        userEmailInput = findViewById(R.id.userEmailInput)
        addUserButton = findViewById(R.id.addUserButton)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe changes to the user list
        userViewModel.userList.observe(this, { users ->
            userAdapter = UserAdapter(users)
            recyclerView.adapter = userAdapter
        })

        // Observe changes to the name and email input fields
        userViewModel.name.observe(this, { name ->
            userNameInput.setText(name)
        })
        userViewModel.email.observe(this, { email ->
            userEmailInput.setText(email)
        })

        // Update name when the user types into the name input field
        userNameInput.addTextChangedListener {
            userViewModel.updateName(it.toString())
        }

        // Update email when the user types into the email input field
        userEmailInput.addTextChangedListener {
            userViewModel.updateEmail(it.toString())
        }

        // Add a new user when the "Add User" button is clicked
        addUserButton.setOnClickListener {
            val name = userNameInput.text.toString()
            val email = userEmailInput.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty()) {
                val newUser = User(name, email)
                userViewModel.addUser(newUser)

                // Clear the input fields after adding the user
                userNameInput.text.clear()
                userEmailInput.text.clear()

                Toast.makeText(this, "User Added: $name", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter both name and email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

