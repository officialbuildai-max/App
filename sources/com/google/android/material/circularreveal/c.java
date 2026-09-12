package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.b;

/* loaded from: classes4.dex */
public interface c extends b.a {

    /* loaded from: classes4.dex */
    public static class b implements TypeEvaluator {

        /* renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator f28806b = new b();

        /* renamed from: a, reason: collision with root package name */
        private final e f28807a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f11, e eVar, e eVar2) {
            this.f28807a.b(va.a.d(eVar.f28810a, eVar2.f28810a, f11), va.a.d(eVar.f28811b, eVar2.f28811b, f11), va.a.d(eVar.f28812c, eVar2.f28812c, f11));
            return this.f28807a;
        }
    }

    /* renamed from: com.google.android.material.circularreveal.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0396c extends Property {

        /* renamed from: a, reason: collision with root package name */
        public static final Property f28808a = new C0396c("circularReveal");

        private C0396c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends Property {

        /* renamed from: a, reason: collision with root package name */
        public static final Property f28809a = new d("circularRevealScrimColor");

        private d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public float f28810a;

        /* renamed from: b, reason: collision with root package name */
        public float f28811b;

        /* renamed from: c, reason: collision with root package name */
        public float f28812c;

        private e() {
        }

        public e(float f11, float f12, float f13) {
            this.f28810a = f11;
            this.f28811b = f12;
            this.f28812c = f13;
        }

        public e(e eVar) {
            this(eVar.f28810a, eVar.f28811b, eVar.f28812c);
        }

        public boolean a() {
            return this.f28812c == Float.MAX_VALUE;
        }

        public void b(float f11, float f12, float f13) {
            this.f28810a = f11;
            this.f28811b = f12;
            this.f28812c = f13;
        }

        public void c(e eVar) {
            b(eVar.f28810a, eVar.f28811b, eVar.f28812c);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i11);

    void setRevealInfo(e eVar);
}
