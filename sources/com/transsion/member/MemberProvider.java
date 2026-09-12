package com.transsion.member;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.member.dialog.ClaimMemberDialog;
import com.transsion.memberapi.GlobalTaskInfo;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberAdTaskInfo;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberRemindData;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.MemberTaskInfo;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.OpType;
import com.transsion.memberapi.TaskRewards;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* loaded from: classes.dex */
public final class MemberProvider implements IMemberApi {

    /* renamed from: b, reason: collision with root package name */
    private volatile MemberDetail f46395b;

    /* renamed from: c, reason: collision with root package name */
    private volatile MemberTaskInfo f46396c;

    /* renamed from: g, reason: collision with root package name */
    private ClaimMemberDialog f46400g;

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f46394a = LazyKt.b(new Function0() { // from class: com.transsion.member.o0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            vm.a Y;
            Y = MemberProvider.Y();
            return Y;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final kotlinx.coroutines.flow.y0 f46397d = j1.a(null);

    /* renamed from: e, reason: collision with root package name */
    private final kotlinx.coroutines.flow.y0 f46398e = j1.a(Boolean.FALSE);

    /* renamed from: f, reason: collision with root package name */
    private String f46399f = "";

    /* loaded from: classes5.dex */
    public static final class a extends sg.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2 f46401d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1 f46402e;

        a(Function2 function2, Function1 function1) {
            this.f46401d = function2;
            this.f46402e = function1;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            com.transsion.member.a.f46460a.b("claimTaskReward error:" + str2);
            Function2 function2 = this.f46401d;
            if (function2 != null) {
                function2.invoke(str, str2);
            }
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(TaskRewards taskRewards) {
            com.transsion.member.a.f46460a.a("claimTaskReward success");
            Function1 function1 = this.f46402e;
            if (function1 != null) {
                function1.invoke(taskRewards);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends sg.a {
        b() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            com.transsion.member.a.f46460a.b("fetchGlobalTasks failed, code: " + str + ", message: " + str2);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(GlobalTaskInfo globalTaskInfo) {
            super.c(globalTaskInfo);
            if (globalTaskInfo == null) {
                com.transsion.member.a.f46460a.b("fetchGlobalTasks data error");
                return;
            }
            com.transsion.member.a.f46460a.a("fetchGlobalTasks succeed " + globalTaskInfo.getTaskInfo());
            MemberProvider.this.f46397d.setValue(globalTaskInfo.getTaskInfo());
            MemberProvider.this.f46398e.setValue(Boolean.valueOf(globalTaskInfo.getTaskInfo() != null));
            xm.k.f78504a.T(globalTaskInfo.getGlobalTaskConf());
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements lz.f {

        /* renamed from: a, reason: collision with root package name */
        public static final c f46404a = new c();

        c() {
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto it) {
            Intrinsics.h(it, "it");
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends sg.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ zm.c f46405d;

        d(zm.c cVar) {
            this.f46405d = cVar;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            com.transsion.member.a.f46460a.b("fetchMemberAdTaskInfo onFailure:" + str + ", " + str2);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberAdTaskInfo memberAdTaskInfo) {
            super.c(memberAdTaskInfo);
            com.transsion.member.a.f46460a.b("fetchMemberAdTaskInfo onSuccess:" + memberAdTaskInfo);
            zm.c cVar = this.f46405d;
            if (cVar != null) {
                cVar.a(memberAdTaskInfo, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends sg.a {
        e() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            com.transsion.member.a.f46460a.b("Fetch member detail failed " + str + ", " + str2);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberDetail memberDetail) {
            super.c(memberDetail);
            if (memberDetail == null) {
                com.transsion.member.a.f46460a.b("Fetch member detail failed");
                return;
            }
            com.transsion.member.a.f46460a.a("Fetch member detail succeed " + memberDetail);
            MemberProvider.this.f46395b = memberDetail;
            c0.f46483a.b().putString("MEMBER_JSON", com.blankj.utilcode.util.o.j(MemberProvider.this.f46395b));
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends sg.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1 f46407d;

        f(Function1 function1) {
            this.f46407d = function1;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            com.transsion.member.a.f46460a.b("Fetch member remind failed " + str + ", " + str2);
            this.f46407d.invoke(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(List list) {
            super.c(list);
            List list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                this.f46407d.invoke(list.get(0));
            } else {
                this.f46407d.invoke(null);
                com.transsion.member.a.f46460a.b("Fetch member remind failed");
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class g implements lz.f {
        g() {
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(BaseDto it) {
            Intrinsics.h(it, "it");
            MemberTaskInfo memberTaskInfo = (MemberTaskInfo) it.getData();
            if (memberTaskInfo != null) {
                MemberProvider memberProvider = MemberProvider.this;
                c0.f46483a.b().putString("MEMBER_TASK_JSON", com.blankj.utilcode.util.o.j(memberTaskInfo));
                memberProvider.f46396c = memberTaskInfo;
                memberProvider.f46399f = memberProvider.W();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class h extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ zm.c f46410e;

        h(zm.c cVar) {
            this.f46410e = cVar;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            com.transsion.member.a.f46460a.b("MemberProvider --> fetchMemberTaskInfo onFailure:" + str + ", " + str2);
            xm.k.f78504a.S(MemberProvider.this.f46396c);
            zm.c cVar = this.f46410e;
            if (cVar != null) {
                cVar.b(MemberProvider.this.f46396c, true);
            }
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MemberTaskInfo memberTaskInfo) {
            super.c(memberTaskInfo);
            com.transsion.member.a.f46460a.b("MemberProvider --> fetchMemberTaskInfo onSuccess:" + memberTaskInfo);
            xm.k.f78504a.S(memberTaskInfo);
            zm.c cVar = this.f46410e;
            if (cVar != null) {
                cVar.b(memberTaskInfo, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class i extends sg.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1 f46411d;

        i(Function1 function1) {
            this.f46411d = function1;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            com.transsion.member.a.f46460a.b("Upload operation stat failed " + str + ", " + str2);
            Function1 function1 = this.f46411d;
            if (function1 != null) {
                function1.invoke(null);
            }
        }

        @Override // sg.a
        public void c(Object obj) {
            super.c(obj);
            com.transsion.member.a.f46460a.b("Upload operation stat succeed " + obj);
            Function1 function1 = this.f46411d;
            if (function1 != null) {
                function1.invoke("ok");
            }
        }
    }

    public MemberProvider() {
        Object m1185constructorimpl;
        String string = c0.f46483a.b().getString("MEMBER_JSON", null);
        if (string == null || string.length() == 0) {
            this.f46395b = null;
        } else {
            try {
                this.f46395b = (MemberDetail) com.blankj.utilcode.util.o.d(string, MemberDetail.class);
            } catch (Exception unused) {
                this.f46395b = null;
            }
        }
        String string2 = c0.f46483a.b().getString("MEMBER_TASK_JSON", null);
        if (string2 != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl((MemberTaskInfo) com.blankj.utilcode.util.o.d(string2, MemberTaskInfo.class));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            this.f46396c = (MemberTaskInfo) (Result.m1191isFailureimpl(m1185constructorimpl) ? null : m1185constructorimpl);
        }
        if (B()) {
            ObserveLoginAction.f46454c.a().j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final native Unit T(Function2 function2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native Unit U(MemberProvider memberProvider, Function0 function0, TaskRewards taskRewards);

    /* JADX INFO: Access modifiers changed from: private */
    public final native String V();

    /* JADX INFO: Access modifiers changed from: private */
    public final native String W();

    private final native vm.a X();

    /* JADX INFO: Access modifiers changed from: private */
    public static final native vm.a Y();

    @Override // com.transsion.memberapi.IMemberApi
    public native void A(Function2 function2, Function0 function0);

    @Override // com.transsion.memberapi.IMemberApi
    public native boolean B();

    @Override // com.transsion.memberapi.IMemberApi
    public native void C(Function0 function0);

    @Override // com.transsion.memberapi.IMemberApi
    public native int D();

    @Override // com.transsion.memberapi.IMemberApi
    public native void E(zm.e eVar);

    @Override // com.transsion.memberapi.IMemberApi
    public native boolean F(MemberRemindData memberRemindData);

    @Override // com.transsion.memberapi.IMemberApi
    public native void G();

    @Override // com.transsion.memberapi.IMemberApi
    public native void a(Activity activity, MemberSource memberSource, zm.b bVar, boolean z10, String str);

    @Override // com.transsion.memberapi.IMemberApi
    public native MemberDetail b();

    @Override // com.transsion.memberapi.IMemberApi
    public native boolean c();

    @Override // com.transsion.memberapi.IMemberApi
    public native i1 d();

    @Override // com.transsion.memberapi.IMemberApi
    public native Object e(MemberSceneType memberSceneType, Integer num, Function1 function1, Continuation continuation);

    @Override // com.transsion.memberapi.IMemberApi
    public native boolean f();

    @Override // com.transsion.memberapi.IMemberApi
    public native boolean g();

    @Override // com.transsion.memberapi.IMemberApi
    public native void h();

    @Override // com.transsion.memberapi.IMemberApi
    public native void i();

    @Override // com.transsion.memberapi.IMemberApi
    public native boolean j(Fragment fragment);

    @Override // com.transsion.memberapi.IMemberApi
    public native void k(MemberDetail memberDetail);

    @Override // com.transsion.memberapi.IMemberApi
    public native void l(MemberTaskItem memberTaskItem, Function2 function2, Function1 function1);

    @Override // com.transsion.memberapi.IMemberApi
    public native void m(Function1 function1);

    @Override // com.transsion.memberapi.IMemberApi
    public native void n(OpType opType, Function1 function1);

    @Override // com.transsion.memberapi.IMemberApi
    public native void o(Integer num, zm.a aVar);

    @Override // com.transsion.memberapi.IMemberApi
    public native void p();

    @Override // com.transsion.memberapi.IMemberApi
    public native void q();

    @Override // com.transsion.memberapi.IMemberApi
    public native Fragment r();

    @Override // com.transsion.memberapi.IMemberApi
    public native void s(zm.c cVar);

    @Override // com.transsion.memberapi.IMemberApi
    public native void t(zm.e eVar);

    @Override // com.transsion.memberapi.IMemberApi
    public native void u(zm.c cVar);

    @Override // com.transsion.memberapi.IMemberApi
    public native void v();

    @Override // com.transsion.memberapi.IMemberApi
    public native void w(Activity activity, MemberSource memberSource, MemberCheckResult memberCheckResult, zm.b bVar);

    @Override // com.transsion.memberapi.IMemberApi
    public native void x(float f11);

    @Override // com.transsion.memberapi.IMemberApi
    public native void y(Activity activity, String str, String str2, zm.k kVar);

    @Override // com.transsion.memberapi.IMemberApi
    public native void z(MemberSceneType memberSceneType, Integer num, zm.a aVar);
}
