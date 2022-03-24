package com.kyle.tasksapp.util

import androidx.appcompat.widget.SearchView

// Contains extension functions for different views (allows for future changes/upgrades easily)
// Only needed in one area currently

// Using inline makes the code more efficient
// Kotlin does not generate a separate object - copies it directly here instead (src: Kotlin doc)
inline fun SearchView.onTextChanged(crossinline listener: (String) -> Unit) {
    // Pass an anon object - anon class that implements the interface
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

        // This function is not needed so it just returns true
        // Not listened to since it does not update until users submits text
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }

        // When text is changed, the listener updates immediately
        // Displays new results for each text change
        override fun onQueryTextChange(newText: String?): Boolean {
            listener(newText.orEmpty())
            return true
        }
    })
}