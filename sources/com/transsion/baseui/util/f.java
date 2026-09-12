package com.transsion.baseui.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class f implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public static final a f43565c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final int f43566d = 8;

    /* renamed from: a, reason: collision with root package name */
    private int f43567a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f43568b = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(f fVar, View view) {
        int i11 = fVar.f43567a;
        if (i11 == 1) {
            fVar.d(view);
        } else if (i11 >= 2) {
            fVar.c(view);
        }
        fVar.f43568b.removeCallbacksAndMessages(null);
        fVar.f43567a = 0;
    }

    public abstract void c(View view);

    public abstract void d(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(final View v11) {
        Intrinsics.h(v11, "v");
        int i11 = this.f43567a + 1;
        this.f43567a = i11;
        if (i11 > 1) {
            return;
        }
        this.f43568b.postDelayed(new Runnable() { // from class: com.transsion.baseui.util.e
            @Override // java.lang.Runnable
            public final void run() {
                f.b(f.this, v11);
            }
        }, 300L);
    }
}
