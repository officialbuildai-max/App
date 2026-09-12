package com.transsion.rewardscenter.task.ad;

import com.tencent.mmkv.MMKV;
import com.transsion.rewardscenter.task.ad.v;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    private static v.c f51178c;

    /* renamed from: f, reason: collision with root package name */
    private static MemberTaskItem f51181f;

    /* renamed from: g, reason: collision with root package name */
    private static MemberTaskItem f51182g;

    /* renamed from: h, reason: collision with root package name */
    private static MemberTaskItem f51183h;

    /* renamed from: i, reason: collision with root package name */
    private static MemberTaskItem f51184i;

    /* renamed from: j, reason: collision with root package name */
    private static MemberTaskItem f51185j;

    /* renamed from: a, reason: collision with root package name */
    public static final u f51176a = new u();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f51177b = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.ad.t
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV o11;
            o11 = u.o();
            return o11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static List f51179d = CollectionsKt.l();

    /* renamed from: e, reason: collision with root package name */
    private static List f51180e = CollectionsKt.l();

    /* renamed from: k, reason: collision with root package name */
    public static final int f51186k = 8;

    private u() {
    }

    private final MMKV f() {
        return (MMKV) f51177b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV o() {
        return MMKV.I("StageTaskAdCache");
    }

    public final void b(v vVar, MemberTaskItem memberTaskItem) {
        if (memberTaskItem == null) {
            return;
        }
        MemberTaskItem memberTaskItem2 = f51181f;
        Pair a11 = TuplesKt.a(memberTaskItem2 != null ? memberTaskItem2.getTaskId() : null, f51181f);
        MemberTaskItem memberTaskItem3 = f51182g;
        Pair a12 = TuplesKt.a(memberTaskItem3 != null ? memberTaskItem3.getTaskId() : null, f51182g);
        MemberTaskItem memberTaskItem4 = f51183h;
        Pair a13 = TuplesKt.a(memberTaskItem4 != null ? memberTaskItem4.getTaskId() : null, f51183h);
        MemberTaskItem memberTaskItem5 = f51185j;
        Pair a14 = TuplesKt.a(memberTaskItem5 != null ? memberTaskItem5.getTaskId() : null, f51185j);
        MemberTaskItem memberTaskItem6 = f51184i;
        MemberTaskItem memberTaskItem7 = (MemberTaskItem) MapsKt.l(a11, a12, a13, a14, TuplesKt.a(memberTaskItem6 != null ? memberTaskItem6.getTaskId() : null, f51184i)).get(memberTaskItem.getTaskId());
        if (memberTaskItem7 != null) {
            memberTaskItem7.setProgress(memberTaskItem.getProgress());
            memberTaskItem7.setTotalProgress(memberTaskItem.getTotalProgress());
            memberTaskItem7.setStatus(memberTaskItem.getStatus());
        }
        Integer totalProgress = memberTaskItem.getTotalProgress();
        if (totalProgress != null) {
            int intValue = totalProgress.intValue();
            Integer progress = memberTaskItem.getProgress();
            r0 = intValue - (progress != null ? progress.intValue() : 0);
        }
        if (r0 <= 0) {
            p(vVar);
        }
    }

    public final boolean c(String sceneId, String packageName) {
        Intrinsics.h(sceneId, "sceneId");
        Intrinsics.h(packageName, "packageName");
        int hashCode = sceneId.hashCode();
        if (hashCode != 1154212438) {
            if (hashCode != 1383510840) {
                if (hashCode == 2139474598 && sceneId.equals("MemberCenterStageNativeScene")) {
                    v.c cVar = f51178c;
                    List e11 = CollectionsKt.e(cVar != null ? cVar.i() : null);
                    if (!(e11 instanceof Collection) || !e11.isEmpty()) {
                        Iterator it = e11.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.c((String) it.next(), packageName)) {
                                return true;
                            }
                        }
                    }
                    List list = f51180e;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (((v.a) obj).k()) {
                            arrayList.add(obj);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            if (Intrinsics.c(((v.a) it2.next()).i(), packageName)) {
                                return true;
                            }
                        }
                    }
                }
            } else if (sceneId.equals("MemberTaskRegularNativeScene")) {
                v.c cVar2 = f51178c;
                List e12 = CollectionsKt.e(cVar2 != null ? cVar2.i() : null);
                if (!(e12 instanceof Collection) || !e12.isEmpty()) {
                    Iterator it3 = e12.iterator();
                    while (it3.hasNext()) {
                        if (Intrinsics.c((String) it3.next(), packageName)) {
                            return true;
                        }
                    }
                }
                List list2 = f51179d;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator it4 = list2.iterator();
                    while (it4.hasNext()) {
                        if (Intrinsics.c(((v.c) it4.next()).i(), packageName)) {
                            return true;
                        }
                    }
                }
                List list3 = f51180e;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list3) {
                    if (((v.a) obj2).k()) {
                        arrayList2.add(obj2);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    Iterator it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        if (Intrinsics.c(((v.a) it5.next()).i(), packageName)) {
                            return true;
                        }
                    }
                }
            }
        } else if (sceneId.equals("MemberTaskStageNativeScene")) {
            List list4 = f51179d;
            if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                Iterator it6 = list4.iterator();
                while (it6.hasNext()) {
                    if (Intrinsics.c(((v.c) it6.next()).i(), packageName)) {
                        return true;
                    }
                }
            }
            List list5 = f51180e;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : list5) {
                if (((v.a) obj3).k()) {
                    arrayList3.add(obj3);
                }
            }
            if (!arrayList3.isEmpty()) {
                Iterator it7 = arrayList3.iterator();
                while (it7.hasNext()) {
                    if (Intrinsics.c(((v.a) it7.next()).i(), packageName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final List d() {
        return f51180e;
    }

    public final List e() {
        return f51179d;
    }

    public final MemberTaskItem g() {
        return f51184i;
    }

    public final MemberTaskItem h() {
        return f51183h;
    }

    public final MemberTaskItem i() {
        return f51185j;
    }

    public final MemberTaskItem j() {
        return f51181f;
    }

    public final MemberTaskItem k() {
        return f51182g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AdTaskState l(String str) {
        if (str == null) {
            return null;
        }
        int i11 = f().getInt("task_state_" + str, -1);
        if (i11 != -1) {
            return (AdTaskState) AdTaskState.getEntries().get(i11);
        }
        return null;
    }

    public final boolean m(String sceneId, String str) {
        boolean z10;
        Intrinsics.h(sceneId, "sceneId");
        boolean z11 = true;
        boolean z12 = false;
        if (str != null) {
            u uVar = f51176a;
            boolean c11 = uVar.c(sceneId, str);
            z10 = uVar.n(str);
            if (!StringsKt.q0(str) && !c11 && !z10) {
                z11 = false;
            }
            z12 = c11;
        } else {
            z10 = false;
        }
        a.C0856a.f(lg.a.f68962a, "StageTaskAd", "isFiltered = " + z11 + ", packageName: " + str + ", isDuplicate: " + z12 + ", isInCooldown: " + z10, false, 4, null);
        return z11;
    }

    public final boolean n(String packageName) {
        Intrinsics.h(packageName, "packageName");
        MMKV f11 = f();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("package_cooldown_");
        sb2.append(packageName);
        return System.currentTimeMillis() < f11.getLong(sb2.toString(), 0L);
    }

    public final void p(v vVar) {
        ArrayList arrayList;
        AdTaskState e11;
        if (vVar instanceof v.c) {
            v.c cVar = f51178c;
            if (cVar != null && (e11 = cVar.e()) != null && e11.ordinal() < AdTaskState.CLAIMED_STAGE1.ordinal()) {
                f51178c = null;
            }
            List list = f51179d;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (((v.c) obj).e().ordinal() >= AdTaskState.CLAIMED_STAGE1.ordinal()) {
                    arrayList2.add(obj);
                }
            }
            f51179d = arrayList2;
            return;
        }
        if (vVar instanceof v.a) {
            if (((v.a) vVar).k()) {
                List list2 = f51180e;
                arrayList = new ArrayList();
                for (Object obj2 : list2) {
                    if (!((v.a) obj2).k()) {
                        arrayList.add(obj2);
                    }
                }
            } else {
                List list3 = f51180e;
                arrayList = new ArrayList();
                for (Object obj3 : list3) {
                    if (((v.a) obj3).k()) {
                        arrayList.add(obj3);
                    }
                }
            }
            f51180e = arrayList;
        }
    }

    public final void q(v.a item) {
        Intrinsics.h(item, "item");
        List list = f51180e;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!Intrinsics.c((v.a) obj, item)) {
                arrayList.add(obj);
            }
        }
        f51180e = arrayList;
    }

    public final void r(List taskInfos) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Intrinsics.h(taskInfos, "taskInfos");
        List list = taskInfos;
        Iterator it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            Integer taskSubType = ((MemberTaskItem) obj2).getTaskSubType();
            int value = TaskType.AD_STAGE_1ST.getValue();
            if (taskSubType != null && taskSubType.intValue() == value) {
                break;
            }
        }
        f51181f = (MemberTaskItem) obj2;
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it2.next();
            Integer taskSubType2 = ((MemberTaskItem) obj3).getTaskSubType();
            int value2 = TaskType.AD_STAGE_2ND.getValue();
            if (taskSubType2 != null && taskSubType2.intValue() == value2) {
                break;
            }
        }
        f51182g = (MemberTaskItem) obj3;
        Iterator it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj4 = null;
                break;
            }
            obj4 = it3.next();
            Integer taskSubType3 = ((MemberTaskItem) obj4).getTaskSubType();
            int value3 = TaskType.AD_REGULAR_PULL_NEW.getValue();
            if (taskSubType3 != null && taskSubType3.intValue() == value3) {
                break;
            }
        }
        f51183h = (MemberTaskItem) obj4;
        Iterator it4 = list.iterator();
        while (true) {
            if (!it4.hasNext()) {
                obj5 = null;
                break;
            }
            obj5 = it4.next();
            Integer taskSubType4 = ((MemberTaskItem) obj5).getTaskSubType();
            int value4 = TaskType.AD_REGULAR_PULL_LIVE.getValue();
            if (taskSubType4 != null && taskSubType4.intValue() == value4) {
                break;
            }
        }
        f51184i = (MemberTaskItem) obj5;
        Iterator it5 = list.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            Integer taskSubType5 = ((MemberTaskItem) next).getTaskSubType();
            int value5 = TaskType.AD_REWARD.getValue();
            if (taskSubType5 != null && taskSubType5.intValue() == value5) {
                obj = next;
                break;
            }
        }
        f51185j = (MemberTaskItem) obj;
    }

    public final void s(List list) {
        Intrinsics.h(list, "<set-?>");
        f51180e = list;
    }

    public final void t(List list) {
        Intrinsics.h(list, "<set-?>");
        f51179d = list;
    }

    public final void u(String packageName, Integer num) {
        Intrinsics.h(packageName, "packageName");
        long j11 = 60;
        long currentTimeMillis = System.currentTimeMillis() + ((num != null ? num.intValue() : 3L) * 24 * j11 * j11 * 1000);
        f().putLong("package_cooldown_" + packageName, currentTimeMillis);
    }

    public final void v(String str, AdTaskState adTaskState) {
        Intrinsics.h(adTaskState, "adTaskState");
        if (str == null) {
            return;
        }
        f().putInt("task_state_" + str, adTaskState.ordinal());
    }
}
