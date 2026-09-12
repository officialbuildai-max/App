package com.cloud.hisavana.sdk;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.j0;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class a implements c6 {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f21636a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.h f21637b;

    /* renamed from: c, reason: collision with root package name */
    private final j0 f21638c;

    /* renamed from: d, reason: collision with root package name */
    private final j0 f21639d;

    /* renamed from: com.cloud.hisavana.sdk.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0304a extends androidx.room.h {
        C0304a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        protected String e() {
            return "INSERT OR REPLACE INTO `attr_impression_room` (`_id`,`pkg`,`imp_ts`,`ad_creative_id`) VALUES (nullif(?, 0),?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.h
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(a4.h hVar, h hVar2) {
            hVar.c(1, hVar2.d());
            if (hVar2.c() == null) {
                hVar.g(2);
            } else {
                hVar.y(2, hVar2.c());
            }
            hVar.c(3, hVar2.b());
            if (hVar2.a() == null) {
                hVar.g(4);
            } else {
                hVar.y(4, hVar2.a());
            }
        }
    }

    /* loaded from: classes3.dex */
    class b extends j0 {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "DELETE FROM attr_impression_room WHERE _id IN (SELECT _id FROM attr_impression_room ORDER BY _id ASC LIMIT ?)";
        }
    }

    /* loaded from: classes3.dex */
    class c extends j0 {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "DELETE FROM attr_impression_room";
        }
    }

    public a(RoomDatabase roomDatabase) {
        this.f21636a = roomDatabase;
        this.f21637b = new C0304a(roomDatabase);
        this.f21638c = new b(roomDatabase);
        this.f21639d = new c(roomDatabase);
    }

    public static List c() {
        return Collections.emptyList();
    }

    @Override // com.cloud.hisavana.sdk.c6
    public int a() {
        this.f21636a.j();
        a4.h b11 = this.f21639d.b();
        try {
            this.f21636a.k();
            try {
                int F = b11.F();
                this.f21636a.e0();
                return F;
            } finally {
                this.f21636a.t();
            }
        } finally {
            this.f21639d.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.c6
    public int a(int i11) {
        this.f21636a.j();
        a4.h b11 = this.f21638c.b();
        b11.c(1, i11);
        try {
            this.f21636a.k();
            try {
                int F = b11.F();
                this.f21636a.e0();
                return F;
            } finally {
                this.f21636a.t();
            }
        } finally {
            this.f21638c.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.c6
    public void a(h hVar) {
        this.f21636a.j();
        this.f21636a.k();
        try {
            this.f21637b.l(hVar);
            this.f21636a.e0();
        } finally {
            this.f21636a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.c6
    public List b() {
        androidx.room.g0 h11 = androidx.room.g0.h("SELECT * FROM attr_impression_room", 0);
        this.f21636a.j();
        Cursor g11 = androidx.room.util.b.g(this.f21636a, h11, false, null);
        try {
            int e11 = androidx.room.util.a.e(g11, "_id");
            int e12 = androidx.room.util.a.e(g11, PushConstants.PROVIDER_FIELD_PKG);
            int e13 = androidx.room.util.a.e(g11, "imp_ts");
            int e14 = androidx.room.util.a.e(g11, "ad_creative_id");
            ArrayList arrayList = new ArrayList(g11.getCount());
            while (g11.moveToNext()) {
                arrayList.add(new h(g11.getInt(e11), g11.isNull(e12) ? null : g11.getString(e12), g11.getLong(e13), g11.isNull(e14) ? null : g11.getString(e14)));
            }
            return arrayList;
        } finally {
            g11.close();
            h11.release();
        }
    }
}
