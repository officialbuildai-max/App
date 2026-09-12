package com.transsion.ad.db.pslink;

import androidx.room.RoomDatabase;
import androidx.room.e;
import androidx.room.g;
import androidx.room.util.k;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.ad.db.pslink.AttributionPoint;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class b implements com.transsion.ad.db.pslink.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f42140a;

    /* renamed from: c, reason: collision with root package name */
    private final AttributionPoint.b f42142c = new AttributionPoint.b();

    /* renamed from: b, reason: collision with root package name */
    private final g f42141b = new a();

    /* renamed from: d, reason: collision with root package name */
    private final e f42143d = new C0595b();

    /* renamed from: e, reason: collision with root package name */
    private final e f42144e = new c();

    /* loaded from: classes5.dex */
    class a extends g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR ABORT INTO `attribution_points` (`id`,`psId`,`failCount`,`reportUrl`,`type`,`updateTimestamp`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, AttributionPoint attributionPoint) {
            eVar.c(1, attributionPoint.getId());
            if (attributionPoint.getPsId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, attributionPoint.getPsId());
            }
            eVar.c(3, attributionPoint.getFailCount());
            if (attributionPoint.getReportUrl() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, attributionPoint.getReportUrl());
            }
            String a11 = b.this.f42142c.a(attributionPoint.getType());
            if (a11 == null) {
                eVar.g(5);
            } else {
                eVar.j(5, a11);
            }
            eVar.c(6, attributionPoint.getUpdateTimestamp());
        }
    }

    /* renamed from: com.transsion.ad.db.pslink.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0595b extends e {
        C0595b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "DELETE FROM `attribution_points` WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, AttributionPoint attributionPoint) {
            eVar.c(1, attributionPoint.getId());
        }
    }

    /* loaded from: classes5.dex */
    class c extends e {
        c() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `attribution_points` SET `id` = ?,`psId` = ?,`failCount` = ?,`reportUrl` = ?,`type` = ?,`updateTimestamp` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, AttributionPoint attributionPoint) {
            eVar.c(1, attributionPoint.getId());
            if (attributionPoint.getPsId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, attributionPoint.getPsId());
            }
            eVar.c(3, attributionPoint.getFailCount());
            if (attributionPoint.getReportUrl() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, attributionPoint.getReportUrl());
            }
            String a11 = b.this.f42142c.a(attributionPoint.getType());
            if (a11 == null) {
                eVar.g(5);
            } else {
                eVar.j(5, a11);
            }
            eVar.c(6, attributionPoint.getUpdateTimestamp());
            eVar.c(7, attributionPoint.getId());
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f42140a = roomDatabase;
    }

    public static List l() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit m(AttributionPoint attributionPoint, z3.b bVar) {
        this.f42143d.c(bVar, attributionPoint);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AttributionPoint n(long j11, long j12, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM attribution_points WHERE ? - updateTimestamp >= ? ORDER BY CASE type WHEN 'CLICK' THEN 0 ELSE 1 END, failCount ASC, updateTimestamp DESC LIMIT 1");
        try {
            D0.c(1, j11);
            D0.c(2, j12);
            int d11 = k.d(D0, "id");
            int d12 = k.d(D0, "psId");
            int d13 = k.d(D0, "failCount");
            int d14 = k.d(D0, "reportUrl");
            int d15 = k.d(D0, NativeComponentConstants.KEY_COMPONENT_TYPE);
            int d16 = k.d(D0, "updateTimestamp");
            AttributionPoint attributionPoint = null;
            if (D0.A0()) {
                try {
                    attributionPoint = new AttributionPoint((int) D0.getLong(d11), D0.isNull(d12) ? null : D0.n0(d12), (int) D0.getLong(d13), D0.isNull(d14) ? null : D0.n0(d14), this.f42142c.b(D0.isNull(d15) ? null : D0.n0(d15)), D0.getLong(d16));
                } catch (Throwable th2) {
                    th = th2;
                    D0.close();
                    throw th;
                }
            }
            D0.close();
            return attributionPoint;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit o(AttributionPoint attributionPoint, z3.b bVar) {
        this.f42141b.d(bVar, attributionPoint);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean p(String str, AttributionPoint.AttributionType attributionType, String str2, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT EXISTS(SELECT 1 FROM attribution_points WHERE psId = ? AND type = ? AND reportUrl = ?)");
        boolean z10 = true;
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            String a11 = this.f42142c.a(attributionType);
            if (a11 == null) {
                D0.g(2);
            } else {
                D0.j(2, a11);
            }
            if (str2 == null) {
                D0.g(3);
            } else {
                D0.j(3, str2);
            }
            Boolean bool = null;
            if (D0.A0()) {
                Integer valueOf = D0.isNull(0) ? null : Integer.valueOf((int) D0.getLong(0));
                if (valueOf != null) {
                    if (valueOf.intValue() == 0) {
                        z10 = false;
                    }
                    bool = Boolean.valueOf(z10);
                }
            }
            return bool;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit q(AttributionPoint attributionPoint, z3.b bVar) {
        this.f42144e.c(bVar, attributionPoint);
        return Unit.f67184a;
    }

    @Override // com.transsion.ad.db.pslink.a
    public Object a(final AttributionPoint attributionPoint, Continuation continuation) {
        attributionPoint.getClass();
        return androidx.room.util.b.f(this.f42140a, false, true, new Function1() { // from class: mi.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m11;
                m11 = com.transsion.ad.db.pslink.b.this.m(attributionPoint, (z3.b) obj);
                return m11;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.pslink.a
    public Object b(final AttributionPoint attributionPoint, Continuation continuation) {
        attributionPoint.getClass();
        return androidx.room.util.b.f(this.f42140a, false, true, new Function1() { // from class: mi.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit q11;
                q11 = com.transsion.ad.db.pslink.b.this.q(attributionPoint, (z3.b) obj);
                return q11;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.pslink.a
    public Object c(final String str, final AttributionPoint.AttributionType attributionType, final String str2, Continuation continuation) {
        return androidx.room.util.b.f(this.f42140a, true, false, new Function1() { // from class: mi.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean p11;
                p11 = com.transsion.ad.db.pslink.b.this.p(str, attributionType, str2, (z3.b) obj);
                return p11;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.pslink.a
    public Object d(final long j11, final long j12, Continuation continuation) {
        return androidx.room.util.b.f(this.f42140a, true, false, new Function1() { // from class: mi.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                AttributionPoint n11;
                n11 = com.transsion.ad.db.pslink.b.this.n(j11, j12, (z3.b) obj);
                return n11;
            }
        }, continuation);
    }

    @Override // com.transsion.ad.db.pslink.a
    public Object e(final AttributionPoint attributionPoint, Continuation continuation) {
        attributionPoint.getClass();
        return androidx.room.util.b.f(this.f42140a, false, true, new Function1() { // from class: mi.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o11;
                o11 = com.transsion.ad.db.pslink.b.this.o(attributionPoint, (z3.b) obj);
                return o11;
            }
        }, continuation);
    }
}
