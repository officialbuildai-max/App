package com.cloud.hisavana.sdk;

import a4.g;
import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.j0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class n1 implements m1 {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f22814a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.h f22815b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.f f22816c;

    /* renamed from: d, reason: collision with root package name */
    private final j0 f22817d;

    /* renamed from: e, reason: collision with root package name */
    private final j0 f22818e;

    /* loaded from: classes3.dex */
    class a extends androidx.room.h {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        protected String e() {
            return "INSERT OR REPLACE INTO `retry_tracking_table_room` (`uuid`,`create_time`,`retry_times`,`tracking_data`,`md5`) VALUES (?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.h
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(a4.h hVar, q1 q1Var) {
            if (q1Var.j() == null) {
                hVar.g(1);
            } else {
                hVar.y(1, q1Var.j());
            }
            if (q1Var.a() == null) {
                hVar.g(2);
            } else {
                hVar.c(2, q1Var.a().longValue());
            }
            if (q1Var.g() == null) {
                hVar.g(3);
            } else {
                hVar.c(3, q1Var.g().intValue());
            }
            if (q1Var.i() == null) {
                hVar.g(4);
            } else {
                hVar.y(4, q1Var.i());
            }
            if (q1Var.e() == null) {
                hVar.g(5);
            } else {
                hVar.y(5, q1Var.e());
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
            return "UPDATE OR ABORT `retry_tracking_table_room` SET `uuid` = ?,`create_time` = ?,`retry_times` = ?,`tracking_data` = ?,`md5` = ? WHERE `uuid` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.f
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void j(a4.h hVar, q1 q1Var) {
            if (q1Var.j() == null) {
                hVar.g(1);
            } else {
                hVar.y(1, q1Var.j());
            }
            if (q1Var.a() == null) {
                hVar.g(2);
            } else {
                hVar.c(2, q1Var.a().longValue());
            }
            if (q1Var.g() == null) {
                hVar.g(3);
            } else {
                hVar.c(3, q1Var.g().intValue());
            }
            if (q1Var.i() == null) {
                hVar.g(4);
            } else {
                hVar.y(4, q1Var.i());
            }
            if (q1Var.e() == null) {
                hVar.g(5);
            } else {
                hVar.y(5, q1Var.e());
            }
            if (q1Var.j() == null) {
                hVar.g(6);
            } else {
                hVar.y(6, q1Var.j());
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
            return "DELETE FROM retry_tracking_table_room WHERE create_time < ?";
        }
    }

    /* loaded from: classes3.dex */
    class d extends j0 {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "DELETE FROM retry_tracking_table_room";
        }
    }

    public n1(RoomDatabase roomDatabase) {
        this.f22814a = roomDatabase;
        this.f22815b = new a(roomDatabase);
        this.f22816c = new b(roomDatabase);
        this.f22817d = new c(roomDatabase);
        this.f22818e = new d(roomDatabase);
    }

    public static List e() {
        return Collections.emptyList();
    }

    @Override // com.cloud.hisavana.sdk.m1
    public int a(long j11) {
        this.f22814a.j();
        a4.h b11 = this.f22817d.b();
        b11.c(1, j11);
        try {
            this.f22814a.k();
            try {
                int F = b11.F();
                this.f22814a.e0();
                return F;
            } finally {
                this.f22814a.t();
            }
        } finally {
            this.f22817d.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.m1
    public Cursor a(g gVar) {
        return this.f22814a.V(gVar);
    }

    @Override // com.cloud.hisavana.sdk.m1
    public List a() {
        androidx.room.g0 h11 = androidx.room.g0.h("SELECT tracking_data FROM retry_tracking_table_room", 0);
        this.f22814a.j();
        Cursor g11 = androidx.room.util.b.g(this.f22814a, h11, false, null);
        try {
            ArrayList arrayList = new ArrayList(g11.getCount());
            while (g11.moveToNext()) {
                arrayList.add(g11.isNull(0) ? null : g11.getString(0));
            }
            return arrayList;
        } finally {
            g11.close();
            h11.release();
        }
    }

    @Override // com.cloud.hisavana.sdk.m1
    public void b() {
        this.f22814a.j();
        a4.h b11 = this.f22818e.b();
        try {
            this.f22814a.k();
            try {
                b11.F();
                this.f22814a.e0();
            } finally {
                this.f22814a.t();
            }
        } finally {
            this.f22818e.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.m1
    public void b(q1 q1Var) {
        this.f22814a.j();
        this.f22814a.k();
        try {
            this.f22815b.l(q1Var);
            this.f22814a.e0();
        } finally {
            this.f22814a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.m1
    public int c(q1 q1Var) {
        this.f22814a.j();
        this.f22814a.k();
        try {
            int k11 = this.f22816c.k(q1Var);
            this.f22814a.e0();
            return k11;
        } finally {
            this.f22814a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.m1
    public int d(String[] strArr) {
        this.f22814a.j();
        StringBuilder b11 = androidx.room.util.n.b();
        b11.append("DELETE FROM retry_tracking_table_room WHERE uuid in (");
        androidx.room.util.n.a(b11, strArr.length);
        b11.append(")");
        a4.h m11 = this.f22814a.m(b11.toString());
        int i11 = 1;
        for (String str : strArr) {
            if (str == null) {
                m11.g(i11);
            } else {
                m11.y(i11, str);
            }
            i11++;
        }
        this.f22814a.k();
        try {
            int F = m11.F();
            this.f22814a.e0();
            return F;
        } finally {
            this.f22814a.t();
        }
    }
}
