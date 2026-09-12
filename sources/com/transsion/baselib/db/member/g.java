package com.transsion.baselib.db.member;

import androidx.room.RoomDatabase;
import androidx.room.util.j;
import androidx.room.util.k;
import com.transsion.baselib.db.member.MemberResolutionDao;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class g implements MemberResolutionDao {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f43150a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.room.g f43151b = new a();

    /* loaded from: classes5.dex */
    class a extends androidx.room.g {
        a() {
        }

        @Override // androidx.room.g
        protected String b() {
            return "INSERT OR ABORT INTO `member_resolution` (`subjectId`,`ep`,`se`,`vipResolutionTip`,`isUnlock`) VALUES (?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(z3.e eVar, MemberResolutionBean memberResolutionBean) {
            if (memberResolutionBean.getSubjectId() == null) {
                eVar.g(1);
            } else {
                eVar.j(1, memberResolutionBean.getSubjectId());
            }
            eVar.c(2, memberResolutionBean.getEp());
            eVar.c(3, memberResolutionBean.getSe());
            if ((memberResolutionBean.getVipResolutionTip() == null ? null : Integer.valueOf(memberResolutionBean.getVipResolutionTip().booleanValue() ? 1 : 0)) == null) {
                eVar.g(4);
            } else {
                eVar.c(4, r0.intValue());
            }
            if ((memberResolutionBean.isUnlock() != null ? Integer.valueOf(memberResolutionBean.isUnlock().booleanValue() ? 1 : 0) : null) == null) {
                eVar.g(5);
            } else {
                eVar.c(5, r1.intValue());
            }
        }
    }

    public g(RoomDatabase roomDatabase) {
        this.f43150a = roomDatabase;
    }

    public static List m() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit n(MemberResolutionBean memberResolutionBean, z3.b bVar) {
        this.f43151b.d(bVar, memberResolutionBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MemberResolutionBean o(String str, int i11, int i12, z3.b bVar) {
        Boolean valueOf;
        z3.e D0 = bVar.D0("\n        SELECT * FROM member_resolution\n        WHERE subjectId = ?\n          AND se = ?\n          AND ep = ?\n        LIMIT 1\n    ");
        boolean z10 = true;
        try {
            if (str == null) {
                D0.g(1);
            } else {
                D0.j(1, str);
            }
            D0.c(2, i11);
            D0.c(3, i12);
            int d11 = k.d(D0, "subjectId");
            int d12 = k.d(D0, "ep");
            int d13 = k.d(D0, "se");
            int d14 = k.d(D0, "vipResolutionTip");
            int d15 = k.d(D0, "isUnlock");
            MemberResolutionBean memberResolutionBean = null;
            Boolean valueOf2 = null;
            if (D0.A0()) {
                String n02 = D0.isNull(d11) ? null : D0.n0(d11);
                int i13 = (int) D0.getLong(d12);
                int i14 = (int) D0.getLong(d13);
                Integer valueOf3 = D0.isNull(d14) ? null : Integer.valueOf((int) D0.getLong(d14));
                if (valueOf3 == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(valueOf3.intValue() != 0);
                }
                Integer valueOf4 = D0.isNull(d15) ? null : Integer.valueOf((int) D0.getLong(d15));
                if (valueOf4 != null) {
                    if (valueOf4.intValue() == 0) {
                        z10 = false;
                    }
                    valueOf2 = Boolean.valueOf(z10);
                }
                memberResolutionBean = new MemberResolutionBean(n02, i13, i14, valueOf, valueOf2);
            }
            D0.close();
            return memberResolutionBean;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer p(boolean z10, String str, int i11, int i12, z3.b bVar) {
        z3.e D0 = bVar.D0("\n        UPDATE member_resolution\n        SET isUnlock = ?\n        WHERE subjectId = ?\n          AND se = ?\n          AND ep = ?\n    ");
        try {
            D0.c(1, z10 ? 1L : 0L);
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
            }
            D0.c(3, i11);
            D0.c(4, i12);
            D0.A0();
            Integer valueOf = Integer.valueOf(j.b(bVar));
            D0.close();
            return valueOf;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(String str, int i11, int i12, boolean z10, Continuation continuation) {
        return MemberResolutionDao.DefaultImpls.a(this, str, i11, i12, z10, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer r(boolean z10, String str, int i11, int i12, z3.b bVar) {
        z3.e D0 = bVar.D0("\n        UPDATE member_resolution\n        SET vipResolutionTip = ?\n        WHERE subjectId = ?\n          AND se = ?\n          AND ep = ?\n    ");
        try {
            D0.c(1, z10 ? 1L : 0L);
            if (str == null) {
                D0.g(2);
            } else {
                D0.j(2, str);
            }
            D0.c(3, i11);
            D0.c(4, i12);
            D0.A0();
            Integer valueOf = Integer.valueOf(j.b(bVar));
            D0.close();
            return valueOf;
        } catch (Throwable th2) {
            D0.close();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(String str, int i11, int i12, boolean z10, Continuation continuation) {
        return MemberResolutionDao.DefaultImpls.b(this, str, i11, i12, z10, continuation);
    }

    @Override // com.transsion.baselib.db.member.MemberResolutionDao
    public Object a(final String str, final int i11, final int i12, final boolean z10, Continuation continuation) {
        return androidx.room.util.b.e(this.f43150a, new Function1() { // from class: com.transsion.baselib.db.member.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object s11;
                s11 = g.this.s(str, i11, i12, z10, (Continuation) obj);
                return s11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.member.MemberResolutionDao
    public Object b(final String str, final int i11, final int i12, Continuation continuation) {
        return androidx.room.util.b.f(this.f43150a, true, false, new Function1() { // from class: com.transsion.baselib.db.member.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MemberResolutionBean o11;
                o11 = g.o(str, i11, i12, (z3.b) obj);
                return o11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.member.MemberResolutionDao
    public Object c(final String str, final int i11, final int i12, final boolean z10, Continuation continuation) {
        return androidx.room.util.b.f(this.f43150a, false, true, new Function1() { // from class: com.transsion.baselib.db.member.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Integer r11;
                r11 = g.r(z10, str, i11, i12, (z3.b) obj);
                return r11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.member.MemberResolutionDao
    public Object d(final MemberResolutionBean memberResolutionBean, Continuation continuation) {
        memberResolutionBean.getClass();
        return androidx.room.util.b.f(this.f43150a, false, true, new Function1() { // from class: com.transsion.baselib.db.member.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n11;
                n11 = g.this.n(memberResolutionBean, (z3.b) obj);
                return n11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.member.MemberResolutionDao
    public Object e(final String str, final int i11, final int i12, final boolean z10, Continuation continuation) {
        return androidx.room.util.b.f(this.f43150a, false, true, new Function1() { // from class: com.transsion.baselib.db.member.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Integer p11;
                p11 = g.p(z10, str, i11, i12, (z3.b) obj);
                return p11;
            }
        }, continuation);
    }

    @Override // com.transsion.baselib.db.member.MemberResolutionDao
    public Object f(final String str, final int i11, final int i12, final boolean z10, Continuation continuation) {
        return androidx.room.util.b.e(this.f43150a, new Function1() { // from class: com.transsion.baselib.db.member.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object q11;
                q11 = g.this.q(str, i11, i12, z10, (Continuation) obj);
                return q11;
            }
        }, continuation);
    }
}
