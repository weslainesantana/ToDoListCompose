package br.edu.satc.todolistcompose

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import com.google.firebase.firestore.auth.User

@Entity
data class TaskData (
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "complete") val complete: String,

    )

@Dao
interface TaskDatadao {

    @Query("SELECT * FROM taskdata")
    fun getAll(): List<TaskData>

    @Update
    fun updateAll(vararg users: TaskData)

    @Insert
    fun insertAll(vararg users: TaskData)

    @Delete
    fun delete(user: TaskData)
}
    @Database(entities = [User::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun userDao(): TaskDatadao

}