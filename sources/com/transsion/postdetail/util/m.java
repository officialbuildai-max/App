package com.transsion.postdetail.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private View f50224a;

    /* renamed from: b, reason: collision with root package name */
    private int f50225b;

    /* renamed from: c, reason: collision with root package name */
    private a f50226c;

    /* renamed from: d, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f50227d = new b();

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i11);

        void b(int i11);
    }

    /* loaded from: classes6.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (m.this.f50224a == null) {
                View view = m.this.f50224a;
                Intrinsics.e(view);
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                return;
            }
            Rect rect = new Rect();
            View view2 = m.this.f50224a;
            Intrinsics.e(view2);
            view2.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (m.this.c() == 0) {
                m.this.e(height);
                return;
            }
            if (m.this.c() == height) {
                return;
            }
            if (m.this.c() - height > 200) {
                if (m.this.f50226c != null) {
                    a aVar = m.this.f50226c;
                    Intrinsics.e(aVar);
                    aVar.b(m.this.c() - height);
                }
                m.this.e(height);
                return;
            }
            if (height - m.this.c() > 200) {
                if (m.this.f50226c != null) {
                    a aVar2 = m.this.f50226c;
                    Intrinsics.e(aVar2);
                    aVar2.a(height - m.this.c());
                }
                m.this.e(height);
            }
        }
    }

    public final int c() {
        return this.f50225b;
    }

    public final void d(Activity activity, a aVar) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        Window window;
        this.f50226c = aVar;
        View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
        this.f50224a = decorView;
        if (aVar == null) {
            if (decorView == null || (viewTreeObserver2 = decorView.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver2.removeOnGlobalLayoutListener(this.f50227d);
            return;
        }
        if (decorView == null || (viewTreeObserver = decorView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.f50227d);
    }

    public final void e(int i11) {
        this.f50225b = i11;
    }
}
