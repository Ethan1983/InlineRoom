package com.sample.inlineroom

import androidx.room.*

inline class Age( val age : Int )

@Entity
data class Person ( val age : Age )

@Dao
interface PersonDao {

    @Insert
    fun insert( person : Person )

}

@Database( entities = [Person::class], version = 1, exportSchema = false )
abstract class AppDatabase : RoomDatabase() {

    abstract fun personDao() : PersonDao
}
