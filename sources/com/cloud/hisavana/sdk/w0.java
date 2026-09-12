package com.cloud.hisavana.sdk;

import a4.g;
import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.j0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class w0 implements v0 {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f23118a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.h f23119b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.f f23120c;

    /* renamed from: d, reason: collision with root package name */
    private final j0 f23121d;

    /* renamed from: e, reason: collision with root package name */
    private final j0 f23122e;

    /* loaded from: classes3.dex */
    class a extends androidx.room.h {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        protected String e() {
            return "INSERT OR REPLACE INTO `cloudList_room` (`codeSeatId`,`code_seat_bean`) VALUES (?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.h
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(a4.h hVar, e1 e1Var) {
            if (e1Var.a() == null) {
                hVar.g(1);
            } else {
                hVar.y(1, e1Var.a());
            }
            if (e1Var.b() == null) {
                hVar.g(2);
            } else {
                hVar.y(2, e1Var.b());
            }
        }
    }

    /* loaded from: classes3.dex */
    class b extends androidx.room.f {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        protected String e() {
            return "UPDATE OR ABORT `cloudList_room` SET `codeSeatId` = ?,`code_seat_bean` = ? WHERE `codeSeatId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.f
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void j(a4.h hVar, e1 e1Var) {
            if (e1Var.a() == null) {
                hVar.g(1);
            } else {
                hVar.y(1, e1Var.a());
            }
            if (e1Var.b() == null) {
                hVar.g(2);
            } else {
                hVar.y(2, e1Var.b());
            }
            if (e1Var.a() == null) {
                hVar.g(3);
            } else {
                hVar.y(3, e1Var.a());
            }
        }
    }

    /* loaded from: classes3.dex */
    class c extends j0 {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "DELETE FROM cloudList_room";
        }
    }

    /* loaded from: classes3.dex */
    class d extends j0 {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "UPDATE cloudList_room SET code_seat_bean = ? WHERE codeSeatId = ?";
        }
    }

    public w0(RoomDatabase roomDatabase) {
        this.f23118a = roomDatabase;
        this.f23119b = new a(roomDatabase);
        this.f23120c = new b(roomDatabase);
        this.f23121d = new c(roomDatabase);
        this.f23122e = new d(roomDatabase);
    }

    public static List d() {
        return Collections.emptyList();
    }

    @Override // com.cloud.hisavana.sdk.v0
    public int a(List list) {
        this.f23118a.j();
        this.f23118a.k();
        try {
            int l11 = this.f23120c.l(list);
            this.f23118a.e0();
            return l11;
        } finally {
            this.f23118a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.v0
    public Cursor a(g gVar) {
        return this.f23118a.V(gVar);
    }

    @Override // com.cloud.hisavana.sdk.v0
    public void a() {
        this.f23118a.j();
        a4.h b11 = this.f23121d.b();
        try {
            this.f23118a.k();
            try {
                b11.F();
                this.f23118a.e0();
            } finally {
                this.f23118a.t();
            }
        } finally {
            this.f23121d.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.v0
    public int b(g gVar) {
        this.f23118a.j();
        Cursor g11 = androidx.room.util.b.g(this.f23118a, gVar, false, null);
        try {
            return g11.moveToFirst() ? g11.getInt(0) : 0;
        } finally {
            g11.close();
        }
    }

    @Override // com.cloud.hisavana.sdk.v0
    public void c(List list) {
        this.f23118a.j();
        this.f23118a.k();
        try {
            this.f23119b.k(list);
            this.f23118a.e0();
        } finally {
            this.f23118a.t();
        }
    }
}
