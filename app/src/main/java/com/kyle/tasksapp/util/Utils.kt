package com.kyle.tasksapp.util

// Creates extension property to return same object of any type e.g. statement to expression
// Removes any compile uncertainty
val <T> T.exhaustive: T
    get() = this