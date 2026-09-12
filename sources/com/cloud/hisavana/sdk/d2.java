package com.cloud.hisavana.sdk;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.j0;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class d2 implements c2 {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f22431a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.h f22432b;

    /* renamed from: c, reason: collision with root package name */
    private final j0 f22433c;

    /* renamed from: d, reason: collision with root package name */
    private final j0 f22434d;

    /* renamed from: e, reason: collision with root package name */
    private final j0 f22435e;

    /* renamed from: f, reason: collision with root package name */
    private final j0 f22436f;

    /* renamed from: g, reason: collision with root package name */
    private final j0 f22437g;

    /* renamed from: h, reason: collision with root package name */
    private final j0 f22438h;

    /* renamed from: i, reason: collision with root package name */
    private final j0 f22439i;

    /* loaded from: classes3.dex */
    class a extends androidx.room.h {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        protected String e() {
            return "INSERT OR REPLACE INTO `default_ad_room` (`ad_creative_id`,`codeSeatId`,`ad_type`,`price`,`ad_request_ver`,`displayed_times`,`displayed_date`,`start_date`,`end_date`,`display_max_times`,`file_path`,`default_country_white`,`default_country_black`,`default_brand_white`,`default_brand_black`,`ad_bean`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.h
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(a4.h hVar, g2 g2Var) {
            if (g2Var.b() == null) {
                hVar.g(1);
            } else {
                hVar.y(1, g2Var.b());
            }
            if (g2Var.e() == null) {
                hVar.g(2);
            } else {
                hVar.y(2, g2Var.e());
            }
            hVar.c(3, g2Var.d());
            if (g2Var.o() == null) {
                hVar.g(4);
            } else {
                hVar.a(4, g2Var.o().doubleValue());
            }
            hVar.c(5, g2Var.c());
            hVar.c(6, g2Var.l());
            if (g2Var.k() == null) {
                hVar.g(7);
            } else {
                hVar.y(7, g2Var.k());
            }
            if (g2Var.p() == null) {
                hVar.g(8);
            } else {
                hVar.y(8, g2Var.p());
            }
            if (g2Var.m() == null) {
                hVar.g(9);
            } else {
                hVar.y(9, g2Var.m());
            }
            hVar.c(10, g2Var.j());
            if (g2Var.n() == null) {
                hVar.g(11);
            } else {
                hVar.y(11, g2Var.n());
            }
            if (g2Var.i() == null) {
                hVar.g(12);
            } else {
                hVar.y(12, g2Var.i());
            }
            if (g2Var.h() == null) {
                hVar.g(13);
            } else {
                hVar.y(13, g2Var.h());
            }
            if (g2Var.g() == null) {
                hVar.g(14);
            } else {
                hVar.y(14, g2Var.g());
            }
            if (g2Var.f() == null) {
                hVar.g(15);
            } else {
                hVar.y(15, g2Var.f());
            }
            if (g2Var.a() == null) {
                hVar.g(16);
            } else {
                hVar.y(16, g2Var.a());
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
            return "UPDATE default_ad_room SET displayed_times = ?, displayed_date = ? WHERE ad_creative_id = ? AND codeSeatId = ?";
        }
    }

    /* loaded from: classes3.dex */
    class c extends j0 {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "DELETE FROM default_ad_room WHERE ad_creative_id = ? AND codeSeatId = ?";
        }
    }

    /* loaded from: classes3.dex */
    class d extends j0 {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "UPDATE default_ad_room SET file_path = '' WHERE file_path LIKE '%' || ? || '.0'";
        }
    }

    /* loaded from: classes3.dex */
    class e extends j0 {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "DELETE FROM default_ad_room WHERE codeSeatId = ? AND ad_request_ver < (SELECT MAX(ad_request_ver) FROM default_ad_room WHERE codeSeatId = ?)";
        }
    }

    /* loaded from: classes3.dex */
    class f extends j0 {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "UPDATE default_ad_room SET file_path = ? WHERE ad_creative_id = ? AND codeSeatId = ?";
        }
    }

    /* loaded from: classes3.dex */
    class g extends j0 {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "DELETE FROM default_ad_room WHERE ad_request_ver < ?";
        }
    }

    /* loaded from: classes3.dex */
    class h extends j0 {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.j0
        public String e() {
            return "DELETE FROM default_ad_room";
        }
    }

    public d2(RoomDatabase roomDatabase) {
        this.f22431a = roomDatabase;
        this.f22432b = new a(roomDatabase);
        this.f22433c = new b(roomDatabase);
        this.f22434d = new c(roomDatabase);
        this.f22435e = new d(roomDatabase);
        this.f22436f = new e(roomDatabase);
        this.f22437g = new f(roomDatabase);
        this.f22438h = new g(roomDatabase);
        this.f22439i = new h(roomDatabase);
    }

    public static List c() {
        return Collections.emptyList();
    }

    @Override // com.cloud.hisavana.sdk.c2
    public List a() {
        androidx.room.g0 g0Var;
        int e11;
        int e12;
        int e13;
        int e14;
        int e15;
        int e16;
        int e17;
        int e18;
        int e19;
        int e20;
        int e21;
        int e22;
        int e23;
        int e24;
        String string;
        int i11;
        String string2;
        int i12;
        androidx.room.g0 h11 = androidx.room.g0.h("SELECT * FROM default_ad_room", 0);
        this.f22431a.j();
        Cursor g11 = androidx.room.util.b.g(this.f22431a, h11, false, null);
        try {
            e11 = androidx.room.util.a.e(g11, "ad_creative_id");
            e12 = androidx.room.util.a.e(g11, "codeSeatId");
            e13 = androidx.room.util.a.e(g11, "ad_type");
            e14 = androidx.room.util.a.e(g11, BidResponsed.KEY_PRICE);
            e15 = androidx.room.util.a.e(g11, "ad_request_ver");
            e16 = androidx.room.util.a.e(g11, "displayed_times");
            e17 = androidx.room.util.a.e(g11, "displayed_date");
            e18 = androidx.room.util.a.e(g11, "start_date");
            e19 = androidx.room.util.a.e(g11, "end_date");
            e20 = androidx.room.util.a.e(g11, "display_max_times");
            e21 = androidx.room.util.a.e(g11, "file_path");
            e22 = androidx.room.util.a.e(g11, "default_country_white");
            e23 = androidx.room.util.a.e(g11, "default_country_black");
            e24 = androidx.room.util.a.e(g11, "default_brand_white");
            g0Var = h11;
        } catch (Throwable th2) {
            th = th2;
            g0Var = h11;
        }
        try {
            int e25 = androidx.room.util.a.e(g11, "default_brand_black");
            int e26 = androidx.room.util.a.e(g11, "ad_bean");
            int i13 = e24;
            ArrayList arrayList = new ArrayList(g11.getCount());
            while (g11.moveToNext()) {
                String string3 = g11.isNull(e11) ? null : g11.getString(e11);
                String string4 = g11.isNull(e12) ? null : g11.getString(e12);
                int i14 = g11.getInt(e13);
                Double valueOf = g11.isNull(e14) ? null : Double.valueOf(g11.getDouble(e14));
                int i15 = g11.getInt(e15);
                int i16 = g11.getInt(e16);
                String string5 = g11.isNull(e17) ? null : g11.getString(e17);
                String string6 = g11.isNull(e18) ? null : g11.getString(e18);
                String string7 = g11.isNull(e19) ? null : g11.getString(e19);
                int i17 = g11.getInt(e20);
                String string8 = g11.isNull(e21) ? null : g11.getString(e21);
                String string9 = g11.isNull(e22) ? null : g11.getString(e22);
                if (g11.isNull(e23)) {
                    i11 = i13;
                    string = null;
                } else {
                    string = g11.getString(e23);
                    i11 = i13;
                }
                String string10 = g11.isNull(i11) ? null : g11.getString(i11);
                int i18 = e25;
                int i19 = e11;
                String string11 = g11.isNull(i18) ? null : g11.getString(i18);
                int i20 = e26;
                if (g11.isNull(i20)) {
                    i12 = i20;
                    string2 = null;
                } else {
                    string2 = g11.getString(i20);
                    i12 = i20;
                }
                arrayList.add(new g2(string3, string4, i14, valueOf, i15, i16, string5, string6, string7, i17, string8, string9, string, string10, string11, string2));
                e11 = i19;
                e25 = i18;
                e26 = i12;
                i13 = i11;
            }
            g11.close();
            g0Var.release();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            g11.close();
            g0Var.release();
            throw th;
        }
    }

    @Override // com.cloud.hisavana.sdk.c2
    public void a(int i11) {
        this.f22431a.j();
        a4.h b11 = this.f22438h.b();
        b11.c(1, i11);
        try {
            this.f22431a.k();
            try {
                b11.F();
                this.f22431a.e0();
            } finally {
                this.f22431a.t();
            }
        } finally {
            this.f22438h.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.c2
    public void a(g2 g2Var) {
        this.f22431a.j();
        this.f22431a.k();
        try {
            this.f22432b.l(g2Var);
            this.f22431a.e0();
        } finally {
            this.f22431a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.c2
    public void a(String str) {
        this.f22431a.j();
        a4.h b11 = this.f22435e.b();
        if (str == null) {
            b11.g(1);
        } else {
            b11.y(1, str);
        }
        try {
            this.f22431a.k();
            try {
                b11.F();
                this.f22431a.e0();
            } finally {
                this.f22431a.t();
            }
        } finally {
            this.f22435e.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.c2
    public void a(String str, String str2) {
        this.f22431a.j();
        a4.h b11 = this.f22434d.b();
        if (str == null) {
            b11.g(1);
        } else {
            b11.y(1, str);
        }
        if (str2 == null) {
            b11.g(2);
        } else {
            b11.y(2, str2);
        }
        try {
            this.f22431a.k();
            try {
                b11.F();
                this.f22431a.e0();
            } finally {
                this.f22431a.t();
            }
        } finally {
            this.f22434d.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.c2
    public void a(String str, String str2, String str3) {
        this.f22431a.j();
        a4.h b11 = this.f22437g.b();
        if (str3 == null) {
            b11.g(1);
        } else {
            b11.y(1, str3);
        }
        if (str == null) {
            b11.g(2);
        } else {
            b11.y(2, str);
        }
        if (str2 == null) {
            b11.g(3);
        } else {
            b11.y(3, str2);
        }
        try {
            this.f22431a.k();
            try {
                b11.F();
                this.f22431a.e0();
            } finally {
                this.f22431a.t();
            }
        } finally {
            this.f22437g.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.c2
    public void a(List list) {
        this.f22431a.j();
        StringBuilder b11 = androidx.room.util.n.b();
        b11.append("DELETE FROM default_ad_room WHERE codeSeatId NOT IN (");
        androidx.room.util.n.a(b11, list.size());
        b11.append(")");
        a4.h m11 = this.f22431a.m(b11.toString());
        Iterator it = list.iterator();
        int i11 = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                m11.g(i11);
            } else {
                m11.y(i11, str);
            }
            i11++;
        }
        this.f22431a.k();
        try {
            m11.F();
            this.f22431a.e0();
        } finally {
            this.f22431a.t();
        }
    }

    @Override // com.cloud.hisavana.sdk.c2
    public void b() {
        this.f22431a.j();
        a4.h b11 = this.f22439i.b();
        try {
            this.f22431a.k();
            try {
                b11.F();
                this.f22431a.e0();
            } finally {
                this.f22431a.t();
            }
        } finally {
            this.f22439i.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.c2
    public void b(String str) {
        this.f22431a.j();
        a4.h b11 = this.f22436f.b();
        if (str == null) {
            b11.g(1);
        } else {
            b11.y(1, str);
        }
        if (str == null) {
            b11.g(2);
        } else {
            b11.y(2, str);
        }
        try {
            this.f22431a.k();
            try {
                b11.F();
                this.f22431a.e0();
            } finally {
                this.f22431a.t();
            }
        } finally {
            this.f22436f.h(b11);
        }
    }

    @Override // com.cloud.hisavana.sdk.c2
    public void b(String str, String str2, int i11, String str3) {
        this.f22431a.j();
        a4.h b11 = this.f22433c.b();
        b11.c(1, i11);
        if (str3 == null) {
            b11.g(2);
        } else {
            b11.y(2, str3);
        }
        if (str == null) {
            b11.g(3);
        } else {
            b11.y(3, str);
        }
        if (str2 == null) {
            b11.g(4);
        } else {
            b11.y(4, str2);
        }
        try {
            this.f22431a.k();
            try {
                b11.F();
                this.f22431a.e0();
            } finally {
                this.f22431a.t();
            }
        } finally {
            this.f22433c.h(b11);
        }
    }
}
