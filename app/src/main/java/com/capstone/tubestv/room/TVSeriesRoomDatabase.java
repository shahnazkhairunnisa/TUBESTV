package com.capstone.tubestv.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.capstone.tubestv.model.ResultsItem;

@Database(entities = {ResultsItem.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class TVSeriesRoomDatabase extends RoomDatabase {

    public abstract TVSeriesDao tvSeriesDao();
    private static TVSeriesRoomDatabase INSTANCE;

    public static TVSeriesRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TVSeriesRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TVSeriesRoomDatabase.class, "database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
