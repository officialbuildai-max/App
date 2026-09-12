package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import ba.b;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
final class b extends View implements SubtitleView.a {

    /* renamed from: a, reason: collision with root package name */
    private final List f27157a;

    /* renamed from: b, reason: collision with root package name */
    private List f27158b;

    /* renamed from: c, reason: collision with root package name */
    private int f27159c;

    /* renamed from: d, reason: collision with root package name */
    private float f27160d;

    /* renamed from: e, reason: collision with root package name */
    private c f27161e;

    /* renamed from: f, reason: collision with root package name */
    private float f27162f;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27157a = new ArrayList();
        this.f27158b = Collections.emptyList();
        this.f27159c = 0;
        this.f27160d = 0.0533f;
        this.f27161e = c.f27164g;
        this.f27162f = 0.08f;
    }

    private static ba.b b(ba.b bVar) {
        b.C0151b p11 = bVar.b().k(-3.4028235E38f).l(Integer.MIN_VALUE).p(null);
        if (bVar.f16338f == 0) {
            p11.h(1.0f - bVar.f16337e, 0);
        } else {
            p11.h((-bVar.f16337e) - 1.0f, 1);
        }
        int i11 = bVar.f16339g;
        if (i11 == 0) {
            p11.i(2);
        } else if (i11 == 2) {
            p11.i(0);
        }
        return p11.a();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List list, c cVar, float f11, int i11, float f12) {
        this.f27158b = list;
        this.f27161e = cVar;
        this.f27160d = f11;
        this.f27159c = i11;
        this.f27162f = f12;
        while (this.f27157a.size() < list.size()) {
            this.f27157a.add(new j0(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List list = this.f27158b;
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
        float h11 = m0.h(this.f27159c, this.f27160d, height, i11);
        if (h11 <= 0.0f) {
            return;
        }
        int size = list.size();
        int i12 = 0;
        while (i12 < size) {
            ba.b bVar = (ba.b) list.get(i12);
            if (bVar.f16348p != Integer.MIN_VALUE) {
                bVar = b(bVar);
            }
            ba.b bVar2 = bVar;
            int i13 = paddingBottom;
            ((j0) this.f27157a.get(i12)).b(bVar2, this.f27161e, h11, m0.h(bVar2.f16346n, bVar2.f16347o, height, i11), this.f27162f, canvas, paddingLeft, paddingTop, width, i13);
            i12++;
            size = size;
            i11 = i11;
            paddingBottom = i13;
            width = width;
        }
    }
}
