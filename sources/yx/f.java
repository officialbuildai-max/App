package yx;

import com.therouter.TheRouter;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberAdTaskInfo;
import com.transsion.memberapi.MemberTaskInfo;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.TaskRewards;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import zm.c;

/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f79214a = new f();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f79215b = LazyKt.b(new Function0() { // from class: yx.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IMemberApi o11;
            o11 = f.o();
            return o11;
        }
    });

    /* loaded from: classes7.dex */
    public static final class a implements zm.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f79216a;

        a(Function1 function1) {
            this.f79216a = function1;
        }

        @Override // zm.c
        public void a(MemberAdTaskInfo memberAdTaskInfo, boolean z10) {
            MemberTaskItem memberTaskItem;
            List<MemberTaskItem> list;
            Object obj;
            if (memberAdTaskInfo == null || (list = memberAdTaskInfo.getList()) == null) {
                memberTaskItem = null;
            } else {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    Integer taskSubType = ((MemberTaskItem) obj).getTaskSubType();
                    if (taskSubType != null && taskSubType.intValue() == 19) {
                        break;
                    }
                }
                memberTaskItem = (MemberTaskItem) obj;
            }
            a.C0856a c0856a = lg.a.f68962a;
            f fVar = f.f79214a;
            a.C0856a.g(c0856a, fVar.l() + " --> fetchAdTaskInfo() --> 获取任务列表 -- taskId = " + (memberTaskItem != null ? memberTaskItem.getTaskId() : null), false, 2, null);
            if (memberTaskItem != null) {
                String taskId = memberTaskItem.getTaskId();
                if (taskId == null) {
                    taskId = "";
                }
                fVar.h(taskId, this.f79216a);
                return;
            }
            Function1 function1 = this.f79216a;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }

        @Override // zm.c
        public void b(MemberTaskInfo memberTaskInfo, boolean z10) {
            c.a.b(this, memberTaskInfo, z10);
        }
    }

    private f() {
    }

    private final void g(Function1 function1) {
        IMemberApi m11 = m();
        if (m11 != null) {
            m11.u(new a(function1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String str, final Function1 function1) {
        MemberTaskItem memberTaskItem = new MemberTaskItem(str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777214, null);
        a.C0856a.g(lg.a.f68962a, l() + " --> fetchAdTaskReward() --> 领取激活广告任务奖励 -- taskId = " + str, false, 2, null);
        IMemberApi m11 = m();
        if (m11 != null) {
            m11.l(memberTaskItem, new Function2() { // from class: yx.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i11;
                    i11 = f.i(Function1.this, (String) obj, (String) obj2);
                    return i11;
                }
            }, new Function1() { // from class: yx.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit k11;
                    k11 = f.k(Function1.this, (TaskRewards) obj);
                    return k11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(final Function1 function1, String str, String str2) {
        new Function0() { // from class: yx.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit j11;
                j11 = f.j(Function1.this);
                return j11;
            }
        };
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function1 function1) {
        if (function1 == null) {
            return null;
        }
        function1.invoke(Boolean.FALSE);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function1 function1, TaskRewards taskRewards) {
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l() {
        String simpleName = f.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final IMemberApi m() {
        return (IMemberApi) f79215b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMemberApi o() {
        return (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
    }

    public final void n(Function1 function1) {
        g(function1);
    }
}
