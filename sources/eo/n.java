package eo;

import android.content.Context;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface n {

    /* renamed from: a, reason: collision with root package name */
    public static final a f62093a = a.f62094a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f62094a = new a();

        private a() {
        }

        public final n a(Context context, ViewGroup viewGroup) {
            Intrinsics.h(context, "context");
            return new m(context, viewGroup);
        }
    }

    void a(float f11, float f12);

    float b();

    int c();

    void d(float f11, float f12, int i11);

    void e(com.transsion.player.orplayer.g gVar);

    void f(boolean z10);

    void g();
}
