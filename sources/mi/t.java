package mi;

import androidx.room.RoomDatabase;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes6.dex */
public final class t implements l {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f69725a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f69726b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final androidx.room.e f69727c = new b();

    /* loaded from: classes6.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR REPLACE INTO `ps_link_ad` (`id`,`nonId`,`adSource`,`extAdSlot`,`rank`,`psPlanId`,`psLinkAdInfoStr`,`psInfoJson`,`updateTimestamp`,`showMax`,`clickMax`,`showHours`,`showedTimes`,`clickedTimes`,`showDate`,`isOffer`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, PsLinkAdPlan psLinkAdPlan) {
            eVar.c(1, psLinkAdPlan.getId());
            if (psLinkAdPlan.getNonId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, psLinkAdPlan.getNonId());
            }
            if (psLinkAdPlan.getAdSource() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, psLinkAdPlan.getAdSource());
            }
            if (psLinkAdPlan.getExtAdSlot() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, psLinkAdPlan.getExtAdSlot());
            }
            eVar.c(5, psLinkAdPlan.getRank());
            if (psLinkAdPlan.getPsPlanId() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, psLinkAdPlan.getPsPlanId());
            }
            if (psLinkAdPlan.getPsLinkAdInfoStr() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, psLinkAdPlan.getPsLinkAdInfoStr());
            }
            if (psLinkAdPlan.getPsInfoJson() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, psLinkAdPlan.getPsInfoJson());
            }
            if (psLinkAdPlan.getUpdateTimestamp() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, psLinkAdPlan.getUpdateTimestamp().longValue());
            }
            if (psLinkAdPlan.getShowMax() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, psLinkAdPlan.getShowMax().intValue());
            }
            if (psLinkAdPlan.getClickMax() == null) {
                eVar.g(11);
            } else {
                eVar.c(11, psLinkAdPlan.getClickMax().intValue());
            }
            if (psLinkAdPlan.getShowHours() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, psLinkAdPlan.getShowHours());
            }
            eVar.c(13, psLinkAdPlan.getShowedTimes());
            eVar.c(14, psLinkAdPlan.getClickedTimes());
            if (psLinkAdPlan.getShowDate() == null) {
                eVar.g(15);
            } else {
                eVar.j(15, psLinkAdPlan.getShowDate());
            }
            eVar.c(16, psLinkAdPlan.isOffer());
        }
    }

    /* loaded from: classes6.dex */
    class b extends androidx.room.e {
        b() {
        }

        @Override // androidx.room.e
        protected String b() {
            return "UPDATE OR ABORT `ps_link_ad` SET `id` = ?,`nonId` = ?,`adSource` = ?,`extAdSlot` = ?,`rank` = ?,`psPlanId` = ?,`psLinkAdInfoStr` = ?,`psInfoJson` = ?,`updateTimestamp` = ?,`showMax` = ?,`clickMax` = ?,`showHours` = ?,`showedTimes` = ?,`clickedTimes` = ?,`showDate` = ?,`isOffer` = ? WHERE `id` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, PsLinkAdPlan psLinkAdPlan) {
            eVar.c(1, psLinkAdPlan.getId());
            if (psLinkAdPlan.getNonId() == null) {
                eVar.g(2);
            } else {
                eVar.j(2, psLinkAdPlan.getNonId());
            }
            if (psLinkAdPlan.getAdSource() == null) {
                eVar.g(3);
            } else {
                eVar.j(3, psLinkAdPlan.getAdSource());
            }
            if (psLinkAdPlan.getExtAdSlot() == null) {
                eVar.g(4);
            } else {
                eVar.j(4, psLinkAdPlan.getExtAdSlot());
            }
            eVar.c(5, psLinkAdPlan.getRank());
            if (psLinkAdPlan.getPsPlanId() == null) {
                eVar.g(6);
            } else {
                eVar.j(6, psLinkAdPlan.getPsPlanId());
            }
            if (psLinkAdPlan.getPsLinkAdInfoStr() == null) {
                eVar.g(7);
            } else {
                eVar.j(7, psLinkAdPlan.getPsLinkAdInfoStr());
            }
            if (psLinkAdPlan.getPsInfoJson() == null) {
                eVar.g(8);
            } else {
                eVar.j(8, psLinkAdPlan.getPsInfoJson());
            }
            if (psLinkAdPlan.getUpdateTimestamp() == null) {
                eVar.g(9);
            } else {
                eVar.c(9, psLinkAdPlan.getUpdateTimestamp().longValue());
            }
            if (psLinkAdPlan.getShowMax() == null) {
                eVar.g(10);
            } else {
                eVar.c(10, psLinkAdPlan.getShowMax().intValue());
            }
            if (psLinkAdPlan.getClickMax() == null) {
                eVar.g(11);
            } else {
                eVar.c(11, psLinkAdPlan.getClickMax().intValue());
            }
            if (psLinkAdPlan.getShowHours() == null) {
                eVar.g(12);
            } else {
                eVar.j(12, psLinkAdPlan.getShowHours());
            }
            eVar.c(13, psLinkAdPlan.getShowedTimes());
            eVar.c(14, psLinkAdPlan.getClickedTimes());
            if (psLinkAdPlan.getShowDate() == null) {
                eVar.g(15);
            } else {
                eVar.j(15, psLinkAdPlan.getShowDate());
            }
            eVar.c(16, psLinkAdPlan.isOffer());
            eVar.c(17, psLinkAdPlan.getId());
        }
    }

    public t(RoomDatabase roomDatabase) {
        this.f69725a = roomDatabase;
    }

    public static List o() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit p(String str, String str2, List list, z3.b bVar) {
        z3.e D0 = bVar.D0(str);
        try {
            if (str2 == null) {
                D0.g(1);
            } else {
                D0.j(1, str2);
            }
            Iterator it = list.iterator();
            int i11 = 2;
            while (it.hasNext()) {
                if (((Integer) it.next()) == null) {
                    D0.g(i11);
                } else {
                    D0.c(i11, r5.intValue());
                }
                i11++;
            }
            D0.A0();
            Unit unit = Unit.f67184a;
            D0.close();
            return unit;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List q(z3.b bVar) {
        int i11;
        String n02;
        int i12;
        int i13;
        Integer valueOf;
        z3.e D0 = bVar.D0("SELECT * FROM ps_link_ad");
        try {
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "nonId");
            int d13 = androidx.room.util.k.d(D0, "adSource");
            int d14 = androidx.room.util.k.d(D0, "extAdSlot");
            int d15 = androidx.room.util.k.d(D0, "rank");
            int d16 = androidx.room.util.k.d(D0, "psPlanId");
            int d17 = androidx.room.util.k.d(D0, "psLinkAdInfoStr");
            int d18 = androidx.room.util.k.d(D0, "psInfoJson");
            int d19 = androidx.room.util.k.d(D0, "updateTimestamp");
            int d20 = androidx.room.util.k.d(D0, "showMax");
            int d21 = androidx.room.util.k.d(D0, "clickMax");
            int d22 = androidx.room.util.k.d(D0, "showHours");
            int d23 = androidx.room.util.k.d(D0, "showedTimes");
            int d24 = androidx.room.util.k.d(D0, "clickedTimes");
            int d25 = androidx.room.util.k.d(D0, "showDate");
            int d26 = androidx.room.util.k.d(D0, "isOffer");
            ArrayList arrayList = new ArrayList();
            while (D0.A0()) {
                int i14 = d24;
                ArrayList arrayList2 = arrayList;
                int i15 = (int) D0.getLong(d11);
                String n03 = D0.isNull(d12) ? null : D0.n0(d12);
                String n04 = D0.isNull(d13) ? null : D0.n0(d13);
                if (D0.isNull(d14)) {
                    i12 = d12;
                    i11 = d13;
                    n02 = null;
                } else {
                    i11 = d13;
                    n02 = D0.n0(d14);
                    i12 = d12;
                }
                int i16 = (int) D0.getLong(d15);
                String n05 = D0.isNull(d16) ? null : D0.n0(d16);
                String n06 = D0.isNull(d17) ? null : D0.n0(d17);
                String n07 = D0.isNull(d18) ? null : D0.n0(d18);
                Long valueOf2 = D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19));
                if (D0.isNull(d20)) {
                    i13 = d14;
                    valueOf = null;
                } else {
                    i13 = d14;
                    valueOf = Integer.valueOf((int) D0.getLong(d20));
                }
                int i17 = d16;
                int i18 = d15;
                int i19 = d25;
                int i20 = d11;
                int i21 = d26;
                int i22 = d17;
                arrayList2.add(new PsLinkAdPlan(i15, n03, n04, n02, i16, n05, n06, n07, valueOf2, valueOf, D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21)), D0.isNull(d22) ? null : D0.n0(d22), (int) D0.getLong(d23), (int) D0.getLong(i14), D0.isNull(i19) ? null : D0.n0(i19), (int) D0.getLong(i21)));
                d24 = i14;
                d17 = i22;
                d15 = i18;
                d13 = i11;
                d14 = i13;
                d16 = i17;
                d26 = i21;
                d11 = i20;
                d25 = i19;
                int i23 = i12;
                arrayList = arrayList2;
                d12 = i23;
            }
            return arrayList;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer r(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT COUNT(*) FROM ps_link_ad WHERE extAdSlot = ?");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            Integer num = null;
            if (D0.A0() && !D0.isNull(0)) {
                num = Integer.valueOf((int) D0.getLong(0));
            }
            return num;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PsLinkAdPlan s(int i11, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM ps_link_ad WHERE id =?");
        try {
            D0.c(1, i11);
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "nonId");
            int d13 = androidx.room.util.k.d(D0, "adSource");
            int d14 = androidx.room.util.k.d(D0, "extAdSlot");
            int d15 = androidx.room.util.k.d(D0, "rank");
            int d16 = androidx.room.util.k.d(D0, "psPlanId");
            int d17 = androidx.room.util.k.d(D0, "psLinkAdInfoStr");
            int d18 = androidx.room.util.k.d(D0, "psInfoJson");
            int d19 = androidx.room.util.k.d(D0, "updateTimestamp");
            int d20 = androidx.room.util.k.d(D0, "showMax");
            int d21 = androidx.room.util.k.d(D0, "clickMax");
            int d22 = androidx.room.util.k.d(D0, "showHours");
            int d23 = androidx.room.util.k.d(D0, "showedTimes");
            int d24 = androidx.room.util.k.d(D0, "clickedTimes");
            int d25 = androidx.room.util.k.d(D0, "showDate");
            int d26 = androidx.room.util.k.d(D0, "isOffer");
            PsLinkAdPlan psLinkAdPlan = null;
            if (D0.A0()) {
                psLinkAdPlan = new PsLinkAdPlan((int) D0.getLong(d11), D0.isNull(d12) ? null : D0.n0(d12), D0.isNull(d13) ? null : D0.n0(d13), D0.isNull(d14) ? null : D0.n0(d14), (int) D0.getLong(d15), D0.isNull(d16) ? null : D0.n0(d16), D0.isNull(d17) ? null : D0.n0(d17), D0.isNull(d18) ? null : D0.n0(d18), D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19)), D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20)), D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21)), D0.isNull(d22) ? null : D0.n0(d22), (int) D0.getLong(d23), (int) D0.getLong(d24), D0.isNull(d25) ? null : D0.n0(d25), (int) D0.getLong(d26));
            }
            return psLinkAdPlan;
        } finally {
            D0.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PsLinkAdPlan t(String str, z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT * FROM ps_link_ad WHERE extAdSlot = ? ORDER BY updateTimestamp ASC LIMIT 1");
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            int d11 = androidx.room.util.k.d(D0, "id");
            int d12 = androidx.room.util.k.d(D0, "nonId");
            int d13 = androidx.room.util.k.d(D0, "adSource");
            int d14 = androidx.room.util.k.d(D0, "extAdSlot");
            int d15 = androidx.room.util.k.d(D0, "rank");
            int d16 = androidx.room.util.k.d(D0, "psPlanId");
            int d17 = androidx.room.util.k.d(D0, "psLinkAdInfoStr");
            int d18 = androidx.room.util.k.d(D0, "psInfoJson");
            int d19 = androidx.room.util.k.d(D0, "updateTimestamp");
            int d20 = androidx.room.util.k.d(D0, "showMax");
            int d21 = androidx.room.util.k.d(D0, "clickMax");
            int d22 = androidx.room.util.k.d(D0, "showHours");
            int d23 = androidx.room.util.k.d(D0, "showedTimes");
            int d24 = androidx.room.util.k.d(D0, "clickedTimes");
            int d25 = androidx.room.util.k.d(D0, "showDate");
            int d26 = androidx.room.util.k.d(D0, "isOffer");
            PsLinkAdPlan psLinkAdPlan = null;
            if (D0.A0()) {
                psLinkAdPlan = new PsLinkAdPlan((int) D0.getLong(d11), D0.isNull(d12) ? null : D0.n0(d12), D0.isNull(d13) ? null : D0.n0(d13), D0.isNull(d14) ? null : D0.n0(d14), (int) D0.getLong(d15), D0.isNull(d16) ? null : D0.n0(d16), D0.isNull(d17) ? null : D0.n0(d17), D0.isNull(d18) ? null : D0.n0(d18), D0.isNull(d19) ? null : Long.valueOf(D0.getLong(d19)), D0.isNull(d20) ? null : Integer.valueOf((int) D0.getLong(d20)), D0.isNull(d21) ? null : Integer.valueOf((int) D0.getLong(d21)), D0.isNull(d22) ? null : D0.n0(d22), (int) D0.getLong(d23), (int) D0.getLong(d24), D0.isNull(d25) ? null : D0.n0(d25), (int) D0.getLong(d26));
            }
            D0.close();
            return psLinkAdPlan;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit u(PsLinkAdPlan psLinkAdPlan, z3.b bVar) {
        this.f69726b.d(bVar, psLinkAdPlan);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit v(PsLinkAdPlan psLinkAdPlan, z3.b bVar) {
        this.f69727c.c(bVar, psLinkAdPlan);
        return Unit.f67184a;
    }

    @Override // mi.l
    public Object a(Continuation continuation) {
        return androidx.room.util.b.f(this.f69725a, true, false, new Function1() { // from class: mi.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List q11;
                q11 = t.q((z3.b) obj);
                return q11;
            }
        }, continuation);
    }

    @Override // mi.l
    public Object b(final PsLinkAdPlan psLinkAdPlan, Continuation continuation) {
        psLinkAdPlan.getClass();
        return androidx.room.util.b.f(this.f69725a, false, true, new Function1() { // from class: mi.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u11;
                u11 = t.this.u(psLinkAdPlan, (z3.b) obj);
                return u11;
            }
        }, continuation);
    }

    @Override // mi.l
    public Object c(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69725a, true, false, new Function1() { // from class: mi.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Integer r11;
                r11 = t.r(str, (z3.b) obj);
                return r11;
            }
        }, continuation);
    }

    @Override // mi.l
    public Object d(final String str, final List list, Continuation continuation) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n");
        sb2.append("    DELETE FROM ps_link_ad ");
        sb2.append("\n");
        sb2.append("    WHERE extAdSlot = ");
        sb2.append(UrlUtils.QUESTION_MARK);
        sb2.append(" ");
        sb2.append("\n");
        sb2.append("      AND id NOT IN (");
        androidx.room.util.n.a(sb2, list.size());
        sb2.append(")");
        sb2.append("\n");
        final String sb3 = sb2.toString();
        return androidx.room.util.b.f(this.f69725a, false, true, new Function1() { // from class: mi.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p11;
                p11 = t.p(sb3, str, list, (z3.b) obj);
                return p11;
            }
        }, continuation);
    }

    @Override // mi.l
    public Object e(final PsLinkAdPlan psLinkAdPlan, Continuation continuation) {
        psLinkAdPlan.getClass();
        return androidx.room.util.b.f(this.f69725a, false, true, new Function1() { // from class: mi.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v11;
                v11 = t.this.v(psLinkAdPlan, (z3.b) obj);
                return v11;
            }
        }, continuation);
    }

    @Override // mi.l
    public Object f(final int i11, Continuation continuation) {
        return androidx.room.util.b.f(this.f69725a, true, false, new Function1() { // from class: mi.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                PsLinkAdPlan s11;
                s11 = t.s(i11, (z3.b) obj);
                return s11;
            }
        }, continuation);
    }

    @Override // mi.l
    public Object g(final String str, Continuation continuation) {
        return androidx.room.util.b.f(this.f69725a, true, false, new Function1() { // from class: mi.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                PsLinkAdPlan t11;
                t11 = t.t(str, (z3.b) obj);
                return t11;
            }
        }, continuation);
    }
}
