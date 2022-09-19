package com.serosoft.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "todoapp")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todoId")
    @NotNull
    var todoId: Int,
    @ColumnInfo(name = "todoDescription")
    @NotNull
    var todoDescription: String
) : java.io.Serializable {}
