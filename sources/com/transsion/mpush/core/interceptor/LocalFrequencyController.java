package com.transsion.mpush.core.interceptor;

import android.content.Context;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.mpush.core.config.PushConfig;
import com.transsion.mpush.core.interceptor.LocalFrequencyController;
import com.transsion.mpush.core.utils.PushPreference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class LocalFrequencyController {

    /* renamed from: a, reason: collision with root package name */
    public static final LocalFrequencyController f47596a = new LocalFrequencyController();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final LocalPushMessage f47597a;

        /* renamed from: b, reason: collision with root package name */
        private final int f47598b;

        public a(LocalPushMessage message, int i11) {
            Intrinsics.h(message, "message");
            this.f47597a = message;
            this.f47598b = i11;
        }

        public final LocalPushMessage a() {
            return this.f47597a;
        }

        public final int b() {
            return this.f47598b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f47597a, aVar.f47597a) && this.f47598b == aVar.f47598b;
        }

        public int hashCode() {
            return (this.f47597a.hashCode() * 31) + this.f47598b;
        }

        public String toString() {
            return "TimedMessage(message=" + this.f47597a + ", pushSeconds=" + this.f47598b + ")";
        }
    }

    private LocalFrequencyController() {
    }

    private final boolean b(LocalPushMessage localPushMessage, int i11, PushConfig pushConfig) {
        Integer v11;
        Integer v12;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "M_PUSH_SDK", "checkFrequency: msgId=" + localPushMessage.getMessageId() + ", source=" + i11, false, 4, null);
        if (!pushConfig.getEnable()) {
            a.C0856a.f(c0856a, "M_PUSH_SDK", "checkFrequency: global switch disabled", false, 4, null);
            return false;
        }
        if (i11 == 1 && Intrinsics.c(pushConfig.getBrightScreen(), Boolean.FALSE)) {
            a.C0856a.f(c0856a, "M_PUSH_SDK", "checkFrequency: screen_on disabled in config", false, 4, null);
            return false;
        }
        if (i11 == 2 && Intrinsics.c(pushConfig.getUnlock(), Boolean.FALSE)) {
            a.C0856a.f(c0856a, "M_PUSH_SDK", "checkFrequency: unlock disabled in config", false, 4, null);
            return false;
        }
        int i12 = Calendar.getInstance().get(11);
        String startTime = pushConfig.getStartTime();
        int intValue = (startTime == null || (v12 = StringsKt.v(startTime)) == null) ? 8 : v12.intValue();
        String endTime = pushConfig.getEndTime();
        int intValue2 = (endTime == null || (v11 = StringsKt.v(endTime)) == null) ? 22 : v11.intValue();
        if (intValue > i12 || i12 > intValue2) {
            a.C0856a.f(c0856a, "M_PUSH_SDK", "checkFrequency: outside active hours", false, 4, null);
            return false;
        }
        if (localPushMessage.getMsgStatus() != 0) {
            a.C0856a.f(c0856a, "M_PUSH_SDK", "checkFrequency: message already shown/clicked status=" + localPushMessage.getMsgStatus(), false, 4, null);
            return false;
        }
        if (i11 == 1 && localPushMessage.getHasScreenOn()) {
            a.C0856a.f(c0856a, "M_PUSH_SDK", "checkFrequency: message already shown for screen_on", false, 4, null);
            return false;
        }
        if (i11 == 2 && localPushMessage.getForceShow()) {
            a.C0856a.f(c0856a, "M_PUSH_SDK", "checkFrequency: message already force shown for unlock", false, 4, null);
            return false;
        }
        localPushMessage.setTriggerSource(i11);
        return true;
    }

    private final List c(List list) {
        if (list.size() <= 1) {
            return list;
        }
        List list2 = list;
        List<Pair> a12 = CollectionsKt.a1(list2);
        if ((a12 instanceof Collection) && a12.isEmpty()) {
            return list;
        }
        for (Pair pair : a12) {
            if (((a) pair.component1()).b() > ((a) pair.component2()).b()) {
                return CollectionsKt.I0(list2, new Comparator() { // from class: com.transsion.mpush.core.interceptor.LocalFrequencyController$ensurePushTimeAscOrder$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t11, T t12) {
                        return ComparisonsKt.d(Integer.valueOf(((LocalFrequencyController.a) t11).b()), Integer.valueOf(((LocalFrequencyController.a) t12).b()));
                    }
                });
            }
        }
        return list;
    }

    private final PushConfig d(Context context) {
        PushConfig a11 = PushPreference.f47662a.a(context);
        return a11 == null ? new PushConfig(false, null, null, null, null, null, null, null, null, 511, null) : a11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer e(String str) {
        String obj;
        List S0;
        int size;
        if (str != null && (obj = StringsKt.n1(str).toString()) != null && (S0 = StringsKt.S0(obj, new String[]{":"}, false, 0, 6, null)) != null && 2 <= (size = S0.size()) && size < 4) {
            int i11 = 0;
            Integer v11 = StringsKt.v((String) S0.get(0));
            if (v11 != null) {
                int intValue = v11.intValue();
                Integer v12 = StringsKt.v((String) S0.get(1));
                if (v12 != null) {
                    int intValue2 = v12.intValue();
                    if (S0.size() == 3) {
                        Integer v13 = StringsKt.v((String) S0.get(2));
                        if (v13 == null) {
                            return null;
                        }
                        i11 = v13.intValue();
                    }
                    if (intValue >= 0 && intValue < 24 && intValue2 >= 0 && intValue2 < 60 && i11 >= 0 && i11 < 60) {
                        return Integer.valueOf((intValue * 3600) + (intValue2 * 60) + i11);
                    }
                }
            }
        }
        return null;
    }

    private final LocalPushMessage f(List list, int i11, int i12, PushConfig pushConfig) {
        Integer v11;
        String pushGap = pushConfig.getPushGap();
        int f11 = ((i11 - i12) / RangesKt.f((pushGap == null || (v11 = StringsKt.v(pushGap)) == null) ? 2 : v11.intValue(), 1)) % list.size();
        if (f11 < 0 || f11 >= list.size()) {
            return null;
        }
        return (LocalPushMessage) list.get(f11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        return r2.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.transsion.mpush.api.LocalPushMessage g(java.util.List r7, int r8, int r9) {
        /*
            r6 = this;
            r0 = r7
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L8:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L54
            java.lang.Object r2 = r0.next()
            int r4 = r1 + 1
            if (r1 >= 0) goto L1a
            kotlin.collections.CollectionsKt.u()
        L1a:
            com.transsion.mpush.core.interceptor.LocalFrequencyController$a r2 = (com.transsion.mpush.core.interceptor.LocalFrequencyController.a) r2
            java.lang.Object r1 = kotlin.collections.CollectionsKt.l0(r7, r4)
            com.transsion.mpush.core.interceptor.LocalFrequencyController$a r1 = (com.transsion.mpush.core.interceptor.LocalFrequencyController.a) r1
            if (r1 == 0) goto L2c
            int r1 = r1.b()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
        L2c:
            if (r3 == 0) goto L45
            int r1 = r2.b()
            int r5 = r3.intValue()
            if (r1 >= r5) goto L52
            int r1 = r2.b()
            if (r1 > r8) goto L52
            int r1 = r3.intValue()
            if (r8 >= r1) goto L52
            goto L4d
        L45:
            int r1 = r2.b()
            if (r1 > r8) goto L52
            if (r8 > r9) goto L52
        L4d:
            com.transsion.mpush.api.LocalPushMessage r7 = r2.a()
            return r7
        L52:
            r1 = r4
            goto L8
        L54:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.mpush.core.interceptor.LocalFrequencyController.g(java.util.List, int, int):com.transsion.mpush.api.LocalPushMessage");
    }

    public final LocalPushMessage h(Context context, List messages) {
        LocalPushMessage f11;
        Integer v11;
        Integer v12;
        Intrinsics.h(context, "context");
        Intrinsics.h(messages, "messages");
        if (messages.isEmpty()) {
            return null;
        }
        PushConfig d11 = d(context);
        Calendar calendar = Calendar.getInstance();
        int i11 = calendar.get(11);
        String startTime = d11.getStartTime();
        int intValue = (startTime == null || (v12 = StringsKt.v(startTime)) == null) ? 8 : v12.intValue();
        String endTime = d11.getEndTime();
        int intValue2 = (endTime == null || (v11 = StringsKt.v(endTime)) == null) ? 22 : v11.intValue();
        if (intValue > i11 || i11 > intValue2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = messages.iterator();
        while (it.hasNext()) {
            LocalPushMessage localPushMessage = (LocalPushMessage) it.next();
            Integer e11 = f47596a.e(localPushMessage.getPushTime());
            a aVar = e11 != null ? new a(localPushMessage, e11.intValue()) : null;
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        if (arrayList.isEmpty() || arrayList.size() != messages.size()) {
            a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "selectMessage: pushTime 存在无效值，回退到小时间隔选取，valid=" + arrayList.size() + "/" + messages.size(), false, 4, null);
            f11 = f(messages, i11, intValue, d11);
        } else {
            f11 = g(c(arrayList), (i11 * 3600) + (calendar.get(12) * 60) + calendar.get(13), (intValue2 * 3600) + 3599);
        }
        if (f11 == null) {
            return null;
        }
        if (f11.getMsgStatus() == 0) {
            return f11;
        }
        a.C0856a.f(lg.a.f68962a, "M_PUSH_SDK", "selectMessage: target message " + f11.getMessageId() + " already shown today. Skipping.", false, 4, null);
        return null;
    }

    public final boolean i(Context context, LocalPushMessage message, int i11) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        return b(message, i11, d(context));
    }

    public final List j(List messages) {
        Intrinsics.h(messages, "messages");
        if (messages.size() <= 1) {
            return messages;
        }
        final Comparator comparator = new Comparator() { // from class: com.transsion.mpush.core.interceptor.LocalFrequencyController$sortByPushTimeAsc$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                Integer e11;
                Integer e12;
                LocalFrequencyController localFrequencyController = LocalFrequencyController.f47596a;
                e11 = localFrequencyController.e(((LocalPushMessage) t11).getPushTime());
                if (e11 == null) {
                    e11 = r1;
                }
                e12 = localFrequencyController.e(((LocalPushMessage) t12).getPushTime());
                return ComparisonsKt.d(e11, e12 != null ? e12 : Integer.MAX_VALUE);
            }
        };
        return CollectionsKt.I0(messages, new Comparator() { // from class: com.transsion.mpush.core.interceptor.LocalFrequencyController$sortByPushTimeAsc$$inlined$thenByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                int compare = comparator.compare(t11, t12);
                return compare != 0 ? compare : ComparisonsKt.d(Long.valueOf(((LocalPushMessage) t12).getReceiveTime()), Long.valueOf(((LocalPushMessage) t11).getReceiveTime()));
            }
        });
    }
}
