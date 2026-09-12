package com.transsion.audio.viewmodel;

import android.app.Application;
import androidx.view.b0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.audio.AudioBean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes5.dex */
public final class HistoryListManager {

    /* renamed from: e, reason: collision with root package name */
    public static final a f43015e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy f43016f = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.audio.viewmodel.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            HistoryListManager x10;
            x10 = HistoryListManager.x();
            return x10;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private static boolean f43017g;

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f43018a = LazyKt.b(new Function0() { // from class: com.transsion.audio.viewmodel.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            jj.a m11;
            m11 = HistoryListManager.m();
            return m11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f43019b = LazyKt.b(new Function0() { // from class: com.transsion.audio.viewmodel.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            cj.a y10;
            y10 = HistoryListManager.y();
            return y10;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f43020c = LazyKt.b(new Function0() { // from class: com.transsion.audio.viewmodel.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 l11;
            l11 = HistoryListManager.l();
            return l11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f43021d = LazyKt.b(new Function0() { // from class: com.transsion.audio.viewmodel.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 z10;
            z10 = HistoryListManager.z();
            return z10;
        }
    });

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return HistoryListManager.f43017g;
        }

        public final HistoryListManager b() {
            return (HistoryListManager) HistoryListManager.f43016f.getValue();
        }

        public final void c(boolean z10) {
            HistoryListManager.f43017g = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 l() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jj.a m() {
        Application a11 = Utils.a();
        if (a11 != null) {
            return AppDatabase.INSTANCE.b(a11).o1();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final jj.a q() {
        return (jj.a) this.f43018a.getValue();
    }

    public static /* synthetic */ void t(HistoryListManager historyListManager, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 10;
        }
        historyListManager.s(str, str2, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final cj.a u() {
        return (cj.a) this.f43019b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HistoryListManager x() {
        return new HistoryListManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final cj.a y() {
        return (cj.a) zg.c.f79537e.a().h(cj.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 z() {
        return new b0();
    }

    public final void k(AudioBean audioBean) {
        Intrinsics.h(audioBean, "audioBean");
        a.C0856a.g(lg.a.f68962a, "audio insert name " + audioBean.getTitle(), false, 2, null);
        i.f(null, new HistoryListManager$addToList$1(audioBean, this, null), 1, null);
    }

    public final void n() {
        i.d(o0.a(y0.b()), null, null, new HistoryListManager$deleteAll$1(this, null), 3, null);
    }

    public final void o(AudioBean audioItem) {
        Intrinsics.h(audioItem, "audioItem");
        i.d(o0.a(y0.b()), null, null, new HistoryListManager$deleteItem$1(this, audioItem, null), 3, null);
    }

    public final b0 p() {
        return (b0) this.f43020c.getValue();
    }

    public final void r() {
        i.d(o0.a(y0.c()), null, null, new HistoryListManager$getAudioList$1(this, null), 3, null);
    }

    public final void s(String subjectId, String postId, int i11) {
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(postId, "postId");
        i.d(o0.a(y0.b()), null, null, new HistoryListManager$getResourcePosition$1(this, subjectId, postId, i11, null), 3, null);
    }

    public final b0 v() {
        return (b0) this.f43021d.getValue();
    }

    public final void w(AudioBean audioBean) {
        Intrinsics.h(audioBean, "audioBean");
        i.d(o0.a(y0.b()), null, null, new HistoryListManager$insert$1(audioBean, this, null), 3, null);
    }
}
