package androidx.media3.exoplayer.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.a1;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.exoplayer.offline.DownloadRequest;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class a implements t {

    /* renamed from: f, reason: collision with root package name */
    private static final String f12484f = p(3, 4);

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f12485g = {"id", "mime_type", "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded", "key_set_id"};

    /* renamed from: a, reason: collision with root package name */
    private final String f12486a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12487b;

    /* renamed from: c, reason: collision with root package name */
    private final v1.a f12488c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f12489d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f12490e;

    /* loaded from: classes2.dex */
    private static final class b implements e {

        /* renamed from: a, reason: collision with root package name */
        private final Cursor f12491a;

        private b(Cursor cursor) {
            this.f12491a = cursor;
        }

        @Override // androidx.media3.exoplayer.offline.e
        public c N() {
            return a.n(this.f12491a);
        }

        @Override // androidx.media3.exoplayer.offline.e, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f12491a.close();
        }

        @Override // androidx.media3.exoplayer.offline.e
        public int getPosition() {
            return this.f12491a.getPosition();
        }

        @Override // androidx.media3.exoplayer.offline.e
        public /* synthetic */ boolean moveToNext() {
            return d.a(this);
        }

        @Override // androidx.media3.exoplayer.offline.e
        public boolean moveToPosition(int i11) {
            return this.f12491a.moveToPosition(i11);
        }
    }

    public a(v1.a aVar) {
        this(aVar, "");
    }

    public a(v1.a aVar, String str) {
        this.f12486a = str;
        this.f12488c = aVar;
        this.f12487b = "ExoPlayerDownloads" + str;
        this.f12489d = new Object();
    }

    private static List j(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String str2 : a1.o1(str, ",")) {
            String[] o12 = a1.o1(str2, "\\.");
            androidx.media3.common.util.a.g(o12.length == 3);
            arrayList.add(new StreamKey(Integer.parseInt(o12[0]), Integer.parseInt(o12[1]), Integer.parseInt(o12[2])));
        }
        return arrayList;
    }

    static String k(List list) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            StreamKey streamKey = (StreamKey) list.get(i11);
            sb2.append(streamKey.periodIndex);
            sb2.append('.');
            sb2.append(streamKey.groupIndex);
            sb2.append('.');
            sb2.append(streamKey.streamIndex);
            sb2.append(',');
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    private void l() {
        synchronized (this.f12489d) {
            if (this.f12490e) {
                return;
            }
            try {
                int b11 = v1.c.b(this.f12488c.getReadableDatabase(), 0, this.f12486a);
                if (b11 != 3) {
                    SQLiteDatabase writableDatabase = this.f12488c.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        v1.c.d(writableDatabase, 0, this.f12486a, 3);
                        List r11 = b11 == 2 ? r(writableDatabase) : new ArrayList();
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.f12487b);
                        writableDatabase.execSQL("CREATE TABLE " + this.f12487b + " (id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)");
                        Iterator it = r11.iterator();
                        while (it.hasNext()) {
                            s((c) it.next(), writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th2) {
                        writableDatabase.endTransaction();
                        throw th2;
                    }
                }
                this.f12490e = true;
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }
    }

    private Cursor m(String str, String[] strArr) {
        try {
            return this.f12488c.getReadableDatabase().query(this.f12487b, f12485g, str, strArr, null, null, "start_time_ms ASC");
        } catch (SQLiteException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c n(Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        DownloadRequest.b f11 = new DownloadRequest.b((String) androidx.media3.common.util.a.e(cursor.getString(0)), Uri.parse((String) androidx.media3.common.util.a.e(cursor.getString(2)))).e(cursor.getString(1)).f(j(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        DownloadRequest a11 = f11.d(blob).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        l lVar = new l();
        lVar.f12506a = cursor.getLong(13);
        lVar.f12507b = cursor.getFloat(12);
        int i11 = cursor.getInt(6);
        return new c(a11, i11, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i11 == 4 ? cursor.getInt(11) : 0, lVar);
    }

    private static c o(Cursor cursor) {
        DownloadRequest a11 = new DownloadRequest.b((String) androidx.media3.common.util.a.e(cursor.getString(0)), Uri.parse((String) androidx.media3.common.util.a.e(cursor.getString(2)))).e(q(cursor.getString(1))).f(j(cursor.getString(3))).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        l lVar = new l();
        lVar.f12506a = cursor.getLong(13);
        lVar.f12507b = cursor.getFloat(12);
        int i11 = cursor.getInt(6);
        return new c(a11, i11, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i11 == 4 ? cursor.getInt(11) : 0, lVar);
    }

    private static String p(int... iArr) {
        if (iArr.length == 0) {
            return "1";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("state");
        sb2.append(" IN (");
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (i11 > 0) {
                sb2.append(',');
            }
            sb2.append(iArr[i11]);
        }
        sb2.append(')');
        return sb2.toString();
    }

    private static String q(String str) {
        return "dash".equals(str) ? MimeTypes.APPLICATION_MPD : "hls".equals(str) ? MimeTypes.APPLICATION_M3U8 : "ss".equals(str) ? MimeTypes.APPLICATION_SS : MimeTypes.VIDEO_UNKNOWN;
    }

    private List r(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        if (!a1.t1(sQLiteDatabase, this.f12487b)) {
            return arrayList;
        }
        Cursor query = sQLiteDatabase.query(this.f12487b, new String[]{"id", CampaignEx.JSON_KEY_TITLE, "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(o(query));
            } finally {
            }
        }
        query.close();
        return arrayList;
    }

    private void s(c cVar, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = cVar.f12495a.keySetId;
        if (bArr == null) {
            bArr = a1.f10437f;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", cVar.f12495a.f12425id);
        contentValues.put("mime_type", cVar.f12495a.mimeType);
        contentValues.put("uri", cVar.f12495a.uri.toString());
        contentValues.put("stream_keys", k(cVar.f12495a.streamKeys));
        contentValues.put("custom_cache_key", cVar.f12495a.customCacheKey);
        contentValues.put("data", cVar.f12495a.data);
        contentValues.put("state", Integer.valueOf(cVar.f12496b));
        contentValues.put("start_time_ms", Long.valueOf(cVar.f12497c));
        contentValues.put("update_time_ms", Long.valueOf(cVar.f12498d));
        contentValues.put("content_length", Long.valueOf(cVar.f12499e));
        contentValues.put("stop_reason", Integer.valueOf(cVar.f12500f));
        contentValues.put("failure_reason", Integer.valueOf(cVar.f12501g));
        contentValues.put("percent_downloaded", Float.valueOf(cVar.b()));
        contentValues.put("bytes_downloaded", Long.valueOf(cVar.a()));
        contentValues.put("key_set_id", bArr);
        sQLiteDatabase.replaceOrThrow(this.f12487b, null, contentValues);
    }

    @Override // androidx.media3.exoplayer.offline.t
    public void a(String str, int i11) {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i11));
            this.f12488c.getWritableDatabase().update(this.f12487b, contentValues, f12484f + " AND id = ?", new String[]{str});
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.t
    public void b(c cVar) {
        l();
        try {
            s(cVar, this.f12488c.getWritableDatabase());
        } catch (SQLiteException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.t
    public void c(String str) {
        l();
        try {
            this.f12488c.getWritableDatabase().delete(this.f12487b, "id = ?", new String[]{str});
        } catch (SQLiteException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.t
    public void d(int i11) {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i11));
            this.f12488c.getWritableDatabase().update(this.f12487b, contentValues, f12484f, null);
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.f
    public e e(int... iArr) {
        l();
        return new b(m(p(iArr), null));
    }

    @Override // androidx.media3.exoplayer.offline.t
    public void f() {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 5);
            contentValues.put("failure_reason", (Integer) 0);
            this.f12488c.getWritableDatabase().update(this.f12487b, contentValues, null, null);
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.t
    public void g() {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 0);
            this.f12488c.getWritableDatabase().update(this.f12487b, contentValues, "state = 2", null);
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @Override // androidx.media3.exoplayer.offline.f
    public c h(String str) {
        l();
        try {
            Cursor m11 = m("id = ?", new String[]{str});
            try {
                if (m11.getCount() == 0) {
                    m11.close();
                    return null;
                }
                m11.moveToNext();
                c n11 = n(m11);
                m11.close();
                return n11;
            } finally {
            }
        } catch (SQLiteException e11) {
            throw new DatabaseIOException(e11);
        }
    }
}
