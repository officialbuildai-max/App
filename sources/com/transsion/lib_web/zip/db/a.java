package com.transsion.lib_web.zip.db;

import androidx.room.RoomDatabase;
import androidx.room.e;
import androidx.room.g;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a implements pm.a {

    /* renamed from: e, reason: collision with root package name */
    public static final d f46249e = new d(null);

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f46250a;

    /* renamed from: b, reason: collision with root package name */
    private final g f46251b;

    /* renamed from: c, reason: collision with root package name */
    private final e f46252c;

    /* renamed from: d, reason: collision with root package name */
    private final e f46253d;

    /* renamed from: com.transsion.lib_web.zip.db.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0630a extends g {
        C0630a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `mb_web_res_db` (`scene`,`htmlUrl`,`zipUrl`,`zipMd5`,`sourceType`,`updateTime`) VALUES (?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e statement, WebViewCacheConfigData entity) {
            Intrinsics.h(statement, "statement");
            Intrinsics.h(entity, "entity");
            statement.j(1, entity.getScene());
            statement.j(2, entity.getHtmlUrl());
            statement.j(3, entity.getZipUrl());
            statement.j(4, entity.getZipMd5());
            statement.c(5, entity.getSourceType());
            String updateTime = entity.getUpdateTime();
            if (updateTime == null) {
                statement.g(6);
            } else {
                statement.j(6, updateTime);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `mb_web_res_db` WHERE `scene` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e statement, WebViewCacheConfigData entity) {
            Intrinsics.h(statement, "statement");
            Intrinsics.h(entity, "entity");
            statement.j(1, entity.getScene());
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends e {
        c() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `mb_web_res_db` SET `scene` = ?,`htmlUrl` = ?,`zipUrl` = ?,`zipMd5` = ?,`sourceType` = ?,`updateTime` = ? WHERE `scene` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e statement, WebViewCacheConfigData entity) {
            Intrinsics.h(statement, "statement");
            Intrinsics.h(entity, "entity");
            statement.j(1, entity.getScene());
            statement.j(2, entity.getHtmlUrl());
            statement.j(3, entity.getZipUrl());
            statement.j(4, entity.getZipMd5());
            statement.c(5, entity.getSourceType());
            String updateTime = entity.getUpdateTime();
            if (updateTime == null) {
                statement.g(6);
            } else {
                statement.j(6, updateTime);
            }
            statement.j(7, entity.getScene());
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return CollectionsKt.l();
        }
    }

    public a(RoomDatabase __db) {
        Intrinsics.h(__db, "__db");
        this.f46250a = __db;
        this.f46251b = new C0630a();
        this.f46252c = new b();
        this.f46253d = new c();
    }
}
