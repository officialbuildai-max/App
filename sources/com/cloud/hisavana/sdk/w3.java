package com.cloud.hisavana.sdk;

import a4.g;
import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.j0;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class w3 implements v3 {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f23129a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.h f23130b;

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.f f23131c;

    /* renamed from: d, reason: collision with root package name */
    private final j0 f23132d;

    /* renamed from: e, reason: collision with root package name */
    private final j0 f23133e;

    /* renamed from: f, reason: collision with root package name */
    private final j0 f23134f;

    /* renamed from: g, reason: collision with root package name */
    private final j0 f23135g;

    /* loaded from: classes3.dex */
    class a extends androidx.room.h {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        protected String e() {
            return "INSERT OR REPLACE INTO `adList_room` (`_id`,`ad_creative_id`,`codeSeatId`,`file_path`,`price`,`is_offline_ad`,`ad_request_ver`,`ad_bean`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.h
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(a4.h hVar, y3 y3Var) {
            hVar.c(1, y3Var.o());
            if (y3Var.f() == null) {
                hVar.g(2);
            } else {
                hVar.y(2, y3Var.f());
            }
            if (y3Var.k() == null) {
                hVar.g(3);
            } else {
                hVar.y(3, y3Var.k());
            }
            if (y3Var.m() == null) {
                hVar.g(4);
            } else {
                hVar.y(4, y3Var.m());
            }
            if (y3Var.n() == null) {
                hVar.g(5);
            } else {
                hVar.a(5, y3Var.n().doubleValue());
            }
            if (y3Var.p() == null) {
                hVar.g(6);
            } else {
                hVar.c(6, y3Var.p().intValue());
            }
            if (y3Var.i() == null) {
                hVar.g(7);
            } else {
                hVar.c(7, y3Var.i().intValue());
            }
            if (y3Var.a() == null) {
                hVar.g(8);
            } else {
                hVar.y(8, y3Var.a());
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
            return "UPDATE OR ABORT `adList_room` SET `_id` = ?,`ad_creative_id` = ?,`codeSeatId` = ?,`file_path` = ?,`price` = ?,`is_offline_ad` = ?,`ad_request_ver` = ?,`ad_bean` = ? WHERE `_id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.f
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void j(a4.h hVar, y3 y3Var) {
            hVar.c(1, y3Var.o());
            if (y3Var.f() == null) {
                hVar.g(2);
            } else {
                hVar.y(2, y3Var.f());
            }
            if (y3Var.k() == null) {
                hVar.g(3);
            } else {
                hVar.y(3, y3Var.k());
            }
            if (y3Var.m() == null) {
                hVar.g(4);
            } else {
                hVar.y(4, y3Var.m());
            }
            if (y3Var.n() == null) {
                hVar.g(5);
            } else {
                hVar.a(5, y3Var.n().doubleValue());
            }
            if (y3Var.p() == null) {
                hVar.g(6);
            } else {
                hVar.c(6, y3Var.p().intValue());
            }
            if (y3Var.i() == null) {
                hVar.g(7);
            } else {
                hVar.c(7, y3Var.i().intValue());
            }
            if (y3Var.a() == null) {
                hVar.g(8);
            } else {
                hVar.y(8, y3Var.a());
            }
            hVar.c(9, y3Var.o());
        }
    }

    /* loaded from: classes3.dex */
    class c extends j0 {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "DELETE FROM adList_room WHERE codeSeatId = ? AND ad_creative_id = ?";
        }
    }

    /* loaded from: classes3.dex */
    class d extends j0 {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "DELETE FROM adList_room WHERE codeSeatId = ? AND ad_request_ver < ? AND is_offline_ad = 1";
        }
    }

    /* loaded from: classes3.dex */
    class e extends j0 {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "DELETE FROM adList_room WHERE codeSeatId = ? AND is_offline_ad = 0";
        }
    }

    /* loaded from: classes3.dex */
    class f extends j0 {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "DELETE FROM adList_room";
        }
    }

    public w3(RoomDatabase roomDatabase) {
        this.f23129a = roomDatabase;
        this.f23130b = new a(roomDatabase);
        this.f23131c = new b(roomDatabase);
        this.f23132d = new c(roomDatabase);
        this.f23133e = new d(roomDatabase);
        this.f23134f = new e(roomDatabase);
        this.f23135g = new f(roomDatabase);
    }

    public static List e() {
        return Collections.emptyList();
    }

    @Override // com.cloud.hisavana.sdk.v3
    public int a(List list) {
        this.f23129a.j();
        this.f23129a.k();
        try {
            int l11 = this.f23131c.l(list);
            this.f23129a.e0();
            return l11;
        } finally {
            this.f23129a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.v3
    public Cursor a(g gVar) {
        return this.f23129a.V(gVar);
    }

    @Override // com.cloud.hisavana.sdk.v3
    public void a() {
        this.f23129a.j();
        a4.h b11 = this.f23135g.b();
        try {
            this.f23129a.k();
            try {
                b11.F();
                this.f23129a.e0();
            } finally {
                this.f23129a.t();
            }
        } finally {
            this.f23135g.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.v3
    public int b(g gVar) {
        this.f23129a.j();
        Cursor g11 = androidx.room.util.b.g(this.f23129a, gVar, false, null);
        try {
            return g11.moveToFirst() ? g11.getInt(0) : 0;
        } finally {
            g11.close();
        }
    }

    @Override // com.cloud.hisavana.sdk.v3
    public void c(List list) {
        this.f23129a.j();
        this.f23129a.k();
        try {
            this.f23130b.k(list);
            this.f23129a.e0();
        } finally {
            this.f23129a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.v3
    public List d(List list) {
        StringBuilder b11 = androidx.room.util.n.b();
        b11.append("SELECT * FROM adList_room WHERE ad_creative_id IN (");
        int i11 = 1;
        int size = list == null ? 1 : list.size();
        androidx.room.util.n.a(b11, size);
        b11.append(")");
        androidx.room.g0 h11 = androidx.room.g0.h(b11.toString(), size);
        if (list == null) {
            h11.g(1);
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str == null) {
                    h11.g(i11);
                } else {
                    h11.y(i11, str);
                }
                i11++;
            }
        }
        this.f23129a.j();
        Cursor g11 = androidx.room.util.b.g(this.f23129a, h11, false, null);
        try {
            int e11 = androidx.room.util.a.e(g11, "_id");
            int e12 = androidx.room.util.a.e(g11, "ad_creative_id");
            int e13 = androidx.room.util.a.e(g11, "codeSeatId");
            int e14 = androidx.room.util.a.e(g11, "file_path");
            int e15 = androidx.room.util.a.e(g11, BidResponsed.KEY_PRICE);
            int e16 = androidx.room.util.a.e(g11, TrackingKey.IS_OFFLINE_AD);
            int e17 = androidx.room.util.a.e(g11, "ad_request_ver");
            int e18 = androidx.room.util.a.e(g11, "ad_bean");
            ArrayList arrayList = new ArrayList(g11.getCount());
            while (g11.moveToNext()) {
                arrayList.add(new y3(g11.getInt(e11), g11.isNull(e12) ? null : g11.getString(e12), g11.isNull(e13) ? null : g11.getString(e13), g11.isNull(e14) ? null : g11.getString(e14), g11.isNull(e15) ? null : Double.valueOf(g11.getDouble(e15)), g11.isNull(e16) ? null : Integer.valueOf(g11.getInt(e16)), g11.isNull(e17) ? null : Integer.valueOf(g11.getInt(e17)), g11.isNull(e18) ? null : g11.getString(e18)));
            }
            return arrayList;
        } finally {
            g11.close();
            h11.release();
        }
    }
}
