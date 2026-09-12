package com.transsion.subtitle_download.db;

import androidx.core.app.NotificationCompat;
import androidx.room.InvalidationTracker;
import androidx.room.d0;
import androidx.room.util.o;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mu.i;
import z3.b;

/* loaded from: classes6.dex */
public final class SubtitleDownloadDatabase_Impl extends SubtitleDownloadDatabase {

    /* renamed from: u, reason: collision with root package name */
    private volatile mu.a f55131u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends d0 {
        a(int i11, String str, String str2) {
            super(i11, str, str2);
        }

        @Override // androidx.room.d0
        public void a(b bVar) {
            z3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `st_download_table` (`id` TEXT NOT NULL, `resourceStreamType` INTEGER NOT NULL, `resourceId` TEXT NOT NULL, `lan` TEXT, `lanName` TEXT, `url` TEXT, `size` INTEGER, `delay` INTEGER, `downloads` INTEGER, `type` INTEGER NOT NULL, `postId` TEXT, `subtitleName` TEXT, `subjectId` TEXT, `ep` INTEGER NOT NULL, `se` INTEGER NOT NULL, `resolution` INTEGER NOT NULL, `subjectName` TEXT, `status` INTEGER NOT NULL, `fileCharsetName` TEXT, `path` TEXT, `zipPath` TEXT NOT NULL, `taskId` TEXT, `failCount` INTEGER NOT NULL, `ugcVideoId` TEXT, `ugcVideoCollectionId` TEXT, `ops` TEXT, PRIMARY KEY(`id`, `resourceStreamType`))");
            z3.a.a(bVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            z3.a.a(bVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b69203d51150b93b225b86bfd78bf875')");
        }

        @Override // androidx.room.d0
        public void b(b bVar) {
            z3.a.a(bVar, "DROP TABLE IF EXISTS `st_download_table`");
        }

        @Override // androidx.room.d0
        public void f(b bVar) {
        }

        @Override // androidx.room.d0
        public void g(b bVar) {
            SubtitleDownloadDatabase_Impl.this.Q(bVar);
        }

        @Override // androidx.room.d0
        public void h(b bVar) {
        }

        @Override // androidx.room.d0
        public void i(b bVar) {
            androidx.room.util.b.b(bVar);
        }

        @Override // androidx.room.d0
        public d0.a j(b bVar) {
            HashMap hashMap = new HashMap(26);
            hashMap.put("id", new o.a("id", "TEXT", true, 1, null, 1));
            hashMap.put("resourceStreamType", new o.a("resourceStreamType", "INTEGER", true, 2, null, 1));
            hashMap.put("resourceId", new o.a("resourceId", "TEXT", true, 0, null, 1));
            hashMap.put("lan", new o.a("lan", "TEXT", false, 0, null, 1));
            hashMap.put("lanName", new o.a("lanName", "TEXT", false, 0, null, 1));
            hashMap.put("url", new o.a("url", "TEXT", false, 0, null, 1));
            hashMap.put("size", new o.a("size", "INTEGER", false, 0, null, 1));
            hashMap.put("delay", new o.a("delay", "INTEGER", false, 0, null, 1));
            hashMap.put("downloads", new o.a("downloads", "INTEGER", false, 0, null, 1));
            hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, new o.a(NativeComponentConstants.KEY_COMPONENT_TYPE, "INTEGER", true, 0, null, 1));
            hashMap.put("postId", new o.a("postId", "TEXT", false, 0, null, 1));
            hashMap.put("subtitleName", new o.a("subtitleName", "TEXT", false, 0, null, 1));
            hashMap.put("subjectId", new o.a("subjectId", "TEXT", false, 0, null, 1));
            hashMap.put("ep", new o.a("ep", "INTEGER", true, 0, null, 1));
            hashMap.put("se", new o.a("se", "INTEGER", true, 0, null, 1));
            hashMap.put("resolution", new o.a("resolution", "INTEGER", true, 0, null, 1));
            hashMap.put("subjectName", new o.a("subjectName", "TEXT", false, 0, null, 1));
            hashMap.put(NotificationCompat.CATEGORY_STATUS, new o.a(NotificationCompat.CATEGORY_STATUS, "INTEGER", true, 0, null, 1));
            hashMap.put("fileCharsetName", new o.a("fileCharsetName", "TEXT", false, 0, null, 1));
            hashMap.put("path", new o.a("path", "TEXT", false, 0, null, 1));
            hashMap.put("zipPath", new o.a("zipPath", "TEXT", true, 0, null, 1));
            hashMap.put("taskId", new o.a("taskId", "TEXT", false, 0, null, 1));
            hashMap.put("failCount", new o.a("failCount", "INTEGER", true, 0, null, 1));
            hashMap.put("ugcVideoId", new o.a("ugcVideoId", "TEXT", false, 0, null, 1));
            hashMap.put("ugcVideoCollectionId", new o.a("ugcVideoCollectionId", "TEXT", false, 0, null, 1));
            hashMap.put("ops", new o.a("ops", "TEXT", false, 0, null, 1));
            o oVar = new o("st_download_table", hashMap, new HashSet(0), new HashSet(0));
            o b11 = o.b(bVar, "st_download_table");
            if (oVar.equals(b11)) {
                return new d0.a(true, null);
            }
            return new d0.a(false, "st_download_table(com.transsion.subtitle_download.db.SubtitleDownloadTable).\n Expected:\n" + oVar + "\n Found:\n" + b11);
        }
    }

    @Override // androidx.room.RoomDatabase
    public Set C() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map F() {
        HashMap hashMap = new HashMap();
        hashMap.put(mu.a.class, i.o());
        return hashMap;
    }

    @Override // com.transsion.subtitle_download.db.SubtitleDownloadDatabase
    public mu.a l0() {
        mu.a aVar;
        if (this.f55131u != null) {
            return this.f55131u;
        }
        synchronized (this) {
            try {
                if (this.f55131u == null) {
                    this.f55131u = new i(this);
                }
                aVar = this.f55131u;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public d0 r() {
        return new a(4, "b69203d51150b93b225b86bfd78bf875", "a207c71dcb7f4328cd120ce375a1f942");
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker q() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "st_download_table");
    }

    @Override // androidx.room.RoomDatabase
    public List v(Map map) {
        return new ArrayList();
    }
}
