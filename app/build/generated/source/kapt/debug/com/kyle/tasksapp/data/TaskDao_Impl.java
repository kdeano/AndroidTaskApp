package com.kyle.tasksapp.data;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TaskDao_Impl implements TaskDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Task> __insertionAdapterOfTask;

  private final EntityDeletionOrUpdateAdapter<Task> __deletionAdapterOfTask;

  private final EntityDeletionOrUpdateAdapter<Task> __updateAdapterOfTask;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCompleted;

  public TaskDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTask = new EntityInsertionAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `table_task` (`task`,`important`,`completed`,`timestamp`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        if (value.getTask() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTask());
        }
        final int _tmp;
        _tmp = value.getImportant() ? 1 : 0;
        stmt.bindLong(2, _tmp);
        final int _tmp_1;
        _tmp_1 = value.getCompleted() ? 1 : 0;
        stmt.bindLong(3, _tmp_1);
        stmt.bindLong(4, value.getTimestamp());
        stmt.bindLong(5, value.getId());
      }
    };
    this.__deletionAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `table_task` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `table_task` SET `task` = ?,`important` = ?,`completed` = ?,`timestamp` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        if (value.getTask() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTask());
        }
        final int _tmp;
        _tmp = value.getImportant() ? 1 : 0;
        stmt.bindLong(2, _tmp);
        final int _tmp_1;
        _tmp_1 = value.getCompleted() ? 1 : 0;
        stmt.bindLong(3, _tmp_1);
        stmt.bindLong(4, value.getTimestamp());
        stmt.bindLong(5, value.getId());
        stmt.bindLong(6, value.getId());
      }
    };
    this.__preparedStmtOfDeleteCompleted = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM table_task WHERE completed = 1";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Task task, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTask.insert(task);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object delete(final Task task, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTask.handle(task);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object update(final Task task, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTask.handle(task);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteCompleted(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCompleted.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteCompleted.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Flow<List<Task>> getTasksByName(final String searchQuery, final boolean hideCompleted) {
    final String _sql = "SELECT * FROM table_task WHERE (completed != ? OR completed = 0) AND task LIKE '%' || ? || '%' ORDER BY important DESC, task";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final int _tmp;
    _tmp = hideCompleted ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"table_task"}, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTask = CursorUtil.getColumnIndexOrThrow(_cursor, "task");
          final int _cursorIndexOfImportant = CursorUtil.getColumnIndexOrThrow(_cursor, "important");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            final String _tmpTask;
            _tmpTask = _cursor.getString(_cursorIndexOfTask);
            final boolean _tmpImportant;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfImportant);
            _tmpImportant = _tmp_1 != 0;
            final boolean _tmpCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_2 != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new Task(_tmpTask,_tmpImportant,_tmpCompleted,_tmpTimestamp,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Task>> getTasksByDate(final String searchQuery, final boolean hideCompleted) {
    final String _sql = "SELECT * FROM table_task WHERE (completed != ? OR completed = 0) AND task LIKE '%' || ? || '%' ORDER BY important DESC, timestamp";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final int _tmp;
    _tmp = hideCompleted ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"table_task"}, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTask = CursorUtil.getColumnIndexOrThrow(_cursor, "task");
          final int _cursorIndexOfImportant = CursorUtil.getColumnIndexOrThrow(_cursor, "important");
          final int _cursorIndexOfCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "completed");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            final String _tmpTask;
            _tmpTask = _cursor.getString(_cursorIndexOfTask);
            final boolean _tmpImportant;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfImportant);
            _tmpImportant = _tmp_1 != 0;
            final boolean _tmpCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfCompleted);
            _tmpCompleted = _tmp_2 != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new Task(_tmpTask,_tmpImportant,_tmpCompleted,_tmpTimestamp,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Task>> getTasks(final String query, final SortOrder sortOrder,
      final boolean hideCompleted) {
    return TaskDao.DefaultImpls.getTasks(TaskDao_Impl.this, query, sortOrder, hideCompleted);
  }
}
