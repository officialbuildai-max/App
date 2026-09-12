package com.transsion.member;

import android.app.Application;
import androidx.view.LiveData;
import com.therouter.TheRouter;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.member.bean.request.InviteUserShareInfoReq;
import com.transsion.member.constants.TaskType;
import com.transsion.memberapi.AllMemberRightsData;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.memberapi.MemberAdTaskInfo;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberPriceData;
import com.transsion.memberapi.MemberTaskGroup;
import com.transsion.memberapi.MemberTaskInfo;
import com.transsion.memberapi.MemberTaskInviteRewards;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskItemInvite;
import com.transsion.memberapi.MemberTaskRewardInfo;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import com.transsion.memberapi.SkuData;
import com.transsion.memberapi.SkuItem;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import vm.a;
import zm.c;

/* loaded from: classes5.dex */
public final class MemberViewModel extends androidx.view.b {

    /* renamed from: t, reason: collision with root package name */
    public static final a f46412t = new a(null);

    /* renamed from: u, reason: collision with root package name */
    public static final int f46413u = 8;

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f46414b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f46415c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f46416d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.view.b0 f46417e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.view.b0 f46418f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.view.b0 f46419g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.view.b0 f46420h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.view.b0 f46421i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.view.b0 f46422j;

    /* renamed from: k, reason: collision with root package name */
    private final androidx.view.b0 f46423k;

    /* renamed from: l, reason: collision with root package name */
    private final androidx.view.b0 f46424l;

    /* renamed from: m, reason: collision with root package name */
    private final androidx.view.b0 f46425m;

    /* renamed from: n, reason: collision with root package name */
    private final androidx.view.b0 f46426n;

    /* renamed from: o, reason: collision with root package name */
    private final androidx.view.b0 f46427o;

    /* renamed from: p, reason: collision with root package name */
    private Map f46428p;

    /* renamed from: q, reason: collision with root package name */
    private io.reactivex.rxjava3.disposables.c f46429q;

    /* renamed from: r, reason: collision with root package name */
    private io.reactivex.rxjava3.disposables.c f46430r;

    /* renamed from: s, reason: collision with root package name */
    private io.reactivex.rxjava3.disposables.c f46431s;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends sg.a {
        b() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            com.transsion.member.a.f46460a.b("requestInviteUserMore failed " + str + ", " + str2);
            MemberViewModel.this.f46420h.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(AllMemberRightsData allMemberRightsData) {
            super.c(allMemberRightsData);
            com.transsion.member.a.f46460a.b("requestInviteUserMore onSuccess:" + allMemberRightsData);
            MemberViewModel.this.f46420h.q(allMemberRightsData);
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements lz.f {

        /* renamed from: a, reason: collision with root package name */
        public static final c f46433a = new c();

        c() {
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto it) {
            Intrinsics.h(it, "it");
            MemberDetail memberDetail = (MemberDetail) it.getData();
            if (memberDetail != null) {
                c0.f46483a.b().putString("MEMBER_JSON", com.blankj.utilcode.util.o.j(memberDetail));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends sg.a {
        d() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            MemberViewModel.this.f46417e.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberDetail memberDetail) {
            super.c(memberDetail);
            MemberViewModel.this.f46417e.q(memberDetail);
            IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
            if (iMemberApi != null) {
                iMemberApi.k(memberDetail);
            }
        }

        @Override // sg.a, io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c d11) {
            Intrinsics.h(d11, "d");
            super.onSubscribe(d11);
            MemberViewModel.this.f46429q = d11;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements zm.j {
        e() {
        }

        @Override // zm.j
        public void a(String str, String str2) {
            MemberViewModel.this.f46417e.q(null);
        }

        @Override // zm.j
        public void b(MemberDetail memberDetail) {
            MemberViewModel.this.f46417e.q(memberDetail);
        }
    }

    /* loaded from: classes5.dex */
    static final class f implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        public static final f f46436a = new f();

        f() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(Throwable it) {
            Intrinsics.h(it, "it");
            String string = c0.f46483a.b().getString("MEMBER_GOODS_JSON", null);
            if (string == null || string.length() == 0) {
                return io.reactivex.rxjava3.core.j.l(it);
            }
            try {
                MemberPriceData memberPriceData = (MemberPriceData) com.blankj.utilcode.util.o.d(string, MemberPriceData.class);
                BaseDto baseDto = new BaseDto();
                baseDto.setCode("0");
                baseDto.setData(memberPriceData);
                return io.reactivex.rxjava3.core.j.t(baseDto);
            } catch (Exception unused) {
                return io.reactivex.rxjava3.core.j.l(it);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class g implements lz.f {

        /* renamed from: a, reason: collision with root package name */
        public static final g f46437a = new g();

        g() {
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto it) {
            Intrinsics.h(it, "it");
            MemberPriceData memberPriceData = (MemberPriceData) it.getData();
            if (memberPriceData != null) {
                c0.f46483a.b().putString("MEMBER_GOODS_JSON", com.blankj.utilcode.util.o.j(memberPriceData));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class h extends sg.a {
        h() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            MemberViewModel.this.f46427o.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberPriceData memberPriceData) {
            super.c(memberPriceData);
            MemberViewModel.this.f46427o.q(memberPriceData);
        }

        @Override // sg.a, io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c d11) {
            Intrinsics.h(d11, "d");
            super.onSubscribe(d11);
            MemberViewModel.this.f46431s = d11;
        }
    }

    /* loaded from: classes5.dex */
    public static final class i implements zm.c {
        i() {
        }

        @Override // zm.c
        public void a(MemberAdTaskInfo memberAdTaskInfo, boolean z10) {
            c.a.a(this, memberAdTaskInfo, z10);
        }

        @Override // zm.c
        public void b(MemberTaskInfo memberTaskInfo, boolean z10) {
            List<MemberTaskGroup> arrayList;
            ArrayList arrayList2 = new ArrayList();
            if (memberTaskInfo == null || (arrayList = memberTaskInfo.getList()) == null) {
                arrayList = new ArrayList<>();
            }
            for (MemberTaskGroup memberTaskGroup : arrayList) {
                List<MemberTaskItem> taskItems = memberTaskGroup.getTaskItems();
                if (!taskItems.isEmpty()) {
                    MemberTaskItem memberTaskItem = (MemberTaskItem) CollectionsKt.i0(taskItems);
                    List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
                    boolean z11 = false;
                    boolean z12 = inviteList != null && (inviteList.isEmpty() ^ true);
                    if (memberTaskItem.getCheckInList() != null && (!r4.isEmpty())) {
                        z11 = true;
                    }
                    if (z12 || z11) {
                        arrayList2.add(new MemberTaskItem(null, null, Integer.valueOf(TaskType.TITLE.getValue()), null, null, memberTaskGroup.getGroupName(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, memberTaskGroup.getGroupName(), memberTaskGroup.getGroupUrl(), memberTaskGroup.getGroupInfo(), 2097115, null));
                        for (MemberTaskItem memberTaskItem2 : taskItems) {
                            Integer taskSubType = memberTaskItem2.getTaskSubType();
                            int value = TaskType.DOWNLOAD_APP.getValue();
                            if (taskSubType == null || taskSubType.intValue() != value) {
                                Integer taskSubType2 = memberTaskItem2.getTaskSubType();
                                int value2 = TaskType.OPEN_APP.getValue();
                                if (taskSubType2 != null) {
                                    if (taskSubType2.intValue() != value2) {
                                    }
                                }
                                arrayList2.add(memberTaskItem2);
                            }
                            if (qi.b.f73757a.n()) {
                                arrayList2.add(memberTaskItem2);
                            }
                        }
                    }
                }
            }
            MemberViewModel.this.f46421i.q(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class j implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        public static final j f46440a = new j();

        j() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(Throwable it) {
            Intrinsics.h(it, "it");
            String string = c0.f46483a.b().getString("SKU_LIST_JSON", null);
            if (string == null || string.length() == 0) {
                return io.reactivex.rxjava3.core.j.l(it);
            }
            try {
                SkuData skuData = (SkuData) com.blankj.utilcode.util.o.e(string, com.blankj.utilcode.util.o.h(SkuData.class, new Type[0]));
                BaseDto baseDto = new BaseDto();
                baseDto.setCode("0");
                baseDto.setData(skuData);
                return io.reactivex.rxjava3.core.j.t(baseDto);
            } catch (Exception unused) {
                return io.reactivex.rxjava3.core.j.l(it);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class k implements lz.f {

        /* renamed from: a, reason: collision with root package name */
        public static final k f46441a = new k();

        k() {
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto it) {
            Intrinsics.h(it, "it");
            SkuData skuData = (SkuData) it.getData();
            if (skuData != null) {
                List<SkuItem> skuList = skuData.getSkuList();
                List<SkuItem> K0 = skuList != null ? CollectionsKt.K0(skuList, 3) : null;
                if (K0 == null) {
                    K0 = CollectionsKt.l();
                }
                skuData.setSkuList(K0);
                List<SkuItem> skuPointList = skuData.getSkuPointList();
                List<SkuItem> K02 = skuPointList != null ? CollectionsKt.K0(skuPointList, 3) : null;
                if (K02 == null) {
                    K02 = CollectionsKt.l();
                }
                skuData.setSkuPointList(K02);
                c0.f46483a.b().putString("SKU_LIST_JSON", com.blankj.utilcode.util.o.j(skuData));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class l extends sg.a {
        l() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            MemberViewModel.this.f46418f.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(SkuData skuData) {
            super.c(skuData);
            MemberViewModel.this.f46418f.q(skuData);
        }

        @Override // sg.a, io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c d11) {
            Intrinsics.h(d11, "d");
            super.onSubscribe(d11);
            MemberViewModel.this.f46430r = d11;
        }
    }

    /* loaded from: classes5.dex */
    public static final class m extends sg.a {
        m() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            com.transsion.member.a.f46460a.b("requestInviteUserMore failed " + str + ", " + str2);
            MemberViewModel.this.f46424l.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskInviteRewards memberTaskInviteRewards) {
            super.c(memberTaskInviteRewards);
            com.transsion.member.a.f46460a.b("requestInviteUserMore onSuccess:" + memberTaskInviteRewards);
            MemberViewModel.this.f46424l.q(memberTaskInviteRewards);
        }
    }

    /* loaded from: classes5.dex */
    static final class n implements lz.g {

        /* renamed from: a, reason: collision with root package name */
        public static final n f46444a = new n();

        n() {
        }

        @Override // lz.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Triple a(BaseDto response1, BaseDto response2, BaseDto response3) {
            Intrinsics.h(response1, "response1");
            Intrinsics.h(response2, "response2");
            Intrinsics.h(response3, "response3");
            return new Triple(response1.getData(), response2.getData(), response3.getData());
        }
    }

    /* loaded from: classes5.dex */
    static final class o implements lz.f {
        o() {
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Triple it) {
            Intrinsics.h(it, "it");
            androidx.view.b0 b0Var = MemberViewModel.this.f46425m;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("WhatsApp", it.getFirst());
            linkedHashMap.put("Telegram", it.getSecond());
            linkedHashMap.put("CopyLink", it.getThird());
            b0Var.q(linkedHashMap);
        }
    }

    /* loaded from: classes5.dex */
    static final class p implements lz.f {
        p() {
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Throwable it) {
            Intrinsics.h(it, "it");
            MemberViewModel.this.f46425m.q(new LinkedHashMap());
        }
    }

    /* loaded from: classes5.dex */
    public static final class q extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f46448e;

        q(int i11) {
            this.f46448e = i11;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            com.transsion.member.a.f46460a.b("taskCheckInSubmit failed " + str + ", " + str2);
            MemberViewModel.this.f46422j.q(new Pair(Integer.valueOf(this.f46448e), null));
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskSubmitCheckInRes memberTaskSubmitCheckInRes) {
            super.c(memberTaskSubmitCheckInRes);
            MemberViewModel.this.f46422j.q(new Pair(Integer.valueOf(this.f46448e), memberTaskSubmitCheckInRes));
        }
    }

    /* loaded from: classes5.dex */
    public static final class r extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f46450e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f46451f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f46452g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f46453h;

        r(int i11, String str, int i12, int i13) {
            this.f46450e = i11;
            this.f46451f = str;
            this.f46452g = i12;
            this.f46453h = i13;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            com.transsion.member.a.f46460a.b("taskCheckInSubmit failed " + str + ", " + str2);
            MemberViewModel.this.f46423k.q(new zm.d(-this.f46450e, this.f46451f, this.f46452g, this.f46453h, null));
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskRewardInfo memberTaskRewardInfo) {
            super.c(memberTaskRewardInfo);
            MemberViewModel.this.f46423k.q(new zm.d(this.f46450e, this.f46451f, this.f46452g, this.f46453h, memberTaskRewardInfo));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f46414b = LazyKt.b(new Function0() { // from class: com.transsion.member.t0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                vm.a P;
                P = MemberViewModel.P();
                return P;
            }
        });
        this.f46415c = LazyKt.b(new Function0() { // from class: com.transsion.member.u0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IPremiumApi R;
                R = MemberViewModel.R();
                return R;
            }
        });
        this.f46416d = LazyKt.b(new Function0() { // from class: com.transsion.member.v0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IMemberApi Q;
                Q = MemberViewModel.Q();
                return Q;
            }
        });
        this.f46417e = new androidx.view.b0();
        this.f46418f = new androidx.view.b0();
        this.f46419g = new androidx.view.b0();
        this.f46420h = new androidx.view.b0();
        this.f46421i = new androidx.view.b0();
        this.f46422j = new androidx.view.b0();
        this.f46423k = new androidx.view.b0();
        this.f46424l = new androidx.view.b0();
        this.f46425m = new androidx.view.b0();
        this.f46426n = new androidx.view.b0();
        this.f46427o = new androidx.view.b0();
        this.f46428p = new LinkedHashMap();
    }

    private final vm.a C() {
        return (vm.a) this.f46414b.getValue();
    }

    private final IMemberApi F() {
        return (IMemberApi) this.f46416d.getValue();
    }

    private final IPremiumApi G() {
        return (IPremiumApi) this.f46415c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vm.a P() {
        return (vm.a) zg.c.f79537e.a().h(vm.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMemberApi Q() {
        return (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPremiumApi R() {
        return (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object S(com.transsion.memberapi.SkuItem r11, kotlin.coroutines.Continuation r12) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.MemberViewModel.S(com.transsion.memberapi.SkuItem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final LiveData A() {
        return this.f46420h;
    }

    public final LiveData B() {
        return this.f46424l;
    }

    public final LiveData D() {
        return this.f46417e;
    }

    public final LiveData E() {
        return this.f46427o;
    }

    public final LiveData H() {
        return this.f46419g;
    }

    public final LiveData I() {
        return this.f46425m;
    }

    public final SkuData J() {
        return (SkuData) this.f46418f.f();
    }

    public final LiveData K() {
        return this.f46418f;
    }

    public final LiveData L() {
        return this.f46422j;
    }

    public final LiveData M() {
        return this.f46423k;
    }

    public final LiveData N() {
        return this.f46421i;
    }

    public final void O() {
        String string = c0.f46483a.b().getString("MEMBER_JSON", null);
        if (string != null && string.length() != 0) {
            try {
                this.f46417e.q((MemberDetail) com.blankj.utilcode.util.o.d(string, MemberDetail.class));
            } catch (Exception e11) {
                a.C0856a.f(lg.a.f68962a, "MemberViewModel", "No member detail cache " + e11, false, 4, null);
            }
        }
        String string2 = c0.f46483a.b().getString("MEMBER_GOODS_JSON", null);
        if (string2 == null || string2.length() == 0) {
            return;
        }
        try {
            this.f46427o.q((MemberPriceData) com.blankj.utilcode.util.o.d(string2, MemberPriceData.class));
        } catch (Exception e12) {
            a.C0856a.f(lg.a.f68962a, "MemberViewModel", "No member goods cache " + e12, false, 4, null);
        }
    }

    public final void T(SkuItem skuItem) {
        Intrinsics.h(skuItem, "skuItem");
        kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.c()), null, null, new MemberViewModel$redeemProduct$1(this, skuItem, null), 3, null);
    }

    public final void U(int i11, int i12) {
        a.C0979a.c(C(), null, i11, i12, 1, null).f(sg.d.f75472a.c()).subscribe(new m());
    }

    public final void V() {
        io.reactivex.rxjava3.core.j.H(a.C0979a.d(C(), null, new InviteUserShareInfoReq(null, "WhatsApp", null, 5, null), 1, null), a.C0979a.d(C(), null, new InviteUserShareInfoReq(null, "Telegram", null, 5, null), 1, null), a.C0979a.d(C(), null, new InviteUserShareInfoReq(null, "CopyLink", null, 5, null), 1, null), n.f46444a).f(sg.d.f75472a.c()).B(new o(), new p());
    }

    public final void W(int i11) {
        a.C0979a.m(C(), null, null, 3, null).f(sg.d.f75472a.c()).subscribe(new q(i11));
    }

    public final void X(int i11, String rewardId, int i12, int i13) {
        Intrinsics.h(rewardId, "rewardId");
        a.C0979a.k(C(), null, rewardId, 1, null).f(sg.d.f75472a.c()).subscribe(new r(i11, rewardId, i12, i13));
    }

    public final void u() {
        a.C0979a.b(C(), null, 1, null).f(sg.d.f75472a.c()).subscribe(new b());
    }

    public final void v() {
        io.reactivex.rxjava3.disposables.c cVar;
        io.reactivex.rxjava3.disposables.c cVar2 = this.f46429q;
        if (cVar2 != null && !cVar2.isDisposed() && (cVar = this.f46429q) != null) {
            cVar.dispose();
        }
        a.C0979a.e(C(), null, 1, null).v(qz.a.c()).h(c.f46433a).f(sg.d.f75472a.c()).subscribe(new d());
    }

    public final void w() {
        IPremiumApi G = G();
        if (G != null) {
            G.g(new e());
        }
    }

    public final void x() {
        io.reactivex.rxjava3.disposables.c cVar;
        io.reactivex.rxjava3.disposables.c cVar2 = this.f46431s;
        if (cVar2 != null && !cVar2.isDisposed() && (cVar = this.f46431s) != null) {
            cVar.dispose();
        }
        a.C0979a.f(C(), null, 1, null).v(qz.a.c()).x(f.f46436a).h(g.f46437a).f(sg.d.f75472a.c()).subscribe(new h());
    }

    public final void y() {
        IMemberApi F = F();
        if (F != null) {
            F.s(new i());
        }
    }

    public final void z() {
        io.reactivex.rxjava3.disposables.c cVar;
        io.reactivex.rxjava3.disposables.c cVar2 = this.f46430r;
        if (cVar2 != null && !cVar2.isDisposed() && (cVar = this.f46430r) != null) {
            cVar.dispose();
        }
        a.C0979a.i(C(), null, 1, null).v(qz.a.c()).x(j.f46440a).h(k.f46441a).f(sg.d.f75472a.c()).subscribe(new l());
    }
}
