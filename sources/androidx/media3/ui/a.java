package androidx.media3.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.media3.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u1.a;

/* loaded from: classes2.dex */
final class a extends View implements SubtitleView.a {

    /* renamed from: a, reason: collision with root package name */
    private final List f13705a;

    /* renamed from: b, reason: collision with root package name */
    private List f13706b;

    /* renamed from: c, reason: collision with root package name */
    private int f13707c;

    /* renamed from: d, reason: collision with root package name */
    private float f13708d;

    /* renamed from: e, reason: collision with root package name */
    private b f13709e;

    /* renamed from: f, reason: collision with root package name */
    private float f13710f;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13705a = new ArrayList();
        this.f13706b = Collections.emptyList();
        this.f13707c = 0;
        this.f13708d = 0.0533f;
        this.f13709e = b.f13713g;
        this.f13710f = 0.08f;
    }

    private static u1.a b(u1.a aVar) {
        a.b p11 = aVar.a().k(-3.4028235E38f).l(Integer.MIN_VALUE).p(null);
        if (aVar.f76686f == 0) {
            p11.h(1.0f - aVar.f76685e, 0);
        } else {
            p11.h((-aVar.f76685e) - 1.0f, 1);
        }
        int i11 = aVar.f76687g;
        if (i11 == 0) {
            p11.i(2);
        } else if (i11 == 2) {
            p11.i(0);
        }
        return p11.a();
    }

    @Override // androidx.media3.ui.SubtitleView.a
    public void a(List list, b bVar, float f11, int i11, float f12) {
        this.f13706b = list;
        this.f13709e = bVar;
        this.f13708d = f11;
        this.f13707c = i11;
        this.f13710f = f12;
        while (this.f13705a.size() < list.size()) {
            this.f13705a.add(new u0(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List list = this.f13706b;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i11 = paddingBottom - paddingTop;
        float h11 = x0.h(this.f13707c, this.f13708d, height, i11);
        if (h11 <= 0.0f) {
            return;
        }
        int size = list.size();
        int i12 = 0;
        while (i12 < size) {
            u1.a aVar = (u1.a) list.get(i12);
            if (aVar.f76696p != Integer.MIN_VALUE) {
                aVar = b(aVar);
            }
            u1.a aVar2 = aVar;
            int i13 = paddingBottom;
            ((u0) this.f13705a.get(i12)).b(aVar2, this.f13709e, h11, x0.h(aVar2.f76694n, aVar2.f76695o, height, i11), this.f13710f, canvas, paddingLeft, paddingTop, width, i13);
            i12++;
            size = size;
            i11 = i11;
            paddingBottom = i13;
            width = width;
        }
    }
}
