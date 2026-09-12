package com.transsion.shorttv.db;

import androidx.room.InvalidationTracker;
import androidx.room.d0;
import androidx.room.util.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public final class ShortTvDatabase_Impl extends ShortTvDatabase {

    /* renamed from: s, reason: collision with root package name */
    private volatile ShortTvFavoriteDao f53064s;

    /* renamed from: t, reason: collision with root package name */
    private volatile ShortTvAdUnlockDao f53065t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends d0 {
        a(int i11, String str, String str2) {
            super(i11, str, str2);
        }

        @Override // androidx.room.d0
        public void a(z3.b bVar) {
            z3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `short_tv_favorite_state` (`subjectId` TEXT NOT NULL, `favoriteNum` TEXT, `hasFavorite` INTEGER NOT NULL, `favoriteTime` TEXT, PRIMARY KEY(`subjectId`))");
            z3.a.a(bVar, "CREATE TABLE IF NOT EXISTS `short_tv_ad_unlock_state` (`subjectId` TEXT NOT NULL, `unlockedEps` TEXT NOT NULL, PRIMARY KEY(`subjectId`))");
            z3.a.a(bVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            z3.a.a(bVar, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7d0cc9a2b371c1f7329d0d00d8bd31c1')");
        }

        @Override // androidx.room.d0
        public void b(z3.b bVar) {
            z3.a.a(bVar, "DROP TABLE IF EXISTS `short_tv_favorite_state`");
            z3.a.a(bVar, "DROP TABLE IF EXISTS `short_tv_ad_unlock_state`");
        }

        @Override // androidx.room.d0
        public void f(z3.b bVar) {
        }

        @Override // androidx.room.d0
        public void g(z3.b bVar) {
            ShortTvDatabase_Impl.this.Q(bVar);
        }

        @Override // androidx.room.d0
        public void h(z3.b bVar) {
        }

        @Override // androidx.room.d0
        public void i(z3.b bVar) {
            androidx.room.util.b.b(bVar);
        }

        @Override // androidx.room.d0
        public d0.a j(z3.b bVar) {
            HashMap hashMap = new HashMap(4);
            hashMap.put("subjectId", new o.a("subjectId", "TEXT", true, 1, null, 1));
            hashMap.put("favoriteNum", new o.a("favoriteNum", "TEXT", false, 0, null, 1));
            hashMap.put("hasFavorite", new o.a("hasFavorite", "INTEGER", true, 0, null, 1));
            hashMap.put("favoriteTime", new o.a("favoriteTime", "TEXT", false, 0, null, 1));
            o oVar = new o("short_tv_favorite_state", hashMap, new HashSet(0), new HashSet(0));
            o b11 = o.b(bVar, "short_tv_favorite_state");
            if (!oVar.equals(b11)) {
                return new d0.a(false, "short_tv_favorite_state(com.transsion.shorttv.db.ShortTvFavoriteStateBean).\n Expected:\n" + oVar + "\n Found:\n" + b11);
            }
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("subjectId", new o.a("subjectId", "TEXT", true, 1, null, 1));
            hashMap2.put("unlockedEps", new o.a("unlockedEps", "TEXT", true, 0, null, 1));
            o oVar2 = new o("short_tv_ad_unlock_state", hashMap2, new HashSet(0), new HashSet(0));
            o b12 = o.b(bVar, "short_tv_ad_unlock_state");
            if (oVar2.equals(b12)) {
                return new d0.a(true, null);
            }
            return new d0.a(false, "short_tv_ad_unlock_state(com.transsion.shorttv.db.ShortTvAdUnlockStateBean).\n Expected:\n" + oVar2 + "\n Found:\n" + b12);
        }
    }

    @Override // androidx.room.RoomDatabase
    public Set C() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map F() {
        HashMap hashMap = new HashMap();
        hashMap.put(ShortTvFavoriteDao.class, i.h());
        hashMap.put(ShortTvAdUnlockDao.class, d.h());
        return hashMap;
    }

    @Override // com.transsion.shorttv.db.ShortTvDatabase
    public ShortTvAdUnlockDao j0() {
        ShortTvAdUnlockDao shortTvAdUnlockDao;
        if (this.f53065t != null) {
            return this.f53065t;
        }
        synchronized (this) {
            try {
                if (this.f53065t == null) {
                    this.f53065t = new d(this);
                }
                shortTvAdUnlockDao = this.f53065t;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return shortTvAdUnlockDao;
    }

    @Override // com.transsion.shorttv.db.ShortTvDatabase
    public ShortTvFavoriteDao k0() {
        ShortTvFavoriteDao shortTvFavoriteDao;
        if (this.f53064s != null) {
            return this.f53064s;
        }
        synchronized (this) {
            try {
                if (this.f53064s == null) {
                    this.f53064s = new i(this);
                }
                shortTvFavoriteDao = this.f53064s;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return shortTvFavoriteDao;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.room.RoomDatabase
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public d0 r() {
        return new a(2, "7d0cc9a2b371c1f7329d0d00d8bd31c1", "8d7f57b404f63d2b99b6f547f57644e9");
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker q() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "short_tv_favorite_state", "short_tv_ad_unlock_state");
    }

    @Override // androidx.room.RoomDatabase
    public List v(Map map) {
        return new ArrayList();
    }
}
