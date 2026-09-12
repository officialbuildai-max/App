package com.transsion.usercenter.profile.see;

import android.app.Application;
import androidx.view.LiveData;
import androidx.view.b0;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.usercenter.profile.b;
import com.transsion.usercenter.profile.see.bean.ProfileSeeMultiItemData;
import com.transsnet.downloader.viewmodel.a0;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class h extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f57407b;

    /* renamed from: c, reason: collision with root package name */
    private int f57408c;

    /* renamed from: d, reason: collision with root package name */
    private int f57409d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList f57410e;

    /* renamed from: f, reason: collision with root package name */
    private final b0 f57411f;

    /* renamed from: g, reason: collision with root package name */
    private final b0 f57412g;

    /* renamed from: h, reason: collision with root package name */
    private final b0 f57413h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements lz.h {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x00bd, code lost:
        
            if (r6 == null) goto L30;
         */
        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final io.reactivex.rxjava3.core.m apply(com.tn.lib.net.bean.BaseDto r12) {
            /*
                r11 = this;
                r0 = 2
                r1 = 0
                r2 = 1
                java.lang.String r3 = "it"
                kotlin.jvm.internal.Intrinsics.h(r12, r3)
                java.lang.Object r3 = r12.getData()
                com.transsion.usercenter.profile.see.bean.ProfileSeeData r3 = (com.transsion.usercenter.profile.see.bean.ProfileSeeData) r3
                r4 = 0
                if (r3 == 0) goto Lbf
                com.transsion.usercenter.profile.see.h r5 = com.transsion.usercenter.profile.see.h.this
                java.util.List r3 = r3.getItems()
                if (r3 == 0) goto Lbc
                java.lang.Iterable r3 = (java.lang.Iterable) r3
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.Iterator r3 = r3.iterator()
            L24:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto Lbd
                java.lang.Object r7 = r3.next()
                com.transsion.usercenter.profile.see.bean.ProfileSeeItem r7 = (com.transsion.usercenter.profile.see.bean.ProfileSeeItem) r7
                com.transsion.usercenter.profile.see.bean.ProfileSeeSubjectItem r8 = r7.getSubject()
                com.transsion.usercenter.profile.see.bean.ProfileSeeStaffItem r7 = r7.getStaff()
                r9 = 0
                if (r8 == 0) goto L74
                java.lang.String r7 = r8.getMySeeTime()
                if (r7 == 0) goto L46
                long r9 = java.lang.Long.parseLong(r7)
            L46:
                java.lang.String r7 = com.transsion.usercenter.profile.see.h.d(r5, r9)
                java.util.ArrayList r9 = com.transsion.usercenter.profile.see.h.f(r5)
                boolean r9 = r9.contains(r7)
                if (r9 == 0) goto L5d
                n6.a[] r7 = new n6.a[r2]
                r7[r1] = r8
                java.util.ArrayList r7 = kotlin.collections.CollectionsKt.h(r7)
                goto Lb2
            L5d:
                java.util.ArrayList r9 = com.transsion.usercenter.profile.see.h.f(r5)
                r9.add(r7)
                com.transsion.usercenter.profile.see.bean.ProfileSeeTimeItem r9 = new com.transsion.usercenter.profile.see.bean.ProfileSeeTimeItem
                r9.<init>(r7)
                n6.a[] r7 = new n6.a[r0]
                r7[r1] = r9
                r7[r2] = r8
                java.util.ArrayList r7 = kotlin.collections.CollectionsKt.h(r7)
                goto Lb2
            L74:
                if (r7 == 0) goto Lae
                java.lang.String r8 = r7.getMySeeTime()
                if (r8 == 0) goto L80
                long r9 = java.lang.Long.parseLong(r8)
            L80:
                java.lang.String r8 = com.transsion.usercenter.profile.see.h.d(r5, r9)
                java.util.ArrayList r9 = com.transsion.usercenter.profile.see.h.f(r5)
                boolean r9 = r9.contains(r8)
                if (r9 == 0) goto L97
                n6.a[] r8 = new n6.a[r2]
                r8[r1] = r7
                java.util.ArrayList r7 = kotlin.collections.CollectionsKt.h(r8)
                goto Lb2
            L97:
                java.util.ArrayList r9 = com.transsion.usercenter.profile.see.h.f(r5)
                r9.add(r8)
                com.transsion.usercenter.profile.see.bean.ProfileSeeTimeItem r9 = new com.transsion.usercenter.profile.see.bean.ProfileSeeTimeItem
                r9.<init>(r8)
                n6.a[] r8 = new n6.a[r0]
                r8[r1] = r9
                r8[r2] = r7
                java.util.ArrayList r7 = kotlin.collections.CollectionsKt.h(r8)
                goto Lb2
            Lae:
                java.util.List r7 = java.util.Collections.emptyList()
            Lb2:
                kotlin.jvm.internal.Intrinsics.e(r7)
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                kotlin.collections.CollectionsKt.B(r6, r7)
                goto L24
            Lbc:
                r6 = r4
            Lbd:
                if (r6 != 0) goto Lc4
            Lbf:
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
            Lc4:
                com.tn.lib.net.bean.BaseDto r0 = new com.tn.lib.net.bean.BaseDto
                r0.<init>()
                com.transsion.usercenter.profile.see.bean.ProfileSeeMultiItemData r1 = new com.transsion.usercenter.profile.see.bean.ProfileSeeMultiItemData
                java.lang.Object r2 = r12.getData()
                com.transsion.usercenter.profile.see.bean.ProfileSeeData r2 = (com.transsion.usercenter.profile.see.bean.ProfileSeeData) r2
                if (r2 == 0) goto Ld7
                com.transsion.moviedetailapi.bean.Pager r4 = r2.getPager()
            Ld7:
                r1.<init>(r4, r6)
                r0.setData(r1)
                java.lang.String r1 = r12.getCode()
                r0.setCode(r1)
                java.lang.String r1 = r12.getMsg()
                r0.setMsg(r1)
                java.lang.String r12 = r12.getReason()
                r0.setReason(r12)
                io.reactivex.rxjava3.core.j r12 = io.reactivex.rxjava3.core.j.t(r0)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.profile.see.h.a.apply(com.tn.lib.net.bean.BaseDto):io.reactivex.rxjava3.core.m");
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends sg.a {
        b() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            h.this.f57411f.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(ProfileSeeMultiItemData profileSeeMultiItemData) {
            Pager pager;
            super.c(profileSeeMultiItemData);
            h.this.f57411f.q(profileSeeMultiItemData);
            if (profileSeeMultiItemData == null || (pager = profileSeeMultiItemData.getPager()) == null) {
                return;
            }
            h hVar = h.this;
            String nextPage = pager.getNextPage();
            hVar.f57408c = nextPage != null ? Integer.parseInt(nextPage) : 1;
            Integer perPage = pager.getPerPage();
            hVar.f57409d = perPage != null ? perPage.intValue() : 10;
            b0 b0Var = hVar.f57413h;
            int totalCount = pager.getTotalCount();
            if (totalCount == null) {
                totalCount = 0;
            }
            b0Var.q(totalCount);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f57407b = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.usercenter.profile.see.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.transsion.usercenter.profile.b p11;
                p11 = h.p();
                return p11;
            }
        });
        this.f57408c = 1;
        this.f57409d = 10;
        this.f57410e = new ArrayList();
        this.f57411f = new b0();
        this.f57412g = new b0();
        this.f57413h = new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j(long j11) {
        return a0.f60208a.z(j11 * 1000);
    }

    private final com.transsion.usercenter.profile.b m() {
        return (com.transsion.usercenter.profile.b) this.f57407b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.usercenter.profile.b p() {
        return (com.transsion.usercenter.profile.b) zg.c.f79537e.a().h(com.transsion.usercenter.profile.b.class);
    }

    public final LiveData k() {
        return this.f57413h;
    }

    public final LiveData l() {
        return this.f57412g;
    }

    public final LiveData n() {
        return this.f57411f;
    }

    public final void o(String userId, int i11) {
        Intrinsics.h(userId, "userId");
        b.a.i(m(), userId, this.f57408c, this.f57409d, i11, null, 16, null).n(new a()).f(sg.d.f75472a.c()).subscribe(new b());
    }

    public final void q(String userId, int i11) {
        Intrinsics.h(userId, "userId");
        this.f57408c = 1;
        this.f57409d = 10;
        this.f57410e.clear();
        o(userId, i11);
    }
}
