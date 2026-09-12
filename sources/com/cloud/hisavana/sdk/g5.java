package com.cloud.hisavana.sdk;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.j0;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class g5 implements f5 {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f22554a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.h f22555b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.h f22556c;

    /* renamed from: d, reason: collision with root package name */
    private final j0 f22557d;

    /* loaded from: classes3.dex */
    class a extends androidx.room.h {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        protected String e() {
            return "INSERT OR ABORT INTO `attr_click_room` (`_id`,`ac_type`,`pkg`,`dl_type`,`codeSeatId`,`click_ts`,`ad_creative_id`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.h
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(a4.h hVar, j5 j5Var) {
            hVar.c(1, j5Var.g());
            hVar.c(2, j5Var.a());
            if (j5Var.f() == null) {
                hVar.g(3);
            } else {
                hVar.y(3, j5Var.f());
            }
            if (j5Var.e() == null) {
                hVar.g(4);
            } else {
                hVar.y(4, j5Var.e());
            }
            if (j5Var.d() == null) {
                hVar.g(5);
            } else {
                hVar.y(5, j5Var.d());
            }
            hVar.c(6, j5Var.c());
            if (j5Var.b() == null) {
                hVar.g(7);
            } else {
                hVar.y(7, j5Var.b());
            }
        }
    }

    /* loaded from: classes3.dex */
    class b extends androidx.room.h {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        protected String e() {
            return "INSERT OR REPLACE INTO `attr_click_room` (`_id`,`ac_type`,`pkg`,`dl_type`,`codeSeatId`,`click_ts`,`ad_creative_id`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.h
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(a4.h hVar, j5 j5Var) {
            hVar.c(1, j5Var.g());
            hVar.c(2, j5Var.a());
            if (j5Var.f() == null) {
                hVar.g(3);
            } else {
                hVar.y(3, j5Var.f());
            }
            if (j5Var.e() == null) {
                hVar.g(4);
            } else {
                hVar.y(4, j5Var.e());
            }
            if (j5Var.d() == null) {
                hVar.g(5);
            } else {
                hVar.y(5, j5Var.d());
            }
            hVar.c(6, j5Var.c());
            if (j5Var.b() == null) {
                hVar.g(7);
            } else {
                hVar.y(7, j5Var.b());
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
            return "DELETE FROM attr_click_room";
        }
    }

    public g5(RoomDatabase roomDatabase) {
        this.f22554a = roomDatabase;
        this.f22555b = new a(roomDatabase);
        this.f22556c = new b(roomDatabase);
        this.f22557d = new c(roomDatabase);
    }

    public static List c() {
        return Collections.emptyList();
    }

    @Override // com.cloud.hisavana.sdk.f5
    public int a() {
        this.f22554a.j();
        a4.h b11 = this.f22557d.b();
        try {
            this.f22554a.k();
            try {
                int F = b11.F();
                this.f22554a.e0();
                return F;
            } finally {
                this.f22554a.t();
            }
        } finally {
            this.f22557d.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.f5
    public int a(List list) {
        this.f22554a.j();
        StringBuilder b11 = androidx.room.util.n.b();
        b11.append("DELETE FROM attr_click_room WHERE _id IN (");
        androidx.room.util.n.a(b11, list.size());
        b11.append(")");
        a4.h m11 = this.f22554a.m(b11.toString());
        Iterator it = list.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            if (((Integer) it.next()) == null) {
                m11.g(i11);
            } else {
                m11.c(i11, r2.intValue());
            }
            i11++;
        }
        this.f22554a.k();
        try {
            int F = m11.F();
            this.f22554a.e0();
            return F;
        } finally {
            this.f22554a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.f5
    public void a(j5 j5Var) {
        this.f22554a.j();
        this.f22554a.k();
        try {
            this.f22555b.l(j5Var);
            this.f22554a.e0();
        } finally {
            this.f22554a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.f5
    public List b() {
        androidx.room.g0 h11 = androidx.room.g0.h("SELECT * FROM attr_click_room", 0);
        this.f22554a.j();
        Cursor g11 = androidx.room.util.b.g(this.f22554a, h11, false, null);
        try {
            int e11 = androidx.room.util.a.e(g11, "_id");
            int e12 = androidx.room.util.a.e(g11, "ac_type");
            int e13 = androidx.room.util.a.e(g11, PushConstants.PROVIDER_FIELD_PKG);
            int e14 = androidx.room.util.a.e(g11, "dl_type");
            int e15 = androidx.room.util.a.e(g11, "codeSeatId");
            int e16 = androidx.room.util.a.e(g11, TrackingKey.CLICK_TS);
            int e17 = androidx.room.util.a.e(g11, "ad_creative_id");
            ArrayList arrayList = new ArrayList(g11.getCount());
            while (g11.moveToNext()) {
                arrayList.add(new j5(g11.getInt(e11), g11.getInt(e12), g11.isNull(e13) ? null : g11.getString(e13), g11.isNull(e14) ? null : g11.getString(e14), g11.isNull(e15) ? null : g11.getString(e15), g11.getLong(e16), g11.isNull(e17) ? null : g11.getString(e17)));
            }
            return arrayList;
        } finally {
            g11.close();
            h11.release();
        }
    }
}
