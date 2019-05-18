package com.example.todolist.DTO

import java.util.ArrayList

//6:29 https://www.youtube.com/watch?v=kdQrElD6ak4&t=749s

class ToDo {

    var Id: Long = -1
    var name = ""
    var createdAt = ""
    var items: MutableList<ToDoItem> = ArrayList()
}